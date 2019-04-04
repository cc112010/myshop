package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.ShippingInfo;
import com.mysiteforme.admin.service.ShippingInfoService;
import com.baomidou.mybatisplus.plugins.Page;
import com.mysiteforme.admin.util.LayerData;
import com.mysiteforme.admin.util.RestResponse;
import com.mysiteforme.admin.annotation.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物流公司信息表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/shippingInfo")
public class ShippingInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShippingInfoController.class);

    @Autowired
    private ShippingInfoService shippingInfoService;

    @GetMapping("list")
    @SysLog("跳转物流公司信息表列表")
    public String list(){
        return "/admin/shippingInfo/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求物流公司信息表列表数据")
    public LayerData<ShippingInfo> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<ShippingInfo> layerData = new LayerData<>();
        EntityWrapper<ShippingInfo> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String shipName = (String) map.get("shipName");
            if(StringUtils.isNotBlank(shipName)) {
                wrapper.like("ship_name",shipName);
            }else{
                map.remove("shipName");
            }

            String shipContact = (String) map.get("shipContact");
            if(StringUtils.isNotBlank(shipContact)) {
                wrapper.like("ship_contact",shipContact);
            }else{
                map.remove("shipContact");
            }

        }
        Page<ShippingInfo> pageData = shippingInfoService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增物流公司信息表页面")
    public String add(){
        return "/admin/shippingInfo/add";
    }

    @PostMapping("add")
    @SysLog("保存新增物流公司信息表数据")
    @ResponseBody
    public RestResponse add(ShippingInfo shippingInfo){
        if(StringUtils.isBlank(shippingInfo.getShipName())){
            return RestResponse.failure("物流公司名称不能为空");
        }
        if(StringUtils.isBlank(shippingInfo.getShipContact())){
            return RestResponse.failure("物流公司联系人不能为空");
        }
        if(StringUtils.isBlank(shippingInfo.getTelephone())){
            return RestResponse.failure("物流公司联系电话不能为空");
        }
        if(shippingInfo.getPrice() == null){
            return RestResponse.failure("配送价格不能为空");
        }
        shippingInfoService.insert(shippingInfo);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑物流公司信息表页面")
    public String edit(Long id,Model model){
        ShippingInfo shippingInfo = shippingInfoService.selectById(id);
        model.addAttribute("shippingInfo",shippingInfo);
        return "/admin/shippingInfo/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑物流公司信息表数据")
    public RestResponse edit(ShippingInfo shippingInfo){
        if(null == shippingInfo.getId() || 0 == shippingInfo.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(StringUtils.isBlank(shippingInfo.getShipName())){
            return RestResponse.failure("物流公司名称不能为空");
        }
        if(StringUtils.isBlank(shippingInfo.getShipContact())){
            return RestResponse.failure("物流公司联系人不能为空");
        }
        if(StringUtils.isBlank(shippingInfo.getTelephone())){
            return RestResponse.failure("物流公司联系电话不能为空");
        }
        if(shippingInfo.getPrice() == null){
            return RestResponse.failure("配送价格不能为空");
        }
        shippingInfoService.updateById(shippingInfo);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除物流公司信息表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        ShippingInfo shippingInfo = shippingInfoService.selectById(id);
        shippingInfo.setDelFlag(true);
        shippingInfoService.updateById(shippingInfo);
        return RestResponse.success();
    }

}
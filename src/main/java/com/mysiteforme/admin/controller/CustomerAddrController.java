package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.CustomerAddr;
import com.mysiteforme.admin.service.CustomerAddrService;
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
 * 用户地址表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/customerAddr")
public class CustomerAddrController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAddrController.class);

    @Autowired
    private CustomerAddrService customerAddrService;

    @GetMapping("list")
    @SysLog("跳转用户地址表列表")
    public String list(){
        return "/admin/customerAddr/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求用户地址表列表数据")
    public LayerData<CustomerAddr> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<CustomerAddr> layerData = new LayerData<>();
        EntityWrapper<CustomerAddr> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String province = (String) map.get("province");
            if(StringUtils.isNotBlank(province)) {
                wrapper.like("province",province);
            }else{
                map.remove("province");
            }

            String city = (String) map.get("city");
            if(StringUtils.isNotBlank(city)) {
                wrapper.like("city",city);
            }else{
                map.remove("city");
            }

            String district = (String) map.get("district");
            if(StringUtils.isNotBlank(district)) {
                wrapper.like("district",district);
            }else{
                map.remove("district");
            }

            String address = (String) map.get("address");
            if(StringUtils.isNotBlank(address)) {
                wrapper.like("address",address);
            }else{
                map.remove("address");
            }

            String isDefault = (String) map.get("isDefault");
            if(StringUtils.isNotBlank(isDefault)) {
                wrapper.like("is_default",isDefault);
            }else{
                map.remove("isDefault");
            }

        }
        Page<CustomerAddr> pageData = customerAddrService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增用户地址表页面")
    public String add(){
        return "/admin/customerAddr/add";
    }

    @PostMapping("add")
    @SysLog("保存新增用户地址表数据")
    @ResponseBody
    public RestResponse add(CustomerAddr customerAddr){
        if(customerAddr.getCustomerId() == null){
            return RestResponse.failure("customer_login表的自增ID不能为空");
        }
        if(customerAddr.getZip() == null){
            return RestResponse.failure("邮编不能为空");
        }
        if(customerAddr.getProvince() == null){
            return RestResponse.failure("地区表中省份的ID不能为空");
        }
        if(customerAddr.getCity() == null){
            return RestResponse.failure("地区表中城市的ID不能为空");
        }
        if(customerAddr.getDistrict() == null){
            return RestResponse.failure("地区表中的区ID不能为空");
        }
        if(StringUtils.isBlank(customerAddr.getAddress())){
            return RestResponse.failure("具体的地址门牌号不能为空");
        }
        if(customerAddr.getIsDefault() == null){
            return RestResponse.failure("是否默认不能为空");
        }
        customerAddrService.insert(customerAddr);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑用户地址表页面")
    public String edit(Long id,Model model){
        CustomerAddr customerAddr = customerAddrService.selectById(id);
        model.addAttribute("customerAddr",customerAddr);
        return "/admin/customerAddr/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑用户地址表数据")
    public RestResponse edit(CustomerAddr customerAddr){
        if(null == customerAddr.getId() || 0 == customerAddr.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(customerAddr.getCustomerId() == null){
            return RestResponse.failure("customer_login表的自增ID不能为空");
        }
        if(customerAddr.getZip() == null){
            return RestResponse.failure("邮编不能为空");
        }
        if(customerAddr.getProvince() == null){
            return RestResponse.failure("地区表中省份的ID不能为空");
        }
        if(customerAddr.getCity() == null){
            return RestResponse.failure("地区表中城市的ID不能为空");
        }
        if(customerAddr.getDistrict() == null){
            return RestResponse.failure("地区表中的区ID不能为空");
        }
        if(StringUtils.isBlank(customerAddr.getAddress())){
            return RestResponse.failure("具体的地址门牌号不能为空");
        }
        if(customerAddr.getIsDefault() == null){
            return RestResponse.failure("是否默认不能为空");
        }
        customerAddrService.updateById(customerAddr);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除用户地址表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        CustomerAddr customerAddr = customerAddrService.selectById(id);
        customerAddr.setDelFlag(true);
        customerAddrService.updateById(customerAddr);
        return RestResponse.success();
    }

}
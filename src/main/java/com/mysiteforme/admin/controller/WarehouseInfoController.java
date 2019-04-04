package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.WarehouseInfo;
import com.mysiteforme.admin.service.WarehouseInfoService;
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
 * 仓库信息表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/warehouseInfo")
public class WarehouseInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseInfoController.class);

    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @GetMapping("list")
    @SysLog("跳转仓库信息表列表")
    public String list(){
        return "/admin/warehouseInfo/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求仓库信息表列表数据")
    public LayerData<WarehouseInfo> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WarehouseInfo> layerData = new LayerData<>();
        EntityWrapper<WarehouseInfo> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String warehouseSn = (String) map.get("warehouseSn");
            if(StringUtils.isNotBlank(warehouseSn)) {
                wrapper.like("warehouse_sn",warehouseSn);
            }else{
                map.remove("warehouseSn");
            }

            String warehoustName = (String) map.get("warehoustName");
            if(StringUtils.isNotBlank(warehoustName)) {
                wrapper.like("warehoust_name",warehoustName);
            }else{
                map.remove("warehoustName");
            }

            String contact = (String) map.get("contact");
            if(StringUtils.isNotBlank(contact)) {
                wrapper.like("contact",contact);
            }else{
                map.remove("contact");
            }

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

            String distrct = (String) map.get("distrct");
            if(StringUtils.isNotBlank(distrct)) {
                wrapper.like("distrct",distrct);
            }else{
                map.remove("distrct");
            }

            String address = (String) map.get("address");
            if(StringUtils.isNotBlank(address)) {
                wrapper.like("address",address);
            }else{
                map.remove("address");
            }

            String warehouseStatus = (String) map.get("warehouseStatus");
            if(StringUtils.isNotBlank(warehouseStatus)) {
                wrapper.like("warehouse_status",warehouseStatus);
            }else{
                map.remove("warehouseStatus");
            }

        }
        Page<WarehouseInfo> pageData = warehouseInfoService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增仓库信息表页面")
    public String add(){
        return "/admin/warehouseInfo/add";
    }

    @PostMapping("add")
    @SysLog("保存新增仓库信息表数据")
    @ResponseBody
    public RestResponse add(WarehouseInfo warehouseInfo){
        if(StringUtils.isBlank(warehouseInfo.getWarehouseSn())){
            return RestResponse.failure("仓库编码不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getWarehoustName())){
            return RestResponse.failure("仓库名称不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getWarehousePhone())){
            return RestResponse.failure("仓库电话不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getContact())){
            return RestResponse.failure("仓库联系人不能为空");
        }
        if(warehouseInfo.getProvince() == null){
            return RestResponse.failure("省不能为空");
        }
        if(warehouseInfo.getCity() == null){
            return RestResponse.failure("市不能为空");
        }
        if(warehouseInfo.getDistrct() == null){
            return RestResponse.failure("区不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getAddress())){
            return RestResponse.failure("仓库地址不能为空");
        }
        if(warehouseInfo.getWarehouseStatus() == null){
            return RestResponse.failure("仓库状态不能为空");
        }
        warehouseInfoService.insert(warehouseInfo);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑仓库信息表页面")
    public String edit(Long id,Model model){
        WarehouseInfo warehouseInfo = warehouseInfoService.selectById(id);
        model.addAttribute("warehouseInfo",warehouseInfo);
        return "/admin/warehouseInfo/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑仓库信息表数据")
    public RestResponse edit(WarehouseInfo warehouseInfo){
        if(null == warehouseInfo.getId() || 0 == warehouseInfo.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getWarehouseSn())){
            return RestResponse.failure("仓库编码不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getWarehoustName())){
            return RestResponse.failure("仓库名称不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getWarehousePhone())){
            return RestResponse.failure("仓库电话不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getContact())){
            return RestResponse.failure("仓库联系人不能为空");
        }
        if(warehouseInfo.getProvince() == null){
            return RestResponse.failure("省不能为空");
        }
        if(warehouseInfo.getCity() == null){
            return RestResponse.failure("市不能为空");
        }
        if(warehouseInfo.getDistrct() == null){
            return RestResponse.failure("区不能为空");
        }
        if(StringUtils.isBlank(warehouseInfo.getAddress())){
            return RestResponse.failure("仓库地址不能为空");
        }
        if(warehouseInfo.getWarehouseStatus() == null){
            return RestResponse.failure("仓库状态不能为空");
        }
        warehouseInfoService.updateById(warehouseInfo);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除仓库信息表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WarehouseInfo warehouseInfo = warehouseInfoService.selectById(id);
        warehouseInfo.setDelFlag(true);
        warehouseInfoService.updateById(warehouseInfo);
        return RestResponse.success();
    }

}
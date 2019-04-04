package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.SupplierInfo;
import com.mysiteforme.admin.service.SupplierInfoService;
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
 * 供应商信息表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/supplierInfo")
public class SupplierInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierInfoController.class);

    @Autowired
    private SupplierInfoService supplierInfoService;

    @GetMapping("list")
    @SysLog("跳转供应商信息表列表")
    public String list(){
        return "/admin/supplierInfo/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求供应商信息表列表数据")
    public LayerData<SupplierInfo> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<SupplierInfo> layerData = new LayerData<>();
        EntityWrapper<SupplierInfo> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String supplierCode = (String) map.get("supplierCode");
            if(StringUtils.isNotBlank(supplierCode)) {
                wrapper.like("supplier_code",supplierCode);
            }else{
                map.remove("supplierCode");
            }

            String supplierName = (String) map.get("supplierName");
            if(StringUtils.isNotBlank(supplierName)) {
                wrapper.like("supplier_name",supplierName);
            }else{
                map.remove("supplierName");
            }

            String supplierType = (String) map.get("supplierType");
            if(StringUtils.isNotBlank(supplierType)) {
                wrapper.like("supplier_type",supplierType);
            }else{
                map.remove("supplierType");
            }

            String linkMan = (String) map.get("linkMan");
            if(StringUtils.isNotBlank(linkMan)) {
                wrapper.like("link_man",linkMan);
            }else{
                map.remove("linkMan");
            }

            String bankName = (String) map.get("bankName");
            if(StringUtils.isNotBlank(bankName)) {
                wrapper.like("bank_name",bankName);
            }else{
                map.remove("bankName");
            }

            String supplierStatus = (String) map.get("supplierStatus");
            if(StringUtils.isNotBlank(supplierStatus)) {
                wrapper.like("supplier_status",supplierStatus);
            }else{
                map.remove("supplierStatus");
            }

        }
        Page<SupplierInfo> pageData = supplierInfoService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增供应商信息表页面")
    public String add(){
        return "/admin/supplierInfo/add";
    }

    @PostMapping("add")
    @SysLog("保存新增供应商信息表数据")
    @ResponseBody
    public RestResponse add(SupplierInfo supplierInfo){
        if(StringUtils.isBlank(supplierInfo.getSupplierCode())){
            return RestResponse.failure("供应商编码不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getSupplierName())){
            return RestResponse.failure("供应商名称不能为空");
        }
        if(supplierInfo.getSupplierType() == null){
            return RestResponse.failure("供应商类型：1.自营，2.平台不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getLinkMan())){
            return RestResponse.failure("供应商联系人不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getPhoneNumber())){
            return RestResponse.failure("联系电话不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getBankName())){
            return RestResponse.failure("供应商开户银行名称不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getBankAccount())){
            return RestResponse.failure("银行账号不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getAddress())){
            return RestResponse.failure("供应商地址不能为空");
        }
        if(supplierInfo.getSupplierStatus() == null){
            return RestResponse.failure("状态：0禁止，1启用不能为空");
        }
        supplierInfoService.insert(supplierInfo);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑供应商信息表页面")
    public String edit(Long id,Model model){
        SupplierInfo supplierInfo = supplierInfoService.selectById(id);
        model.addAttribute("supplierInfo",supplierInfo);
        return "/admin/supplierInfo/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑供应商信息表数据")
    public RestResponse edit(SupplierInfo supplierInfo){
        if(null == supplierInfo.getId() || 0 == supplierInfo.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getSupplierCode())){
            return RestResponse.failure("供应商编码不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getSupplierName())){
            return RestResponse.failure("供应商名称不能为空");
        }
        if(supplierInfo.getSupplierType() == null){
            return RestResponse.failure("供应商类型：1.自营，2.平台不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getLinkMan())){
            return RestResponse.failure("供应商联系人不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getPhoneNumber())){
            return RestResponse.failure("联系电话不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getBankName())){
            return RestResponse.failure("供应商开户银行名称不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getBankAccount())){
            return RestResponse.failure("银行账号不能为空");
        }
        if(StringUtils.isBlank(supplierInfo.getAddress())){
            return RestResponse.failure("供应商地址不能为空");
        }
        if(supplierInfo.getSupplierStatus() == null){
            return RestResponse.failure("状态：0禁止，1启用不能为空");
        }
        supplierInfoService.updateById(supplierInfo);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除供应商信息表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        SupplierInfo supplierInfo = supplierInfoService.selectById(id);
        supplierInfo.setDelFlag(true);
        supplierInfoService.updateById(supplierInfo);
        return RestResponse.success();
    }

}
package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.CustomerInf;
import com.mysiteforme.admin.service.CustomerInfService;
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
 * 用户信息表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/customerInf")
public class CustomerInfController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInfController.class);

    @Autowired
    private CustomerInfService customerInfService;

    @GetMapping("list")
    @SysLog("跳转用户信息表列表")
    public String list(){
        return "/admin/customerInf/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求用户信息表列表数据")
    public LayerData<CustomerInf> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<CustomerInf> layerData = new LayerData<>();
        EntityWrapper<CustomerInf> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String customerName = (String) map.get("customerName");
            if(StringUtils.isNotBlank(customerName)) {
                wrapper.like("customer_name",customerName);
            }else{
                map.remove("customerName");
            }

            String identityCardType = (String) map.get("identityCardType");
            if(StringUtils.isNotBlank(identityCardType)) {
                wrapper.like("identity_card_type",identityCardType);
            }else{
                map.remove("identityCardType");
            }

            String identityCardNo = (String) map.get("identityCardNo");
            if(StringUtils.isNotBlank(identityCardNo)) {
                wrapper.like("identity_card_no",identityCardNo);
            }else{
                map.remove("identityCardNo");
            }

            String mobilePhone = (String) map.get("mobilePhone");
            if(StringUtils.isNotBlank(mobilePhone)) {
                wrapper.like("mobile_phone",mobilePhone);
            }else{
                map.remove("mobilePhone");
            }

            String customerEmail = (String) map.get("customerEmail");
            if(StringUtils.isNotBlank(customerEmail)) {
                wrapper.like("customer_email",customerEmail);
            }else{
                map.remove("customerEmail");
            }

            String gender = (String) map.get("gender");
            if(StringUtils.isNotBlank(gender)) {
                wrapper.eq("gender",gender);
            }else{
                map.remove("gender");
            }

            String beginRegisterTime = (String) map.get("beginRegisterTime");
            String endRegisterTime = (String) map.get("endRegisterTime");
            if(StringUtils.isNotBlank(beginRegisterTime)) {
                Date begin = DateUtil.parse(beginRegisterTime);
                wrapper.ge("register_time",begin);
            }else{
                map.remove("beginRegisterTime");
            }
            if(StringUtils.isNotBlank(endRegisterTime)) {
                Date end = DateUtil.parse(endRegisterTime);
                wrapper.le("register_time",end);
            }else{
                map.remove("endRegisterTime");
            }

            String beginBirthday = (String) map.get("beginBirthday");
            String endBirthday = (String) map.get("endBirthday");
            if(StringUtils.isNotBlank(beginBirthday)) {
                Date begin = DateUtil.parse(beginBirthday);
                wrapper.ge("birthday",begin);
            }else{
                map.remove("beginBirthday");
            }
            if(StringUtils.isNotBlank(endBirthday)) {
                Date end = DateUtil.parse(endBirthday);
                wrapper.le("birthday",end);
            }else{
                map.remove("endBirthday");
            }

            String customerLevel = (String) map.get("customerLevel");
            if(StringUtils.isNotBlank(customerLevel)) {
                wrapper.like("customer_level",customerLevel);
            }else{
                map.remove("customerLevel");
            }

        }
        Page<CustomerInf> pageData = customerInfService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增用户信息表页面")
    public String add(){
        return "/admin/customerInf/add";
    }

    @PostMapping("add")
    @SysLog("保存新增用户信息表数据")
    @ResponseBody
    public RestResponse add(CustomerInf customerInf){
        if(customerInf.getCustomerId() == null){
            return RestResponse.failure("customer_login表的自增ID不能为空");
        }
        if(StringUtils.isBlank(customerInf.getCustomerName())){
            return RestResponse.failure("用户真实姓名不能为空");
        }
        if(customerInf.getIdentityCardType() == null){
            return RestResponse.failure("证件类型：1 身份证，2 军官证，3 护照不能为空");
        }
        if(customerInf.getUserPoint() == null){
            return RestResponse.failure("用户积分不能为空");
        }
        if(customerInf.getRegisterTime() == null){
            return RestResponse.failure("注册时间不能为空");
        }
        if(customerInf.getCustomerLevel() == null){
            return RestResponse.failure("会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石不能为空");
        }
        if(customerInf.getUserMoney() == null){
            return RestResponse.failure("用户余额不能为空");
        }
        customerInfService.insert(customerInf);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑用户信息表页面")
    public String edit(Long id,Model model){
        CustomerInf customerInf = customerInfService.selectById(id);
        model.addAttribute("customerInf",customerInf);
        return "/admin/customerInf/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑用户信息表数据")
    public RestResponse edit(CustomerInf customerInf){
        if(null == customerInf.getId() || 0 == customerInf.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(customerInf.getCustomerId() == null){
            return RestResponse.failure("customer_login表的自增ID不能为空");
        }
        if(StringUtils.isBlank(customerInf.getCustomerName())){
            return RestResponse.failure("用户真实姓名不能为空");
        }
        if(customerInf.getIdentityCardType() == null){
            return RestResponse.failure("证件类型：1 身份证，2 军官证，3 护照不能为空");
        }
        if(customerInf.getUserPoint() == null){
            return RestResponse.failure("用户积分不能为空");
        }
        if(customerInf.getRegisterTime() == null){
            return RestResponse.failure("注册时间不能为空");
        }
        if(customerInf.getCustomerLevel() == null){
            return RestResponse.failure("会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石不能为空");
        }
        if(customerInf.getUserMoney() == null){
            return RestResponse.failure("用户余额不能为空");
        }
        customerInfService.updateById(customerInf);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除用户信息表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        CustomerInf customerInf = customerInfService.selectById(id);
        customerInf.setDelFlag(true);
        customerInfService.updateById(customerInf);
        return RestResponse.success();
    }

}
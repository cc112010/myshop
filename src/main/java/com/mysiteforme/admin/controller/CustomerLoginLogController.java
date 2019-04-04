package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.CustomerLoginLog;
import com.mysiteforme.admin.service.CustomerLoginLogService;
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
 * 用户登陆日志表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/customerLoginLog")
public class CustomerLoginLogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerLoginLogController.class);

    @Autowired
    private CustomerLoginLogService customerLoginLogService;

    @GetMapping("list")
    @SysLog("跳转用户登陆日志表列表")
    public String list(){
        return "/admin/customerLoginLog/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求用户登陆日志表列表数据")
    public LayerData<CustomerLoginLog> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<CustomerLoginLog> layerData = new LayerData<>();
        EntityWrapper<CustomerLoginLog> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String beginLoginTime = (String) map.get("beginLoginTime");
            String endLoginTime = (String) map.get("endLoginTime");
            if(StringUtils.isNotBlank(beginLoginTime)) {
                Date begin = DateUtil.parse(beginLoginTime);
                wrapper.ge("login_time",begin);
            }else{
                map.remove("beginLoginTime");
            }
            if(StringUtils.isNotBlank(endLoginTime)) {
                Date end = DateUtil.parse(endLoginTime);
                wrapper.le("login_time",end);
            }else{
                map.remove("endLoginTime");
            }

            String loginIp = (String) map.get("loginIp");
            if(StringUtils.isNotBlank(loginIp)) {
                wrapper.like("login_ip",loginIp);
            }else{
                map.remove("loginIp");
            }

            String loginType = (String) map.get("loginType");
            if(StringUtils.isNotBlank(loginType)) {
                wrapper.like("login_type",loginType);
            }else{
                map.remove("loginType");
            }

        }
        Page<CustomerLoginLog> pageData = customerLoginLogService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增用户登陆日志表页面")
    public String add(){
        return "/admin/customerLoginLog/add";
    }

    @PostMapping("add")
    @SysLog("保存新增用户登陆日志表数据")
    @ResponseBody
    public RestResponse add(CustomerLoginLog customerLoginLog){
        if(customerLoginLog.getCustomerId() == null){
            return RestResponse.failure("登陆用户ID不能为空");
        }
        if(customerLoginLog.getLoginTime() == null){
            return RestResponse.failure("用户登陆时间不能为空");
        }
        if(StringUtils.isBlank(customerLoginLog.getLoginIp())){
            return RestResponse.failure("登陆IP不能为空");
        }
        if(customerLoginLog.getLoginType() == null){
            return RestResponse.failure("登陆类型：0未成功，1成功不能为空");
        }
        customerLoginLogService.insert(customerLoginLog);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑用户登陆日志表页面")
    public String edit(Long id,Model model){
        CustomerLoginLog customerLoginLog = customerLoginLogService.selectById(id);
        model.addAttribute("customerLoginLog",customerLoginLog);
        return "/admin/customerLoginLog/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑用户登陆日志表数据")
    public RestResponse edit(CustomerLoginLog customerLoginLog){
        if(null == customerLoginLog.getId() || 0 == customerLoginLog.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(customerLoginLog.getCustomerId() == null){
            return RestResponse.failure("登陆用户ID不能为空");
        }
        if(customerLoginLog.getLoginTime() == null){
            return RestResponse.failure("用户登陆时间不能为空");
        }
        if(StringUtils.isBlank(customerLoginLog.getLoginIp())){
            return RestResponse.failure("登陆IP不能为空");
        }
        if(customerLoginLog.getLoginType() == null){
            return RestResponse.failure("登陆类型：0未成功，1成功不能为空");
        }
        customerLoginLogService.updateById(customerLoginLog);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除用户登陆日志表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        CustomerLoginLog customerLoginLog = customerLoginLogService.selectById(id);
        customerLoginLog.setDelFlag(true);
        customerLoginLogService.updateById(customerLoginLog);
        return RestResponse.success();
    }

}
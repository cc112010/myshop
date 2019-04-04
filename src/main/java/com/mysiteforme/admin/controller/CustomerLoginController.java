package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.CustomerLogin;
import com.mysiteforme.admin.service.CustomerLoginService;
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
 * 用户登录表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/customerLogin")
public class CustomerLoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerLoginController.class);

    @Autowired
    private CustomerLoginService customerLoginService;

    @GetMapping("list")
    @SysLog("跳转用户登录表列表")
    public String list(){
        return "/admin/customerLogin/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求用户登录表列表数据")
    public LayerData<CustomerLogin> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<CustomerLogin> layerData = new LayerData<>();
        EntityWrapper<CustomerLogin> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String loginName = (String) map.get("loginName");
            if(StringUtils.isNotBlank(loginName)) {
                wrapper.like("login_name",loginName);
            }else{
                map.remove("loginName");
            }

            String userStats = (String) map.get("userStats");
            if(StringUtils.isNotBlank(userStats)) {
                wrapper.like("user_stats",userStats);
            }else{
                map.remove("userStats");
            }

        }
        Page<CustomerLogin> pageData = customerLoginService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增用户登录表页面")
    public String add(){
        return "/admin/customerLogin/add";
    }

    @PostMapping("add")
    @SysLog("保存新增用户登录表数据")
    @ResponseBody
    public RestResponse add(CustomerLogin customerLogin){
        customerLoginService.insert(customerLogin);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑用户登录表页面")
    public String edit(Long id,Model model){
        CustomerLogin customerLogin = customerLoginService.selectById(id);
        model.addAttribute("customerLogin",customerLogin);
        return "/admin/customerLogin/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑用户登录表数据")
    public RestResponse edit(CustomerLogin customerLogin){
        if(null == customerLogin.getId() || 0 == customerLogin.getId()){
            return RestResponse.failure("ID不能为空");
        }
        customerLoginService.updateById(customerLogin);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除用户登录表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        CustomerLogin customerLogin = customerLoginService.selectById(id);
        customerLogin.setDelFlag(true);
        customerLoginService.updateById(customerLogin);
        return RestResponse.success();
    }

}
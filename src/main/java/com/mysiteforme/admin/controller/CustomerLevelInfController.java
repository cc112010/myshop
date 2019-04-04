package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.CustomerLevelInf;
import com.mysiteforme.admin.service.CustomerLevelInfService;
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
 * 用户级别表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/customerLevelInf")
public class CustomerLevelInfController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerLevelInfController.class);

    @Autowired
    private CustomerLevelInfService customerLevelInfService;

    @GetMapping("list")
    @SysLog("跳转用户级别表列表")
    public String list(){
        return "/admin/customerLevelInf/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求用户级别表列表数据")
    public LayerData<CustomerLevelInf> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<CustomerLevelInf> layerData = new LayerData<>();
        EntityWrapper<CustomerLevelInf> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String levelName = (String) map.get("levelName");
            if(StringUtils.isNotBlank(levelName)) {
                wrapper.like("level_name",levelName);
            }else{
                map.remove("levelName");
            }

        }
        Page<CustomerLevelInf> pageData = customerLevelInfService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增用户级别表页面")
    public String add(){
        return "/admin/customerLevelInf/add";
    }

    @PostMapping("add")
    @SysLog("保存新增用户级别表数据")
    @ResponseBody
    public RestResponse add(CustomerLevelInf customerLevelInf){
        if(StringUtils.isBlank(customerLevelInf.getLevelName())){
            return RestResponse.failure("会员级别名称不能为空");
        }
        if(customerLevelInf.getMinPoint() == null){
            return RestResponse.failure("该级别最低积分不能为空");
        }
        if(customerLevelInf.getMaxPoint() == null){
            return RestResponse.failure("该级别最高积分不能为空");
        }
        customerLevelInfService.insert(customerLevelInf);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑用户级别表页面")
    public String edit(Long id,Model model){
        CustomerLevelInf customerLevelInf = customerLevelInfService.selectById(id);
        model.addAttribute("customerLevelInf",customerLevelInf);
        return "/admin/customerLevelInf/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑用户级别表数据")
    public RestResponse edit(CustomerLevelInf customerLevelInf){
        if(null == customerLevelInf.getId() || 0 == customerLevelInf.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(StringUtils.isBlank(customerLevelInf.getLevelName())){
            return RestResponse.failure("会员级别名称不能为空");
        }
        if(customerLevelInf.getMinPoint() == null){
            return RestResponse.failure("该级别最低积分不能为空");
        }
        if(customerLevelInf.getMaxPoint() == null){
            return RestResponse.failure("该级别最高积分不能为空");
        }
        customerLevelInfService.updateById(customerLevelInf);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除用户级别表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        CustomerLevelInf customerLevelInf = customerLevelInfService.selectById(id);
        customerLevelInf.setDelFlag(true);
        customerLevelInfService.updateById(customerLevelInf);
        return RestResponse.success();
    }

}
package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.CustomerPointLog;
import com.mysiteforme.admin.service.CustomerPointLogService;
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
 * 用户积分日志表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/customerPointLog")
public class CustomerPointLogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerPointLogController.class);

    @Autowired
    private CustomerPointLogService customerPointLogService;

    @GetMapping("list")
    @SysLog("跳转用户积分日志表列表")
    public String list(){
        return "/admin/customerPointLog/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求用户积分日志表列表数据")
    public LayerData<CustomerPointLog> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<CustomerPointLog> layerData = new LayerData<>();
        EntityWrapper<CustomerPointLog> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String source = (String) map.get("source");
            if(StringUtils.isNotBlank(source)) {
                wrapper.like("source",source);
            }else{
                map.remove("source");
            }

            String referNumber = (String) map.get("referNumber");
            if(StringUtils.isNotBlank(referNumber)) {
                wrapper.like("refer_number",referNumber);
            }else{
                map.remove("referNumber");
            }

            String changePoint = (String) map.get("changePoint");
            if(StringUtils.isNotBlank(changePoint)) {
                wrapper.like("change_point",changePoint);
            }else{
                map.remove("changePoint");
            }

        }
        Page<CustomerPointLog> pageData = customerPointLogService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增用户积分日志表页面")
    public String add(){
        return "/admin/customerPointLog/add";
    }

    @PostMapping("add")
    @SysLog("保存新增用户积分日志表数据")
    @ResponseBody
    public RestResponse add(CustomerPointLog customerPointLog){
        if(customerPointLog.getCustomerId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(customerPointLog.getSource() == null){
            return RestResponse.failure("积分来源：0订单，1登陆，2活动不能为空");
        }
        if(customerPointLog.getReferNumber() == null){
            return RestResponse.failure("积分来源相关编号不能为空");
        }
        if(customerPointLog.getChangePoint() == null){
            return RestResponse.failure("变更积分数不能为空");
        }
        customerPointLogService.insert(customerPointLog);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑用户积分日志表页面")
    public String edit(Long id,Model model){
        CustomerPointLog customerPointLog = customerPointLogService.selectById(id);
        model.addAttribute("customerPointLog",customerPointLog);
        return "/admin/customerPointLog/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑用户积分日志表数据")
    public RestResponse edit(CustomerPointLog customerPointLog){
        if(null == customerPointLog.getId() || 0 == customerPointLog.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(customerPointLog.getCustomerId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(customerPointLog.getSource() == null){
            return RestResponse.failure("积分来源：0订单，1登陆，2活动不能为空");
        }
        if(customerPointLog.getReferNumber() == null){
            return RestResponse.failure("积分来源相关编号不能为空");
        }
        if(customerPointLog.getChangePoint() == null){
            return RestResponse.failure("变更积分数不能为空");
        }
        customerPointLogService.updateById(customerPointLog);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除用户积分日志表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        CustomerPointLog customerPointLog = customerPointLogService.selectById(id);
        customerPointLog.setDelFlag(true);
        customerPointLogService.updateById(customerPointLog);
        return RestResponse.success();
    }

}
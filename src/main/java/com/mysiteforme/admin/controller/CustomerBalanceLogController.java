package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.CustomerBalanceLog;
import com.mysiteforme.admin.service.CustomerBalanceLogService;
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
 * 用户余额变动表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/customerBalanceLog")
public class CustomerBalanceLogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerBalanceLogController.class);

    @Autowired
    private CustomerBalanceLogService customerBalanceLogService;

    @GetMapping("list")
    @SysLog("跳转用户余额变动表列表")
    public String list(){
        return "/admin/customerBalanceLog/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求用户余额变动表列表数据")
    public LayerData<CustomerBalanceLog> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<CustomerBalanceLog> layerData = new LayerData<>();
        EntityWrapper<CustomerBalanceLog> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String source = (String) map.get("source");
            if(StringUtils.isNotBlank(source)) {
                wrapper.like("source",source);
            }else{
                map.remove("source");
            }

        }
        Page<CustomerBalanceLog> pageData = customerBalanceLogService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增用户余额变动表页面")
    public String add(){
        return "/admin/customerBalanceLog/add";
    }

    @PostMapping("add")
    @SysLog("保存新增用户余额变动表数据")
    @ResponseBody
    public RestResponse add(CustomerBalanceLog customerBalanceLog){
        if(customerBalanceLog.getCustomerId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(customerBalanceLog.getSource() == null){
            return RestResponse.failure("记录来源：1订单，2退货单不能为空");
        }
        if(StringUtils.isBlank(customerBalanceLog.getSourceSn())){
            return RestResponse.failure("相关单据ID不能为空");
        }
        if(customerBalanceLog.getAmount() == null){
            return RestResponse.failure("变动金额不能为空");
        }
        customerBalanceLogService.insert(customerBalanceLog);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑用户余额变动表页面")
    public String edit(Long id,Model model){
        CustomerBalanceLog customerBalanceLog = customerBalanceLogService.selectById(id);
        model.addAttribute("customerBalanceLog",customerBalanceLog);
        return "/admin/customerBalanceLog/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑用户余额变动表数据")
    public RestResponse edit(CustomerBalanceLog customerBalanceLog){
        if(null == customerBalanceLog.getId() || 0 == customerBalanceLog.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(customerBalanceLog.getCustomerId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(customerBalanceLog.getSource() == null){
            return RestResponse.failure("记录来源：1订单，2退货单不能为空");
        }
        if(StringUtils.isBlank(customerBalanceLog.getSourceSn())){
            return RestResponse.failure("相关单据ID不能为空");
        }
        if(customerBalanceLog.getAmount() == null){
            return RestResponse.failure("变动金额不能为空");
        }
        customerBalanceLogService.updateById(customerBalanceLog);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除用户余额变动表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        CustomerBalanceLog customerBalanceLog = customerBalanceLogService.selectById(id);
        customerBalanceLog.setDelFlag(true);
        customerBalanceLogService.updateById(customerBalanceLog);
        return RestResponse.success();
    }

}
package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.OrderDetail;
import com.mysiteforme.admin.service.OrderDetailService;
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
 * 订单详情表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/orderDetail")
public class OrderDetailController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailController.class);

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("list")
    @SysLog("跳转订单详情表列表")
    public String list(){
        return "/admin/orderDetail/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求订单详情表列表数据")
    public LayerData<OrderDetail> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<OrderDetail> layerData = new LayerData<>();
        EntityWrapper<OrderDetail> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String productName = (String) map.get("productName");
            if(StringUtils.isNotBlank(productName)) {
                wrapper.like("product_name",productName);
            }else{
                map.remove("productName");
            }

        }
        Page<OrderDetail> pageData = orderDetailService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增订单详情表页面")
    public String add(){
        return "/admin/orderDetail/add";
    }

    @PostMapping("add")
    @SysLog("保存新增订单详情表数据")
    @ResponseBody
    public RestResponse add(OrderDetail orderDetail){
        if(orderDetail.getOrderId() == null){
            return RestResponse.failure("订单表ID不能为空");
        }
        if(orderDetail.getProductId() == null){
            return RestResponse.failure("订单商品ID不能为空");
        }
        if(StringUtils.isBlank(orderDetail.getProductName())){
            return RestResponse.failure("商品名称不能为空");
        }
        if(orderDetail.getProductCnt() == null){
            return RestResponse.failure("购买商品数量不能为空");
        }
        if(orderDetail.getProductPrice() == null){
            return RestResponse.failure("购买商品单价不能为空");
        }
        if(orderDetail.getAverageCost() == null){
            return RestResponse.failure("平均成本价格不能为空");
        }
        if(orderDetail.getFeeMoney() == null){
            return RestResponse.failure("优惠分摊金额不能为空");
        }
        if(orderDetail.getwId() == null){
            return RestResponse.failure("仓库ID不能为空");
        }
        orderDetailService.insert(orderDetail);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑订单详情表页面")
    public String edit(Long id,Model model){
        OrderDetail orderDetail = orderDetailService.selectById(id);
        model.addAttribute("orderDetail",orderDetail);
        return "/admin/orderDetail/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑订单详情表数据")
    public RestResponse edit(OrderDetail orderDetail){
        if(null == orderDetail.getId() || 0 == orderDetail.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(orderDetail.getOrderId() == null){
            return RestResponse.failure("订单表ID不能为空");
        }
        if(orderDetail.getProductId() == null){
            return RestResponse.failure("订单商品ID不能为空");
        }
        if(StringUtils.isBlank(orderDetail.getProductName())){
            return RestResponse.failure("商品名称不能为空");
        }
        if(orderDetail.getProductCnt() == null){
            return RestResponse.failure("购买商品数量不能为空");
        }
        if(orderDetail.getProductPrice() == null){
            return RestResponse.failure("购买商品单价不能为空");
        }
        if(orderDetail.getAverageCost() == null){
            return RestResponse.failure("平均成本价格不能为空");
        }
        if(orderDetail.getFeeMoney() == null){
            return RestResponse.failure("优惠分摊金额不能为空");
        }
        if(orderDetail.getwId() == null){
            return RestResponse.failure("仓库ID不能为空");
        }
        orderDetailService.updateById(orderDetail);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除订单详情表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        OrderDetail orderDetail = orderDetailService.selectById(id);
        orderDetail.setDelFlag(true);
        orderDetailService.updateById(orderDetail);
        return RestResponse.success();
    }

}
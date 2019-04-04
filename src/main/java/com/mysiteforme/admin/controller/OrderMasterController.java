package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.OrderMaster;
import com.mysiteforme.admin.service.OrderMasterService;
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
 * 订单主表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/orderMaster")
public class OrderMasterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMasterController.class);

    @Autowired
    private OrderMasterService orderMasterService;

    @GetMapping("list")
    @SysLog("跳转订单主表列表")
    public String list(){
        return "/admin/orderMaster/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求订单主表列表数据")
    public LayerData<OrderMaster> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<OrderMaster> layerData = new LayerData<>();
        EntityWrapper<OrderMaster> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String orderSn = (String) map.get("orderSn");
            if(StringUtils.isNotBlank(orderSn)) {
                wrapper.like("order_sn",orderSn);
            }else{
                map.remove("orderSn");
            }

            String shippingUser = (String) map.get("shippingUser");
            if(StringUtils.isNotBlank(shippingUser)) {
                wrapper.like("shipping_user",shippingUser);
            }else{
                map.remove("shippingUser");
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

            String district = (String) map.get("district");
            if(StringUtils.isNotBlank(district)) {
                wrapper.like("district",district);
            }else{
                map.remove("district");
            }

            String paymentMethod = (String) map.get("paymentMethod");
            if(StringUtils.isNotBlank(paymentMethod)) {
                wrapper.like("payment_method",paymentMethod);
            }else{
                map.remove("paymentMethod");
            }

            String shippingCompName = (String) map.get("shippingCompName");
            if(StringUtils.isNotBlank(shippingCompName)) {
                wrapper.like("shipping_comp_name",shippingCompName);
            }else{
                map.remove("shippingCompName");
            }

            String shippingSn = (String) map.get("shippingSn");
            if(StringUtils.isNotBlank(shippingSn)) {
                wrapper.like("shipping_sn",shippingSn);
            }else{
                map.remove("shippingSn");
            }

            String beginCreateTime = (String) map.get("beginCreateTime");
            String endCreateTime = (String) map.get("endCreateTime");
            if(StringUtils.isNotBlank(beginCreateTime)) {
                Date begin = DateUtil.parse(beginCreateTime);
                wrapper.ge("create_time",begin);
            }else{
                map.remove("beginCreateTime");
            }
            if(StringUtils.isNotBlank(endCreateTime)) {
                Date end = DateUtil.parse(endCreateTime);
                wrapper.le("create_time",end);
            }else{
                map.remove("endCreateTime");
            }

            String beginShippingTime = (String) map.get("beginShippingTime");
            String endShippingTime = (String) map.get("endShippingTime");
            if(StringUtils.isNotBlank(beginShippingTime)) {
                Date begin = DateUtil.parse(beginShippingTime);
                wrapper.ge("shipping_time",begin);
            }else{
                map.remove("beginShippingTime");
            }
            if(StringUtils.isNotBlank(endShippingTime)) {
                Date end = DateUtil.parse(endShippingTime);
                wrapper.le("shipping_time",end);
            }else{
                map.remove("endShippingTime");
            }

            String beginPayTime = (String) map.get("beginPayTime");
            String endPayTime = (String) map.get("endPayTime");
            if(StringUtils.isNotBlank(beginPayTime)) {
                Date begin = DateUtil.parse(beginPayTime);
                wrapper.ge("pay_time",begin);
            }else{
                map.remove("beginPayTime");
            }
            if(StringUtils.isNotBlank(endPayTime)) {
                Date end = DateUtil.parse(endPayTime);
                wrapper.le("pay_time",end);
            }else{
                map.remove("endPayTime");
            }

            String beginReceiveTime = (String) map.get("beginReceiveTime");
            String endReceiveTime = (String) map.get("endReceiveTime");
            if(StringUtils.isNotBlank(beginReceiveTime)) {
                Date begin = DateUtil.parse(beginReceiveTime);
                wrapper.ge("receive_time",begin);
            }else{
                map.remove("beginReceiveTime");
            }
            if(StringUtils.isNotBlank(endReceiveTime)) {
                Date end = DateUtil.parse(endReceiveTime);
                wrapper.le("receive_time",end);
            }else{
                map.remove("endReceiveTime");
            }

            String orderStatus = (String) map.get("orderStatus");
            if(StringUtils.isNotBlank(orderStatus)) {
                wrapper.like("order_status",orderStatus);
            }else{
                map.remove("orderStatus");
            }

        }
        Page<OrderMaster> pageData = orderMasterService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增订单主表页面")
    public String add(){
        return "/admin/orderMaster/add";
    }

    @PostMapping("add")
    @SysLog("保存新增订单主表数据")
    @ResponseBody
    public RestResponse add(OrderMaster orderMaster){
        if(StringUtils.isBlank(orderMaster.getOrderSn())){
            return RestResponse.failure("订单编号 yyyymmddnnnnnnnn不能为空");
        }
        if(orderMaster.getCustomerId() == null){
            return RestResponse.failure("下单人ID不能为空");
        }
        if(StringUtils.isBlank(orderMaster.getShippingUser())){
            return RestResponse.failure("收货人姓名不能为空");
        }
        if(orderMaster.getProvince() == null){
            return RestResponse.failure("省不能为空");
        }
        if(orderMaster.getCity() == null){
            return RestResponse.failure("市不能为空");
        }
        if(orderMaster.getDistrict() == null){
            return RestResponse.failure("区不能为空");
        }
        if(StringUtils.isBlank(orderMaster.getAddress())){
            return RestResponse.failure("地址不能为空");
        }
        if(orderMaster.getPaymentMethod() == null){
            return RestResponse.failure("支付方式不能为空");
        }
        if(orderMaster.getOrderMoney() == null){
            return RestResponse.failure("订单金额不能为空");
        }
        if(orderMaster.getDistrictMoney() == null){
            return RestResponse.failure("优惠金额不能为空");
        }
        if(orderMaster.getShippingMoney() == null){
            return RestResponse.failure("运费金额不能为空");
        }
        if(orderMaster.getPaymentMoney() == null){
            return RestResponse.failure("支付金额不能为空");
        }
        if(orderMaster.getCreateTime() == null){
            return RestResponse.failure("下单时间不能为空");
        }
        if(orderMaster.getOrderStatus() == null){
            return RestResponse.failure("订单状态不能为空");
        }
        if(orderMaster.getOrderPoint() == null){
            return RestResponse.failure("订单积分不能为空");
        }
        orderMasterService.insert(orderMaster);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑订单主表页面")
    public String edit(Long id,Model model){
        OrderMaster orderMaster = orderMasterService.selectById(id);
        model.addAttribute("orderMaster",orderMaster);
        return "/admin/orderMaster/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑订单主表数据")
    public RestResponse edit(OrderMaster orderMaster){
        if(null == orderMaster.getId() || 0 == orderMaster.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(StringUtils.isBlank(orderMaster.getOrderSn())){
            return RestResponse.failure("订单编号 yyyymmddnnnnnnnn不能为空");
        }
        if(orderMaster.getCustomerId() == null){
            return RestResponse.failure("下单人ID不能为空");
        }
        if(StringUtils.isBlank(orderMaster.getShippingUser())){
            return RestResponse.failure("收货人姓名不能为空");
        }
        if(orderMaster.getProvince() == null){
            return RestResponse.failure("省不能为空");
        }
        if(orderMaster.getCity() == null){
            return RestResponse.failure("市不能为空");
        }
        if(orderMaster.getDistrict() == null){
            return RestResponse.failure("区不能为空");
        }
        if(StringUtils.isBlank(orderMaster.getAddress())){
            return RestResponse.failure("地址不能为空");
        }
        if(orderMaster.getPaymentMethod() == null){
            return RestResponse.failure("支付方式不能为空");
        }
        if(orderMaster.getOrderMoney() == null){
            return RestResponse.failure("订单金额不能为空");
        }
        if(orderMaster.getDistrictMoney() == null){
            return RestResponse.failure("优惠金额不能为空");
        }
        if(orderMaster.getShippingMoney() == null){
            return RestResponse.failure("运费金额不能为空");
        }
        if(orderMaster.getPaymentMoney() == null){
            return RestResponse.failure("支付金额不能为空");
        }
        if(orderMaster.getCreateTime() == null){
            return RestResponse.failure("下单时间不能为空");
        }
        if(orderMaster.getOrderStatus() == null){
            return RestResponse.failure("订单状态不能为空");
        }
        if(orderMaster.getOrderPoint() == null){
            return RestResponse.failure("订单积分不能为空");
        }
        orderMasterService.updateById(orderMaster);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除订单主表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        OrderMaster orderMaster = orderMasterService.selectById(id);
        orderMaster.setDelFlag(true);
        orderMasterService.updateById(orderMaster);
        return RestResponse.success();
    }

}
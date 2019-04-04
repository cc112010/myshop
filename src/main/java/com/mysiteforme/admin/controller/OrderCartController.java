package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.OrderCart;
import com.mysiteforme.admin.service.OrderCartService;
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
 * 购物车表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/orderCart")
public class OrderCartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderCartController.class);

    @Autowired
    private OrderCartService orderCartService;

    @GetMapping("list")
    @SysLog("跳转购物车表列表")
    public String list(){
        return "/admin/orderCart/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求购物车表列表数据")
    public LayerData<OrderCart> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<OrderCart> layerData = new LayerData<>();
        EntityWrapper<OrderCart> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String beginAddTime = (String) map.get("beginAddTime");
            String endAddTime = (String) map.get("endAddTime");
            if(StringUtils.isNotBlank(beginAddTime)) {
                Date begin = DateUtil.parse(beginAddTime);
                wrapper.ge("add_time",begin);
            }else{
                map.remove("beginAddTime");
            }
            if(StringUtils.isNotBlank(endAddTime)) {
                Date end = DateUtil.parse(endAddTime);
                wrapper.le("add_time",end);
            }else{
                map.remove("endAddTime");
            }

        }
        Page<OrderCart> pageData = orderCartService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增购物车表页面")
    public String add(){
        return "/admin/orderCart/add";
    }

    @PostMapping("add")
    @SysLog("保存新增购物车表数据")
    @ResponseBody
    public RestResponse add(OrderCart orderCart){
        if(orderCart.getCustomerId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(orderCart.getProductId() == null){
            return RestResponse.failure("商品ID不能为空");
        }
        if(orderCart.getProductAmount() == null){
            return RestResponse.failure("加入购物车商品数量不能为空");
        }
        if(orderCart.getPrice() == null){
            return RestResponse.failure("商品价格不能为空");
        }
        if(orderCart.getAddTime() == null){
            return RestResponse.failure("加入购物车时间不能为空");
        }
        orderCartService.insert(orderCart);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑购物车表页面")
    public String edit(Long id,Model model){
        OrderCart orderCart = orderCartService.selectById(id);
        model.addAttribute("orderCart",orderCart);
        return "/admin/orderCart/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑购物车表数据")
    public RestResponse edit(OrderCart orderCart){
        if(null == orderCart.getId() || 0 == orderCart.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(orderCart.getCustomerId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(orderCart.getProductId() == null){
            return RestResponse.failure("商品ID不能为空");
        }
        if(orderCart.getProductAmount() == null){
            return RestResponse.failure("加入购物车商品数量不能为空");
        }
        if(orderCart.getPrice() == null){
            return RestResponse.failure("商品价格不能为空");
        }
        if(orderCart.getAddTime() == null){
            return RestResponse.failure("加入购物车时间不能为空");
        }
        orderCartService.updateById(orderCart);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除购物车表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        OrderCart orderCart = orderCartService.selectById(id);
        orderCart.setDelFlag(true);
        orderCartService.updateById(orderCart);
        return RestResponse.success();
    }

}
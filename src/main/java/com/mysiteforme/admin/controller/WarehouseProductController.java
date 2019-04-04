package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.WarehouseProduct;
import com.mysiteforme.admin.service.WarehouseProductService;
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
 * 商品库存表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/warehouseProduct")
public class WarehouseProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseProductController.class);

    @Autowired
    private WarehouseProductService warehouseProductService;

    @GetMapping("list")
    @SysLog("跳转商品库存表列表")
    public String list(){
        return "/admin/warehouseProduct/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求商品库存表列表数据")
    public LayerData<WarehouseProduct> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WarehouseProduct> layerData = new LayerData<>();
        EntityWrapper<WarehouseProduct> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
        }
        Page<WarehouseProduct> pageData = warehouseProductService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增商品库存表页面")
    public String add(){
        return "/admin/warehouseProduct/add";
    }

    @PostMapping("add")
    @SysLog("保存新增商品库存表数据")
    @ResponseBody
    public RestResponse add(WarehouseProduct warehouseProduct){
        if(warehouseProduct.getProductId() == null){
            return RestResponse.failure("商品ID不能为空");
        }
        if(warehouseProduct.getwId() == null){
            return RestResponse.failure("仓库ID不能为空");
        }
        if(warehouseProduct.getCurrentCnt() == null){
            return RestResponse.failure("当前商品数量不能为空");
        }
        if(warehouseProduct.getLockCnt() == null){
            return RestResponse.failure("当前占用数据不能为空");
        }
        if(warehouseProduct.getInTransitCnt() == null){
            return RestResponse.failure("在途数据不能为空");
        }
        if(warehouseProduct.getAverageCost() == null){
            return RestResponse.failure("移动加权成本不能为空");
        }
        warehouseProductService.insert(warehouseProduct);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑商品库存表页面")
    public String edit(Long id,Model model){
        WarehouseProduct warehouseProduct = warehouseProductService.selectById(id);
        model.addAttribute("warehouseProduct",warehouseProduct);
        return "/admin/warehouseProduct/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑商品库存表数据")
    public RestResponse edit(WarehouseProduct warehouseProduct){
        if(null == warehouseProduct.getId() || 0 == warehouseProduct.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(warehouseProduct.getProductId() == null){
            return RestResponse.failure("商品ID不能为空");
        }
        if(warehouseProduct.getwId() == null){
            return RestResponse.failure("仓库ID不能为空");
        }
        if(warehouseProduct.getCurrentCnt() == null){
            return RestResponse.failure("当前商品数量不能为空");
        }
        if(warehouseProduct.getLockCnt() == null){
            return RestResponse.failure("当前占用数据不能为空");
        }
        if(warehouseProduct.getInTransitCnt() == null){
            return RestResponse.failure("在途数据不能为空");
        }
        if(warehouseProduct.getAverageCost() == null){
            return RestResponse.failure("移动加权成本不能为空");
        }
        warehouseProductService.updateById(warehouseProduct);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除商品库存表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WarehouseProduct warehouseProduct = warehouseProductService.selectById(id);
        warehouseProduct.setDelFlag(true);
        warehouseProductService.updateById(warehouseProduct);
        return RestResponse.success();
    }

}
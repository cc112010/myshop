package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.ProductInfo;
import com.mysiteforme.admin.service.ProductInfoService;
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
 * 商品信息表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/productInfo")
public class ProductInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductInfoController.class);

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("list")
    @SysLog("跳转商品信息表列表")
    public String list(){
        return "/admin/productInfo/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求商品信息表列表数据")
    public LayerData<ProductInfo> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<ProductInfo> layerData = new LayerData<>();
        EntityWrapper<ProductInfo> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String productCore = (String) map.get("productCore");
            if(StringUtils.isNotBlank(productCore)) {
                wrapper.like("product_core",productCore);
            }else{
                map.remove("productCore");
            }

            String productName = (String) map.get("productName");
            if(StringUtils.isNotBlank(productName)) {
                wrapper.like("product_name",productName);
            }else{
                map.remove("productName");
            }

            String barCode = (String) map.get("barCode");
            if(StringUtils.isNotBlank(barCode)) {
                wrapper.like("bar_code",barCode);
            }else{
                map.remove("barCode");
            }

            String publishStatus = (String) map.get("publishStatus");
            if(StringUtils.isNotBlank(publishStatus)) {
                wrapper.like("publish_status",publishStatus);
            }else{
                map.remove("publishStatus");
            }

            String auditStatus = (String) map.get("auditStatus");
            if(StringUtils.isNotBlank(auditStatus)) {
                wrapper.like("audit_status",auditStatus);
            }else{
                map.remove("auditStatus");
            }

            String colorType = (String) map.get("colorType");
            if(StringUtils.isNotBlank(colorType)) {
                wrapper.like("color_type",colorType);
            }else{
                map.remove("colorType");
            }

            String beginProductionDate = (String) map.get("beginProductionDate");
            String endProductionDate = (String) map.get("endProductionDate");
            if(StringUtils.isNotBlank(beginProductionDate)) {
                Date begin = DateUtil.parse(beginProductionDate);
                wrapper.ge("production_date",begin);
            }else{
                map.remove("beginProductionDate");
            }
            if(StringUtils.isNotBlank(endProductionDate)) {
                Date end = DateUtil.parse(endProductionDate);
                wrapper.le("production_date",end);
            }else{
                map.remove("endProductionDate");
            }

        }
        Page<ProductInfo> pageData = productInfoService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增商品信息表页面")
    public String add(){
        return "/admin/productInfo/add";
    }

    @PostMapping("add")
    @SysLog("保存新增商品信息表数据")
    @ResponseBody
    public RestResponse add(ProductInfo productInfo){
        if(StringUtils.isBlank(productInfo.getProductCore())){
            return RestResponse.failure("商品编码不能为空");
        }
        if(StringUtils.isBlank(productInfo.getProductName())){
            return RestResponse.failure("商品名称不能为空");
        }
        if(StringUtils.isBlank(productInfo.getBarCode())){
            return RestResponse.failure("国条码不能为空");
        }
        if(productInfo.getBrandId() == null){
            return RestResponse.failure("品牌表的ID不能为空");
        }
        if(productInfo.getOneCategoryId() == null){
            return RestResponse.failure("一级分类ID不能为空");
        }
        if(productInfo.getTwoCategoryId() == null){
            return RestResponse.failure("二级分类ID不能为空");
        }
        if(productInfo.getThreeCategoryId() == null){
            return RestResponse.failure("三级分类ID不能为空");
        }
        if(productInfo.getSupplierId() == null){
            return RestResponse.failure("商品的供应商ID不能为空");
        }
        if(productInfo.getPrice() == null){
            return RestResponse.failure("商品销售价格不能为空");
        }
        if(productInfo.getAverageCost() == null){
            return RestResponse.failure("商品加权平均成本不能为空");
        }
        if(productInfo.getPublishStatus() == null){
            return RestResponse.failure("上下架状态：0下架1上架不能为空");
        }
        if(productInfo.getAuditStatus() == null){
            return RestResponse.failure("审核状态：0未审核，1已审核不能为空");
        }
        productInfoService.insert(productInfo);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑商品信息表页面")
    public String edit(Long id,Model model){
        ProductInfo productInfo = productInfoService.selectById(id);
        model.addAttribute("productInfo",productInfo);
        return "/admin/productInfo/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑商品信息表数据")
    public RestResponse edit(ProductInfo productInfo){
        if(null == productInfo.getId() || 0 == productInfo.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(StringUtils.isBlank(productInfo.getProductCore())){
            return RestResponse.failure("商品编码不能为空");
        }
        if(StringUtils.isBlank(productInfo.getProductName())){
            return RestResponse.failure("商品名称不能为空");
        }
        if(StringUtils.isBlank(productInfo.getBarCode())){
            return RestResponse.failure("国条码不能为空");
        }
        if(productInfo.getBrandId() == null){
            return RestResponse.failure("品牌表的ID不能为空");
        }
        if(productInfo.getOneCategoryId() == null){
            return RestResponse.failure("一级分类ID不能为空");
        }
        if(productInfo.getTwoCategoryId() == null){
            return RestResponse.failure("二级分类ID不能为空");
        }
        if(productInfo.getThreeCategoryId() == null){
            return RestResponse.failure("三级分类ID不能为空");
        }
        if(productInfo.getSupplierId() == null){
            return RestResponse.failure("商品的供应商ID不能为空");
        }
        if(productInfo.getPrice() == null){
            return RestResponse.failure("商品销售价格不能为空");
        }
        if(productInfo.getAverageCost() == null){
            return RestResponse.failure("商品加权平均成本不能为空");
        }
        if(productInfo.getPublishStatus() == null){
            return RestResponse.failure("上下架状态：0下架1上架不能为空");
        }
        if(productInfo.getAuditStatus() == null){
            return RestResponse.failure("审核状态：0未审核，1已审核不能为空");
        }
        productInfoService.updateById(productInfo);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除商品信息表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        ProductInfo productInfo = productInfoService.selectById(id);
        productInfo.setDelFlag(true);
        productInfoService.updateById(productInfo);
        return RestResponse.success();
    }

}
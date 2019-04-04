package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.ProductCategory;
import com.mysiteforme.admin.service.ProductCategoryService;
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
 * 分类信息表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/productCategory")
public class ProductCategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryController.class);

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("list")
    @SysLog("跳转分类信息表列表")
    public String list(){
        return "/admin/productCategory/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求分类信息表列表数据")
    public LayerData<ProductCategory> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<ProductCategory> layerData = new LayerData<>();
        EntityWrapper<ProductCategory> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String categoryName = (String) map.get("categoryName");
            if(StringUtils.isNotBlank(categoryName)) {
                wrapper.like("category_name",categoryName);
            }else{
                map.remove("categoryName");
            }

            String categoryCode = (String) map.get("categoryCode");
            if(StringUtils.isNotBlank(categoryCode)) {
                wrapper.like("category_code",categoryCode);
            }else{
                map.remove("categoryCode");
            }

            String categoryLevel = (String) map.get("categoryLevel");
            if(StringUtils.isNotBlank(categoryLevel)) {
                wrapper.like("category_level",categoryLevel);
            }else{
                map.remove("categoryLevel");
            }

            String categoryStatus = (String) map.get("categoryStatus");
            if(StringUtils.isNotBlank(categoryStatus)) {
                wrapper.like("category_status",categoryStatus);
            }else{
                map.remove("categoryStatus");
            }

        }
        Page<ProductCategory> pageData = productCategoryService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增分类信息表页面")
    public String add(){
        return "/admin/productCategory/add";
    }

    @PostMapping("add")
    @SysLog("保存新增分类信息表数据")
    @ResponseBody
    public RestResponse add(ProductCategory productCategory){
        if(StringUtils.isBlank(productCategory.getCategoryName())){
            return RestResponse.failure("分类名称不能为空");
        }
        if(StringUtils.isBlank(productCategory.getCategoryCode())){
            return RestResponse.failure("分类编码不能为空");
        }
        if(productCategory.getCategoryLevel() == null){
            return RestResponse.failure("分类层级不能为空");
        }
        if(productCategory.getCategoryStatus() == null){
            return RestResponse.failure("分类状态不能为空");
        }
        productCategoryService.insert(productCategory);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑分类信息表页面")
    public String edit(Long id,Model model){
        ProductCategory productCategory = productCategoryService.selectById(id);
        model.addAttribute("productCategory",productCategory);
        return "/admin/productCategory/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑分类信息表数据")
    public RestResponse edit(ProductCategory productCategory){
        if(null == productCategory.getId() || 0 == productCategory.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(StringUtils.isBlank(productCategory.getCategoryName())){
            return RestResponse.failure("分类名称不能为空");
        }
        if(StringUtils.isBlank(productCategory.getCategoryCode())){
            return RestResponse.failure("分类编码不能为空");
        }
        if(productCategory.getCategoryLevel() == null){
            return RestResponse.failure("分类层级不能为空");
        }
        if(productCategory.getCategoryStatus() == null){
            return RestResponse.failure("分类状态不能为空");
        }
        productCategoryService.updateById(productCategory);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除分类信息表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        ProductCategory productCategory = productCategoryService.selectById(id);
        productCategory.setDelFlag(true);
        productCategoryService.updateById(productCategory);
        return RestResponse.success();
    }

}
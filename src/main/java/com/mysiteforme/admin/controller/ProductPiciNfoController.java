package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.ProductPiciNfo;
import com.mysiteforme.admin.service.ProductPiciNfoService;
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
 * 商品图片表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/productPiciNfo")
public class ProductPiciNfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPiciNfoController.class);

    @Autowired
    private ProductPiciNfoService productPiciNfoService;

    @GetMapping("list")
    @SysLog("跳转商品图片表列表")
    public String list(){
        return "/admin/productPiciNfo/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求商品图片表列表数据")
    public LayerData<ProductPiciNfo> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<ProductPiciNfo> layerData = new LayerData<>();
        EntityWrapper<ProductPiciNfo> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String isMaster = (String) map.get("isMaster");
            if(StringUtils.isNotBlank(isMaster)) {
                wrapper.like("is_master",isMaster);
            }else{
                map.remove("isMaster");
            }

            String picStatus = (String) map.get("picStatus");
            if(StringUtils.isNotBlank(picStatus)) {
                wrapper.like("pic_status",picStatus);
            }else{
                map.remove("picStatus");
            }

        }
        Page<ProductPiciNfo> pageData = productPiciNfoService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增商品图片表页面")
    public String add(){
        return "/admin/productPiciNfo/add";
    }

    @PostMapping("add")
    @SysLog("保存新增商品图片表数据")
    @ResponseBody
    public RestResponse add(ProductPiciNfo productPiciNfo){
        if(productPiciNfo.getProductId() == null){
            return RestResponse.failure("商品ID不能为空");
        }
        if(StringUtils.isBlank(productPiciNfo.getPicUrl())){
            return RestResponse.failure("图片URL不能为空");
        }
        if(productPiciNfo.getIsMaster() == null){
            return RestResponse.failure("是否主图不能为空");
        }
        if(productPiciNfo.getPicOrder() == null){
            return RestResponse.failure("图片排序不能为空");
        }
        if(productPiciNfo.getPicStatus() == null){
            return RestResponse.failure("图片是否有效不能为空");
        }
        productPiciNfoService.insert(productPiciNfo);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑商品图片表页面")
    public String edit(Long id,Model model){
        ProductPiciNfo productPiciNfo = productPiciNfoService.selectById(id);
        model.addAttribute("productPiciNfo",productPiciNfo);
        return "/admin/productPiciNfo/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑商品图片表数据")
    public RestResponse edit(ProductPiciNfo productPiciNfo){
        if(null == productPiciNfo.getId() || 0 == productPiciNfo.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(productPiciNfo.getProductId() == null){
            return RestResponse.failure("商品ID不能为空");
        }
        if(StringUtils.isBlank(productPiciNfo.getPicUrl())){
            return RestResponse.failure("图片URL不能为空");
        }
        if(productPiciNfo.getIsMaster() == null){
            return RestResponse.failure("是否主图不能为空");
        }
        if(productPiciNfo.getPicOrder() == null){
            return RestResponse.failure("图片排序不能为空");
        }
        if(productPiciNfo.getPicStatus() == null){
            return RestResponse.failure("图片是否有效不能为空");
        }
        productPiciNfoService.updateById(productPiciNfo);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除商品图片表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        ProductPiciNfo productPiciNfo = productPiciNfoService.selectById(id);
        productPiciNfo.setDelFlag(true);
        productPiciNfoService.updateById(productPiciNfo);
        return RestResponse.success();
    }

}
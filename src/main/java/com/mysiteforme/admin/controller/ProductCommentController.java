package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.ProductComment;
import com.mysiteforme.admin.service.ProductCommentService;
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
 * 商品评论表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/productComment")
public class ProductCommentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCommentController.class);

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("list")
    @SysLog("跳转商品评论表列表")
    public String list(){
        return "/admin/productComment/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求商品评论表列表数据")
    public LayerData<ProductComment> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<ProductComment> layerData = new LayerData<>();
        EntityWrapper<ProductComment> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String auditStatus = (String) map.get("auditStatus");
            if(StringUtils.isNotBlank(auditStatus)) {
                wrapper.like("audit_status",auditStatus);
            }else{
                map.remove("auditStatus");
            }

            String beginAuditTime = (String) map.get("beginAuditTime");
            String endAuditTime = (String) map.get("endAuditTime");
            if(StringUtils.isNotBlank(beginAuditTime)) {
                Date begin = DateUtil.parse(beginAuditTime);
                wrapper.ge("audit_time",begin);
            }else{
                map.remove("beginAuditTime");
            }
            if(StringUtils.isNotBlank(endAuditTime)) {
                Date end = DateUtil.parse(endAuditTime);
                wrapper.le("audit_time",end);
            }else{
                map.remove("endAuditTime");
            }

        }
        Page<ProductComment> pageData = productCommentService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增商品评论表页面")
    public String add(){
        return "/admin/productComment/add";
    }

    @PostMapping("add")
    @SysLog("保存新增商品评论表数据")
    @ResponseBody
    public RestResponse add(ProductComment productComment){
        if(productComment.getProductId() == null){
            return RestResponse.failure("商品ID不能为空");
        }
        if(productComment.getOrderId() == null){
            return RestResponse.failure("订单ID不能为空");
        }
        if(productComment.getCustomerId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(StringUtils.isBlank(productComment.getTitle())){
            return RestResponse.failure("评论标题不能为空");
        }
        if(StringUtils.isBlank(productComment.getContent())){
            return RestResponse.failure("评论内容不能为空");
        }
        if(productComment.getAuditStatus() == null){
            return RestResponse.failure("审核状态不能为空");
        }
        productCommentService.insert(productComment);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑商品评论表页面")
    public String edit(Long id,Model model){
        ProductComment productComment = productCommentService.selectById(id);
        model.addAttribute("productComment",productComment);
        return "/admin/productComment/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑商品评论表数据")
    public RestResponse edit(ProductComment productComment){
        if(null == productComment.getId() || 0 == productComment.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(productComment.getProductId() == null){
            return RestResponse.failure("商品ID不能为空");
        }
        if(productComment.getOrderId() == null){
            return RestResponse.failure("订单ID不能为空");
        }
        if(productComment.getCustomerId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(StringUtils.isBlank(productComment.getTitle())){
            return RestResponse.failure("评论标题不能为空");
        }
        if(StringUtils.isBlank(productComment.getContent())){
            return RestResponse.failure("评论内容不能为空");
        }
        if(productComment.getAuditStatus() == null){
            return RestResponse.failure("审核状态不能为空");
        }
        productCommentService.updateById(productComment);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除商品评论表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        ProductComment productComment = productCommentService.selectById(id);
        productComment.setDelFlag(true);
        productCommentService.updateById(productComment);
        return RestResponse.success();
    }

}
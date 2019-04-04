package com.mysiteforme.admin.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.BrandInfo;
import com.mysiteforme.admin.service.BrandInfoService;
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
 * 品牌信息表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Controller
@RequestMapping("/admin/brandInfo")
public class BrandInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrandInfoController.class);

    @Autowired
    private BrandInfoService brandInfoService;

    @GetMapping("list")
    @SysLog("跳转品牌信息表列表")
    public String list(){
        return "/admin/brandInfo/list";
    }

    @RequiresPermissions("brand:info:list")
    @PostMapping("list")
    @ResponseBody
    @SysLog("请求品牌信息表列表数据")
    public LayerData<BrandInfo> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<BrandInfo> layerData = new LayerData<>();
        EntityWrapper<BrandInfo> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String brandName = (String) map.get("brandName");
            if(StringUtils.isNotBlank(brandName)) {
                wrapper.like("brand_name",brandName);
            }else{
                map.remove("brandName");
            }

            String telephone = (String) map.get("telephone");
            if(StringUtils.isNotBlank(telephone)) {
                wrapper.like("telephone",telephone);
            }else{
                map.remove("telephone");
            }

            String brandWeb = (String) map.get("brandWeb");
            if(StringUtils.isNotBlank(brandWeb)) {
                wrapper.like("brand_web",brandWeb);
            }else{
                map.remove("brandWeb");
            }

        }
        Page<BrandInfo> pageData = brandInfoService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增品牌信息表页面")
    public String add(){
        return "/admin/brandInfo/add";
    }

    @RequiresPermissions("brand:info:add")
    @PostMapping("add")
    @SysLog("保存新增品牌信息表数据")
    @ResponseBody
    public RestResponse add(BrandInfo brandInfo){
        if(StringUtils.isBlank(brandInfo.getBrandName())){
            return RestResponse.failure("品牌名称不能为空");
        }
        if(StringUtils.isBlank(brandInfo.getTelephone())){
            return RestResponse.failure("联系电话不能为空");
        }
        if(brandInfo.getBrandStatus() == null){
            return RestResponse.failure("品牌状态不能为空");
        }
        if(brandInfo.getBrandOrder() == null){
            return RestResponse.failure("排序不能为空");
        }
        brandInfoService.insert(brandInfo);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑品牌信息表页面")
    public String edit(Long id,Model model){
        BrandInfo brandInfo = brandInfoService.selectById(id);
        model.addAttribute("brandInfo",brandInfo);
        return "/admin/brandInfo/edit";
    }

    @RequiresPermissions("brand:info:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑品牌信息表数据")
    public RestResponse edit(BrandInfo brandInfo){
        if(null == brandInfo.getId() || 0 == brandInfo.getId()){
            return RestResponse.failure("ID不能为空");
        }
        if(StringUtils.isBlank(brandInfo.getBrandName())){
            return RestResponse.failure("品牌名称不能为空");
        }
        if(StringUtils.isBlank(brandInfo.getTelephone())){
            return RestResponse.failure("联系电话不能为空");
        }
        if(brandInfo.getBrandStatus() == null){
            return RestResponse.failure("品牌状态不能为空");
        }
        if(brandInfo.getBrandOrder() == null){
            return RestResponse.failure("排序不能为空");
        }
        brandInfoService.updateById(brandInfo);
        return RestResponse.success();
    }

    @RequiresPermissions("brand:info:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除品牌信息表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        BrandInfo brandInfo = brandInfoService.selectById(id);
        brandInfo.setDelFlag(true);
        brandInfoService.updateById(brandInfo);
        return RestResponse.success();
    }

}
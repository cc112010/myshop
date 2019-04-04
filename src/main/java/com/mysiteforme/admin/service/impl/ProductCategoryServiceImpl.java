package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.ProductCategory;
import com.mysiteforme.admin.dao.ProductCategoryDao;
import com.mysiteforme.admin.service.ProductCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 分类信息表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategory> implements ProductCategoryService {

}

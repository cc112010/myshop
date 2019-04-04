package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.ProductInfo;
import com.mysiteforme.admin.dao.ProductInfoDao;
import com.mysiteforme.admin.service.ProductInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品信息表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoDao, ProductInfo> implements ProductInfoService {

}

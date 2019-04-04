package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.ProductPiciNfo;
import com.mysiteforme.admin.dao.ProductPiciNfoDao;
import com.mysiteforme.admin.service.ProductPiciNfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品图片表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductPiciNfoServiceImpl extends ServiceImpl<ProductPiciNfoDao, ProductPiciNfo> implements ProductPiciNfoService {

}

package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.ProductComment;
import com.mysiteforme.admin.dao.ProductCommentDao;
import com.mysiteforme.admin.service.ProductCommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品评论表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductCommentServiceImpl extends ServiceImpl<ProductCommentDao, ProductComment> implements ProductCommentService {

}

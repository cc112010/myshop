package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.OrderCart;
import com.mysiteforme.admin.dao.OrderCartDao;
import com.mysiteforme.admin.service.OrderCartService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderCartServiceImpl extends ServiceImpl<OrderCartDao, OrderCart> implements OrderCartService {

}

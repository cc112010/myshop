package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.OrderDetail;
import com.mysiteforme.admin.dao.OrderDetailDao;
import com.mysiteforme.admin.service.OrderDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailDao, OrderDetail> implements OrderDetailService {

}

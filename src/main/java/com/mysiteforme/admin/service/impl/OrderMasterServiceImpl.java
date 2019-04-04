package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.OrderMaster;
import com.mysiteforme.admin.dao.OrderMasterDao;
import com.mysiteforme.admin.service.OrderMasterService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单主表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterDao, OrderMaster> implements OrderMasterService {

}

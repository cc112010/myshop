package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.CustomerBalanceLog;
import com.mysiteforme.admin.dao.CustomerBalanceLogDao;
import com.mysiteforme.admin.service.CustomerBalanceLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户余额变动表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerBalanceLogServiceImpl extends ServiceImpl<CustomerBalanceLogDao, CustomerBalanceLog> implements CustomerBalanceLogService {

}

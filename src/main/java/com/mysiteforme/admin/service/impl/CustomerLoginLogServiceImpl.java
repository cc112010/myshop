package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.CustomerLoginLog;
import com.mysiteforme.admin.dao.CustomerLoginLogDao;
import com.mysiteforme.admin.service.CustomerLoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户登陆日志表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerLoginLogServiceImpl extends ServiceImpl<CustomerLoginLogDao, CustomerLoginLog> implements CustomerLoginLogService {

}

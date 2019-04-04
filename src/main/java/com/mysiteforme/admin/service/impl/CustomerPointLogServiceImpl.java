package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.CustomerPointLog;
import com.mysiteforme.admin.dao.CustomerPointLogDao;
import com.mysiteforme.admin.service.CustomerPointLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户积分日志表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerPointLogServiceImpl extends ServiceImpl<CustomerPointLogDao, CustomerPointLog> implements CustomerPointLogService {

}

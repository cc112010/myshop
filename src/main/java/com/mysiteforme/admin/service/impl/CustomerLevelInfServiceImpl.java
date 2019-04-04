package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.CustomerLevelInf;
import com.mysiteforme.admin.dao.CustomerLevelInfDao;
import com.mysiteforme.admin.service.CustomerLevelInfService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户级别表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerLevelInfServiceImpl extends ServiceImpl<CustomerLevelInfDao, CustomerLevelInf> implements CustomerLevelInfService {

}

package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.CustomerInf;
import com.mysiteforme.admin.dao.CustomerInfDao;
import com.mysiteforme.admin.service.CustomerInfService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerInfServiceImpl extends ServiceImpl<CustomerInfDao, CustomerInf> implements CustomerInfService {

}

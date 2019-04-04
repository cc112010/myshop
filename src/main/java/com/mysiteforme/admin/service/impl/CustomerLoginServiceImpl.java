package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.CustomerLogin;
import com.mysiteforme.admin.dao.CustomerLoginDao;
import com.mysiteforme.admin.service.CustomerLoginService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerLoginServiceImpl extends ServiceImpl<CustomerLoginDao, CustomerLogin> implements CustomerLoginService {

}

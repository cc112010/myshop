package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.CustomerAddr;
import com.mysiteforme.admin.dao.CustomerAddrDao;
import com.mysiteforme.admin.service.CustomerAddrService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户地址表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerAddrServiceImpl extends ServiceImpl<CustomerAddrDao, CustomerAddr> implements CustomerAddrService {

}

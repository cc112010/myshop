package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.SupplierInfo;
import com.mysiteforme.admin.dao.SupplierInfoDao;
import com.mysiteforme.admin.service.SupplierInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 供应商信息表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SupplierInfoServiceImpl extends ServiceImpl<SupplierInfoDao, SupplierInfo> implements SupplierInfoService {

}

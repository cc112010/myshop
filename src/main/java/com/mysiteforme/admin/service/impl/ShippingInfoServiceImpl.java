package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.ShippingInfo;
import com.mysiteforme.admin.dao.ShippingInfoDao;
import com.mysiteforme.admin.service.ShippingInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 物流公司信息表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShippingInfoServiceImpl extends ServiceImpl<ShippingInfoDao, ShippingInfo> implements ShippingInfoService {

}

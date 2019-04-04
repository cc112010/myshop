package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.WarehouseProduct;
import com.mysiteforme.admin.dao.WarehouseProductDao;
import com.mysiteforme.admin.service.WarehouseProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品库存表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WarehouseProductServiceImpl extends ServiceImpl<WarehouseProductDao, WarehouseProduct> implements WarehouseProductService {

}

package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.WarehouseInfo;
import com.mysiteforme.admin.dao.WarehouseInfoDao;
import com.mysiteforme.admin.service.WarehouseInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 仓库信息表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WarehouseInfoServiceImpl extends ServiceImpl<WarehouseInfoDao, WarehouseInfo> implements WarehouseInfoService {

}

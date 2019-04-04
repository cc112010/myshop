package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.BrandInfo;
import com.mysiteforme.admin.dao.BrandInfoDao;
import com.mysiteforme.admin.service.BrandInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 品牌信息表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BrandInfoServiceImpl extends ServiceImpl<BrandInfoDao, BrandInfo> implements BrandInfoService {

}

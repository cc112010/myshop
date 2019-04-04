package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 用户级别表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("customer_level_inf")
public class CustomerLevelInf extends DataEntity<CustomerLevelInf> {

    private static final long serialVersionUID = 1L;

    /**
     * 会员级别名称
     */
	@TableField("level_name")
	private String levelName;
    /**
     * 该级别最低积分
     */
	@TableField("min_point")
	private Integer minPoint;
    /**
     * 该级别最高积分
     */
	@TableField("max_point")
	private Integer maxPoint;

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Integer getMinPoint() {
		return minPoint;
	}

	public void setMinPoint(Integer minPoint) {
		this.minPoint = minPoint;
	}
	public Integer getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(Integer maxPoint) {
		this.maxPoint = maxPoint;
	}


	@Override
	public String toString() {
		return "CustomerLevelInf{" +
			", levelName=" + levelName +
			", minPoint=" + minPoint +
			", maxPoint=" + maxPoint +
			"}";
	}
}

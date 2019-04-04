package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 用户积分日志表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("customer_point_log")
public class CustomerPointLog extends DataEntity<CustomerPointLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 积分来源：0订单，1登陆，2活动
     */
	private Integer source;
    /**
     * 积分来源相关编号
     */
	@TableField("refer_number")
	private Integer referNumber;
    /**
     * 变更积分数
     */
	@TableField("change_point")
	private Integer changePoint;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getReferNumber() {
		return referNumber;
	}

	public void setReferNumber(Integer referNumber) {
		this.referNumber = referNumber;
	}
	public Integer getChangePoint() {
		return changePoint;
	}

	public void setChangePoint(Integer changePoint) {
		this.changePoint = changePoint;
	}


	@Override
	public String toString() {
		return "CustomerPointLog{" +
			", customerId=" + customerId +
			", source=" + source +
			", referNumber=" + referNumber +
			", changePoint=" + changePoint +
			"}";
	}
}

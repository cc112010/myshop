package com.mysiteforme.admin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 用户余额变动表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("customer_balance_log")
public class CustomerBalanceLog extends DataEntity<CustomerBalanceLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 记录来源：1订单，2退货单
     */
	private Integer source;
    /**
     * 相关单据ID
     */
	@TableField("source_sn")
	private String sourceSn;
    /**
     * 变动金额
     */
	private BigDecimal amount;

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
	public String getSourceSn() {
		return sourceSn;
	}

	public void setSourceSn(String sourceSn) {
		this.sourceSn = sourceSn;
	}
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "CustomerBalanceLog{" +
			", customerId=" + customerId +
			", source=" + source +
			", sourceSn=" + sourceSn +
			", amount=" + amount +
			"}";
	}
}

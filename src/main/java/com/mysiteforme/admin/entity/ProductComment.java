package com.mysiteforme.admin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 商品评论表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("product_comment")
public class ProductComment extends DataEntity<ProductComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
	@TableField("product_id")
	private Long productId;
    /**
     * 订单ID
     */
	@TableField("order_id")
	private Long orderId;
    /**
     * 用户ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 评论标题
     */
	private String title;
    /**
     * 评论内容
     */
	private String content;
    /**
     * 审核状态
     */
	@TableField("audit_status")
	private Integer auditStatus;
    /**
     * 评论时间
     */
	@TableField("audit_time")
	private Date auditTime;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}


	@Override
	public String toString() {
		return "ProductComment{" +
			", productId=" + productId +
			", orderId=" + orderId +
			", customerId=" + customerId +
			", title=" + title +
			", content=" + content +
			", auditStatus=" + auditStatus +
			", auditTime=" + auditTime +
			"}";
	}
}

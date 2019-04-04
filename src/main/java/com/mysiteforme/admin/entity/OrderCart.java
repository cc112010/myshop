package com.mysiteforme.admin.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 购物车表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("order_cart")
public class OrderCart extends DataEntity<OrderCart> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 商品ID
     */
	@TableField("product_id")
	private Long productId;
    /**
     * 加入购物车商品数量
     */
	@TableField("product_amount")
	private Integer productAmount;
    /**
     * 商品价格
     */
	private BigDecimal price;
    /**
     * 加入购物车时间
     */
	@TableField("add_time")
	private Date addTime;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	@Override
	public String toString() {
		return "OrderCart{" +
			", customerId=" + customerId +
			", productId=" + productId +
			", productAmount=" + productAmount +
			", price=" + price +
			", addTime=" + addTime +
			"}";
	}
}

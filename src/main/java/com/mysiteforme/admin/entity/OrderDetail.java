package com.mysiteforme.admin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("order_detail")
public class OrderDetail extends DataEntity<OrderDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单表ID
     */
	@TableField("order_id")
	private Long orderId;
    /**
     * 订单商品ID
     */
	@TableField("product_id")
	private Long productId;
    /**
     * 商品名称
     */
	@TableField("product_name")
	private String productName;
    /**
     * 购买商品数量
     */
	@TableField("product_cnt")
	private Integer productCnt;
    /**
     * 购买商品单价
     */
	@TableField("product_price")
	private BigDecimal productPrice;
    /**
     * 平均成本价格
     */
	@TableField("average_cost")
	private BigDecimal averageCost;
    /**
     * 商品重量
     */
	private Float weight;
    /**
     * 优惠分摊金额
     */
	@TableField("fee_money")
	private BigDecimal feeMoney;
    /**
     * 仓库ID
     */
	@TableField("w_id")
	private Long wId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(Integer productCnt) {
		this.productCnt = productCnt;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public BigDecimal getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(BigDecimal averageCost) {
		this.averageCost = averageCost;
	}
	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public BigDecimal getFeeMoney() {
		return feeMoney;
	}

	public void setFeeMoney(BigDecimal feeMoney) {
		this.feeMoney = feeMoney;
	}
	public Long getwId() {
		return wId;
	}

	public void setwId(Long wId) {
		this.wId = wId;
	}


	@Override
	public String toString() {
		return "OrderDetail{" +
			", orderId=" + orderId +
			", productId=" + productId +
			", productName=" + productName +
			", productCnt=" + productCnt +
			", productPrice=" + productPrice +
			", averageCost=" + averageCost +
			", weight=" + weight +
			", feeMoney=" + feeMoney +
			", wId=" + wId +
			"}";
	}
}

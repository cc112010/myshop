package com.mysiteforme.admin.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("order_master")
public class OrderMaster extends DataEntity<OrderMaster> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号 yyyymmddnnnnnnnn
     */
	@TableField("order_sn")
	private String orderSn;
    /**
     * 下单人ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 收货人姓名
     */
	@TableField("shipping_user")
	private String shippingUser;
    /**
     * 省
     */
	private Integer province;
    /**
     * 市
     */
	private Integer city;
    /**
     * 区
     */
	private Integer district;
    /**
     * 地址
     */
	private String address;
    /**
     * 支付方式
     */
	@TableField("payment_method")
	private Integer paymentMethod;
    /**
     * 订单金额
     */
	@TableField("order_money")
	private BigDecimal orderMoney;
    /**
     * 优惠金额
     */
	@TableField("district_money")
	private BigDecimal districtMoney;
    /**
     * 运费金额
     */
	@TableField("shipping_money")
	private BigDecimal shippingMoney;
    /**
     * 支付金额
     */
	@TableField("payment_money")
	private BigDecimal paymentMoney;
    /**
     * 快递公司名称
     */
	@TableField("shipping_comp_name")
	private String shippingCompName;
    /**
     * 快递单号
     */
	@TableField("shipping_sn")
	private String shippingSn;
    /**
     * 下单时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 发货时间
     */
	@TableField("shipping_time")
	private Date shippingTime;
    /**
     * 支付时间
     */
	@TableField("pay_time")
	private Date payTime;
    /**
     * 收货时间
     */
	@TableField("receive_time")
	private Date receiveTime;
    /**
     * 订单状态
     */
	@TableField("order_status")
	private Integer orderStatus;
    /**
     * 订单积分
     */
	@TableField("order_point")
	private Integer orderPoint;
    /**
     * 发票抬头
     */
	@TableField("invoice_time")
	private String invoiceTime;

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getShippingUser() {
		return shippingUser;
	}

	public void setShippingUser(String shippingUser) {
		this.shippingUser = shippingUser;
	}
	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}
	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}
	public BigDecimal getDistrictMoney() {
		return districtMoney;
	}

	public void setDistrictMoney(BigDecimal districtMoney) {
		this.districtMoney = districtMoney;
	}
	public BigDecimal getShippingMoney() {
		return shippingMoney;
	}

	public void setShippingMoney(BigDecimal shippingMoney) {
		this.shippingMoney = shippingMoney;
	}
	public BigDecimal getPaymentMoney() {
		return paymentMoney;
	}

	public void setPaymentMoney(BigDecimal paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
	public String getShippingCompName() {
		return shippingCompName;
	}

	public void setShippingCompName(String shippingCompName) {
		this.shippingCompName = shippingCompName;
	}
	public String getShippingSn() {
		return shippingSn;
	}

	public void setShippingSn(String shippingSn) {
		this.shippingSn = shippingSn;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getShippingTime() {
		return shippingTime;
	}

	public void setShippingTime(Date shippingTime) {
		this.shippingTime = shippingTime;
	}
	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getOrderPoint() {
		return orderPoint;
	}

	public void setOrderPoint(Integer orderPoint) {
		this.orderPoint = orderPoint;
	}
	public String getInvoiceTime() {
		return invoiceTime;
	}

	public void setInvoiceTime(String invoiceTime) {
		this.invoiceTime = invoiceTime;
	}


	@Override
	public String toString() {
		return "OrderMaster{" +
			", orderSn=" + orderSn +
			", customerId=" + customerId +
			", shippingUser=" + shippingUser +
			", province=" + province +
			", city=" + city +
			", district=" + district +
			", address=" + address +
			", paymentMethod=" + paymentMethod +
			", orderMoney=" + orderMoney +
			", districtMoney=" + districtMoney +
			", shippingMoney=" + shippingMoney +
			", paymentMoney=" + paymentMoney +
			", shippingCompName=" + shippingCompName +
			", shippingSn=" + shippingSn +
			", createTime=" + createTime +
			", shippingTime=" + shippingTime +
			", payTime=" + payTime +
			", receiveTime=" + receiveTime +
			", orderStatus=" + orderStatus +
			", orderPoint=" + orderPoint +
			", invoiceTime=" + invoiceTime +
			"}";
	}
}

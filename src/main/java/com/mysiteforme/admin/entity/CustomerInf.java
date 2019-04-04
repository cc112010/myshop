package com.mysiteforme.admin.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("customer_inf")
public class CustomerInf extends DataEntity<CustomerInf> {

    private static final long serialVersionUID = 1L;

    /**
     * customer_login表的自增ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 用户真实姓名
     */
	@TableField("customer_name")
	private String customerName;
    /**
     * 证件类型：1 身份证，2 军官证，3 护照
     */
	@TableField("identity_card_type")
	private Integer identityCardType;
    /**
     * 证件号码
     */
	@TableField("identity_card_no")
	private String identityCardNo;
    /**
     * 手机号
     */
	@TableField("mobile_phone")
	private String mobilePhone;
    /**
     * 邮箱
     */
	@TableField("customer_email")
	private String customerEmail;
    /**
     * 性别
     */
	private Integer gender;
    /**
     * 用户积分
     */
	@TableField("user_point")
	private Integer userPoint;
    /**
     * 注册时间
     */
	@TableField("register_time")
	private Date registerTime;
    /**
     * 会员生日
     */
	private Date birthday;
    /**
     * 会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石
     */
	@TableField("customer_level")
	private Integer customerLevel;
    /**
     * 用户余额
     */
	@TableField("user_money")
	private BigDecimal userMoney;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getIdentityCardType() {
		return identityCardType;
	}

	public void setIdentityCardType(Integer identityCardType) {
		this.identityCardType = identityCardType;
	}
	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(Integer userPoint) {
		this.userPoint = userPoint;
	}
	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(Integer customerLevel) {
		this.customerLevel = customerLevel;
	}
	public BigDecimal getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(BigDecimal userMoney) {
		this.userMoney = userMoney;
	}


	@Override
	public String toString() {
		return "CustomerInf{" +
			", customerId=" + customerId +
			", customerName=" + customerName +
			", identityCardType=" + identityCardType +
			", identityCardNo=" + identityCardNo +
			", mobilePhone=" + mobilePhone +
			", customerEmail=" + customerEmail +
			", gender=" + gender +
			", userPoint=" + userPoint +
			", registerTime=" + registerTime +
			", birthday=" + birthday +
			", customerLevel=" + customerLevel +
			", userMoney=" + userMoney +
			"}";
	}
}

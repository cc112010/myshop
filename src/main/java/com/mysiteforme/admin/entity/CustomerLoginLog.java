package com.mysiteforme.admin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 用户登陆日志表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("customer_login_log")
public class CustomerLoginLog extends DataEntity<CustomerLoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 登陆用户ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 用户登陆时间
     */
	@TableField("login_time")
	private Date loginTime;
    /**
     * 登陆IP
     */
	@TableField("login_ip")
	private String loginIp;
    /**
     * 登陆类型：0未成功，1成功
     */
	@TableField("login_type")
	private Integer loginType;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Integer getLoginType() {
		return loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}


	@Override
	public String toString() {
		return "CustomerLoginLog{" +
			", customerId=" + customerId +
			", loginTime=" + loginTime +
			", loginIp=" + loginIp +
			", loginType=" + loginType +
			"}";
	}
}

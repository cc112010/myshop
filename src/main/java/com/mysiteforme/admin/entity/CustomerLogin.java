package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 用户登录表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("customer_login")
public class CustomerLogin extends DataEntity<CustomerLogin> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户登录名
     */
	@TableField("login_name")
	private String loginName;
    /**
     * md5加密的密码
     */
	private String password;
    /**
     * 用户状态
     */
	@TableField("user_stats")
	private Integer userStats;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserStats() {
		return userStats;
	}

	public void setUserStats(Integer userStats) {
		this.userStats = userStats;
	}


	@Override
	public String toString() {
		return "CustomerLogin{" +
			", loginName=" + loginName +
			", password=" + password +
			", userStats=" + userStats +
			"}";
	}
}

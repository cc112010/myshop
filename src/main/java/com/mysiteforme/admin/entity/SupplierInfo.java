package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 供应商信息表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("supplier_info")
public class SupplierInfo extends DataEntity<SupplierInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 供应商编码
     */
	@TableField("supplier_code")
	private String supplierCode;
    /**
     * 供应商名称
     */
	@TableField("supplier_name")
	private String supplierName;
    /**
     * 供应商类型：1.自营，2.平台
     */
	@TableField("supplier_type")
	private Integer supplierType;
    /**
     * 供应商联系人
     */
	@TableField("link_man")
	private String linkMan;
    /**
     * 联系电话
     */
	@TableField("phone_number")
	private String phoneNumber;
    /**
     * 供应商开户银行名称
     */
	@TableField("bank_name")
	private String bankName;
    /**
     * 银行账号
     */
	@TableField("bank_account")
	private String bankAccount;
    /**
     * 供应商地址
     */
	private String address;
    /**
     * 状态：0禁止，1启用
     */
	@TableField("supplier_status")
	private Integer supplierStatus;

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Integer getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(Integer supplierType) {
		this.supplierType = supplierType;
	}
	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSupplierStatus() {
		return supplierStatus;
	}

	public void setSupplierStatus(Integer supplierStatus) {
		this.supplierStatus = supplierStatus;
	}


	@Override
	public String toString() {
		return "SupplierInfo{" +
			", supplierCode=" + supplierCode +
			", supplierName=" + supplierName +
			", supplierType=" + supplierType +
			", linkMan=" + linkMan +
			", phoneNumber=" + phoneNumber +
			", bankName=" + bankName +
			", bankAccount=" + bankAccount +
			", address=" + address +
			", supplierStatus=" + supplierStatus +
			"}";
	}
}

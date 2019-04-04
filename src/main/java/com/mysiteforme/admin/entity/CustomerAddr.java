package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("customer_addr")
public class CustomerAddr extends DataEntity<CustomerAddr> {

    private static final long serialVersionUID = 1L;

    /**
     * customer_login表的自增ID
     */
	@TableField("customer_id")
	private Long customerId;
    /**
     * 邮编
     */
	private Integer zip;
    /**
     * 地区表中省份的ID
     */
	private Integer province;
    /**
     * 地区表中城市的ID
     */
	private Integer city;
    /**
     * 地区表中的区ID
     */
	private Integer district;
    /**
     * 具体的地址门牌号
     */
	private String address;
    /**
     * 是否默认
     */
	@TableField("is_default")
	private Integer isDefault;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
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
	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}


	@Override
	public String toString() {
		return "CustomerAddr{" +
			", customerId=" + customerId +
			", zip=" + zip +
			", province=" + province +
			", city=" + city +
			", district=" + district +
			", address=" + address +
			", isDefault=" + isDefault +
			"}";
	}
}

package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 仓库信息表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("warehouse_info")
public class WarehouseInfo extends DataEntity<WarehouseInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 仓库编码
     */
	@TableField("warehouse_sn")
	private String warehouseSn;
    /**
     * 仓库名称
     */
	@TableField("warehoust_name")
	private String warehoustName;
    /**
     * 仓库电话
     */
	@TableField("warehouse_phone")
	private String warehousePhone;
    /**
     * 仓库联系人
     */
	private String contact;
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
	private Integer distrct;
    /**
     * 仓库地址
     */
	private String address;
    /**
     * 仓库状态
     */
	@TableField("warehouse_status")
	private Integer warehouseStatus;

	public String getWarehouseSn() {
		return warehouseSn;
	}

	public void setWarehouseSn(String warehouseSn) {
		this.warehouseSn = warehouseSn;
	}
	public String getWarehoustName() {
		return warehoustName;
	}

	public void setWarehoustName(String warehoustName) {
		this.warehoustName = warehoustName;
	}
	public String getWarehousePhone() {
		return warehousePhone;
	}

	public void setWarehousePhone(String warehousePhone) {
		this.warehousePhone = warehousePhone;
	}
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
	public Integer getDistrct() {
		return distrct;
	}

	public void setDistrct(Integer distrct) {
		this.distrct = distrct;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getWarehouseStatus() {
		return warehouseStatus;
	}

	public void setWarehouseStatus(Integer warehouseStatus) {
		this.warehouseStatus = warehouseStatus;
	}


	@Override
	public String toString() {
		return "WarehouseInfo{" +
			", warehouseSn=" + warehouseSn +
			", warehoustName=" + warehoustName +
			", warehousePhone=" + warehousePhone +
			", contact=" + contact +
			", province=" + province +
			", city=" + city +
			", distrct=" + distrct +
			", address=" + address +
			", warehouseStatus=" + warehouseStatus +
			"}";
	}
}

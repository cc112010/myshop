package com.mysiteforme.admin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 物流公司信息表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("shipping_info")
public class ShippingInfo extends DataEntity<ShippingInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 物流公司名称
     */
	@TableField("ship_name")
	private String shipName;
    /**
     * 物流公司联系人
     */
	@TableField("ship_contact")
	private String shipContact;
    /**
     * 物流公司联系电话
     */
	private String telephone;
    /**
     * 配送价格
     */
	private BigDecimal price;

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getShipContact() {
		return shipContact;
	}

	public void setShipContact(String shipContact) {
		this.shipContact = shipContact;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "ShippingInfo{" +
			", shipName=" + shipName +
			", shipContact=" + shipContact +
			", telephone=" + telephone +
			", price=" + price +
			"}";
	}
}

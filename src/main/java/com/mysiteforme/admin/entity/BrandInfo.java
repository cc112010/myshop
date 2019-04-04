package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 品牌信息表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("brand_info")
public class BrandInfo extends DataEntity<BrandInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌名称
     */
	@TableField("brand_name")
	private String brandName;
    /**
     * 联系电话
     */
	private String telephone;
    /**
     * 品牌网络
     */
	@TableField("brand_web")
	private String brandWeb;
    /**
     * 品牌logo URL
     */
	@TableField("brand_logo")
	private String brandLogo;
    /**
     * 品牌描述
     */
	@TableField("brand_desc")
	private String brandDesc;
    /**
     * 品牌状态
     */
	@TableField("brand_status")
	private Integer brandStatus;
    /**
     * 排序
     */
	@TableField("brand_order")
	private Integer brandOrder;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBrandWeb() {
		return brandWeb;
	}

	public void setBrandWeb(String brandWeb) {
		this.brandWeb = brandWeb;
	}
	public String getBrandLogo() {
		return brandLogo;
	}

	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}
	public String getBrandDesc() {
		return brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}
	public Integer getBrandStatus() {
		return brandStatus;
	}

	public void setBrandStatus(Integer brandStatus) {
		this.brandStatus = brandStatus;
	}
	public Integer getBrandOrder() {
		return brandOrder;
	}

	public void setBrandOrder(Integer brandOrder) {
		this.brandOrder = brandOrder;
	}


	@Override
	public String toString() {
		return "BrandInfo{" +
			", brandName=" + brandName +
			", telephone=" + telephone +
			", brandWeb=" + brandWeb +
			", brandLogo=" + brandLogo +
			", brandDesc=" + brandDesc +
			", brandStatus=" + brandStatus +
			", brandOrder=" + brandOrder +
			"}";
	}
}

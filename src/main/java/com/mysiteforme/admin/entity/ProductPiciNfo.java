package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 商品图片表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("product_pici_nfo")
public class ProductPiciNfo extends DataEntity<ProductPiciNfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
	@TableField("product_id")
	private Long productId;
    /**
     * 图片描述
     */
	@TableField("pic_desc")
	private String picDesc;
    /**
     * 图片URL
     */
	@TableField("pic_url")
	private String picUrl;
    /**
     * 是否主图
     */
	@TableField("is_master")
	private Integer isMaster;
    /**
     * 图片排序
     */
	@TableField("pic_order")
	private Integer picOrder;
    /**
     * 图片是否有效
     */
	@TableField("pic_status")
	private Integer picStatus;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getPicDesc() {
		return picDesc;
	}

	public void setPicDesc(String picDesc) {
		this.picDesc = picDesc;
	}
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Integer getIsMaster() {
		return isMaster;
	}

	public void setIsMaster(Integer isMaster) {
		this.isMaster = isMaster;
	}
	public Integer getPicOrder() {
		return picOrder;
	}

	public void setPicOrder(Integer picOrder) {
		this.picOrder = picOrder;
	}
	public Integer getPicStatus() {
		return picStatus;
	}

	public void setPicStatus(Integer picStatus) {
		this.picStatus = picStatus;
	}


	@Override
	public String toString() {
		return "ProductPiciNfo{" +
			", productId=" + productId +
			", picDesc=" + picDesc +
			", picUrl=" + picUrl +
			", isMaster=" + isMaster +
			", picOrder=" + picOrder +
			", picStatus=" + picStatus +
			"}";
	}
}

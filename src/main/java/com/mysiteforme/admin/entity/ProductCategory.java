package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 分类信息表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("product_category")
public class ProductCategory extends DataEntity<ProductCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 分类名称
     */
	@TableField("category_name")
	private String categoryName;
    /**
     * 分类编码
     */
	@TableField("category_code")
	private String categoryCode;
    /**
     * 父分类ID
     */
	@TableField("parent_id")
	private Long parentId;
    /**
     * 分类层级
     */
	@TableField("category_level")
	private Integer categoryLevel;
    /**
     * 分类状态
     */
	@TableField("category_status")
	private Integer categoryStatus;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
	public Integer getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(Integer categoryStatus) {
		this.categoryStatus = categoryStatus;
	}


	@Override
	public String toString() {
		return "ProductCategory{" +
			", categoryName=" + categoryName +
			", categoryCode=" + categoryCode +
			", parentId=" + parentId +
			", categoryLevel=" + categoryLevel +
			", categoryStatus=" + categoryStatus +
			"}";
	}
}

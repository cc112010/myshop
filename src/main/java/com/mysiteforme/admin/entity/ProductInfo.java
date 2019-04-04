package com.mysiteforme.admin.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 商品信息表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("product_info")
public class ProductInfo extends DataEntity<ProductInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
	@TableField("product_core")
	private String productCore;
    /**
     * 商品名称
     */
	@TableField("product_name")
	private String productName;
    /**
     * 国条码
     */
	@TableField("bar_code")
	private String barCode;
    /**
     * 品牌表的ID
     */
	@TableField("brand_id")
	private Long brandId;
    /**
     * 一级分类ID
     */
	@TableField("one_category_id")
	private Long oneCategoryId;
    /**
     * 二级分类ID
     */
	@TableField("two_category_id")
	private Long twoCategoryId;
    /**
     * 三级分类ID
     */
	@TableField("three_category_id")
	private Long threeCategoryId;
    /**
     * 商品的供应商ID
     */
	@TableField("supplier_id")
	private Long supplierId;
    /**
     * 商品销售价格
     */
	private BigDecimal price;
    /**
     * 商品加权平均成本
     */
	@TableField("average_cost")
	private BigDecimal averageCost;
    /**
     * 上下架状态：0下架1上架
     */
	@TableField("publish_status")
	private Integer publishStatus;
    /**
     * 审核状态：0未审核，1已审核
     */
	@TableField("audit_status")
	private Integer auditStatus;
    /**
     * 商品重量
     */
	private Float weight;
    /**
     * 商品长度
     */
	private Float length;
    /**
     * 商品高度
     */
	private Float height;
    /**
     * 商品宽度
     */
	private Float width;
    /**
     * 颜色分类
     */
	@TableField("color_type")
	private Integer colorType;
    /**
     * 生产日期
     */
	@TableField("production_date")
	private Date productionDate;
    /**
     * 商品有效期
     */
	@TableField("shelf_life")
	private Integer shelfLife;
    /**
     * 商品描述
     */
	private String descript;

	public String getProductCore() {
		return productCore;
	}

	public void setProductCore(String productCore) {
		this.productCore = productCore;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getOneCategoryId() {
		return oneCategoryId;
	}

	public void setOneCategoryId(Long oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}
	public Long getTwoCategoryId() {
		return twoCategoryId;
	}

	public void setTwoCategoryId(Long twoCategoryId) {
		this.twoCategoryId = twoCategoryId;
	}
	public Long getThreeCategoryId() {
		return threeCategoryId;
	}

	public void setThreeCategoryId(Long threeCategoryId) {
		this.threeCategoryId = threeCategoryId;
	}
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(BigDecimal averageCost) {
		this.averageCost = averageCost;
	}
	public Integer getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}
	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}
	public Integer getColorType() {
		return colorType;
	}

	public void setColorType(Integer colorType) {
		this.colorType = colorType;
	}
	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}


	@Override
	public String toString() {
		return "ProductInfo{" +
			", productCore=" + productCore +
			", productName=" + productName +
			", barCode=" + barCode +
			", brandId=" + brandId +
			", oneCategoryId=" + oneCategoryId +
			", twoCategoryId=" + twoCategoryId +
			", threeCategoryId=" + threeCategoryId +
			", supplierId=" + supplierId +
			", price=" + price +
			", averageCost=" + averageCost +
			", publishStatus=" + publishStatus +
			", auditStatus=" + auditStatus +
			", weight=" + weight +
			", length=" + length +
			", height=" + height +
			", width=" + width +
			", colorType=" + colorType +
			", productionDate=" + productionDate +
			", shelfLife=" + shelfLife +
			", descript=" + descript +
			"}";
	}
}

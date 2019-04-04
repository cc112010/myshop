package com.mysiteforme.admin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 商品库存表
 * </p>
 *
 * @author wangl
 * @since 2019-04-04
 */
@TableName("warehouse_product")
public class WarehouseProduct extends DataEntity<WarehouseProduct> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
	@TableField("product_id")
	private Long productId;
    /**
     * 仓库ID
     */
	@TableField("w_id")
	private Long wId;
    /**
     * 当前商品数量
     */
	@TableField("current_cnt")
	private Integer currentCnt;
    /**
     * 当前占用数据
     */
	@TableField("lock_cnt")
	private Integer lockCnt;
    /**
     * 在途数据
     */
	@TableField("in_transit_cnt")
	private Integer inTransitCnt;
    /**
     * 移动加权成本
     */
	@TableField("average_cost")
	private BigDecimal averageCost;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getwId() {
		return wId;
	}

	public void setwId(Long wId) {
		this.wId = wId;
	}
	public Integer getCurrentCnt() {
		return currentCnt;
	}

	public void setCurrentCnt(Integer currentCnt) {
		this.currentCnt = currentCnt;
	}
	public Integer getLockCnt() {
		return lockCnt;
	}

	public void setLockCnt(Integer lockCnt) {
		this.lockCnt = lockCnt;
	}
	public Integer getInTransitCnt() {
		return inTransitCnt;
	}

	public void setInTransitCnt(Integer inTransitCnt) {
		this.inTransitCnt = inTransitCnt;
	}
	public BigDecimal getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(BigDecimal averageCost) {
		this.averageCost = averageCost;
	}


	@Override
	public String toString() {
		return "WarehouseProduct{" +
			", productId=" + productId +
			", wId=" + wId +
			", currentCnt=" + currentCnt +
			", lockCnt=" + lockCnt +
			", inTransitCnt=" + inTransitCnt +
			", averageCost=" + averageCost +
			"}";
	}
}

package com.zhongym.test.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 *  积分抵扣金额数据返回
 * @author duanxiong
 * @date 2019/10/24 16:56
 */
public class PointsPriceVO {

    private Long id;

    private Integer isAvailability;

    private Integer pointsLimit;

    private Integer isFull;

    private BigDecimal disprice;

    private BigDecimal amountLimit;

    private BigDecimal deductionRate;

    private List<Long> productScopeIds;

    private List<ProductScopeVO> productScopeList;

    /**
     * 会员级别（1-粉钻会员;2-红钻会员;3-黑钻会员;4-金钻会员）
     */
    private Integer memberLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsAvailability() {
        return isAvailability;
    }

    public void setIsAvailability(Integer isAvailability) {
        this.isAvailability = isAvailability;
    }

    public Integer getPointsLimit() {
        return pointsLimit;
    }

    public void setPointsLimit(Integer pointsLimit) {
        this.pointsLimit = pointsLimit;
    }

    public Integer getIsFull() {
        return isFull;
    }

    public void setIsFull(Integer isFull) {
        this.isFull = isFull;
    }

    public BigDecimal getDisprice() {
        return disprice;
    }

    public void setDisprice(BigDecimal disprice) {
        this.disprice = disprice;
    }

    public BigDecimal getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(BigDecimal amountLimit) {
        this.amountLimit = amountLimit;
    }

    public BigDecimal getDeductionRate() {
        return deductionRate;
    }

    public void setDeductionRate(BigDecimal deductionRate) {
        this.deductionRate = deductionRate;
    }

    public List<Long> getProductScopeIds() {
        return productScopeIds;
    }

    public void setProductScopeIds(List<Long> productScopeIds) {
        this.productScopeIds = productScopeIds;
    }

    public List<ProductScopeVO> getProductScopeList() {
        return productScopeList;
    }

    public void setProductScopeList(List<ProductScopeVO> productScopeList) {
        this.productScopeList = productScopeList;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }
}

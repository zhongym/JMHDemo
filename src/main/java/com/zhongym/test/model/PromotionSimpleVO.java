package com.zhongym.test.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PromotionSimpleVO implements Serializable {

    @ApiModelProperty("活动id")
    private Long promotionId;
    @ApiModelProperty("活动类型")
    private Long promotionType;
    @ApiModelProperty("活动类型名称")
    private String promotionTypeName;
    @ApiModelProperty("活动名称")
    private String promotionName;
    @ApiModelProperty("开始时间")
    private LocalDateTime gmtStart;
    @ApiModelProperty("结束时间")
    private LocalDateTime gmtEnd;
    @ApiModelProperty("活动标签，活动期间展示于商品详情的价格旁边")
    private String promotionTag;
    @ApiModelProperty("客户参与活动是否给客户打标签 0-否 1-是")
    private Integer isCustomerTag;
    @ApiModelProperty("否全场活动，全场活动则无需指定参与商品 0-非全场活动 1-全场活动 2-部分商品不参与")
    private Integer isFull;
    @ApiModelProperty("是否循环条件 0-无此设置 1-循环享受活动 2-阶梯享受活动")
    private Integer isLoop;
    @ApiModelProperty("限购数，设置限制只能购买x件,比如限时活动")
    private Integer orderLimit;
    @ApiModelProperty("限量数，优惠券是限制领取数；限时折扣是限制前x件享受活动")
    private Integer quota;
    @ApiModelProperty("已订购数,目前只有限时折扣活动前n件享受活动时")
    private Integer orderNum;
    @ApiModelProperty("活动是否有效 0-失效 1-有效")
    private Integer isAvailability;
    @ApiModelProperty("优先级，数字越大优先计算")
    private Integer typePriority;
    @ApiModelProperty("活动提示，如限时折扣如果设置了限购、前n件享受活动")
    private String promotionTipName;
    @ApiModelProperty("促销折扣价格")
    private BigDecimal prmDisprice;
    @ApiModelProperty("促销折扣率")
    private BigDecimal prmDiscountRate;
    @ApiModelProperty("配送方式 0：无此设置， 1：快递  ，2：同城配送")
    private Integer shippingMethod;
    @ApiModelProperty("免邮范围 0: 无此设置 ，1：整单包邮，2：仅活动商品包邮")
    private Integer pinkageScope;
    @ApiModelProperty("满足该活动的商品Ids")
    private List<Long> productIds;
    @ApiModelProperty("获取的优惠内容")
    private List<String> promotionContents;
    @ApiModelProperty("会员级别（1-普卡，2-银卡 ，3-金卡，4-黑卡 （从低到高排序））")
    private Integer memberLevel;
    @ApiModelProperty("该活动商品不允许原价购买 1-不允许")
    private Integer canOriginalBuy;
    @ApiModelProperty("该活动商品允许使用积分抵扣 2-允许")
    private Integer canUsePoints;
    @ApiModelProperty("(满减活动)封顶金额 0-无封顶 加价购就是临界值")
    private BigDecimal amountCeiling;
}

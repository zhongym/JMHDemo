package com.zhongym.test.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MiniProductPromotionVO implements Serializable {
    @ApiModelProperty("活动信息")
    private List<PromotionSimpleVO> promotionSimples;
}

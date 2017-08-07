package com.doraemon.trevi.controller.protocols;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zbs on 2017/7/3.
 */
public class FinancePro {

    @ApiModelProperty(value = "类型(0 单次,1 循环)")
    int type;
    @ApiModelProperty(value = "周期类型(0 按天 1 按周  2按月  3按年 )")
    int cycleType;
    @ApiModelProperty(value = "")
    List cycleValue;
    //名称
    String name;
    //金额
    BigDecimal amount;
}

package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Integer id       ;
    private Integer orderid  ;
    private Integer goodsid  ;
    private Integer num      ;
    private Integer price    ;
}

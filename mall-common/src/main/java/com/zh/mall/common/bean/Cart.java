package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer id        ;
    private Integer memberid  ;
    private Integer goodsid   ;
    private Integer num       ;
    private Integer price     ;
    private String jointime  ;

    private String goodsname;
    private String goodsremark;
    private String introduce;
}

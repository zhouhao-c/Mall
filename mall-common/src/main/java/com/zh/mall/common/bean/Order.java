package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id          ;
    private Integer memberid    ;
    private String ordernum    ;
    private String status      ;
    private String createtime  ;
    private Integer price       ;
    private String paytype     ;
    private Integer payprice    ;
    private String ispay       ;
    private String paytime     ;
    private String issend      ;
    private String sendtime    ;
    private String isreceipt   ;
    private String receipttime ;
    private Integer addressid   ;
}

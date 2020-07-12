package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商家信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerInfo {
    private Integer id;
    private Integer memberid;
    private String introduce;
    private String remark;
    private String tel;
    private String cstel;
}

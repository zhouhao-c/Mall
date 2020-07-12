package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品详情
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo {
    private Integer id;
    private Integer goodsid;
    private Integer buycnt;
    private Integer goodcnt;
    private Integer favcnt;
    private Integer sellcnt;
}

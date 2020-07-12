package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品标签
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsTag {
    private Integer id;
    private Integer goodsid;
    private Integer tagid;
}

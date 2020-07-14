package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavGoods {

    private Integer id;
    private Integer memberid;
    private Integer goodsid;
}

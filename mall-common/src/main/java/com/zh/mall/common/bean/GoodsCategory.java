package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCategory {
    private Integer id;
    private String name;
    private String remark;
    private Integer orderid;
    private String createtime;
    private List<Goods> goodsDatas = new ArrayList<Goods>();
}

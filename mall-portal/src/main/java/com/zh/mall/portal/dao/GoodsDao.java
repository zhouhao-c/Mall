package com.zh.mall.portal.dao;

import com.zh.mall.common.bean.Goods;
import com.zh.mall.common.bean.GoodsInfo;

import java.util.List;

public interface GoodsDao {
    List<Goods> queryAll();

    Goods queryById(Integer goodsid);

    GoodsInfo queryGoodsInfoById(Integer goodsid);
}

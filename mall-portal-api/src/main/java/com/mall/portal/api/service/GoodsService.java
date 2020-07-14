package com.mall.portal.api.service;

import com.zh.mall.common.bean.Goods;
import com.zh.mall.common.bean.GoodsInfo;

import java.util.List;

public interface GoodsService {
    List<Goods> queryAll();

    Goods queryById(Integer goodsid);

    GoodsInfo queryGoodsInfoById(Integer goodsid);
}

package com.mall.portal.api.service;

import com.zh.mall.common.bean.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> queryAll();

    Goods queryById(Integer goodsid);
}

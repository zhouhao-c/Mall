package com.zh.mall.portal.service.impl;

import com.mall.portal.api.service.GoodsService;
import com.zh.mall.common.bean.Goods;
import com.zh.mall.common.bean.GoodsInfo;
import com.zh.mall.portal.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> queryAll() {
        return goodsDao.queryAll();
    }

    @Override
    public Goods queryById(Integer goodsid) {
        return goodsDao.queryById(goodsid);
    }

    @Override
    public GoodsInfo queryGoodsInfoById(Integer goodsid) {
        return goodsDao.queryGoodsInfoById(goodsid);
    }
}

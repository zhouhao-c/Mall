package com.zh.mall.portal.service.impl;

import com.mall.portal.api.service.GoodsService;
import com.zh.mall.common.bean.Goods;
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
}
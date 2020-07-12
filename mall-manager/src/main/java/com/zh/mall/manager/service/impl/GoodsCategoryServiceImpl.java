package com.zh.mall.manager.service.impl;

import com.mall.manager.api.service.GoodsCategoryService;
import com.zh.mall.common.bean.Datas;
import com.zh.mall.common.bean.GoodsCategory;
import com.zh.mall.manager.dao.GoodsCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    @Override
    public List<GoodsCategory> queryPageData(Map<String, Object> paramMap) {
        return goodsCategoryDao.queryPageData(paramMap);
    }

    @Override
    public int queryPageCount(Map<String, Object> paramMap) {
        return goodsCategoryDao.queryPageCount(paramMap);
    }

    @Override
    public void insertGoodsCategory(GoodsCategory gc) {
        goodsCategoryDao.insertGoodsCategory(gc);
    }

    @Override
    public GoodsCategory queryById(Integer id) {
        return goodsCategoryDao.queryById(id);
    }

    @Override
    public int updateGoodsCategory(GoodsCategory gc) {
        return goodsCategoryDao.updateGoodsCategory(gc);
    }

    @Override
    public int deleteGoodsCategoryById(Integer id) {
        return goodsCategoryDao.deleteGoodsCategoryById(id);
    }

    @Override
    public int deleteGoodsCategorys(Datas ds) {
        return goodsCategoryDao.deleteGoodsCategorys(ds);
    }

    @Override
    public List<GoodsCategory> queryAll() {
        return goodsCategoryDao.queryAll();
    }
}

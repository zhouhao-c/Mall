package com.zh.mall.manager.service;

import com.zh.mall.common.bean.Datas;
import com.zh.mall.common.bean.GoodsCategory;

import java.util.List;
import java.util.Map;

public interface GoodsCategoryService {
    List<GoodsCategory> queryPageData(Map<String, Object> paramMap);

    int queryPageCount(Map<String, Object> paramMap);

    void insertGoodsCategory(GoodsCategory gc);

    GoodsCategory queryById(Integer id);

    int updateGoodsCategory(GoodsCategory gc);

    int deleteGoodsCategoryById(Integer id);

    int deleteGoodsCategorys(Datas ds);
}

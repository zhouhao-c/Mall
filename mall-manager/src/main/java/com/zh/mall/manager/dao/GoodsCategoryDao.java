package com.zh.mall.manager.dao;

import com.zh.mall.common.bean.GoodsCategory;

import java.util.List;
import java.util.Map;

public interface GoodsCategoryDao {

    List<GoodsCategory> queryPageData(Map<String, Object> paramMap);

    int queryPageCount(Map<String, Object> paramMap);
}

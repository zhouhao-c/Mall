package com.zh.mall.manager.service.impl;

import com.zh.mall.common.bean.GoodsCategory;
import com.zh.mall.manager.dao.GoodsCategoryDao;
import com.zh.mall.manager.service.GoodsCategoryService;
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
}

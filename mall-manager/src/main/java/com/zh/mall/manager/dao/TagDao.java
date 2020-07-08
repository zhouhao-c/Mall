package com.zh.mall.manager.dao;

import com.zh.mall.common.bean.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> queryRootTags();

    List<Tag> queryChildTagsByPid(Integer id);

    List<Tag> queryAll();
}

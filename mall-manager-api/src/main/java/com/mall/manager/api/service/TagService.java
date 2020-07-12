package com.mall.manager.api.service;

import com.zh.mall.common.bean.Tag;

import java.util.List;

public interface TagService {
    List<Tag> queryRootTags();

    List<Tag> queryChildTagsByPid(Integer id);

    List<Tag> queryAll();
}

package com.zh.mall.manager.service.impl;

import com.mall.manager.api.service.TagService;
import com.zh.mall.common.bean.Tag;
import com.zh.mall.manager.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> queryRootTags() {
        return tagDao.queryRootTags();
    }

    @Override
    public List<Tag> queryChildTagsByPid(Integer id) {
        return tagDao.queryChildTagsByPid(id);
    }

    @Override
    public List<Tag> queryAll() {
        return tagDao.queryAll();
    }
}

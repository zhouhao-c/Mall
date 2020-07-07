package com.zh.mall.manager.controller;

import com.zh.mall.common.bean.AJAXResult;
import com.zh.mall.common.bean.Tag;
import com.zh.mall.manager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @ResponseBody
    @RequestMapping("/loadData")
    public Object loadData() {
        AJAXResult result = new AJAXResult();

        try {

            // 准备数据
            // list ==> json ==> []
            // map  ==> json ==> {}
            List<Tag> list = new ArrayList<Tag>();
			/*
			// 父节点
			Tag tag = new Tag();
			tag.setOpen(true);
			tag.setName("父标签");

			// 子节点
			Tag childTag = new Tag();
			childTag.setName("子标签");

			// 组合父子节点的关系
			tag.getChildren().add(childTag);
			*/

            // 查询标签数据
            List<Tag> tags = tagService.queryRootTags();

            for ( Tag tag : tags ) {
                // 查询子节点
                List<Tag> children = tagService.queryChildTagsByPid(tag.getId());

                for ( Tag childTag : children ) {
                    // 查询子节点的子节点
                    List<Tag> childrenChildren = tagService.queryChildTagsByPid(childTag.getId());

                    // 组合父子节点的关系
                    childTag.setChildren(childrenChildren);
                }

                // 组合父子节点的关系
                tag.setChildren(children);
            }

            //list.add(tag);
            result.setData(tags);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @RequestMapping("/index")
    public String index() {
        return "tag/index";
    }
}

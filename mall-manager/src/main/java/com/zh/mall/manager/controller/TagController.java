package com.zh.mall.manager.controller;

import com.zh.mall.common.bean.AJAXResult;
import com.zh.mall.common.bean.Tag;
import com.zh.mall.manager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @ResponseBody
    @RequestMapping("/asyncLoadData")
    public Object asyncLoadData(){
        List<Tag> rootTag = new ArrayList<Tag>();
        List<Tag> allTags = tagService.queryAll();
        Map<Integer,Tag> tagMap = new HashMap<Integer, Tag>();
        for (Tag tag:allTags){
            tagMap.put(tag.getId(),tag);
        }
        for (Tag tag:allTags){
            Tag child = tag;
            if (child.getPid() == 0){
                rootTag.add(tag);
            }else {
                Tag parent = tagMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        return rootTag;
    }

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
            //List<Tag> tags = tagService.queryRootTags();
            /*
            List<Tag> tags = tagService.queryChildTagsByPid(0);

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
             */
            //list.add(tag);

            // 使用递归方式读取标签数据
            /*
            Tag tag = new Tag();
            tag.setId(0);
            queryChildTags(tag);
            result.setData(tag.getChildren());
            */

            //嵌套for循环方式查询标签数据
            //在具有索引的条件下ArrayList查询快，以下方式没有用到索引
            /*
            List<Tag> rootTag = new ArrayList<Tag>();
            List<Tag> allTags = tagService.queryAll();
            for (Tag tag :allTags){
                Tag child = tag;
                if (child.getPid() == 0){
                    rootTag.add(tag);
                }else {
                    for (Tag innerTag : allTags){
                        //包装类型用equals比较
                        if (innerTag.getId().equals(child.getPid())){
                            Tag parent = innerTag;

                            parent.getChildren().add(child);
                            break;
                        }
                    }
                }
            }
             */

            //Map集合查询标签数据，Map集合一定用到索引,效率最高
            List<Tag> rootTag = new ArrayList<Tag>();
            List<Tag> allTags = tagService.queryAll();
            Map<Integer,Tag> tagMap = new HashMap<Integer, Tag>();
            for (Tag tag:allTags){
                tagMap.put(tag.getId(),tag);
            }
            for (Tag tag:allTags){
                Tag child = tag;
                if (child.getPid() == 0){
                    rootTag.add(tag);
                }else {
                    Tag parent = tagMap.get(child.getPid());
                    parent.getChildren().add(child);
                }
            }

            result.setData(rootTag);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 递归查询子标签
     * 1) 调用自身
     * 2) 调用自身时参数之间有规律
     * 3) 含有跳出的逻辑
     */
    private void queryChildTags( Tag parent ) {
        // 查询子标签
        List<Tag> children = tagService.queryChildTagsByPid(parent.getId());

        for ( Tag child : children ) {
            queryChildTags(child);
        }

        // 组合父子标签之间的关系
        parent.setChildren(children);
    }

    @RequestMapping("/index")
    public String index() {
        return "tag/index";
    }
}

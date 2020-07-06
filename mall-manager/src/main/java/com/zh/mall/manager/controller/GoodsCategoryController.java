package com.zh.mall.manager.controller;

import com.zh.mall.common.bean.AJAXResult;
import com.zh.mall.common.bean.GoodsCategory;
import com.zh.mall.common.bean.Page;
import com.zh.mall.common.util.StringUtil;
import com.zh.mall.manager.service.GoodsCategoryService;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品分类控制器
 */
@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(GoodsCategory gc){
        AJAXResult ajaxResult = new AJAXResult();
        try {
            //JDK8 时间格式化
            gc.setCreatetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            goodsCategoryService.insertGoodsCategory(gc);
            ajaxResult.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }
    /**
     * 异步分页
     * @param pageno
     * @param pagesize
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(Integer pageno,Integer pagesize,String queryText){
        AJAXResult ajaxResult = new AJAXResult();

        try {
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("start",(pageno-1)*pagesize);
            paramMap.put("size",pagesize);
            //特殊字符转义
            if (!StringUtil.isEmpty(queryText)){
                if (queryText.contains("\\")){
                    queryText = queryText.replaceAll("\\\\","\\\\\\\\");
                }
                if (queryText.contains("%")){
                    queryText = queryText.replaceAll("%","\\\\%");
                }
                if (queryText.contains("_")){
                    queryText = queryText.replaceAll("_","\\\\_");
                }
            }
            paramMap.put("queryText",queryText);

            int totalsize = goodsCategoryService.queryPageCount(paramMap);
            int totalno = 0;
            if (totalsize % pagesize == 0){
                totalno = totalsize / pagesize;
            }else {
                totalno = totalsize / pagesize + 1;
            }
            List<GoodsCategory> goodsCategories = goodsCategoryService.queryPageData(paramMap);

            Page<GoodsCategory> page = new Page<GoodsCategory>();
            page.setDatas(goodsCategories);
            page.setTotalsize(totalsize);
            page.setTotalno(totalno);
            page.setPageno(pageno);
            page.setPagesize(pagesize);

            ajaxResult.setData(page);
            ajaxResult.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    /**
     * 跳转主页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "goodsCategory/index";
    }

    /**
     * 跳转新增页面
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "goodsCategory/add";
    }

    /**
     * 跳转修改页面
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Integer id,Model model){
        GoodsCategory gc = goodsCategoryService.queryById(id);
        model.addAttribute("gc",gc);
        if (gc != null){

        }else {

        }
        return "goodsCategory/edit";
    }
    /**
     * 同步分页
     * @param pageno
     * @param pagesize
     * @param model
     * @return
     */
    @RequestMapping("/index1")
    public String index1(@RequestParam(required = false,defaultValue = "1") Integer pageno,
                        @RequestParam(required = false,defaultValue = "2") Integer pagesize, Model model){

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("start",(pageno-1)*pagesize);
        paramMap.put("size",pagesize);

        int totalsize = goodsCategoryService.queryPageCount(paramMap);
        int totalno = 0;
        if (totalsize % pagesize == 0){
            totalno = totalsize / pagesize;
        }else {
            totalno = totalsize / pagesize + 1;
        }

        List<GoodsCategory> goodsCategories = goodsCategoryService.queryPageData(paramMap);
        model.addAttribute("gcs",goodsCategories);
        model.addAttribute("pageno",pageno);
        model.addAttribute("totalno",totalno);

        return "goodsCategory/index";
    }
}

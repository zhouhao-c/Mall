package com.zh.mall.portal.controller;

import com.mall.portal.api.service.GoodsService;
import com.zh.mall.common.bean.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到商品的详情页面
     *
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id")Integer goodsid, Model model){

        Goods goods = goodsService.queryById(goodsid);
        model.addAttribute("goods",goods);
        return "goods/detail";
    }
}

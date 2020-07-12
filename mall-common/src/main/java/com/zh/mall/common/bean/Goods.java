package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String name;
    private String num;
    private Integer memberid;
    private String createtime;
    private String status;
    private Integer stock;
    private Integer price;
    private String iconpath;
    private String iconpathtail;
    private Integer cost;
    private Integer limitstock;
    private String hot;
    private String newgoods;
    private String best;
    private String priceunit;
    private Integer categoryid;
    private String remark;
    private MultipartFile goodsHeadImgFile;
    private MultipartFile goodsDetailImgFile;
    private String introduce;
    private String siremark;
    private String tel;
    private String cstel;
}

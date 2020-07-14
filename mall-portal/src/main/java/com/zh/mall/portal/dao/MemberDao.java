package com.zh.mall.portal.dao;

import com.zh.mall.common.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberDao {
    Member queryMemberByLoginacct(String loginacct);

    void insertSellerInfo(SellerInfo sellerInfo);

    void insertGoods(Goods goods);

    void insertGoodsTags(@Param("gts") List<GoodsTag> goodsTags);

    void insertGoodsInfo(GoodsInfo goodsInfo);

    List<Goods> queryMemberGoods(Member loginMember);

    void insertFavGoods(FavGoods fg, GoodsInfo info);
}

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

    void insertFavGoods(FavGoods fg);

    void updateGoodsInfoFavcnt(GoodsInfo info);

    Cart queryCart(Cart c);

    void insertCart(Cart c);

    void updateCart(Cart cart);

    List<Cart> queryCartsByMemberid(Integer id);
}

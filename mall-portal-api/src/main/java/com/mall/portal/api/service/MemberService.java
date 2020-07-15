package com.mall.portal.api.service;

import com.zh.mall.common.bean.*;

import java.util.List;

public interface MemberService {
    Member queryMemberByLoginacct(String loginacct);

    void insertGoods(Goods goods, SellerInfo sellerInfo, int[] tags);

    List<Goods> queryMemberGoods(Member loginMember);

    void insertFavGoods(FavGoods fg, GoodsInfo info);

    Cart queryCart(Cart c);

    void insertCart(Cart c);

    void updateCart(Cart cart);

    void updateGoodsInfoFavcnt(GoodsInfo gi);

    List<Cart> queryCartsByMemberid(Integer id);

    void insertOrder(Order order, List<OrderItem> items);

    int queryCartCount(Integer id);
}

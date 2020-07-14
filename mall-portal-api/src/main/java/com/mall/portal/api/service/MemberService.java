package com.mall.portal.api.service;

import com.zh.mall.common.bean.*;

import java.util.List;

public interface MemberService {
    Member queryMemberByLoginacct(String loginacct);

    void insertGoods(Goods goods, SellerInfo sellerInfo, int[] tags);

    List<Goods> queryMemberGoods(Member loginMember);

    void insertFavGoods(FavGoods fg, GoodsInfo info);
}

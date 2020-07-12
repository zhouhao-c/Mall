package com.mall.portal.api.service;

import com.zh.mall.common.bean.Goods;
import com.zh.mall.common.bean.Member;
import com.zh.mall.common.bean.SellerInfo;

import java.util.List;

public interface MemberService {
    Member queryMemberByLoginacct(String loginacct);

    void insertGoods(Goods goods, SellerInfo sellerInfo, int[] tags);

    List<Goods> queryMemberGoods(Member loginMember);
}

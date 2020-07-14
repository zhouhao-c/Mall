package com.zh.mall.portal.service.impl;

import com.mall.portal.api.service.MemberService;
import com.zh.mall.common.bean.*;
import com.zh.mall.portal.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member queryMemberByLoginacct(String loginacct) {
        return memberDao.queryMemberByLoginacct(loginacct);
    }

    @Override
    public void insertGoods(Goods goods, SellerInfo sellerInfo, int[] tags) {
        memberDao.insertGoods(goods);
        memberDao.insertSellerInfo(sellerInfo);

        List<GoodsTag> goodsTags = new ArrayList<GoodsTag>();
        for (int tagid:tags){
            GoodsTag t = new GoodsTag();
            t.setTagid(tagid);
            t.setGoodsid(goods.getId());
            goodsTags.add(t);
        }
        memberDao.insertGoodsTags(goodsTags);

        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsid(goods.getId());
        memberDao.insertGoodsInfo(goodsInfo);
    }

    @Override
    public List<Goods> queryMemberGoods(Member loginMember) {
        return memberDao.queryMemberGoods(loginMember);
    }

    @Override
    public void insertFavGoods(FavGoods fg, GoodsInfo info) {
        memberDao.insertFavGoods(fg);
        memberDao.updateGoodsInfoFavcnt(info);
    }

    @Override
    public Cart queryCart(Cart c) {
        return memberDao.queryCart(c);
    }

    @Override
    public void insertCart(Cart c) {
        memberDao.insertCart(c);
    }

    @Override
    public void updateCart(Cart cart) {
        memberDao.updateCart(cart);
    }

    @Override
    public void updateGoodsInfoFavcnt(GoodsInfo gi) {
        memberDao.updateGoodsInfoFavcnt(gi);
    }

    @Override
    public List<Cart> queryCartsByMemberid(Integer id) {
        return memberDao.queryCartsByMemberid(id);
    }
}

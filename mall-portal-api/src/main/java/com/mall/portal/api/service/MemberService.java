package com.mall.portal.api.service;

import com.zh.mall.common.bean.Member;

public interface MemberService {
    Member queryMemberByLoginacct(String loginacct);
}

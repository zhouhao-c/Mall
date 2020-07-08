package com.zh.mall.portal.controller;

import com.zh.mall.common.BaseController;
import com.zh.mall.common.bean.Member;
import com.zh.mall.common.util.MD5Util;
import com.zh.mall.portal.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(String loginacct, String userpswd, HttpSession session){
        start();
        try {
            //根据账号查询会员信息
            //错误码
            //101：账号错误
            //102：密码错误
            //103：权限
            Member dbmember = memberService.queryMemberByLoginacct(loginacct);
            if (dbmember == null){
                data(101);
                fail();
            }else {
                if (dbmember.getMemberpswd().equals(MD5Util.digest(userpswd))){
                    session.setAttribute("loginMember",dbmember);
                    success();
                }else {
                    data(102);
                    fail();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            data(103);
            fail();
        }
        return end();
    }


}

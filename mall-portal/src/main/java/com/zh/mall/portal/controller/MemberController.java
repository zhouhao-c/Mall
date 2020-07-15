package com.zh.mall.portal.controller;

import com.mall.manager.api.service.GoodsCategoryService;
import com.mall.manager.api.service.TagService;
import com.mall.portal.api.service.GoodsService;
import com.mall.portal.api.service.MemberService;
import com.zh.mall.common.BaseController;
import com.zh.mall.common.bean.*;
import com.zh.mall.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private TagService tagService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 下订单
     * @return
     */
    @RequestMapping("/doOrder")
    public String doOrder( HttpSession session ) {

        Member loginMember = (Member)session.getAttribute("loginMember");

        List<Cart> carts = memberService.queryCartsByMemberid(loginMember.getId());
        int totalprice = 0;
        List<OrderItem> items = new ArrayList<OrderItem>();
        for ( Cart cart : carts ) {
            totalprice += cart.getNum() * cart.getPrice();
            OrderItem item = new OrderItem();
            item.setNum(cart.getNum());
            item.setPrice(cart.getPrice());
            item.setGoodsid(cart.getGoodsid());
            items.add(item);
        }

        Order order = new Order();
        order.setMemberid(loginMember.getId());
        order.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        order.setStatus("00");
        order.setPrice(totalprice);

        memberService.insertOrder(order, items);

        return "redirect:/member/myorder";
    }

    @RequestMapping("/checkOrder")
    public String checkOrder() {
        return "member/checkOrder";
    }

    /**
     * 跳转我的订单
     * @return
     */
    @RequestMapping("/myorder")
    public String myorder() {
        return "member/myorder";
    }

    @ResponseBody
    @RequestMapping("/carts")
    public Object carts( HttpSession session ) {
        start();

        try {
            Member loginMember = (Member)session.getAttribute("loginMember");
            List<Cart> carts = memberService.queryCartsByMemberid(loginMember.getId());
            data(carts);
            success();
        } catch ( Exception e ) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 购物车页面跳转
     * @return
     */
    @RequestMapping("/cart")
    public String cart() {
        return "member/cart";
    }

    /**
     * 将商品加入购物车
     * @return
     */
    @ResponseBody
    @RequestMapping("/addGoodsIntoCart")
    public Object addGoodsIntoCart(HttpSession session, Integer price, Integer goodsid, Integer cnt) {
        start();

        try {

            Member loginMember = (Member)session.getAttribute("loginMember");
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // 查询是否曾经买过商品
            Cart c = new Cart();
            c.setMemberid(loginMember.getId());
            c.setGoodsid(goodsid);
            Cart cart = memberService.queryCart(c);

            if ( cart == null ) {
                // 没买
                c.setNum(cnt);
                c.setPrice(price);
                c.setJointime(date);

                memberService.insertCart(c);
            } else {
                // 买过
                cart.setNum(cart.getNum() + cnt);
                GoodsInfo gi = goodsService.queryGoodsInfoById(goodsid);
                gi.setFavcnt(gi.getFavcnt()-cnt);
                memberService.updateGoodsInfoFavcnt(gi);
                memberService.updateCart(cart);

            }

            success();
        } catch ( Exception e ) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 商品收藏功能
     * @param goodsid
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/addFav")
    public Object addFav( Integer goodsid, HttpSession session ) {
        start();

        try {

            Member loginMember = (Member)session.getAttribute("loginMember");
            // 增加
            FavGoods fg = new FavGoods();
            if (loginMember != null){
                fg.setGoodsid(goodsid);
                fg.setMemberid(loginMember.getId());
            }else {
                fail();
                return end();
            }

            GoodsInfo info = goodsService.queryGoodsInfoById(goodsid);
            if ( info.getFavcnt() == null ) {
                info.setFavcnt(1);
            } else {
                info.setFavcnt(info.getFavcnt() + 1);
            }

            memberService.insertFavGoods(fg, info);

            success();
        } catch ( Exception e ) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 查询我的商品
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryMemberGoods")
    private Object queryMemberGoods(HttpSession session){
        start();
        try{
            Member loginMember = (Member) session.getAttribute("loginMember");
            List<Goods> goodsDatas = memberService.queryMemberGoods(loginMember);
            data(goodsDatas);
            success();
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }

        return end();
    }


    /**
     * 发布商品
     * @return
     */
    @RequestMapping("/insertGoods")
    private String insertGoods(Goods goods, SellerInfo sellerInfo,int[] tags,HttpSession session) throws Exception{

        //登录会员信息
        Member loginMember = (Member) session.getAttribute("loginMember");
        goods.setMemberid(loginMember.getId());
        sellerInfo.setMemberid(loginMember.getId());

        sellerInfo.setRemark(goods.getSiremark());
        sellerInfo.setIntroduce(goods.getIntroduce());
        sellerInfo.setTel(goods.getTel());
        sellerInfo.setCstel(goods.getCstel());

        MultipartFile goodsHeadImgFile = goods.getGoodsHeadImgFile();
        MultipartFile goodsDetailImgFile = goods.getGoodsDetailImgFile();

        ServletContext application = session.getServletContext();
        String imgSavaPath = application.getRealPath("static/img/goods");

        String headImgFileName = goodsHeadImgFile.getOriginalFilename();
        String detailImgFileName = goodsDetailImgFile.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();
        String suffix = headImgFileName.substring(headImgFileName.lastIndexOf("."));
        String targetFileName = uuid+suffix;
        File file = new File(imgSavaPath+"/"+targetFileName);
        //保存宣传图片
        goodsHeadImgFile.transferTo(file);
        goods.setIconpath(targetFileName);

        uuid = UUID.randomUUID().toString();
        suffix = detailImgFileName.substring(detailImgFileName.lastIndexOf("."));
        targetFileName = uuid+suffix;
        file = new File(imgSavaPath+"/"+targetFileName);
        //保存详细图片
        goodsDetailImgFile.transferTo(file);
        goods.setIconpathtail(targetFileName);

        memberService.insertGoods(goods,sellerInfo,tags);
        return "redirect:/member/myshop";
    }

    @RequestMapping("/insertGoodsTest")
    public String insertGoodsTest(HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
        MultipartFile goodsHeadImgFile = req.getFile("goodsHeadImg");

        //获取当前web应用的文件路径
        ServletContext application = request.getSession().getServletContext();
        String imgSavaPath = application.getRealPath("static/img/goods");

        //真实文件名称
        String fileName = goodsHeadImgFile.getOriginalFilename();

        //UUID.png
        String uuid = UUID.randomUUID().toString();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String targetFileName = uuid+suffix;
        File file = new File(imgSavaPath+"/"+targetFileName);

        //保存文件
        //装饰者模式
        //代理模式
        //new BufferedInputStream(new FileInputStream());

        goodsHeadImgFile.transferTo(file);
        return "redirect:/member";
    }

    @RequestMapping("/addGoods")
    public String addGoods(Model model){
        List<GoodsCategory> gcs = goodsCategoryService.queryAll();
        model.addAttribute("gcs",gcs);

        Tag rootTag = null;
        List<Tag> allTags = tagService.queryAll();
        Map<Integer,Tag> tagMap = new HashMap<Integer, Tag>();
        for (Tag tag:allTags){
            tagMap.put(tag.getId(),tag);
        }
        for (Tag tag:allTags){
            Tag child = tag;
            if (child.getPid() == 0){
                rootTag = tag;
            }else {
                Tag parent = tagMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        model.addAttribute("rootTag",rootTag);
        return "member/addGoods";
    }

    @RequestMapping("/myshop")
    public String myshop(){
        return "member/myshop";
    }

    /**
     * 安全退出
     * @param session
     * @return
     */
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
            int cartCnt = memberService.queryCartCount(dbmember.getId());
            if (dbmember == null){
                data(101);
                fail();
            }else {
                if (dbmember.getMemberpswd().equals(MD5Util.digest(userpswd))){
                    session.setAttribute("loginMember",dbmember);
                    session.setAttribute("cartCnt",cartCnt);
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

package com.zh.mall.manager.controller;

import com.mall.manager.api.service.UserService;
import com.zh.mall.common.bean.AJAXResult;
import com.zh.mall.common.bean.User;
import com.zh.mall.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * AJAX请求方法必须访问对象，不需要跳转页面，
     * 必须增加注解：@ResponseBody
     * @return
     */
    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session){

        AJAXResult result = new AJAXResult();
        user.setUserpswd(MD5Util.digest(user.getUserpswd()));
        User dbUser = userService.queryLoginUser(user);

        if(dbUser != null){
            result.setSuccess(true);
            session.setAttribute("loginUser",dbUser);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 如果web程序出现乱码：
     * 1）增加字符编码过滤器（POST）
     * 2）修改服务器的配置，增加对URI字符的解析(GET)
     * @author rambler
     * @param user, model
     * @returns java.lang.String
     * @time 21:03
    */
    @RequestMapping("/dologin")
    public String dologin(User user, Model model) throws Exception{

//        String s = user.getUsername();
//        //System.out.println("s = " + s);
//
//         1) 将乱码字符串按照错误的编码方式恢复成原始字节码序列
//        byte[] bs = s.getBytes("ISO8859-1");
//         2) 将原始的字节码序列按照正确的编码变成正确的文字
//        s = new String(bs, "UTF-8");
//        System.out.println("s = " + s);
        // 获取表单提交的数据
        // 1) req.getParameter("username");
        // 2) 参数列表中直接增加同名的参数
        // 3) 将参数封装为实体类对象(表单数据名称=实体类中属性名称)

        User dbUser = userService.queryLoginUser(user);

        if(dbUser != null){
            return "main";
        }else{
            String errorMsg = "登录失败！";
            model.addAttribute("errorMsg",errorMsg);
            return "redirect:/login";
        }
    }

}

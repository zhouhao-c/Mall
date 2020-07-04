<%--
  Created by IntelliJ IDEA.
  User: hao Zhou
  Date: 2020/6/24
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="GB18030">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="../../static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../static/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../static/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">产品购物平台</a></div>
        </div>
    </div>
</nav>

<div class="container">
    <form id="LoginFrom" method="post" action="user/dologin" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-globe"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select class="form-control" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
        </div>
        <p>${param.errorMsg}</p>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="reg.html">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="../../static/jquery/jquery-2.1.1.min.js"></script>
<script src="../../static/bootstrap/js/bootstrap.min.js"></script>
<script src="../../static/layer/layer.js"></script>
<script>
    function dologin() {
        var username = $("#username").val();
        if( username == ""){
            //alert("登录账号不能为空，请输入");
            layer.msg("登录账号不能为空，请输入",{time:1000,icon:5,shift:6},function () {
               //回调方法，消息关闭后执行逻辑
            });
            return;
        }

        var password = $("#password").val();
        if( password == ""){
            layer.msg("登录密码不能为空，请输入",{time:1000,icon:5,shift:6},function () {
                //回调方法，消息关闭后执行逻辑
            });
            return;
        }
        // AJAX执行登录
        var index = 0;
        $.ajax({
            type : "POST",
            url  : "user/doAJAXLogin",
            data : {
                "username" : username,
                "password" : password
            },
            beforeSend : function () {
                index = layer.load(2,{time : 10*1000});
            },
            success : function (result) {
                layer.close(index);
                if(result.success){
                    window.location.href = "main";
                }else {
                    layer.msg("登录失败，请重新输入",{time:1000,icon:5,shift:6},function () {
                        //回调方法，消息关闭后执行逻辑
                    });
                };
            }
        });
    }
</script>
</body>
</html>

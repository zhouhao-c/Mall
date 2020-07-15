<%--
  Created by IntelliJ IDEA.
  User: hao Zhou
  Date: 2020/7/9
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="navbar-header">
        <a class="navbar-brand" href="index.html" style="font-size:32px;">产品购物平台</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse" style="float:right;">
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> ${loginMember.nickname}<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="${APP_PATH}/member/myshop"><i class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                    <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                    <li class="divider"></li>
                    <li><a href="${APP_PATH}/member/logout"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                </ul>
            </li>
            <li><a href="${APP_PATH}/member/cart"><i class="glyphicon glyphicon-shopping-cart"></i> 购物车<span class="label label-danger">${cartCnt}</span></a></li>
        </ul>
    </div>
</div>

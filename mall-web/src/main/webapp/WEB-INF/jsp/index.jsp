<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/carousel.css">
    <style>
        h3 {
            font-weight:bold;
        }
        #footer {
            padding: 15px 0;
            background: #fff;
            border-top: 1px solid #ddd;
            text-align: center;
        }
        #topcontrol {
            color: #fff;
            z-index: 99;
            width: 30px;
            height: 30px;
            font-size: 20px;
            background: #222;
            position: relative;
            right: 14px !important;
            bottom: 11px !important;
            border-radius: 3px !important;
        }

        #topcontrol:after {
            /*top: -2px;*/
            left: 8.5px;
            content: "\f106";
            position: absolute;
            text-align: center;
            font-family: FontAwesome;
        }

        #topcontrol:hover {
            color: #fff;
            background: #18ba9b;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }
        /* 侧栏导航 */
        .sideBox{padding:10px;height:220px;background:#fff;margin-bottom:10px;overflow:hidden;}
        .sideBox .hd{height:30px; line-height:30px; background:#f60; padding:0 10px;text-align:center;overflow:hidden;}
        .sideBox .hd .more{color:#fff;}
        .sideBox .hd h3 span{font-weight:bold; font-size:14px;color:#fff;}
        .sideBox .bd{padding:5px 0 0;}

        #sideMenu .bd li{margin-bottom:2px; height:30px; line-height:30px;text-align:center; overflow:hidden;}
        #sideMenu .bd li a{display:block;background:#EAE6DD;}
        #sideMenu .bd li a:hover{background:#D5CFBF;}

        /* 列表页 */
        #mainBox{margin-bottom:10px;padding:10px;background:#fff;overflow:hidden;}
        #mainBox .mHd{border-bottom:2px solid #09c;height:30px;line-height:30px;}
        #mainBox .mHd h3{display:initial;*display:inline;zoom:1;padding:0 15px;background:#09c;color:#fff;}
        #mainBox .mHd h3 span{color:#fff;font-size:14px;font-weight:bold;}
        #mainBox .path{float:right;}

        /* 位置导航 */
        .path{ height:30px; line-height:30px; padding-left:10px;}
        .path a,.path span{ margin:0 5px;}

        /* 文章列表 */
        .newsList{padding:10px;text-align:left;}
        .newsList li{background:url("../images/share/point.png") no-repeat 2px 14px; padding-left:10px;height:30px; line-height:30px;}
        .newsList li a{display:inline-block;*display:inline;zoom:1;font-size:14px;}
        .newsList li .date{float:right; color:#999;}
        .newsList li.split{margin-bottom:10px;padding-bottom:10px;border-bottom:1px dotted #ddd;height:0px;line-height:0px;overflow:hidden;}

        /* 通用带图片的信息列表_普通式 */
        .picList{padding:10px;text-align:left;}
        .picList li{margin:0 5px;height:190px;}

        h3.break {
            font-size:16px;
            display: block;
            white-space: nowrap;
            word-wrap: normal;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        h3.break>a {
            text-decoration:none;
        }
        .favgoods.glyphicon-star-empty {
            color:blue;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <c:if test="${loginMember.id == null}">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="javascript:;" style="font-size:32px;">产品购物平台</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse" style="float:right;">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="${APP_PATH}/login">登录</a></li>
                            <li><a href="">注册</a></li>
                        </ul>
                    </div>
                </div>
            </c:if>
            <c:if test="${loginMember.id != null}">
                <%@include file="/WEB-INF/jsp/common/memberNavInfo.jsp"%>
            </c:if>
        </nav>

    </div>
</div>


<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active" onclick="window.location.href='project.html'" style="cursor:pointer;">
            <img src="/static/img/carousel-1.jpg" alt="First slide">
        </div>
        <div class="item" onclick="window.location.href='project.html'" style="cursor:pointer;">
            <img src="/static/img/carousel-2.jpg" alt="Second slide">
        </div>
        <div class="item" onclick="window.location.href='project.html'" style="cursor:pointer;">
            <img src="/static/img/carousel-3.jpg" alt="Third slide">
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="/static/img/p1.jpg" alt="Generic placeholder image" style="width: 140px; height: 140px;">
            <h2>智能高清监控机器人</h2>
            <p>可爱的造型，摄像安防远程互联的全能设计，让你随时随地守护您的家人，陪伴你的生活。</p>
            <p><a class="btn btn-default" href="project.html" role="button">商品详情 &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="/static/img/p2.jpg" alt="Generic placeholder image" style="width: 140px; height: 140px;">
            <h2>NEOKA智能手环</h2>
            <p>要运动更要安全，这款、名为“蝶舞”的NEOKA-V9100智能运动手环为“安全运动而生”。</p>
            <p><a class="btn btn-default" href="project.html" role="button">商品详情 &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="/static/img/p3.png" alt="Generic placeholder image" style="width: 140px; height: 140px;">
            <h2>驱蚊扣</h2>
            <p>随处使用的驱蚊纽扣，<br>解决夏季蚊虫问题。</p>
            <p><a class="btn btn-default" href="project.html" role="button">商品详情 &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->

    <c:forEach items="${APP_GCS}" var="gc" >
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="box ui-draggable" id="mainBox">
                        <div class="mHd" style="">
                            <div class="path">
                                <a href="projects.html">更多...</a>
                            </div>
                            <h3>
                                    ${gc.name} <small style="color:#FFF;">${gc.remark}</small>
                            </h3>
                        </div>
                        <div class="mBd" style="padding-top:10px;">
                            <div class="row">
                                <c:forEach items="${gc.goodsDatas}" var="goods">
                                    <div class="col-md-3">
                                        <div class="thumbnail">
                                            <img alt="300x200" src="${APP_PATH}/static/img/goods/${goods.iconpath}" />
                                            <div class="caption">
                                                <h3 class="break">
                                                    <a href="${APP_PATH}/goods/detail/${goods.id}">${goods.name}</a>
                                                </h3>
                                                <div style="padding:10px;"><span style="float:right;"><i goodsid="${goods.id}" class="glyphicon glyphicon-star-empty" ></i></span>  <span ><font color="red"><b><i class="glyphicon glyphicon-yen" title="价格"></i> ${goods.price}</b></font></span> </div>
                                                <div><button class="btn btn-danger"><i class="glyphicon glyphicon-gift"></i> 我要兑换</button><button id="testBtn" disabled="disabled" class="btn btn-success" style="float:right;"onclick="window.location.href='${APP_PATH}/goods/detail/${goods.id}'"><i class="glyphicon glyphicon-shopping-cart"></i> 我要购买</button></div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </c:forEach>

    <!-- FOOTER -->
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow">关于我们</a> | <a rel="nofollow">服务条款</a> | <a rel="nofollow">免责声明</a> | <a rel="nofollow">网站地图</a> | <a rel="nofollow">联系我们</a>
                    </div>
                    <div class="copyRight">
                        Copyright ?2017-2017atguigu.com 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>

</div><!-- /.container -->


<script src="${APP_PATH}/static/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/script/docs.min.js"></script>
<script src="${APP_PATH}/static/script/back-to-top.js"></script>
<script src="${APP_PATH}/static/layer/layer.js"></script>
<script>
    $(".thumbnail img").css("cursor", "pointer");
    $(".thumbnail img").click(function(){
        window.location.href = "project.html";
    });

    var loginMember="<%=session.getAttribute("loginMember")%>";
    if (loginMember == "null"){
        $("#testBtn").attr("disabled",true);
    }else {
        $("#testBtn").attr("disabled",false);
    }

    $(".glyphicon-star-empty").click(function(){
        that = this;
        $.ajax({
            type : "POST",
            url  : "${APP_PATH}/member/addFav",
            data : {
                "goodsid" : $(that).attr("goodsid")
            },
            success : function(result) {
                if (result.success){
                    layer.msg("商品收藏成功",{time:1000,icon:1,shift:3},function () {
                        //回调方法，消息关闭后执行逻辑
                    });
                    $(that).addClass("favgoods");
                }else {
                    layer.msg("商品收藏失败,请先登录",{time:1000,icon:2,shift:3},function () {
                        //回调方法，消息关闭后执行逻辑
                    });
                }
            }
        });
    });
</script>
</body>
</html>

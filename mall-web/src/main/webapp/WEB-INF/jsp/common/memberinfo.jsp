<%--
  Created by IntelliJ IDEA.
  User: hao Zhou
  Date: 2020/7/9
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="thumbnail" style="    border-radius: 0px;">
    <img src="/static/img/services-box1.jpg" class="img-thumbnail" alt="">
    <div class="caption" style="text-align:center;">
        <h3>
            ${loginMember.nickname}
        </h3>
        <c:if test="${loginMember.authstatus == '1'}">
            <span class="label label-success" style="cursor:pointer;">已实名认证</span>
        </c:if>
        <c:if test="${loginMember.authstatus != '1'}">
            <span class="label label-danger" onclick="alert('实名认证业务');" style="cursor:pointer;">未实名认证</span>
        </c:if>
        <br>
        <br>
        <button class="btn btn-danger" onclick="window.location.href='${APP_PATH}/member/logout'">安全退出</button>
    </div>
</div>

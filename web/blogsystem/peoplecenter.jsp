<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>等你下课</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/pintuer.css"/>
    <style>
        .pinglun{
            width: 40%;
        }
    </style>
</head>
<body>
<div class="container">
    <%@ include file="/blogsystem/other/head.jsp"%>

    <table class="table table-hover" style="margin-top: 10%">
        <caption><h1>个人信息</h1></caption>
            <tr>
                <td>用户名</td>
                <td>${requestScope.user.userName}</td>
            </tr>
            <tr>
                <td>注册日期</td>
                <td>${requestScope.user.registrationDate}</td>
            </tr>
            <tr>
                <td>性别</td>
                <td>${requestScope.user.sex}</td>
            </tr>
            <tr>
                <td>生日</td>
                <td>${requestScope.user.birthday}</td>
            </tr>
            <tr>
                <td>上次登录日期</td>
                <td>${requestScope.user.lastLoginTime}</td>
            </tr>
            <tr>
                <td>个人描述</td>
                <td>${requestScope.user.description}</td>
            </tr>


    </table>
    <br><br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br><br>

</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>
<script>
    window.onload=function (ev) {
        var more = document.getElementById("moreandemore");
        more.className="active";
    }
    function aboutus() {
        alert("云奕三部");
    }
    function exitlogin() {
        window.location.href="/userServlet?cast=exit";
    }
</script>
<%@ include file="/blogsystem/other/foot.jsp"%>
</body>
</html>

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
    <br>
    <h1 class="text-center height-large">${blogobj.blogTitle}</h1><br>
    <p class="text-right height-large text-big">${blogobj.user.userName}于${blogobj.createTime}发布</p><br>
    <p class="text-justify text-big">${blogobj.blogText}</p>
    <br>
    <form action="/commentsServlet" class="text-center">
        我要评论：
        <input type="text" name="pinglun" class="pinglun">
        <input type="hidden" name="blogid" value="${blogobj.blogId}">
        <input type="hidden" name="cast" value="newcomments">
        <input type="submit">
    </form>
    <br><br>
    <c:forEach items="${list}" var="comments">
        <div class="panel">
            <div class="panel-head" style="text-align: center">
                <a href="/userServlet?cast=query&userid=${comments.user.id}">${comments.user.userName}</a>于${comments.createTime}评论了这条博客<br>
            </div>
            <div class="panel-body" style="text-align: center">
                内容为：${comments.commentText}<c:if test="${comments.authorid==user.id}"><a href="/commentsServlet?cast=delete&cid=${comments.id}&bid=${comments.blogId}" style="margin-left: 3em;color: red">删除</a></c:if>
            </div>
        </div>
        <p class="text-center panel">


    </p>
    </c:forEach>


</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>
<script>
    window.onload=function (ev) {
        var myblog = document.getElementById("blogcenter");
        myblog.className="active";
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

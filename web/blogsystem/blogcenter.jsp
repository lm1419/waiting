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
</head>
<body>
<div class="container">
    <%@ include file="/blogsystem/other/head.jsp" %>
    <center><h1>博客中心</h1></center>
    <c:forEach items="${pb.list}" var="blog">
        <br>
        <div class="panel">
            <div class="panel-head" style="text-align: center">
                <a href="/showBlogTextServlet?blogId=${blog.blogId}">${blog.blogTitle}&nbsp;&nbsp;&nbsp;&nbsp;类别：${blog.type}</a>
            </div>
            <div class="panel-body">
                <p class="text-left" style="padding-left: 10%">
                        ${blog.blogText}
                </p>
            </div>
            <div class="panel-foot">
                <div class="text-right">
                    <span style="color: red"><a
                            href="/userServlet?cast=query&userid=${blog.user.id}">${blog.user.userName}</a></span>发布于${blog.createTime}
                </div>
            </div>
            <br>

        </div>
    </c:forEach>
    <div style="text-align: center">
        <ul class="pagination">
            <c:if test="${pb.currentPage!=1}">
                <li><a href="/showAllBlogByPageServlet?currentPage=${pb.currentPage-1}&rows=5">上一页</a></li>
            </c:if>
        </ul>
        <ul class="pagination pagination-group">
            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <li id="${i}"><a href="/showAllBlogByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
            </c:forEach>
        </ul>
        <ul class="pagination">
            <c:if test="${pb.currentPage!=pb.totalPage}">
                <li><a href="/showAllBlogByPageServlet?currentPage=${pb.currentPage+1}&rows=5">下一页</a></li>
            </c:if>
        </ul>
        <h1>共${pb.totalCount}条博客，共${pb.totalPage}页</h1>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>
<script>
    window.onload = function (ev) {
        var myblog = document.getElementById("blogcenter");
        myblog.className = "active";
        var elementById = document.getElementById("${pb.currentPage}");
        elementById.className = "active";
    }

    function aboutus() {
        alert("云奕三部");
    }

    function exitlogin() {
        window.location.href = "/userServlet?cast=exit";
    }
</script>
<%@ include file="/blogsystem/other/foot.jsp" %>
</body>
</html>

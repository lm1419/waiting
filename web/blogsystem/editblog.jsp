<%--
  Created by IntelliJ IDEA.
  User: limiao
  Date: 2019/11/9
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
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
        .foooot {
            position: absolute;
            left: 32%;
            bottom: 0;
        }

        td {
            width: 200px;
        }

    </style>
</head>
<body>
<div class="container">
    <%@ include file="/blogsystem/other/head.jsp" %>
    <p>
    <center><h1>博客管理</h1></center>
    </p>
    <form id="formaa" action="/deleteBlogChoosedServlet">
        <input type="hidden" name="currentPage" value="${pb.currentPage}">
        <input type="hidden" name="rows" value="5">
        <input type="button" style="float:right;margin-left: 5px;" value="删除选中" class="button" id="delchoosed">
        <a href="/blogsystem/newblog.jsp" class="button" style="float:right; ">增加新博客</a>
        <table class="table table-hover table-hover table-striped">
            <tr>
                <th><input type="checkbox" id="checkall"></th>
                <th>博客序号</th>
                <th>博客标题</th>
                <th>发表日期</th>
                <th>博客类型</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="blog" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="blogsid" value="${blog.blogId}"></td>
                    <td>${s.count}</td>
                    <td>${blog.blogTitle}</td>
                    <td>${blog.type}</td>
                    <td>${blog.createTime}</td>
                    <td>
                        <a href="/changeBlogServlet?id=${blog.blogId}" class="button">修改</a>&nbsp;&nbsp;
                        <a href="/deleteBlogServlet?id=${blog.blogId}" class="button">删除</a>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div style="text-align: center">
        <ul class="pagination">
            <c:if test="${pb.currentPage!=1}">
                <li><a href="/manageBlogServlet?currentPage=${pb.currentPage-1}&rows=5">上一页</a></li>
            </c:if>
        </ul>
        <ul class="pagination pagination-group">
            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <li id="${i}"><a href="/manageBlogServlet?currentPage=${i}&rows=5">${i}</a></li>
            </c:forEach>
        </ul>
        <ul class="pagination">
            <c:if test="${pb.currentPage!=pb.totalPage}">
                <li><a href="/manageBlogServlet?currentPage=${pb.currentPage+1}&rows=5">下一页</a></li>
            </c:if>
        </ul>
        <h1>共${pb.totalCount}条博客，共${pb.totalPage}页</h1>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>
<script>
    window.onload = function (ev) {
        var myblog = document.getElementById("myblog");
        myblog.className = "active";

        var checkall = document.getElementById("checkall");
        var checks = document.getElementsByName("blogsid");
        checkall.onclick = function (ev1) {
            for (var i = 0; i <= checks.length; i++) {
                checks[i].checked = checkall.checked;
            }
        }

        var btn = document.getElementById("delchoosed");
        btn.onclick = function () {
            if (confirm("您确定要删除吗？")) {
                var flag = false;
                for (var j = 0; j < checks.length; j++) {
                    if (checks[j].checked) {
                        //有一个条目选中了
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    document.getElementById("formaa").submit();
                }
            }

        }
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

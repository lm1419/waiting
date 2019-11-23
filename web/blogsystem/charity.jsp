<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>捐助我们</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/pintuer.css"/>
    <script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>

</head>
<body>
<div class="container">
    <%@include file="other/head.jsp" %>
    <div class="keypoint bg radius text-center">
        <h1>
            尊敬的用户，您好！！！</h1>
        <p>
            充值本博客会员可以获得超值体验！<br>
            充值了会员，在云奕博客网，你就是爹！

        <p>
            <button id="chong" class="button bg-yunyi text-center text-white">
                我已充值
            </button>
        </p>
    </div>
    <center>
    <img src="${pageContext.request.contextPath}/img/wx.png" alt="" width="240px" height="320px">
    <img src="${pageContext.request.contextPath}/img/zfb.png" alt="" width="240px" height="320px">
    </center>
    <%@include file="other/foot.jsp"%>
</div>
<script>
    window.onload=function (ev) {
        var myblog = document.getElementById("moreandemore");
        myblog.className="active";
    }
    document.getElementById("chong").onclick=function (ev) {
        alert("哈哈~！");
    }
</script>
</body>
</html>

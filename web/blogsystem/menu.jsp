<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>等你下课</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/pintuer.css"/>
    <script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/pintuer.js"></script>
    <style>
        .foooot {
            position: absolute;
            left: 32%;
            bottom: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <%@ include file="/blogsystem/other/head.jsp" %>
    <div class="banner" data-style="border-yunyi">
        <div class="carousel">
            <div class="item">
                <div class="keypoint bg radius text-center">
                    <h1>
                        等你下课</h1>
                    <p>
                        云奕三部的大家庭一起使用的交流网站，方便，快捷s发表自己的见解。

                    <p>
                        <button id="love" class="button bg-yunyi text-center text-white">
                            爱你
                        </button>
                    </p>
                </div>
            </div>
            <div class="item">
                <div class="keypoint bg radius text-center ">
                    <h1>
                        Tomcat服务器部署，轻松高效</h1>
                    <p>
                        免费开放源代码的轻量级应用服务器，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP程序的首选。</p>
                    <p class="text-center">
                        <button onclick="tmcat()" class="button bg-yunyi text-white">
                            了解一下
                        </button>
                    </p>
                </div>
            </div>
            <div class="item">
                <div class="item">
                    <div class="keypoint bg radius text-center">
                        <h1>
                            快速，简洁，且多用户可交流的博客框架</h1>
                        <p>
                            登录，注册，找回密码，个人中心，博客管理，评论管理，会员充值等等功能，应有尽有。

                        <p>
                            <button class="button bg-yunyi text-center text-white">
                                爱你
                            </button>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="popo">
        <div class="popo-left">
            <div class="popo-body popo-blue left box-shadow-big">希望你可以在我的博客系统里愉快遨游哦！</div>
        </div>
    </div>
    <div class="popo">
        <div class="popo-right">
            <div class="ico-right "></div>
            <div class="popo-body popo-yellow right radius box-shadow-small">
                如果喜欢我，就请点一下爱我吧！
            </div>
        </div>
    </div>
    <br>
    <br>



</div>

<script>
    function tmcat() {
        window.location.href = "https://blog.csdn.net/qq_40881680/article/details/83582484";
    }

    window.onload = function (ev) {
        var main = document.getElementById("main");
        main.classList.add("active")
    }
    var love = document.getElementById("love");
    love.onclick = function (ev) {
        alert("我也爱你")
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

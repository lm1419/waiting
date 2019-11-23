<%--
  Created by IntelliJ IDEA.
  User: limiao
  Date: 2019/11/9
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-layout padding-big-top padding-big-bottom">
    <div class="line">
        <div class="xl12 xs5 xm6 xb7">
            <button class="button icon-navicon float-right" data-target="#header-demo1">
            </button>
            <a href="#">
                <%--                    <img src="/img/logo.png" width="200px" height="45px" alt="wait" />--%>
            </a>
        </div>
    </div>
    <div class="line">
        <a href="/blogsystem/menu.jsp"><img src="../img/yybkw.jpg" height="90px" width="14%" alt="" style="position:absolute;top: -10px;left: 18%"></a>
        <div class="xl12 xs7 xm6 xb5 padding-small-top x3 x11-move fixed" data-style="fixed-bottom" >
            <ul class="nav nav-menu nav-inline nav-navicon" id="header-demo1">
                <li class="active"><a href="#">${user.userName}<span class="arrow"></span></a>
                    <ul class="drop-menu">
                        <li><a href="/userServlet?cast=query&userid=${sessionScope.user.id}">用户中心</a></li>
                        <li><a href="/userServlet?cast=exit">退出登录</a></li>
                    </ul>
                </li>
<%--                <li><a href="#" onclick="aboutus()">关于我们</a>--%>
<%--                </li>--%>
            </ul>
            </li>
            </ul>
        </div>
    </div>
</div>
<div class="navbar bg-yunyi bg-inverse radius">
    <div class="navbar-head">
        <button class="button bg icon-navicon" data-target="#navbar-bg1">
        </button>
    </div>
    <div class="navbar-body nav-navicon" id="navbar-bg2">
        <ul class="nav nav-inline nav-menu nav-tabs">
            <li id="main"><a href="/blogsystem/menu.jsp">首页</a></li>
            <li id="blogcenter"><a href="/showAllBlogByPageServlet?rows=5&currentPage=1" >博客中心</a></li>
            <li id="myblog"><a href="/showMyBlogByPageServlet?rows=5&currentPage=1" >我的博客<span class="arrow"></span></a>
                <ul class="drop-menu">
                    <li><a href="/blogsystem/newblog.jsp">写博客</a></li>
                    <li><a href="/manageBlogServlet?currentPage=1&rows=5">博客管理</a>
                    </li>
                    <li><a href="/showAllBlogByPageServlet?rows=5&currentPage=1">我的博客</a></li>
                </ul>
            </li>
            <li class="nav-more" id="moreandemore"><a href="/blogsystem/charity.jsp" style="font-weight: bold;">会员充值</a>

            </li>
        </ul>
        <div class="navbar-form navbar-left">
        </div>
        <div class="navbar-text navbar-right hidden-s">
            联系电话：17635206976
        </div>
    </div>
</div>

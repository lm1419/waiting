<%--
  Created by IntelliJ IDEA.
  User: limiao
  Date: 2019/11/4
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        .panel {
            width: 45%;
            height: 50%;
            position: absolute;
            top: 20%;
            left: 26%;
        }

        .text {
            height: 100%;
            width: 40%;

            position: relative;
            left: 8%;
            top: 28%;
        }

        .right {
            border-left: 1px grey solid;
            border-left-width: thin;
            height: 70%;
            width: 60%;
            position: absolute;
            left: 44%;
            top: 20%;
        }

        #cn {
            font-family: 幼圆;
            font-size: 65px;
            color: orange;
        }

        #en {
            font-family: "Century Gothic";
            font-size: 35px;
            color: grey;
        }

        .bord {
            margin-left: 40px;
            width: 400px;
            height: 65px;
            border-radius: 8px;
            border-style: groove;
            position: relative;
            top: 10px;
            padding-left: 5%;
            font-size: 15px;
        }
        .bord_vcode {
            margin-left: 40px;
            width: 200px;
            height: 65px;
            border-radius: 8px;
            border-style: groove;
            position: relative;
            top: 10px;
            padding-left: 5%;
            font-size: 15px;
        }

        #subbtn {
            position: relative;
            left: 10%;
            top: 50%;
            width: 200px;
            height: 50px;
            background: orange;
            border: 0;
            color: white;
            font-size: 17px;
            border-radius: 8px;
        }

        #subbtn:hover {
            background: darkorange;
        }

        a {
            position: relative;
            left: 40px;
            top: 22px;
            color: orange;
            text-decoration: none;
        }

        a:hover {
            color: skyblue;
            text-decoration: underline;
        }


    </style>
</head>
<body>
<div class="background">
    <div class="panel">
        <div class="text">
            <div id="cn">云奕博客</div>
            <div id="en">Grand&nbsp;&nbsp;&nbsp;&nbsp;Cloud</div>
        </div>
        <div class="right">
          <span>
        <form action="/userServlet">
            <input type="hidden" name="cast" value="login">
            <input type="text" name="userName" placeholder="请输入用户名" class="bord"><br><br>
            <input type="password" name="passWord" placeholder="请输入密码" class="bord"><br><br>
            <input type="text" name="vcode" placeholder="请输入验证码" class="bord_vcode"><a
                href="javascript:refreshCode()"><img id="vcode" src="${pageContext.request.contextPath}/checkCodeServlet"></a><br><br>

            <a href="register.jsp" id="">现在注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录" id="subbtn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
                href="forget.jsp">忘记密码</a>

        </form>

<script>
    function refreshCode() {
        var vcod = document.getElementById("vcode");
        vcod.src="/checkCodeServlet?time="+new Date().getTime();
    }
</script>
         </span>
        </div>

    </div>
</div>

</body>
</html>

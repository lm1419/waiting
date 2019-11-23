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
            height: 40%;
            position: absolute;
            top: 23%;
            left: 26%;
        }
        .text{
            height: 100%;
            width: 40%;
            position: relative;
            left: 8%;
            top:28%;
        }
        .right{
            border-left: 1px grey solid ;
            border-left-width: thin;
            position: absolute;
            left: 44%;
            top: 20%;
            height: auto;
            width: 700px;
        }
        #cn{
            font-family: 幼圆;
            font-size: 65px;
            color: lightseagreen;
        }
        #en{
            font-family: "Century Gothic";
            font-size: 35px;
            color: grey;
        }
        .bord{
            margin-top:10px;
            margin-left: 40px;
            width: 400px;
            height: 45px;
            border-radius: 8px;
            border-style: groove;
            position: relative;
            top: 10px;
            padding-left: 5%;
            font-size: 15px;
        }
        #subbtn{
            margin-bottom: 40px;
            margin-left: 140px;
            position: relative;
            top: 30px;
            width: 200px;
            height: 50px;
            background: lightseagreen;
            border: 0;
            color: white;
            font-size: 17px;
            border-radius: 8px;
        }
        #subbtn:hover{
            background: darkseagreen;
        }
        a{
            color:green;
            text-decoration: none;
        }
        a:hover{
            color: greenyellow;
            text-decoration: underline;
        }
        .box{
            padding-left: 100px;
            height: 5px;
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
            <form action="/userServlet" method="post">
                <input type="hidden" name="cast" value="forget2">
                <div class="dv">
                    <div class="box">你的密保问题是：${user.question} </div><br>
                    <input name="answer" placeholder="请输入答案：" class="bord"/><br>
                    <input type="password" name="passWord" placeholder="请输入你要更改的新密码："class="bord"><br>
                    <input type="submit" id="subbtn">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

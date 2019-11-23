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
        table{
            table-layout:fixed;
            margin-left: 30px;
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
            color: green;
        }
        #en{
            font-family: "Century Gothic";
            font-size: 35px;
            color: grey;
        }
        .bord{
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
            margin-top: 40px;
            margin-left: 140px;
            position: absolute;
            width: 200px;
            height: 50px;
            background: green;
            border: 0;
            color: white;
            font-size: 17px;
            border-radius: 8px;
        }
        #subbtn:hover{
            background: darkgreen;
        }
        a{
            color:green;
            text-decoration: none;
        }
        a:hover{
            color: greenyellow;
            text-decoration: underline;
        }
        .td_left{
            width: 60px;
        }
        .td_bottom{
            padding-top: 20px;
        }
        #tex{
            position: relative;
            top: -5px;
            left: 300px;
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
           <input type="hidden" name="cast" value="forget">
    <table>
        <tr>
            <td class="td_left">你的用户名为：<input type="text" name="userName" class="bord"></td>
        </tr>
            <td class="td_bottom" colspan="2"><input type="submit" value="提交" id="subbtn"><a href="login.jsp" id="tex">我想起来了，点此登录</a></td>

        </tr>
    </table>
</form>
        </div>
    </div>
</div>
</body>
</html>

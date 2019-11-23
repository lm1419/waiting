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
    <title>用户注册</title>
    <style>
        table {
            position: relative;
            top: -100px;
            left: 40px;
            /*            border: 1px solid;*/
            text-align: center;
        }

        /*        td {
                    border: 1px solid;
                }*/

        .panel {
            width: 45%;
            height: 40%;
            position: absolute;
            top: 23%;
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
            width: 80%;
            position: absolute;
            left: 44%;
            top: 20%;
        }

        #cn {
            font-family: 幼圆;
            font-size: 65px;
            color: deepskyblue;
        }

        #en {
            font-family: "Century Gothic";
            font-size: 35px;
            color: grey;
        }

        .input {
            margin-top: 8px;
            margin-bottom: 5px;
            margin-left: 40px;
            width: 400px;
            height: 50px;
            border-radius: 8px;
            border-style: groove;
            padding-left: 5%;
            font-size: 15px;
        }

        .sex {
            margin-left: 40px;
        }

        #subbtn {
            margin-top: 9px;
            position: relative;
            top: 78%;
            width: 200px;
            height: 50px;
            background: deepskyblue;
            border: 0;
            color: white;
            font-size: 17px;
            border-radius: 8px;
        }

        #subbtn:hover {
            background: skyblue;
        }

        a {
            color: deepskyblue;
            text-decoration: none;
        }

        a:hover {
            color: skyblue;
            text-decoration: underline;
        }

        textarea {
            height: 20px;
            line-height: 20px;
        }

        .td_right {
            padding-left: 2em;
        }

        .duigou {
            position: relative;
            width: 30px;
            height: 30px;
            top: 0px;
            left: 0px
        }

        .ck {
            color: gray;
            font-size: 10px;
            font-family: "微软雅黑 Light";
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
            <form action="/userServlet" onsubmit="return checksub();">
                <table cellspacing="0">
                    <input type="hidden" name="cast" value="register">
                    <tr>
                        <td class="td_left"><font color="red">*</font>用户名</td>
                        <td class="td_middle"><input type="text" name="userName" onblur="ajax()" id="userName"
                                                     placeholder="请输入用户名" class="input">
                        </td>
                        <td class="td_right"><span id="checkun" class="ck">用户名应由3-12位字符组成</span></td>
                    </tr>
                    <tr>
                        <td class="td_left"><font color="red">*</font>密码</td>
                        <td class="td_middle"><input type="password" name="passWord" placeholder="请输入密码"
                                                     onblur="checkpw()" id="passWord" class="input">
                        </td>
                        <td class="td_right"><span id="checkpw" class="ck">密码应包含6-20位的大写、小写英文及数字</span></td>
                    </tr>
                    <tr>
                        <td class="td_left"><font color="red">*</font>性别</td>
                        <td class="td_middle"><input type="radio" name="sex" value="男" checked class="sex">男<input
                                type="radio" name="sex" value="女" class="sex">女
                        </td>
                        <td class="td_right"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><font color="red">*</font>生日</td>
                        <td class="td_middle"><input type="date" id="date" name="birthday" onblur="checkbirth()"
                                                     class="input"></td>
                        <td class="td_right"><span id="checkbirthday" class="ck"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left"><font color="red">*</font>密保问题</td>
                        <td class="td_middle"><input name="question" onblur="checkque()" placeholder="为了防止忘记密码，请设置密保问题"
                                                     id="question" class="input"></td>
                        <td class="td_right"><span id="checkquestion" class="ck"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left"><font color="red">*</font>答案</td>
                        <td class="td_middle"><input name="answer" class="input" onblur="checkanswer()" id="answer"
                                                     placeholder="请输入密保问题的答案"></td>
                        <td class="td_right"><span id="checkanswer" class="ck"></span></td>
                    </tr>
                    <tr>
                        <td class="td_left">个人描述</td>
                        <td class="td_middle"><INPUT name="description" class="input"
                                                     placeholder="描述你自己吧！"></td>
                        <td class="td_right"><span id="checkdescription"></span></td>
                    </tr>
                    <tr id="last">
                        <td class="td_left"><a href="login.jsp">我有账号，点此登录</a></td>
                        <td class="td_middle"><input type="submit" value="注册" id="subbtn"></td>
                        <td class="td_right"><a href="forget.jsp">忘记密码</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script>
    var userName = document.getElementById("userName");
    var checkUNSpan = document.getElementById("checkun");
    var passWord = document.getElementById("passWord");
    var checkPWSpan = document.getElementById("checkpw");
    var question = document.getElementById("question");
    var checkQueSpan = document.getElementById("checkquestion");
    var answer = document.getElementById("answer");
    var checkanswerSpan = document.getElementById("checkanswer")
    var date = document.getElementById("date");
    var checkdateSpan = document.getElementById("checkbirthday");

    function checkbirth() {
        if (date.value.length != 0) {
            checkdateSpan.innerHTML = "<img src='/img/benefits.png'  class='duigou'>";
            return true;
        } else {
            checkdateSpan.innerHTML = "生日不能为空";
            return false;
        }
    }


    function checkpw() {
        var pw = passWord.value;
        var regExppw = /^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9~!@&%#_]{8,16}$/;
        if (regExppw.test(pw)) {
            checkPWSpan.innerHTML = "<img src='/img/benefits.png'  class='duigou'>";
            return true;
        } else {
            checkPWSpan.innerHTML = "密码应包含6-20位的大写、小写英文及数字";
            return false;
        }
    }

    function checkque() {
        var qe = question.value;
        if (qe.length != 0) {
            checkQueSpan.innerHTML = "<img src='/img/benefits.png'  class='duigou'>";
            return true;
        } else {
            checkQueSpan.innerHTML = "问题不能为空！";
            return false;
        }
    }

    function checkanswer() {
        var as = answer.value;
        if (as.length != 0) {
            checkanswerSpan.innerHTML = "<img src='/img/benefits.png'  class='duigou'>";
            return true;
        } else {
            checkanswerSpan.innerHTML = "答案不能为空！";
            return false;
        }
    }

    function checksub() {
        // alert("abc");
        if (ajax() && checkpw() && checkque() && checkanswer() && checkbirth()) {
            return true;
        } else {
            alert("还有没填完的必填项~");
            return false;
        }

    }

    function ajax() {
        var un = userName.value;
        var b = false;
        $.ajax({
            type: "post",
            url: "/userServlet?cast=ajax",
            async : false,
            data: {name: un},
            success: function (result) {
                alert(un);
                if (un.length >= 3 && un.length <= 12) {
                    if (result == "1") {
                        checkUNSpan.innerHTML = "用户名重复";
                        b = false;
                    }
                    if (result == "0") {
                        checkUNSpan.innerHTML = "<img src='img/benefits.png'  class='duigou'>";
                        b = true;
                    }
                } else {
                    checkUNSpan.innerHTML = "用户名应由3-12位字符组成";
                    b = false;
                }
            }
        });
        return b;
    }
</script>
</body>
</html>

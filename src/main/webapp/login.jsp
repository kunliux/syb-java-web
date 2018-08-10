
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>手语帮管理系统登录</title>
    <style>

        td{
            height: 50px;
        }
        #container
        {
            margin: 0 auto;
            width:380px;
            background-color: #FAFAFA;
            border: 13px solid #A5D6A7;
            padding: 25px;

        }
        body {
            margin: 50px 0;
            text-align: center;
        }

        .btn {
            border: 1px solid gray;
            width: 100px;
            height: 30px;
            font-size: 18px;
            cursor: pointer;
        }
        #embed-captcha {
            width: 300px;
            margin: 0 auto;
        }
        .show {
            display: block;
        }
        .hide {
            display: none;
        }
        #notice {
            color: red;
        }
        /* 以下遮罩层为demo.用户可自行设计实现 */
        #mask {
            display: none;
            position: fixed;
            text-align: center;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            overflow: auto;
        }
        /* 可自行设计实现captcha的位置大小 */
        .popup-mobile {
            position: relative;
        }
        #popup-captcha-mobile {
            position: fixed;
            display: none;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            -webkit-transform: translate(-50%, -50%);
            z-index: 9999;
        }
        .inp {
            border: 1px solid gray;
            padding: 0 10px;
            width: 200px;
            height: 30px;
            font-size: 18px;
        }
        .input {
            border: 1px solid #ffd800;
            height: 30px;
            width: 200px;
            font-family: Andalus;
            font-size: 20px;
            padding-left: 15px;
        }
        .button {

            float: right;
            font-size: 20px;
            height: 40px;
            width: 100px;
            margin-right: 20px;
            border-radius: 10px 10px 10px 10px;
        }
        .button:hover {
            color: floralwhite;
            float: right;
            background-color:  #A5D6A7;
            font-size: 23px;
            height: 40px;
            width: 100px;
            margin-right: 20px;
            border-radius: 10px 10px 10px 10px;

        }
    </style>
</head>
<body>

<br><br>
<br><br>

<!-- 为使用方便，直接使用jquery.js库，如您代码中不需要，可以去掉 -->
<!-- <script ype="text/javascript" src="http://code.jquery.com/jquery-1.12.3.min.js"></script> -->
<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="js/gt.js"></script>
<!-- 引入封装了failback的接口--initGeetest -->
<script type="text/javascript" src="http://static.geetest.com/static/tools/gt.js"></script>

<!-- 若是https，使用以下接口 -->
<!-- <script src="https://code.jquery.com/jquery-1.12.3.min.js"></script> -->
<!-- <script src="https://static.geetest.com/static/tools/gt.js"></script> -->
<div id="container">
<div class="popup">
    <h2>管理员登录</h2>
    <br>
    <form action="check.jsp" method="post" onsubmit="return sendLoginData()">
        <table align="center">
    <tr>
        <td>用户名：</td>
        <td><input class="input" id="username" name="username" type="text" placeholder="请输入用户名" ></td>
    </tr>

            <tr>
                <td align="left">密&nbsp;&nbsp;码：</td>
                <td><input class="input" id="password" name="password" type="password" placeholder="请输入密码"></td>
        </tr>
            <tr>
                <td align="left">身&nbsp;&nbsp;份：</td>
                <td> <input class="" name="status" type="radio" value="superManager">超管
        <input class="" name="status" type="radio" value="staffManager">客服
        <input class="" name="status" type="radio" value="jobManager">就业
        <input class="" name="status" type="radio" value="newsManager">新闻</td>
            </tr>
            <tr>
                <td colspan="2"><div id="embed-captcha" ></div>
                    <p id="wait" class="show">正在加载验证码......</p>
                    <p id="notice" class="hide">请先拖动验证码到相应位置</p><br></td>
            </tr>
        </table>

    <%--<div id="embed-captcha" ></div>--%>
    <%--<p id="wait" class="show">正在加载验证码......</p>--%>
    <%--<p id="notice" class="hide">请先拖动验证码到相应位置</p><br>--%>
        <input type="submit"  class="button" id="embed-submit" value="登录"   />
    </form>


</div><br><br>
</div>

<script type="text/javascript" src="js/pc.js"></script>
</body>
<script>
    function sendLoginData() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var status = document.getElementById("status").value;
        if (username == "") {
            alert("用户名不能为空！");
            return false;
        }
        if (password == "") {
            alert("密码不能为空！");
            return false; }

            else {
            session.setAttribute("status",status);
            <%--<%   %>--%>
        }
    }
</script>

</html>


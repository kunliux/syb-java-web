<%--
  Created by IntelliJ IDEA.
  User: SYL
  Date: 2017/8/17
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员添加</title>
    <style>
        .input {
            border: 1px solid #ffd800;
            height: 30px;
            width: 200px;
            font-family: Andalus;
            font-size: 17px;
            padding-left: 15px;
        }
        h3{
            text-align:center;
        }
        td
        {
            font-size: 17px;
            height:50px;
        }
        body
        {
            margin:0 auto;
        }
        #container
        {
            margin: 0 auto;
            width:430px;
            background-color: #FAFAFA;
            border: 13px solid #A5D6A7;
            padding: 25px;

        }
        .error{
            color: #ff0000;
        }
        .button {

            float: right;

            font-size: 20px;
            height: 40px;
            width: 120px;
            margin-right: 20px;
            border-radius: 10px 10px 10px 10px;
            font-family: Andalus;
        }
        .button:hover {
            color: white;
            float: right;
            background-color: #808080;
            font-size: 22px;
            height: 40px;
            width: 120px;
            margin-right: 20px;
            border-radius: 10px 10px 10px 10px;
            font-family: Andalus;
        }
    </style>
</head>
<body onload="yanzheng()">
<h3>添加管理员</h3>
<form:form method="POST" modelAttribute="manager" >
<div id="container">
    <form:input type="hidden" path="id" id="id" />
    <table border="0">
        <tr>
            <td align="left"><a href="<c:url value='/home' />">首页</a></td>
        </tr>

        <tr>
            <td>用户名：</td>
            <td><form:input path="username" class="input"  id="username" placeholder="请输入用户名"/></td>
            <td><form:errors path="username" cssClass="error"/></td>

        </tr>
        <tr>
            <td>密码：</td>
             <td><form:input path="password" class="input" type="password" id="password" placeholder="请输入密码"/></td>
             <td><form:errors path="password" cssClass="error"/></td>


        </tr>
        <tr>
            <td>身份：</td>
            <td><form:radiobutton path="status" id="status" value="staffManager"/>客服管理员
            <form:radiobutton path="status" id="status" value="jobManager"/>就业管理员<form:radiobutton path="status" id="status" value="newsManager"/>新闻管理员</td>

        </tr>
        <tr>
            <td></td><td align="right"><input type="submit" class="button" value="确定" onclick="sendLoginData()"></td>
        </tr>
    </table>
    <br/>
    </form:form>
</div>
<script>
function sendLoginData() {
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
if (username == "") {
alert("用户名不能为空！");
return;
}
if (password == "") {
alert("密码不能为空！");
return; }

else {
    alert("注册成功！");

}

}
</script>
<script>
    function yanzheng()
    {
        <%
   if(session.getAttribute("status")==null)
        {
            System.out.println("你未登陆，请先登陆！");%>
        alert("您未登陆，请先登陆！");

        <%
              response.sendRedirect("login.jsp");  }%>


    }
</script>
</body>
</html>

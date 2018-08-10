<%--
  Created by IntelliJ IDEA.
  User: SYL
  Date: 2017/8/23
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户反馈</title>

    <style>
        table tr td {
            text-overflow: ellipsis; /* for IE */
            -moz-text-overflow: ellipsis; /* for Firefox,mozilla */
            overflow: hidden;
            white-space: nowrap;
            text-align: left;
            height:50px;
        }
        h3{
            text-align:center;
        }
        td
        {
            text-align: center;
            height:50px;
        }
        body
        {
            font-family:Verdana; margin:0 auto;
        }
        #container
        {
            margin: 0 auto;
            width:700px;
            background-color: #FAFAFA;
            border: 13px solid #A5D6A7;
            padding: 25px;

        }
    </style>

</head>


<body onload="yanzheng()">
<h3 >用户反馈列表</h3>
<div id="container">
    <table >
        <tr>
            <td ><a href="<c:url value='/home' />">首页</a></td>
        </tr>
        <tr align="left">
            <td width="17%">日期</td> <td width="50%">反馈标题</td><td width="28%">用户名</td>
        </tr>
        <c:forEach items="${adviceList}" var="advice" >
            <tr>
                <td>${advice.submitDate}</td>
                <td>${advice.title}</td>
                <td>${advice.userId}</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><a href="<c:url value='/advice/${advice.id}'/>">查看</a></td>
                    <%--<td><a href="<c:url value='/deleteuser/${user.id}'/>">删除</a></td>--%>
            </tr>
        </c:forEach>
    </table>
    <br/>


</div>
<script>
    function yanzheng()
    {
        <%
   if(session.getAttribute("status")==null)
        {
            System.out.println("你未登陆，请先登陆！");%>
        alert("您未登陆，请先登陆！");
        window.location.href="login.jsp";

        <%
               }%>


    }
</script>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: SYL
  Date: 2017/7/15
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客服列表</title>

    <style>

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
            width:600px;
            background-color: #FAFAFA;
            border: 13px solid #A5D6A7;
            padding: 25px;

        }
        .button {

            float: right;

            font-size: 15px;
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
            font-size: 17px;
            height: 40px;
            width: 120px;
            margin-right: 20px;
            border-radius: 10px 10px 10px 10px;
            font-family: Andalus;
        }

    </style>

</head>


<body onload="yanzheng()">
<h3 >客服列表</h3>
<div id="container">
<table>
    <tr>
        <td align="left"><a href="<c:url value='/home' />">首页</a></td>
    </tr>
    <tr >
        <td>客服编号</td><td>姓名</td><td width="10%">性别</td><td>手机号</td><td>服务类别</td><td>在线状态</td>
    </tr>
    <c:forEach items="${staffs}" var="staff" >
        <tr>
            <td>${staff.id}&nbsp;&nbsp;</td>
            <td>${staff.nickname}&nbsp;&nbsp;</td>
            <td> <c:choose>
                <c:when test="${staff.gender==1}">男</c:when>
                <c:when test="${staff.gender==2}">女</c:when>
            </c:choose></td>
            <td>${staff.phone}&nbsp;&nbsp;</td>
            <td>${staff.industry}&nbsp;&nbsp;</td>
            <td> <c:choose>
                <c:when test="${staff.online==1}">在线</c:when>
                <c:when test="${staff.online==0}">离线</c:when>
            </c:choose></td>
            <td><a href="<c:url value='/edit-${staff.id}-staff' />" >编辑</a></td>
            <td><a href="<c:url value='/delete-${staff.phone}-staff' />" onclick="javascript:if(confirm('确定要删除此客服信息吗？')){return true;}return false;">删除</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/new' />"><input type="button" class="button" value="添加新客服"></a>
    <br/><br/>



</div>
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

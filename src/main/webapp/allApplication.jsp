<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.shouyubang.web.service.AccountService" %>
<%@ page import="com.shouyubang.web.model.Application" %>
<%@ page import="com.shouyubang.web.service.ApplicationService" %><%--
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
    <title>职位列表</title>

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
            width:720px;
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
<h3 >职位申请列表</h3>
<div id="container">
    <table >
        <tr align="left">
            <td>申请编号</td><td width="25%">申请人编号</td><td width="20%">职位名称</td><td width="20%">申请时间</td><td>申请状态</td>
        </tr>

        <c:forEach items="${applications}" var="application" >
            <tr>
                <td>${application.id}</td>
                <td>${application.userId}</td>
                <td>${application.jobTitle}</td>
                <td>${application.applyDate}</td>
                <td>${application.process}</td>
                <td><a href="<c:url value='/userInfo/${application.userId}'/>">查看简历</a></td>
                <td><a href="<c:url value='/applicationCheck/job${application.jobId}/${application.id}'/>">审核</a></td>

            </tr>
        </c:forEach>
    </table>

    <div >
        <a href="<c:url value='/joblist' />">  <input type="button" class="button"  value="返回"> </a>
    </div>
    <br>
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

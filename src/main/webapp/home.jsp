<%--
  Created by IntelliJ IDEA.
  User: SYL
  Date: 2017/8/24
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>手语帮管理系统</title>
    <style>
        table{
            table-layout: fixed;
            width: 100%;
        }
        a{
            font-size: 21px;
            text-decoration:none;
        }
        a:hover {
            float:inherit;
            /*background-color: #A5D6A7;*/
            font-size: 26px;
            height: 40px;
            margin-right: 20px;
            border-radius: 10px 10px 10px 10px;
        }
        td{
            width:300px;
            height:100px;
            text-align: center;
            font-size: larger;
        }
        h2{
            text-align: center;
        }
        body
        {
            margin:0 auto;
        }
        #container
        {
            margin: 0 auto;
            width:600px;
            background-color: #FAFAFA;
            border: 13px solid #A5D6A7;
            padding: 25px;

        }
    </style>
</head>
<body onload="yanzheng()">
<h2>手语帮管理系统</h2>
<div id="container">
    <table >
        <tr>
            <td><a onclick="return status1()" href="<c:url value='/list' />">客服信息管理</a></td>
            <td> <a onclick="return status2()" href="<c:url value='/userlist' />">用户信息管理</a></td>

        </tr>

        <tr>
            <td><a onclick="return status3()" href="<c:url value='/joblist' />">企业职位管理</a></td>
            <td> <a onclick="return status4()" href="<c:url value='/newsList' />">新闻资讯管理</a></td>

        </tr>
        <tr>
            <td> <a onclick="return status5()" href="<c:url value='/managernew' />">添加管理员</a></td>
            <td><a onclick="return status6()" href="<c:url value='/adviceList' />">用户反馈管理</a></td>
        </tr>

    </table>


</div>
</body>
<script>
    function yanzheng()
    {
        <%
   if(session.getAttribute("status")==null)
        {
            System.out.println("您未登陆，请先登陆！");%>
        alert("您未登陆，请先登陆！");
        <jsp:forward page="/"/>
        <%
               response.sendRedirect("login.jsp");  }%>


    }
</script>
<script>
    function status1()
    {
        <% if(session.getAttribute("status").equals("jobManager") || session.getAttribute("status").equals("newsManager" )) { %>
        alert("您无此权限！");  return false; <%  }%>
    }
        function status2()
        {
            <% if(session.getAttribute("status").equals("jobManager") || session.getAttribute("status").equals("newsManager" )||  session.getAttribute("status").equals("staffManager" )) { %>
            alert("您无此权限！");  return false;<%  }%>

        }
        function status3()
        {
            <% if(session.getAttribute("status").equals("staffManager") || session.getAttribute("status").equals("newsManager" )) { %>
            alert("您无此权限！");  return false;<%  }%>

        }
        function status4()
        {
            <% if(session.getAttribute("status").equals("jobManager") || session.getAttribute("status").equals("staffManager" )) { %>
            alert("您无此权限！");  return false;<%  }%>

        }
        function status5()
        {
            <% if(session.getAttribute("status").equals("jobManager") || session.getAttribute("status").equals("newsManager" ) || session.getAttribute("status").equals("staffManager" )) { %>
            alert("您无此权限！");  return false;<%  }%>

        }
        function status6()
        {
            <% if(session.getAttribute("status").equals("jobManager") || session.getAttribute("status").equals("newsManager" ) || session.getAttribute("status").equals("staffManager" )) { %>
            alert("您无此权限！");  return false;<%  }%>

        }
</script>
</html>

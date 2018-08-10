<%--
  Created by IntelliJ IDEA.
  User: SYL
  Date: 2017/8/18
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>反馈详情</title>
    <style>

        .input2 {
            border: 1px solid #ffd800;
            font-family: Andalus;
            font-size: 17px;
            padding-left: 15px;
        }
        h3{
            text-align:center;
        }
        td
        {
            height:50px;
            font-size: 17px;
        }
        body
        {
            margin:0 auto;
        }
        #minSalary,#maxSalary,#minAge,#maxAge
        {
            width:65px;
        }
        #container
        {
            margin: 0 auto;
            width:900px;
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
        }
        .read{
            border-style:none;
            background-color: #FAFAFA;
            height: 30px;
            font-size: 17px;
            padding-left: 15px;
            width:700px;
            text-align:center;
        }


    </style>

</head>
<body onload="yanzheng()">
<div id="container">
    <h3 align="center">反馈详情</h3>
    <form:form method="POST" modelAttribute="advice"  >

        <table >
            <tr>
                <td>日期：</td>
                <td><form:input path="submitDate" class="read"   id="submitDate" readonly="true"/></td>

            </tr>

            <tr>
                <td>用户名：</td>
                <td><form:input path="userId" class="read"   id="userId" readonly="true"/></td>

            </tr>

            <tr>
                <td>反馈标题：</td>
                <td><form:input path="title" class="read"  id="title" readonly="true" /></td>

            </tr>
            <%--<tr>--%>
                <%--<td>  <img src="" ></td>--%>
            <%--</tr>--%>
            <tr>
                <td>反馈内容：</td>
                <td><form:textarea path="content" class="input2" style="width:700px;margin-left:55px; border-style:none;" rows = "8" id="content" readonly="true" /></td>
            </tr>
        </table>
        <br><br>
        <div style="width:900px; border:1px solid black;"></div>
        <br><br>
            <table>
            <tr>
                <td>回复：</td>
                <td><form:textarea path="reply" class="input2" style="width:700px" rows = "8" id="reply" /></td>
            </tr>
                <tr>
                </tr>
            <tr>
                <td><a href="<c:url value='/adviceList' />"> <input type="button" class="button"   value="返回" /></a></td>
                <td><input type="submit" class="button"   value="提交" /></td>
            </tr>

        </table>
        <br/><br/>
    </form:form>
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

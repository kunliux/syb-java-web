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
    <title>职位信息</title>
    <style>
        .input {
            border: 1px solid #ffd800;
            height: 30px;
            font-family: Andalus;
            font-size: 17px;
            padding-left: 15px;
        }
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
<div id="container">
    <h3 align="center">简历审核</h3>
    <form:form method="POST" modelAttribute="application"  >

        <table>
            <tr>
                <td>申请号：</td>
                <td><form:input path="id" class="input" style="width:420px"  id="id" readonly="true" /></td>
            </tr>
            <tr>
                <td>申请人编号：</td>
                <td><form:input path="userId" class="input" style="width:420px" id="userId" readonly="true" /></td>
            <tr>
                <td>职位名称：</td>
                <td><form:input path="jobId" class="input" style="width:420px" id="jobId" readonly="true" /></td>

            </tr>

            <tr>
                <td>公司名称：</td>
                <td><form:input path="companyId" class="input" style="width:420px" id="companyId" readonly="true" /></td>
            </tr>
            <tr>
                <td>申请时间：</td>
                <td><form:input path="applyDate" class="input" style="width:420px" id="applyDate" readonly="true" /></td>
            </tr>
            <%--<tr>--%>
                <%--<td>就业导师编号：</td>--%>
                <%--<td><form:input path="adviserId" class="input" style="width:420px" id="applyDate"  /></td>--%>
            <%--</tr>--%>
            <tr>
                <td>申请状态：</td>
                <td><form:input path="process" class="input" style="width:420px" id="process" readonly="true" /></td>
            </tr>

            <tr>
                <td >
                  <input type="submit" class="button"   value="通过" onclick="check1()"/></a>
                </td>
                <td> <input type="submit" class="button"   value="未通过" onclick="check2()"/></td>
            </tr>

        </table>
        <br/><br/>
    </form:form>
</div>
<script >
    function sendJobData() {
        var jobTitle = document.getElementById("jobTitle").value;
        var type = document.getElementById("type").value;
        var company = document.getElementById("company").value;


        if (jobTitle == "") {
            alert("职位名称不能为空！");
            return false;
        }
        if (type == "") {
            alert("工作类型不能为空！");
            return false;
        }
        if (company == "") {
            alert("公司名称不能为空！");
            return false;
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
    function check1()
    {
        document.getElementById("process").value="已通过";


    }
    function check2()
    {
        document.getElementById("process").value="未通过";


    }

</script>
</body>
</html>

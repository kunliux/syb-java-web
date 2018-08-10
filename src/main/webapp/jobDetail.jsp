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
    <h3 align="center">企业职位信息填写</h3>
    <form:form method="POST" modelAttribute="job"  >

        <table>
            <tr>
                <td>职位名称：</td>
                <td><form:input path="jobTitle" class="input" style="width:420px"  id="jobTitle" readonly="true" placeholder="请输入职位名称"/></td>

            </tr>
            <tr>
                <td>职位类别：</td>
                <td ><form:radiobutton path="type"   id="type" value="1" disabled="true"/>服务&nbsp;
                        <form:radiobutton path="type"   id="type" value="2" disabled="true"/>生产&nbsp;
                        <form:radiobutton path="type"   id="type" value="3" disabled="true"/>技术&nbsp;
                        <form:radiobutton path="type"   id="type" value="4" disabled="true"/>教育&nbsp;
            <tr>
                <td>公司名称：</td>
                <td><form:input path="company" class="input" style="width:420px" id="company" readonly="true" placeholder="请输入公司名称"/></td>

            </tr>
            <tr>
                <td>工作城市：</td>
                <td><form:input path="city" class="input" style="width:420px" id="city" readonly="true" placeholder="请输入工作城市"/></td>
            </tr>
            <tr>
                <td>工作地区：</td>
                <td><form:input path="district" class="input" style="width:420px" id="district" readonly="true" placeholder="请输入工作地区"/></td>
            </tr>
            <tr>
                <td>工作地点：</td>
                <td><form:input path="workplace" class="input" style="width:420px" id="workplace" readonly="true" placeholder="请输入工作地点"/></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td ><form:radiobutton path="gender"   id="gender" value="3" disabled="true"/>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="gender"   id="gender" value="2" disabled="true"/>女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="gender"   id="gender" value="1" disabled="true"/>不限&nbsp;</td>
            </tr>
            <tr>
                <td>残疾类别：</td>
                <td><form:input path="disabilityType" class="input" style="width:420px" id="disabilityType" readonly="true" placeholder="请输入残疾类别"/></td>
            </tr>

            <tr>
                <td>工资水平：</td>
                <td><form:input path="minSalary" class="input" style="width:194px" id="minSalary" readonly="true" value="1350 "/>——<form:input path="maxSalary" class="input" style="width:192px" id="maxSalary" readonly="true" placeholder="最高工资 " value=""/></td>
            </tr>
            <tr>
                <td>文化程度：</td>
                <td ><form:radiobutton path="education"   id="education" value="不限" disabled="true" />不限
                    <form:radiobutton path="education"   id="education" value="小学以上" disabled="true"/>小学以上
                    <form:radiobutton path="education"   id="education" value="初中以上" disabled="true" />初中以上
                    <form:radiobutton path="education"   id="education" value="高中以上" disabled="true"/>高中以上
                    <form:radiobutton path="education"   id="education" value="大专以上" disabled="true"/>大专以上</td>
            </tr>
            <tr>
                <td>年龄要求：</td>
                <td><form:input path="minAge" class="input" style="width:194px"  id="minAge" readonly="true" value="18"/>——<form:input path="maxAge" class="input" style="width:192px" id="maxAge" readonly="true" value="65"/></td>
            </tr>
            <tr>
                <td>工作内容：</td>
                <td><form:textarea path="jobContent" class="input2" style="width:420px" rows = "3" id="jobContent" readonly="true" placeholder="请输入工作内容"/></td>
            </tr>
            <tr>
                <td>工作要求：</td>
                <td><form:textarea path="requirement" class="input2" style="width:420px" rows = "3" id="requirement" readonly="true" placeholder="请输入工作要求"/></td>
            </tr>
            <tr>
                <td>工作工休：</td>
                <td><form:textarea path="workTime" class="input2" style="width:420px" rows = "3" id="workTime" readonly="true" placeholder="请输入工作时间"/></td>
            </tr>
            <tr>
                <td>薪资待遇：</td>
                <td><form:textarea path="salary" class="input2" style="width:420px" rows = "3" id="salary" readonly="true" placeholder="请输入薪资待遇"/></td>
            </tr>
            <tr>
                <td>保险：</td>
                <td><form:textarea path="insurance" class="input2" style="width:420px" rows = "3" id="insurance" readonly="true" placeholder="请输入保险"/></td>
            </tr>
            <tr>
                <td>食宿：</td>
                <td><form:textarea path="roomBoard" class="input2" style="width:420px" rows = "3" id="roomBoard" readonly="true" placeholder="请输入食宿"/></td>
            </tr>
            <tr>
                <td>劳动合同：</td>
                <td><form:textarea path="contract" class="input2" style="width:420px" rows = "3" id="contract" readonly="true" placeholder="请输入劳动合同"/></td>
            </tr>
            <tr>
                <td>福利：</td>
                <td><form:textarea path="benefits" class="input2" style="width:420px" rows = "3" id="benefits" readonly="true" placeholder="请输入福利"/></td>
            </tr>
            <tr>
                <td>招聘人数：</td>
                <td><form:input path="amount" class="input" style="width:420px" id="number" readonly="true" placeholder="请输入招聘人数"/></td>
            </tr>
            <tr>
                <td>备注：</td>
                <td><form:textarea path="remark" class="input2" style="width:420px" rows = "3" id="remark" readonly="true" placeholder="请输入备注"/></td>
            </tr>
            <tr>
                <td >
                    <a href="<c:url value='/edit-${job.id}-job'/>"><input type="button" class="button"   value="编辑" /></a>
                </td>
                <td><a href="<c:url value='/joblist' />"> <input type="button" class="button"   value="返回" /></a></td>
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
</script>
</body>
</html>

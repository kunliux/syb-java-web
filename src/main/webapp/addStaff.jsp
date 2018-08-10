<%--
  Created by IntelliJ IDEA.
  User: SYL
  Date: 2017/7/15
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentTyp e="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客服注册</title>

    <style>
        .input {
            border: 1px solid #ffd800;
            height: 30px;
            width: 200px;
            font-family: Andalus;
            font-size: 17px;
            padding-left: 15px;
        }
        .radio {
            font-size: 17px;
            width:17px;
            height:17px
        }
        .error {
            color: #ff0000;
        }
        h3{
            text-align:center;
        }
        td
        {
            font-size: 17px;
            height:50px;
        }
        body { font-family:Verdana; margin:0 auto;}
        #container
        {
            margin: 0 auto;
            width:420px;
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
<c:choose>
    <c:when test="${edit}">
        <h3>修改客服信息</h3>
    </c:when>
    <c:otherwise>
        <h3>新增客服</h3>
    </c:otherwise>
</c:choose>


<form:form method="POST" modelAttribute="staff">
<div id="container">
    <table  >
        <%--<tr>--%>
            <%--<td align="left"><a href="<c:url value='/home' />">首页</a></td>--%>
        <%--</tr>--%>
        <tr>
            <td><label for="nickname">姓名: </label> </td>
            <td><form:input path="nickname" class="input" id="nickname" /></td>
            <td><form:errors path="nickname" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="phone">手机号: </label> </td>
            <c:choose>
                <c:when test="${edit}">
            <td><form:input path="phone" class="input" id="phone" readonly="true"/></td>
           <td><p style="color: #dd0000;font-size: 16px">不可修改</p></td>
                </c:when>
                <c:otherwise>  <td><form:input path="phone" class="input" id="phone" /></td></c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td><label for="gender">性别: </label> </td>
            <td ><form:radiobutton path="gender" class="radio"  id="gender" value="1" />男&nbsp;
                <form:radiobutton path="gender" class="radio"  id="gender" value="2" />女&nbsp;</td>
            <td><form:errors path="gender" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="industry">服务类别: </label> </td>
            <td><form:input path="industry" class="input" id="industry"/></td>
        </tr>
            <c:choose>
            <c:when test="${edit}">
            <tr>
            <td><label for="online">在线状态: </label> </td>
                <td ><form:radiobutton path="online" class="radio"  id="online" value="0" />离线&nbsp;
                    <form:radiobutton path="online" class="radio"  id="online" value="1" />在线&nbsp;</td>
        </tr>
            </c:when>
            </c:choose>


        <tr>

                <c:choose>
                    <c:when test="${edit}">
                    <td>  <input type="submit" class="button" value="修改" onclick="return sendLoginData()" /> </td>
                        <td> <a href="<c:url value='/list' />">  <input type="button" class="button"  value="返回"> </a> </td>
                    </c:when>
                    <c:otherwise>
                        <td><input type="submit" class="button" value="添加" onclick="return sendLoginData()" /></td>
                        <td> <a href="<c:url value='/list' />">  <input type="button" class="button"  value="返回"> </a> </td>
                    </c:otherwise>
                </c:choose>
        </tr>
    </table>
</form:form>
    <br/>
</div>
<script type="text/javascript">

    //回车键按下时执行 Login
    <%--$("body").keydown(function (e) {--%>
        <%--e = e || event;--%>
        <%--if (e.keyCode == 13) {--%>
            <%--sendLoginData();--%>
        <%--}--%>
    <%--})--%>

    //按下 Login 按钮
    function sendLoginData() {
        var phone = document.getElementById("phone").value;
        var nickname = document.getElementById("nickname").value;
        var gender = document.getElementById("gender").value;



        if (nickname == "") {
            alert("姓名不能为空！");
            return false;
        }
        if (phone == "") {
            alert("手机号不能为空！");
            return false;
        }
//        if (phone.length !=14) {
//            alert("手机号格式有误！");
//            return false;
//        }

        if (gender == "") {
            alert("性别不能为空！");
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

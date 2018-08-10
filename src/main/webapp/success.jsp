<%--
  Created by IntelliJ IDEA.
  User: SYL
  Date: 2017/7/15
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加成功</title>
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
<div id="container">
<body>

 ${success}

<br/>
<br/>
 <c:choose>
 <c:when test="${staff}">
 <a href="<c:url value='/list' />"><input type="button" class="button" value="返回客服列表"></a>
 </c:when>
 <c:when test="${news}">
 <a href="<c:url value='/newsList' />"><input type="button" class="button" value="返回新闻列表"></a>
 </c:when>
 <c:when test="${job}">
 <a href="<c:url value='/joblist' />"><input type="button" class="button" value="返回职位列表"></a>
 </c:when>
 <c:when test="${advice}">
 <a href="<c:url value='/adviceList' />"><input type="button" class="button" value="返回反馈列表"></a>
 </c:when>
 </c:choose>
 <br> <br>
</div>
</body>

</html>
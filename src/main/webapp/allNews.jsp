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
    <title>新闻列表</title>

    <style>
        table {
            table-layout: fixed;
            width: 100%;
            border:0px;
            margin: 0px;

        }
        h3{
            text-align:center;
        }
        td{
            text-align: center;
            height:50px;
        }
        .td1
        {
            text-align: left;
            height:50px;
        }
        body
        {  margin:0 auto;
        }
        #container
        {
            margin: 0 auto;
            width:600px;
            background-color: #FAFAFA;
            border: 13px solid #A5D6A7;
            padding: 25px;
            height: 950px;
            position: relative;
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
          #t{
               top:950px;
             position: absolute;
           }
        #add{
            top:900px;
            right:0;
            position: absolute;
        }
    </style>

</head>


<body onload="yanzheng()">


<%
    int count=0; //总行数
int page_count=0;  //开始条数
int page_total=1;  //，总页码
int page_current= 1;  //首页
int page_size=15;//一页的行数
 String page_cu = request.getParameter("page_current");

    if(page_cu==null){
        page_cu="0";
    }
    page_current = Integer.parseInt(page_cu);
    if(page_current<0){
        page_current = 1;
    }
    page_count=page_count+ page_current*page_size;

%>
<h3 >新闻列表</h3>
<div id="container">
    <table >
        <tr>
            <td width="10%"><a href="<c:url value='/home' />">首页</a></td><td width="70%"></td><td width="10%"></td><td width="10%"></td>
        </tr>
        <tr align="left">
            <td >编号</td> <td>标题</td><td></td>
        </tr>
        <c:forEach items="${newsList}" var="news" begin="<%=page_count%>"  end="<%=page_size+page_count-1%>">
            <tr>
                <td class="td1">${news.id}</td>
                <td class="td1">${news.topic}</td>
                <td><a href="<c:url value='/edit-${news.id}-news'/>">详情</a></td>
                    <td><a href="<c:url value='/deleteNews/${news.id}'/>">删除</a></td>
                <% count++; %>
            </tr>
        </c:forEach>
    </table>
    <div  id="add">
        <a href="<c:url value='/news' />"><input type="button" class="button"  value="添加新闻" ></a>
    </div>
    <br/>


        <p id="main-content">
        </p>
        <table id="t">
    <tr>
        <td colspan="2" align="right"> 本页总共<%=count%>条   &nbsp; &nbsp; &nbsp; &nbsp; 总共${newsList.size()}条</td>
        <%--<%--%>
        <%--page_total = ((newsSize)%20==0)?((newsSize)/20):((newsSize)/20+1);--%>

        <%--%>--%>
        <td colspan="2" align="center">

            <a href = "?page_current=0" >首页</a>
            <a href = "?page_current=<%=page_current-1%>" onclick="return news1()">上一页</a>
            <a href = "?page_current=<%=page_current+1%>" onclick="return news2()">下一页</a>
            <%--<a href = "?page_current=<%=page_total%>" >尾页</a>--%>
            第<%=page_current+1%> 页
            <%--/共     <%=page_total%>页--%>
        </td>
    </tr>

</table>



</div>
<script>
    function news1()
    {
        <% if(page_current==0) { %>
         return false;
        <%  }%>
    }
    function news2()
    {
        <% if(count<15) { %>
        return false;
        <%  }%>
    }





</script>
</body>
</html>


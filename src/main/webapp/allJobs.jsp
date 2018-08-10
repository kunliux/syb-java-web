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
    <title>职位列表</title>

    <style>


        h3{
            text-align:center;
        }
        .mytable {
            table-layout: fixed;
            width: 100%;
            border:0px;
            margin: 0px;
        }

        .mytable tr td {
            text-overflow: ellipsis; /* for IE */
            -moz-text-overflow: ellipsis; /* for Firefox,mozilla */
            overflow: hidden;
            white-space: nowrap;
            text-align: left;
            height:50px;
        }
        body
        {
            font-family:Verdana; margin:0 auto;
        }
        #container
        {
            margin: 0 auto;
            width:820px;
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
        #t  {
            top:950px;
            position: absolute;
            text-align: center;
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
    int page_current=0;  //首页
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
<h3 >职位列表</h3>
<div id="container">
    <table class="mytable" width="800px">

        <tr align="left">
            <td width="10%"><a href="<c:url value='/home' />">首页</a></td> <td width="15%"></td><td width="35%"></td><td width="20%"></td><td width="5%"></td><td width="5%"></td><td width="10%"> </td>
        </tr>
        <tr align="left">
           <td width="10%">职位编号</td> <td width="15%">职位名称</td><td width="35%">公司名称</td><td width="20%">工作地点</td><td width="5%"></td><td width="5%"></td><td width="10%"> </td>
        </tr>
        <c:forEach items="${jobs}" var="job" begin="<%=page_count%>"  end="<%=page_size+page_count-1%>">
            <tr>
                <td width="10%">${job.id}</td>
                <td width="15%">${job.jobTitle}</td>
                <td width="35%">${job.company}</td>
                <td width="20%" >${job.workplace}</td>
                <td width="5%"><a href="<c:url value='/jobDetail/${job.id}'/>">详情</a></td>
                <td width="5%"><a href="<c:url value='/deletejob/${job.id}'/>" onclick="javascript:if(confirm('确定要删除该条记录吗？')){return true;}return false;">删除</a></td>
                <td width="10%"><a href="<c:url value='/application/${job.id}'/>">申请信息</a></td>
                <% count++; %>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <div id="add">
    <a href="<c:url value='/jobnew' />"><input type="button" class="button"  value="添加新职位信息" ></a>
    </div>
    <br/><br/>
    <table id="t">
        <tr>
            <td colspan="2" align="right"> 本页总共<%=count%>条   &nbsp; &nbsp; &nbsp; &nbsp; 总共${jobs.size()}条</td>
            <%--<%--%>
            <%--page_total = ((newsList.size())%20==0)?((newsList.size())/20):((newsList.size())/20+1);--%>

            <%--%>--%>
            <td colspan="2" align="center">

                <a href = "?page_current=1" >首页</a>
                <a href = "?page_current=<%=page_current-1%>" onclick="return job1()">上一页</a>
                <a href = "?page_current=<%=page_current+1%>" onclick="return job2()" >下一页</a>
                <%--<a href = "?page_current=<%=page_total%>" >尾页</a>--%>
                第<%=page_current+1%> 页
                <%--/共     <%=page_total%>页--%>
            </td>
        </tr>

    </table>
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

    function job1()
    {
        <% if(page_current==0) { %>
        return false;
        <%  }%>
    }
    function job2()
    {
        <% if(count<15) { %>
        return false;
        <%  }%>
    }



</script>
</body>
</html>

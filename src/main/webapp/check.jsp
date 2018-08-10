<%@ page language="java" import="java.sql.*" contentType="text/html;charset=utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/views/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'check.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String users=request.getParameter("username");
    String pass=request.getParameter("password");
    String status=request.getParameter("status");
     session.setAttribute("status",status);
    int t=0;
    PreparedStatement sql=null;
    ResultSet rs=null;
    Connection conn=null;
%>

<%
    String driver = "com.mysql.jdbc.Driver";
//    String url = "jdbc:mysql://localhost:3306/sybang";
    String url = "jdbc:mysql://localhost:3306/shouyubang";
    String user = "syliu";
    String password = "951001";
    Class.forName(driver);
    conn= DriverManager.getConnection(url,user,password);
    sql =conn.prepareStatement("select * from manager where username=? and password=? and status=?");
    sql.setString(1,users);
    sql.setString(2,pass);
    sql.setString(3,status);

    rs=sql.executeQuery();
    if ( rs.next()) {
        t=1;
        }

    rs.close();
    sql.close();
    conn.close();
%>
<!-- 判断是否是正确的登录用户 -->
<% if (t==1 && status.equals("superManager")){ %>
<jsp:forward page="/home.jsp"/>
<%}
else
if (t==1 && status.equals("staffManager")){
%>
<jsp:forward page="/home.jsp"/>
<%}
else
if (t==1 && status.equals("jobManager")){
%>
<jsp:forward page="/home.jsp"/>
<%}
else
if (t==1 && status.equals("newsManager")){
%>
<jsp:forward page="/home.jsp"/>
<%}
else
if (t==0){
%>
<jsp:forward page="/login_fail.jsp"/>
<%} %>
</body>
</html>
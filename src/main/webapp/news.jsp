<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"--%>
<%--"http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
    <title>新闻编辑页</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
        .button {
            float:right;
            margin-right: 40px;
            display: inline-block;
            zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
            *display: inline;
            vertical-align: baseline;
            /*margin: 0 2px;*/
            outline: none;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            font: 15px/100% Arial, Helvetica, sans-serif;
            padding: .5em 2em .55em;
            text-shadow: 0 1px 1px rgba(0,0,0,.3);
            -webkit-border-radius: .5em;
            -moz-border-radius: .5em;
            border-radius: .5em;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
            box-shadow: 0 1px 2px rgba(0,0,0,.2);
        }
        .button:hover {
            text-decoration: none;
        }
        .button:active {
            position: relative;
            top: 1px;
        }
        .blue {
            color: #d9eef7;
            border: solid 1px #0076a3;
            background: #0095cd;
            background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
            background: -moz-linear-gradient(top, #00adee, #0078a5);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee', endColorstr='#0078a5');
        }
        .blue:hover {
            background: #007ead;
            background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
            background: -moz-linear-gradient(top, #0095cc, #00678e);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0095cc', endColorstr='#00678e');
        }
        .blue:active {
            color: #80bed6;
            background: -webkit-gradient(linear, left top, left bottom, from(#0078a5), to(#00adee));
            background: -moz-linear-gradient(top, #0078a5, #00adee);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0078a5', endColorstr='#00adee');
        }
        #container
        {
            margin: 0 auto;
            width:1100px;
            /*background-color: #FAFAFA;*/
            border: 1px ;
            padding: 25px;

        }
        td
        {
            font-size: 17px;
            height:50px;

        }
        .input {
            border: 1px solid #ffd800;
            height: 40px;
            width: 600px;
            font-family: Andalus;
            font-size: 17px;
            padding-left: 15px;
        }
        #editor{
            width: 1024px;height:500px; margin-left:auto; margin-right:auto;
        }
        .a1{
            margin-left: 40px;

        }
        label{
            margin-left:20px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div>
<form:form method="POST" modelAttribute="news">
    <h3 align="center">新闻编辑</h3>
    <div id="container">

        <a class="a1" href="<c:url value='/newsList' />">返回</a>
        <button type="submit" class="button blue" onclick="javascript:this.form.action='/guanli/news';javascript:this.form.target='_self';">提交</button>
        <button type="submit" class="button blue" onclick="javascript:this.form.action='newsView.jsp';javascript:this.form.target='_blank';">预览</button><br>

        <br>
            <label width="80px"><label for="topic">标题: </label>
            <form:input path="topic" class="input" id ="topic" name="topic" placeholder="请输入标题"  />

                <br>
        <br>
    <script id="editor" path="body" type="text/plain" name="body"  ></script>


            </div>
            </form:form>
    </div>
        <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    </script>
        <script>
            function check() {
                var body = document.getElementById("body").value;
                if (body == "") {
                    alert("内容不能为空！");
                    return false;
                }

            }
        </script>
</body>
</html>

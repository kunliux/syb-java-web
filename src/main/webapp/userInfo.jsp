<%--
  Created by IntelliJ IDEA.
  User: SYL
  Date: 2017/8/30
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>用户详细信息</title>
    <link rel="stylesheet" href="../../style/weui.css"/>

    <style>
        .radio{
            font-size: 15px;
        }


        .weui-btn-area{
            margin:1.17647059em 15px 0.3em;
        }

        .page,body{background-color:#f8f8f8}

        .weui-cell_warn .weui-textarea-counter{
            color:#E64340;
        }
        html{
            -ms-text-size-adjust:100%;
            -webkit-text-size-adjust:100%;
        }
        body{
            line-height:1.6;
            font-family:-apple-system-font, "Helvetica Neue", sans-serif;
        }

        .weui-cells{
            margin-top:1.17647059em;
            background-color:#FFFFFF;
            line-height:1.47058824;
            font-size:17px;
            overflow:hidden;
            position:relative;
        }
        .weui-cells:before{
            content:" ";
            position:absolute;
            left:0;
            top:0;
            right:0;
            height:1px;
            border-top:1px solid #e5e5e5;
            color:#e5e5e5;
            -webkit-transform-origin:0 0;
            transform-origin:0 0;
            -webkit-transform:scaleY(0.5);
            transform:scaleY(0.5);
            z-index:2;
        }
        .weui-cells:after{
            content:" ";
            position:absolute;
            left:0;
            bottom:0;
            right:0;
            height:1px;
            border-bottom:1px solid #e5e5e5;
            color:#e5e5e5;
            -webkit-transform-origin:0 100%;
            transform-origin:0 100%;
            -webkit-transform:scaleY(0.5);
            transform:scaleY(0.5);
            z-index:2;
        }
        .weui-cells__title{
            margin-top:.77em;
            margin-bottom:.3em;
            padding-left:15px;
            padding-right:15px;
            color:#999999;
            font-size:14px;
        }
        .weui-cells__title + .weui-cells{
            margin-top:0;
        }
        .weui-cell{
            padding:10px 15px;
            position:relative;
            display:-webkit-box;
            display:-webkit-flex;
            display:flex;
            -webkit-box-align:center;
            -webkit-align-items:center;
            align-items:center;
        }
        .weui-cell:before{
            content:" ";
            position:absolute;
            left:0;
            top:0;
            right:0;
            height:1px;
            border-top:1px solid #e5e5e5;
            color:#e5e5e5;
            -webkit-transform-origin:0 0;
            transform-origin:0 0;
            -webkit-transform:scaleY(0.5);
            transform:scaleY(0.5);
            left:15px;
            z-index:2;
        }
        .weui-cell:first-child:before{
            display:none;
        }

        .weui-cell__bd{
            -webkit-box-flex:1;
            -webkit-flex:1;
            flex:1;
        }


        .weui-cell_swiped > .weui-cell__bd{
            position:relative;
            z-index:1;
            background-color:#FFFFFF;
        }
        .weui-cell_swiped > .weui-cell__ft{
            position:absolute;
            right:0;
            top:0;
            bottom:0;
            display:-webkit-box;
            display:-webkit-flex;
            display:flex;
            color:#FFFFFF;
        }

        .weui-cell_access .weui-cell__ft{
            padding-right:13px;
            position:relative;
        }
        .weui-cell_access .weui-cell__ft:after{
            content:" ";
            display:inline-block;
            height:6px;
            width:6px;
            border-width:2px 2px 0 0;
            border-color:#C8C8CD;
            border-style:solid;
            -webkit-transform:matrix(0.71, 0.71, -0.71, 0.71, 0, 0);
            transform:matrix(0.71, 0.71, -0.71, 0.71, 0, 0);
            position:relative;
            top:-2px;
            position:absolute;
            top:50%;
            margin-top:-4px;
            right:2px;
        }

        .weui-cells_radio .weui-cell__ft{
            padding-left:0.35em;
        }
        .weui-cells_radio .weui-check:checked + .weui-icon-checked:before{
            display:block;
            content:'\EA08';
            color:#09BB07;
            font-size:16px;
        }
        .weui-cells_checkbox .weui-cell__hd{
            padding-right:0.35em;
        }
        .weui-cells_checkbox .weui-icon-checked:before{
            content:'\EA01';
            color:#C9C9C9;
            font-size:23px;
            display:block;
        }
        .weui-cells_checkbox .weui-check:checked + .weui-icon-checked:before{
            content:'\EA06';
            color:#09BB07;
        }
        .weui-label{
            display:block;
            width:105px;
            font-size: 15px;
            word-wrap:break-word;
            word-break:break-all;
        }
        .weui-input{
            width:100%;
            border:0;
            outline:0;
            -webkit-appearance:none;
            background-color:transparent;
            font-size:15px;
            color:inherit;
            height:1.47058824em;
            line-height:1.47058824;
        }
        .weui-input::-webkit-outer-spin-button,
        .weui-input::-webkit-inner-spin-button{
            -webkit-appearance:none;
            margin:0;
        }
        .weui-textarea{
            display:block;
            border:0;
            resize:none;
            width:100%;
            color:inherit;
            font-size:1em;
            line-height:inherit;
            outline:0;
        }

        .weui-cell_warn .weui-textarea-counter{
            color:#E64340;
        }

        .weui-cells_form .weui-cell__ft{
            font-size:0;
        }
        .weui-cells_form .weui-icon-warn{
            display:none;
        }
        .weui-cells_form input,
        .weui-cells_form textarea,
        .weui-cells_form label[for]{
            -webkit-tap-highlight-color:rgba(0, 0, 0, 0);
        }



        .weui-form-preview__hd .weui-form-preview__value{
            font-style:normal;
            font-size:1.6em;
        }

        .weui-cell_vcode{
            height: 30px;
            padding-top:0;
            padding-right:0;
            padding-bottom:0;
        }
        .weui-cell_vcode2{
            padding-top:0;
            padding-right:0;
            padding-bottom:0;
        }
        .button {

            float: right;
            font-size: 20px;
            height:35px;
            width: 80px;
            margin-right: 1px;
            border-radius: 10px 10px 10px 10px;
            font-family: Andalus;
        }
        .button:hover {
        color: white;
        float: right;
        background-color: #808080;
        font-size: 22px;
        height: 40px;
        width: 80px;
        margin-right: 20px;
        border-radius: 10px 10px 10px 10px;
        font-family: Andalus;
        }
    </style>
</head>

<body onload="yanzheng()">

<div class="page">
    <div class="page__hd">
        <h3 align="center">详细信息</h3>
    </div>
    <div class="page__bd">
        <form:form method="POST" modelAttribute="user" >
        <div class="weui-cells__title">关于你，我们想了解多一点</div>
        <div class="weui-cells weui-cells_form">

                <%--<div class="weui-cell weui-cell_vcode">--%>
                <%--<div class="weui-cell__hd">--%>
                <%--<label class="weui-label">头像</label>--%>
                <%--</div>--%>
                <%--<div class="weui-cell__bd">--%>
                <%--<form:textarea path="avatarUrl" id="avatarUrl" class="weui-input" />--%>
                <%--</div>--%>
                <%--</div>--%>

            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">姓名</label>
                </div>
                <div class="weui-cell__bd">
                    <form:input path="nickname" id="nickname" class="weui-input" readonly="true"/>
                </div>

            </div>
            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label for="" class="weui-label">性别</label>
                </div>
                <div class="weui-cell__bd">
                    <form:radiobutton path="gender" id="gender"  value="1" disabled="true"/>男&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="gender" id="gender"  value="2" disabled="true"/>女&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="gender" id="gender"  value="0" disabled="true"/>其他

                </div>
            </div>
            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">民族</label>
                </div>
                <div class="weui-cell__bd">
                    <form:input path="nationality" id="nationality" class="weui-input" readonly="true"/>
                </div>

            </div>
            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">籍贯</label>
                </div>
                <div class="weui-cell__bd">
                    <form:input path="nativePlace" id="nativePlace" class="weui-input" readonly="true"/>
                </div>

            </div>


            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">手机号</label>
                </div>
                <div class="weui-cell__bd">
                    <form:input path="phone"  id="phone" class="weui-input"  readonly="true"/>
                </div>

            </div>

            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">联系人电话</label>
                </div>
                <div class="weui-cell__bd">
                    <form:input path="emergencyContact" id="emergencyContact" class="weui-input"  readonly="true"/>
                </div>

            </div>


            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">身份证号</label>
                </div>
                <div class="weui-cell__bd">
                    <form:input path="idNumber" id="idNumber" class="weui-input" readonly="true"/>
                </div>
            </div>

            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">残疾证号</label>
                </div>
                <div class="weui-cell__bd">
                    <form:input path="disabilityNumber" id="disabilityNumber" class="weui-input" readonly="true"/>
                </div>
            </div>

        </div>
    </div>


    <div class="weui-cells__title">你现在的状态</div>
    <div class="weui-cells weui-cells_form">

        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label class="weui-label">阅读能力</label>
            </div>
            <div class="weui-cell__bd">
                <form:radiobutton path="readingLevel" id="readingLevel" class="radio" value="3" disabled="true"/>好&nbsp;&nbsp;&nbsp;
                <form:radiobutton path="readingLevel" id="readingLevel" class="radio" value="2" disabled="true"/>中&nbsp;&nbsp;&nbsp;
                <form:radiobutton path="readingLevel" id="readingLevel" class="radio" value="1" disabled="true"/>差
            </div>

        </div>

        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label class="weui-label">写字能力</label>
            </div>
            <div class="weui-cell__bd">
                <form:radiobutton path="writingLevel" id="writingLevel" class="radio"  value="3" disabled="true"/>好&nbsp;&nbsp;&nbsp;
                <form:radiobutton path="writingLevel" id="writingLevel" class="radio" value="2" disabled="true"/>中&nbsp;&nbsp;&nbsp;
                <form:radiobutton path="writingLevel" id="writingLevel" class="radio" value="1" disabled="true"/>差
            </div>

        </div>



        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label for="" class="weui-label">有无保险</label>
            </div>
            <div class="weui-cell__bd">
                <form:radiobutton path="insurance" id="insurance" class="radio" value="1" disabled="true"/>有&nbsp;&nbsp;&nbsp;
                <form:radiobutton path="insurance" id="insurance" class="radio" value="0" disabled="true"/>无
            </div>
        </div>


        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label class="weui-label">所在城市</label>
            </div>
            <div class="weui-cell__bd">
                <form:input path="city" id="city" class="weui-input" readonly="true"/>
            </div>

        </div>

        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label class="weui-label">常住地址</label>
            </div>
            <div class="weui-cell__bd">
                <form:input path="address" id="address" class="weui-input" readonly="true"/>
            </div>

        </div>
        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label class="weui-label">最高学历</label>
            </div>
            <div class="weui-cell__bd">
                <form:input path="education" id="education" class="weui-input" readonly="true"/>
            </div>

        </div>
        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label class="weui-label">毕业院校</label>
            </div>
            <div class="weui-cell__bd">
                <form:input path="academy" id="academy" class="weui-input" readonly="true"/>
            </div>

        </div>


        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cells__hd">
                <label for="" class="weui-label">特长</label>
            </div>
            <div class="weui-cell__bd">
                <form:input path="speciality" id="speciality" class="weui-input" readonly="true"/>
            </div>
        </div>

        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label class="weui-label">兴趣爱好</label>
            </div>
            <div class="weui-cell__bd">
                <form:input path="interests" id="interests" class="weui-input" readonly="true"/>
            </div>

        </div>
    </div>

    <div class="weui-cells__title">你的职业规划</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label class="weui-label">期望职位</label>
            </div>
            <div class="weui-cell__bd">
                <form:input path="position" id="position" class="weui-input" readonly="true"/>
            </div>

        </div>
        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd">
                <label for="" class="weui-label">期望工资</label>
            </div>
            <div class="weui-cell__bd">
                <form:input path="salary" id="salary" class="weui-input" readonly="true"/>
            </div>
        </div>

        <div class="weui-cell weui-cell_vcode2">
            <div class="weui-cell__hd">
                <label class="weui-label">工作经历</label>
            </div>
            <div class="weui-cell__bd">
                <form:textarea path="experience" id="experience" class="weui-textarea" rows="3" readonly="true"/>
            </div>

        </div>

        <div class="weui-cell weui-cell_vcode2">
            <div class="weui-cell__hd">
                <label class="weui-label">个人介绍</label>
            </div>
            <div class="weui-cell__bd">
                <form:textarea path="introduction" id="introduction" class="weui-textarea" rows="3" readonly="true"/>
            </div>

        </div>
        <br>
    </div>
    <div class="weui-btn-area">
        <input type="button" class="button" onclick="history.back(-1);" value="返回">
            <%--<a href="<c:url value='/userlist' />">--%>
            <%--&lt;%&ndash;<input type="button" class="button" value="返回" align="right" size="20px" >&ndash;%&gt;--%>
            <%--</a>--%>
    </div>
    <br>
    <br>
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

<script src="../../html/zepto.min.js"></script>
<script src="../../html/SYB-web.js"></script>
</body>
</html>

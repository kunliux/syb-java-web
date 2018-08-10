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
    <title>详细信息</title>
    <link rel="stylesheet" href="../style/weui.css"/>
    <link rel="stylesheet" href="SYB-web.css"/>
</head>

<body >
<div class="weui-toptips weui-toptips_warn js_tooltips">错误提示</div>

<div class="container" id="container"></div>
<script type="text/html" id="tpl_home">
    <div class="page">
        <div class="page__hd">
            <h3 align="center">详细信息</h3>
        </div>
        <div class="page__bd">
            <form:form method="POST" modelAttribute="user" >


                <div class="weui-cells__title">关于你，我们想了解多一点</div>
                <div class="weui-cells weui-cells_form">

                    <div class="weui-cells__title">头像</div>
                    <div class="weui-cell">
                        <div class="weui-cell__bd">
                            <form:textarea path="avatarUrl" id="avatarUrl" class="weui-input" />
                        </div>
                    </div>



                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">姓名</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="nickname" id="nickname" class="weui-input" />
                        </div>

                    </div>
                    <div class="weui-cell weui-cell_select weui-cell_select-after">
                        <div class="weui-cell__hd">
                            <label for="" class="weui-label">性别</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:radiobutton path="gender" id="gender" class="weui-select" value="1" />男<form:radiobutton path="gender" id="gender" class="weui-select" value="2"/>女
                            <form:radiobutton path="gender" id="gender" class="weui-select" value="0"/>其他

                        </div>
                    </div>
                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">民族</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="nationality" id="nationality" class="weui-input" />
                        </div>

                    </div>
                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">籍贯</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="nativePlace" id="nativePlace" class="weui-input" />
                        </div>

                    </div>


                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">手机号</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="phone"  id="phone" class="weui-input"  />
                        </div>

                    </div>

                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">联系人电话</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="emergencyContact" id="emergencyContact" class="weui-input"  />
                        </div>

                    </div>


                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">身份证号</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="idNumber" id="idNumber" class="weui-input" />
                        </div>
                    </div>

                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">残疾证号</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="disabilityNumber" id="disabilityNumber" class="weui-input" />
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
                            <form:radiobutton path="readingLevel" id="readingLevel" class="weui-select" value="3" />好<form:radiobutton path="readingLevel" id="readingLevel" class="weui-select" value="2"/>中
                            <form:radiobutton path="readingLevel" id="readingLevel" class="weui-select" value="1"/>差<form:radiobutton path="readingLevel" id="readingLevel"    class="weui-select" value="0"/>
                        </div>

                    </div>

                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">写字能力</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:radiobutton path="writingLevel" id="writingLevel" class="weui-select" value="3" />好<form:radiobutton path="writingLevel" id="writingLevel" class="weui-select" value="2"/>中
                            <form:radiobutton path="writingLevel" id="writingLevel" class="weui-select" value="1"/>差 <form:radiobutton path="writingLevel" id="writingLevel" class="weui-select" value="0"/>
                        </div>

                    </div>


                    <div class="weui-cell weui-cell_select weui-cell_select-after">

                        <div class="weui-cell__hd">
                            <label for="" class="weui-label">有无保险</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:radiobutton path="insurance" id="insurance" class="weui-select" value="1"/>有
                            <form:radiobutton path="insurance" id="insurance" class="weui-select" value="0"/>无
                        </div>
                    </div>


                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">所在城市</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="city" id="city" class="weui-input" />
                        </div>

                    </div>

                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">常住地址</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="address" id="address" class="weui-input" />
                        </div>

                    </div>
                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">最高学历</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="education" id="education" class="weui-input" />
                        </div>

                    </div>
                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">毕业院校</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="academy" id="academy" class="weui-input" />
                        </div>

                    </div>


                    <div class="weui-cell">
                        <div class="weui-cells__hd">
                            <label for="" class="weui-label">特长</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:textarea path="speciality" id="speciality" class="weui-textarea" rows="3"/>
                        </div>
                    </div>

                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">兴趣爱好</label>
                        </div>
                        <div class="weui-cell__bd">
                            <input class="weui-input"  type="text"  placeholder=""/>
                            <form:input path="interests" id="interests" class="weui-input" />
                        </div>

                    </div>
                </div>

                <div class="weui-cells weui-cells_form">
                    <div class="weui-cells__title">你的职业规划</div>


                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">工作经历</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:textarea path="experience" id="experience" class="weui-textarea" rows="3"/>
                        </div>

                    </div>

                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">期望职位</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="position" id="position" class="weui-input" />
                        </div>

                    </div>
                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label for="" class="weui-label">期望工资</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:input path="salary" id="salary" class="weui-input" />
                        </div>
                    </div>


                    <div class="weui-cell weui-cell_vcode">
                        <div class="weui-cell__hd">
                            <label class="weui-label">个人介绍</label>
                        </div>
                        <div class="weui-cell__bd">
                            <form:textarea path="introduction" id="introduction" class="weui-textarea" rows="3"/>
                        </div>

                    </div>
                    <br>
                </div>
            </form:form>
            <div class="weui-btn-area">
                <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips">确定</a>
            </div>
        </div>

    </div>
</script>
<script>
    $(document).ready(function(){
        $("#btn1").click(function(){
            alert("name: " + $("#name").text());
        });

    });
</script>
<script >
    $(function(){
        var $tooltips = $('.js_tooltips');

        $('#showTooltips').on('click', function(){
            if ($tooltips.css('display') != 'none') return;

            // toptips的fixed, 如果有`animation`, `position: fixed`不生效
            $('.page.cell').removeClass('slideIn');

            $tooltips.css('display', 'block');
            setTimeout(function () {
                $tooltips.css('display', 'none');
            }, 2000);
        });
    });
</script>

<script src="zepto.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
<script src="SYB-web.js"></script>
</body>
</html>

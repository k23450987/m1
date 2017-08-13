<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>注册</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css"
          href="<%=path%>/js/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="<%=path%>/js/themes/icon.css">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="<%=path%>/js/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#username").bind('keyup', function () {

                $.post("checkUser.action", {'username': $("#username").val()}, function (result) {
                    if (result == "true") {
                        $("#spanid").empty();
                        $("#spanid").append("<font color='green'>用户名可以使用</font>");

                    } else {
                        $("#spanid").empty();
                        $("#spanid").append("<font color='red'>用户名已存在</font>");
                    }
                });
            });
        });
    </script>
</head>
<body>
<span style="color: red; ">${message }</span>
<div class="easyui-panel" title="新用户注册" align="center" style="width:400px;padding:10px 60px 20px 60px">
    <br/>
    <form action="<%=path%>/insert.action" method="post" id="f"
          onsubmit="return check();">
        <table>
            <tr>
                <td></td>
                <td><span id="spanid"></span></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input id="username" type="text" name="username" class="easyui-validatebox textbox"
                           data-options="prompt:'Enter User Name.',required:true,validType:'length[3,10]'">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" class="easyui-validatebox" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="repassword" class="easyui-validatebox" data-options="required:true">
                </td>
            </tr>
        </table>
        <br/> <input type="submit" value="注册">
    </form>
    <a href="<%=path%>/toLogin.action">已有账号？点击登录</a>
</div>
</body>
<script type="text/javascript">
    function check() {
        var user = document.getElementById("f").username.value;
        var pass = document.getElementById("f").password.value;
        var repass = document.getElementById("f").repassword.value;
        if (user == "") {
            alert("用户名不能为空!");
            return false;
        } else if (pass.length > 16 || pass.length < 6) {
            alert("密码长度应该为 6 - 16 位");
            return false;
        } else if (pass != repass) {
            alert("两次密码不一致");
            return false;
        } else {
            document.f.submit();
        }
    }
</script>
</html>

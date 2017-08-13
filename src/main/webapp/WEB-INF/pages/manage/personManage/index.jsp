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

    <title>综合管理首页</title>

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
<table border="1px" align="left">
    <tr>
        <td>部门管理</td>
        <td><a href="<%=path %>/deptList.action">进入</a></td>
    </tr>
    <tr>
        <td>岗位管理</td>
        <td><a href="<%=path %>/jobList.action">进入</a></td>
    </tr>
    <tr>
        <td>人员管理</td>
        <td><a href="<%=path %>/personList.action">进入</a></td>
    </tr>
</table>
</body>
</html>

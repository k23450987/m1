<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>欢迎您</title>

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
<div align="center">
    <c:if test="${not empty user.username}">
        <span>${user.username}  您好！<br>欢迎您<br></span>
        <a href="<%=path%>/toManage.action">前往管理页面</a>
        <a href="<%=path%>/test.jsp">2.0试用</a>
        <a href="<%=path%>/tableList.action">自由库管理</a>
    </c:if>
</div>
</body>
</html>

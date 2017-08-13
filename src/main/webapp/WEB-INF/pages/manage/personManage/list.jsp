<%@ page language="java"  pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>当前员工列表</title>

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
<jsp:include page="index.jsp" />
<a href="<%=path%>/personToAdd.action">新增人员</a>
<font color="green">${message }</font>
<form action="<%=path%>/personSearch.action" method="post">
    <table>
        <tr>
            <td><input type="text" name="p_name" value="按姓名搜索" onclick="this.value=''"/></td>
            <td><input type="submit" value="搜索"/></td>
        </tr>
    </table>
</form>
<table border="1px">

    <tr>
        <td>员工姓名</td>
        <td>员工年龄</td>
        <td>员工信息</td>
        <td>职务</td>
        <td>所属部门</td>
        <td>修改资料</td>
        <td>删除</td>
        <td>岗位管理</td>
    </tr>
    <c:forEach items="${persons }" var="p">
        <tr>
            <td>${p.name}</td>
            <td>${p.age}</td>
            <td>${p.info}</td>
            <td>${p.jobName}</td>
            <td>${p.deptName}</td>
            <td><a href="<%=path%>/personToUpdate.action?person_id=${p.id}">修改</a></td>
            <td><a href="<%=path%>/personDelete.action?person_id=${p.id}">删除</a></td>
            <td><a href="<%=path%>/personToManage.action?person_id=${p.id}">进入</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

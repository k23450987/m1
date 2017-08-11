<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新增岗位</title>

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
<jsp:include page="index.jsp"></jsp:include>
<font color="red">${message }</font>
	<form action="<%=path %>/personUpdate.action" method="post">
			<input type="hidden" name="person_id" value="${p.person_id }">
		<table border="1px" align="left">
			<tr>
				<td>员工姓名</td>
				<td><input type="text" name="p_name" value="${p.p_name }"></td>
			</tr>
			<tr>
				<td>员工年龄</td>
				<td><input type="text" name="age" value="${p.age }"></td>
			</tr>
			<tr>
				<td>员工信息</td>
				<td><textarea name="info" rows="10" cols="30" >${p.info }</textarea></td>
			</tr>
		</table>
		<input type="submit" value="修改">
	</form>
	<button onclick="history.go(-1)">取消</button>
</body>
</html>

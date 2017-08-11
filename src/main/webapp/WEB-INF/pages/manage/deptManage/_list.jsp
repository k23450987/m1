<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>当前部门列表</title>
    
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
  	<a href="<%=path %>/deptToAdd.action">新增部门</a>
  <font color="green">${message }</font>
    <table border="2px" height="50%">
    <tr>
    	<td>部门名称</td>
    	<td>父部门</td>
    	<td>修改</td>
    	<td>删除</td>
    </tr>
    <c:forEach items="${depts }" var="dept">
    	<tr>
    	<td>${dept.dept_name }</td>
    	<td>${dept.fdept_name }</td>
    	<td><a href="<%=path %>/deptToUpdate.action?dept_id=${dept.dept_id}">修改</a></td>
    	<td><a href="<%=path %>/deptDel.action?dept_id=${dept.dept_id}">删除</a></td>
    </tr>
    </c:forEach>
    </table>
  </body>
</html>

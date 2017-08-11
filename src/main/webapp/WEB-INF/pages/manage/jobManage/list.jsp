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
    
    <title>当前岗位列表</title>
    
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
  	<a href="<%=path %>/jobToAdd.action">新增岗位</a>
  	<font color="green">${message }</font>
    <table border="1px" height="50%">
    <tr>
    	<td>岗位名称</td>
    	<td>所属部门</td>
    	<td>父部门</td>
    	<td>修改</td>
    	<td>删除</td>
    </tr>
    <c:forEach items="${jobs }" var="job">
    	<tr>
    	<td>${job.job_name }</td>
    	<td>${job.dept_name }</td>
    	<td>${job.fdept_name }</td>
    	<td><a href="<%=path %>/jobToUpdate.action?job_id=${job.job_id}">修改</a></td>
    	<td><a href="<%=path %>/jobDelete.action?job_id=${job.job_id}">删除</a></td>
    </tr>
    </c:forEach>
    </table>
  </body>
</html>

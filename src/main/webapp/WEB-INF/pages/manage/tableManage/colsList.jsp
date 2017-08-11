<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>表格列</title>
    
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
  <table style="padding: 10px;width: 300px">
  	<tr>
  		<td>列名</td>
  		<td>类型</td>
  		<td>唯一</td>
  		<td>表id</td>
  	
  	</tr>
    <c:forEach items="${cols }" var="col">
    	<tr>
    	
    	<td>${col.params }<br/></td>
    	<td>${col.type }</td>
    	<td>${col.unique }</td>
    	<td>${col.tableId }</td>
    	</tr>
    
    </c:forEach>
  </table>
  <a href="<%=path%>/tableList.action">返回</a>
  </body>
</html>

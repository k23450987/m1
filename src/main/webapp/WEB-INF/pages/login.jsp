<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
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
  <font color="green">${message }</font><br/>
  <div align="center">
  	<font size="10">后台登录</font>
    <form action="<%=path%>/login.action" method="post">
	  	<table>
	    	<tr>
		    	<td>用户名</td>
		    	<td><input type="text" name="username" value="用户名" onclick="this.value=''"></td>
	    	</tr>
	    	<tr>
		    	<td>密码</td>
		    	<td><input type="password" name="password" value="anklj" onclick="this.value=''"></td>
	    	</tr>
	    </table>
	    	<br/>
	    	<input type="submit" value="登录">
    </form>
    	<a href="<%=path%>/toReg.action">新用户？点击注册</a>
    </div>
  </body>
</html>

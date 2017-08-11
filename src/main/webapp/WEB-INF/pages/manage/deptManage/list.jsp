<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <table class="easyui-datagrid">
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

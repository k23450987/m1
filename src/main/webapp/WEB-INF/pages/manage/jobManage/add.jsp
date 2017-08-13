<%@ page language="java" pageEncoding="UTF-8" %>
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
<jsp:include page="index.jsp"/>
<span style="color: red; ">${message }</span>
<form action="<%=path %>/jobAdd.action" method="post">
    <table border="1px" align="left">
        <tr>
            <td>请选择要设立岗位的所在部门</td>
            <td>
                <label>
                    <select name="dept_id">
                        <!-- <option value="0">无</option> -->
                        <c:forEach items="${depts}" var="d">
                            <option value="${d.id}">${d.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td>岗位名称</td>
            <td><label>
                <input type="text" name="job_name">
            </label></td>
        </tr>
    </table>
    <input type="submit" value="添加">
</form>
<button onclick="history.go(-1)">取消</button>
</body>
</html>

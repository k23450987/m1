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

    <title>My JSP 'manage.jsp' starting page</title>

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
${message }
<form action="<%=path%>/personManage.action" method="post">
    <input type="hidden" name="person_id" value="${p.id}">
    对<span style="color: blue; ">${p.name}</span>进行人员调动<br/>
    请选择职位
    <label>
        <select name="job_id">
            <option value="0">无</option>
            <c:forEach items="${jobs}" var="job">
                <option value="${job.id}">${job.name}</option>
            </c:forEach>
        </select>
    </label>
    <input type="submit" value="完成">
</form>
</body>
</html>

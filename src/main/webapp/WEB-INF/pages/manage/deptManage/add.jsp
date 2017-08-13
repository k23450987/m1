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

    <title>新增部门</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#dept_name").keyup(function () {
                $.ajax({
                    type: "POST",
                    data: {
                        dept_name: $("#dept_name").val(),
                    },
                    url: "deptVerify.action",
                    success: function (data) {
                        if (data == "fail") {
                            $("#msg").empty();
                            $("#msg").append("<font color='red'>请输入正确的部门名称</font>");
                        }
                        if (data == "success") {
                            $("#msg").empty();
                            $("#msg").append("<font color='green'>部门名称可以使用</font>");
                        }
                    }
                })
            })
        })
    </script>
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
</head>
<body>
<jsp:include page="index.jsp"/>
<span style="color: red; ">${message }</span>
<form action="<%=path%>/deptAdd.action" method="post">
    <table border="1px" align="left">
        <tr>
            <td>部门名称</td>
            <td><label for="dept_name"></label><input type="text" name="dept_name" id="dept_name"><span
                    id="msg">
				</span></td>
        </tr>
        <tr>
            <td>隶属于</td>
            <td><label>
                <select name="fdept_id">
                    <option value="0">无</option>
                    <c:forEach items="${depts }" var="d">
                        <option value="${d.id}">${d.name}</option>
                    </c:forEach>
                </select>
            </label>
            </td>
        </tr>
    </table>
    <input type="submit" value="添加">
</form>
<button onclick="history.go(-1)">取消</button>
</body>
</html>

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

    <title>编辑</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    <script type="text/javascript">
        $(function () {
            var tr_id = 1;
            var tableName = '${tableName}';
            $("#add").bind('click', function () {
                tr_id++;
                $("#table").find("tbody").append(
                        "<tr id =" + tr_id + "><td><input type='hidden' name='id' value='" + tr_id
                        + "' /></td><td><input type='text' name='params' id='add_titleName' /></td><td><select name='type'><option value='int'>整数</option><option value='varchar'>字符串</option></select></td><td><input type='button' value='删除该行' onclick='func_rowdel(this)'></td></tr>");
            });
            $("#test").bind('click', function () {
                alert("hello");
                var fields = [];
                var trs = $('#form').find('table tbody tr');
                for (var i = 0; i < trs.length; i++) {
                    var params = $(trs[i]).find('[name="params"]').val();
                    var type = $(trs[i]).find('[name="type"]').val();
                    fields.push({
                        params: params,
                        type: type
                    });
                }
                $.ajax({
                    url: "tableEdit.action",
                    type: "POST",
                    dataType: "json",
                    data: {
                        tableName: tableName,
                        json: JSON.stringify(fields)
                    },
                    success: function (result) {
                        if (result) {
                            window.location = "tableList.action";
                            //alert("hello");
                        }

                    }
                });
            });
        });
        function func_rowdel(dom) {

            $(dom).parents('tr').remove();
        }
    </script>
</head>
<body>
<a href="javascript:void(0)" id="add">新增一行</a>
<form action="#" id="form">
    <table id="table" style="padding: 10px;width: 300px">
        <thead>
        <tr>
            <td></td>
            <td>列名</td>
            <td>类型</td>
            <td>表id</td>
        </tr>
        <c:forEach items="${cols}" var="col">
            <tr>
                <td></td>
                <td>${col.params}</td>
                <td>${col.type}</td>
                <td>${col.tableId}</td>
            </tr>
        </c:forEach>
        </thead>
        <tbody>
        </tbody>
    </table>
</form>
<a href="javascript:void(0)" id="test">提交</a>
<a href="<%=path%>/tableList.action">返回</a>
</body>
</html>

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

</head>
<script type="text/javascript">
    $(function () {
        var tableName = '${tableName}';
        var tr_id = 1;
        $("#test").bind('click', function () {

            var fields = [];
            var trs = $('#form table tbody tr');
            for (var i = 0; i < trs.length; i++) {
                var colid = $(trs[i]).find('[name="colid"]').val();
                var params = $(trs[i]).find('[name="params"]').val();
                var type = $(trs[i]).find('[name="type"]').val();
                fields.push({
                    colid: colid,
                    params: params,
                    type: type
                });
            }
            //alert(JSON.stringify(fields));
            //alert(tableName);
            $.ajax({
                url: "tableEdit.action",
                type: "POST",
                dataType: "json",
                //contentType: "application/json;charset=utf-8",
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
        $("#add").bind('click', function () {
            tr_id++;
            $("#table tbody").append("<tr id =" + tr_id + "><td><input type='hidden' name='id' value='" + tr_id
                    + "' /></td><td><input type='text' name='params' id='add_titleName' /></td><td><select name='type'><option value='int'>整数</option><option value='varchar'>字符串</option></select></td><td><input type='button' value='删除该行' onclick='func_rowdel(this)'></td></tr>");

        });

    })
    function func_rowdel(dom) {
        var a = confirm("确定删除吗？");
        if (a == true) {
            var tableName = '${tableName}';
            $(dom).parents('tr').remove();
            var params = $(dom).parents('tr').find('[name="params"]').val();
            var colid = $(dom).parents('tr').find('[name="colid"]').val();
            //alert(colid);
            $.post("dropCol.action", {tableName: tableName, params: params, colid: colid},
                    function (result) {
                        if (result) {
                            alert("删除成功");
                        }
                    });
        }
    }
</script>
<body>
<a href="javascript:void(0)" id="add">新增一行</a>
<form id="form" action="#">
    <table style="padding: 10px;width: 300px" id="table">
        <thead>
        <tr>
            <td></td>
            <td>列名</td>
            <td>类型</td>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cols }" var="col">

            <tr>
                <td><input type="hidden" name="colid" value="${col.id }">
                </td>
                <td><input type="text" name="params" value="${col.params }">
                </td>
                <td><select name="type">
                    <option value="${col.type }">--默认${col.type }---</option>
                    <option value="int">整数</option>
                    <option value="varchar">字符串</option>
                </select> <%-- <input type="text" name="type" value="${col.type }"> --%></td>
                <td><input type='button' value='删除该行' onclick='func_rowdel(this)'></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</form>
<a href="javascript:void(0)" id="test">提交</a>
<a href="<%=path%>/tableList.action">返回</a>
</body>
</html>

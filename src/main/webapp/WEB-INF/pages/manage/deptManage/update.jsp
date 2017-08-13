<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
    $(function () {
        $('#deptbtn_1').bind('click', function () {
            var fdept_id = $("#p4fdeptid").val();
            var dept_id = $("#p4deptid").val();
            var dept_name = $("#p4deptname").val();
            $.post("deptUpdate.action", {
                'parentId': fdept_id,
                'id': dept_id,
                'name': dept_name
            }, function (result) {
                if (result) {
                    $('#p4').window('close');
                    $('#tree').tree('reload');
                    $('#dg').datagrid('reload'); // reload the user data
                    $('#dg_2').datagrid('reload');
                }
            });
        });
    })
</script>
<div class="easyui-panel"
     style="width:500px;height:150px;padding:10px;background:#fafafa;"
     data-options="fit:ture">
    <input type="hidden" id="p4deptid" name="dept_id" value="${dept.id}">
    <table>
        <tr>
            <td>部门名称</td>
            <td><label for="p4deptname"></label><input type="text" name="dept_name" value="${dept.name}"
                                                       id="p4deptname"></td>
        </tr>
        <tr>
            <td>隶属于</td>
            <td>
                <label for="p4fdeptid"></label><select id="p4fdeptid" name="fdept_id">
                <option value="${dept.parentId}">${dept.parentName}</option>
                <option value="0">无</option>
                <c:forEach items="${depts}" var="d">
                    <option value="${d.id}">${d.name}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
    </table>
    <a id="deptbtn_1" href="javascript:void(0)" class="easyui-linkbutton"
       data-options="iconCls:'icon-ok'">修改</a>
</div>
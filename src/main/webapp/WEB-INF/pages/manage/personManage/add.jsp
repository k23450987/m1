<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <form action="<%=path %>/personAdd.action" method="post">
    <table border="1px" align="left">
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="p_name"></td>
        </tr>
        <tr>
            <td>员工年龄</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>员工信息</td>
            <td><textarea name="info" rows="10" cols="30"></textarea></td>
        </tr>
    </table>
    <input type="submit" value="添加">
</form>
<button onclick="history.go(-1)">取消</button> --%>
<script>
    $(function () {
        $("#btn_ok").bind('click', function () {
            var p_name = $("#pname").val();
            var age = $("#age").val();
            var info = $("#info").val();
            var job_ = $('#dg').datagrid('getSelected');
            if (job_ == null) {
                $.post("personAdd.action", {'name': p_name, 'age': age, 'info': info},
                        function () {
                            $('#p2').window('close');
                            $('#dg_2').datagrid('reload');
                        });

            } else {
                $.post("personAdd.action",
                        {'name': p_name, 'age': age, 'info': info, 'deptId': job_.deptId, 'jobId': job_.id},
                        function () {
                            $('#p2').window('close');
                            $('#dg_2').datagrid('reload');
                        });

            }
        })
    })
    function clearForm() {
        $('#ff').form('clear');
    }
</script>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" style="width:400px" data-options="fit:true">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post">
            <table cellpadding="5">
                <tr>
                    <td>员工姓名:</td>
                    <td><label for="pname"></label><input class="easyui-textbox" type="text" name="p_name" id="pname"
                                                          data-options="required:true"/></td>
                </tr>
                <tr>
                    <td>员工年龄:</td>
                    <td><label for="age"></label><input class="easyui-textbox" type="text" name="age" id="age" data-options="required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>员工信息:</td>
                    <td><label for="info"></label><input class="easyui-textbox" name="info" id="info" data-options="multiline:true"
                                                         style="height:60px"/></td>
                </tr>

            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a id="btn_ok" href="javascript:void(0)" class="easyui-linkbutton">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
        </div>
    </div>
</div>
	
	


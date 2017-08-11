<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function() {

		$('#btn_1').bind('click', function() {
			var jobid = $("#jobid").val();
			var deptid = $("#ffdeptid").val();
			var jobname = $("#jobname").val();
			$.post("jobUpdate.action", {
				'job_id' : jobid,
				'dept_id' : deptid,
				'job_name' : jobname
			}, function(result) {
				if (result) {
					$('#p').window('close');
					$('#dg').datagrid('reload'); // reload the user data
					$('#dg_2').datagrid('reload');
				}
			});
		});

	})
</script>
<font color="red">${message }</font>
<input type="hidden" name="job_id" id="jobid" value="${job.job_id }">
<div class="easyui-panel" style="width:360px">
	<table cellpadding="5">
		<tr>
			<td>请选择在那个部门下设立岗位</td>
			<td><select name="dept_id" id="ffdeptid">
					<option value="${job.dept_id }" selected="selected">当前：${job.dept_name
						}</option>
					<c:forEach items="${depts }" var="d">
						<option value="${d.dept_id }">${d.dept_name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>岗位名称</td>
			<td><input class="easyui-textbox" id="jobname" type="text"
				name="job_name" value="${job.job_name }">
			</td>
		</tr>
	</table>
	<a id="btn_1" href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-ok'">修改</a>
</div>

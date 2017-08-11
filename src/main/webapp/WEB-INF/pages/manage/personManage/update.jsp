<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 			<input type="hidden" name="person_id" value="${p.person_id }">
		<table border="1px" align="left">
			<tr>
				<td>员工姓名</td>
				<td><input type="text" name="p_name" value="${p.p_name }"></td>
			</tr>
			<tr>
				<td>员工年龄</td>
				<td><input type="text" name="age" value="${p.age }"></td>
			</tr>
			<tr>
				<td>员工信息</td>
				<td><textarea name="info" rows="10" cols="30" >${p.info }</textarea></td>
			</tr>
		</table>
		<input type="submit" value="修改"> --%>
<script>
	$(function() {

		$.getJSON("personToManageJson.action", function(jsons) {
			$.each(jsons, function(i, obj) {
				$("#select1").append("<option value="+obj.dept_id+">" + obj.dept_name + "</option>");
			});
		});
		$("#select1").bind('change', function() {
			//var deptid = $("#select1").val();
			$("#select2").empty();
			$.getJSON("jobListJson.action", {
				'dept_id' : $("#select1").val()
			}, function(jobs) {
				$.each(jobs, function(i, job) {
					$("#select2").append("<option value="+job.job_id+">" + job.job_name + "</option>");
				});
			});

		});
		$("#btn_ok2").bind('click', function() {
			//var job = $('#dg').datagrid('getSelected');
			//var dept = $('#tree').tree('getSelected');
			var p_name2 = $("#pname2").val();
			var p_id2 = $("#personid").val();
			var age2 = $("#age2").val();
			var info2 = $("#info2").val();
			var dept_id2 = $("#select1").val();
			var job_id2 = $("#select2").val();

			/* alert(p_name2);
			alert(p_id2);
			alert(age2);
			alert(info2);
			alert(dept_id2);
			alert(job_id2); */
			$.post("personUpdate.action", {
				'p_name' : p_name2,
				'person_id' : p_id2,
				'age' : age2,
				'info' : info2,
				'dept_id' : dept_id2,
				'job_id' : job_id2
			}, function(data) {
				$('#p3').window('close');
				$('#dg_2').datagrid('reload');
			});

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
			<input type="hidden" id="personid" name="person_id"
				value="${p.person_id }">
			<table cellpadding="5">
				<tr>
					<td>员工姓名:</td>
					<td><input class="easyui-textbox" type="text" name="p_name"
						id="pname2" value="${p.p_name }" data-options="required:true"></input>
					</td>
				</tr>
				<tr>
					<td>员工年龄:</td>
					<td><input class="easyui-textbox" type="text" name="age"
						id="age2" value="${p.age }" data-options="required:true"></input>
					</td>
				</tr>
				<tr>
					<td>员工信息:</td>
					<td><input class="easyui-textbox" name="info" id="info2"
						value="${p.info }" data-options="multiline:true"
						style="height:60px"></input>
					</td>
				</tr>
				<tr>
					<td>选择部门:</td>
					<td><select name="dept_id" id="select1">
							<option value="">默认</option>
					</select></td>
				</tr>
				<tr>
					<td>选择岗位:</td>
					<td><select name="job_id" id="select2">
							<option value="">默认</option>
					</select></td>
				</tr>
			</table>
		</form>
		<div style="text-align:center;padding:5px">
			<a id="btn_ok2" href="javascript:void(0)" class="easyui-linkbutton">确定</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="clearForm()">清空</a>
		</div>
	</div>
</div>

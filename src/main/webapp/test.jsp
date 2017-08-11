<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>部门管理2.0</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/js/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/js/themes/icon.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		$("#tree").tree({

			url : 'deptTree.action',
			onClick : function(node) {
				$("#dg_2div").hide();
				$("#dg").datagrid({
					url : 'JobListJson.action?dept_id=' + node.id,
					width : 500,
					columns : [ [ {
						field : 'checkbox',
						checkbox : "true"
					}, {
						field : 'job_id',
						title : '序号',
						width : 100
					}, {
						field : 'job_name',
						title : '岗位名称',
						width : 100
					}, {
						field : 'dept_name',
						title : '所属部门',
						width : 100
					}, {
						field : 'fdept_name',
						title : '父部门',
						width : 100
					}, ] ],
					checkbox : true,
					fitColumns : true,
					singleSelect : true,
					toolbar : [ {
						text : '添加',
						iconCls : 'icon-add',
						handler : function() {
							$('#win').show();
							$('#win').window({
								title : '添加岗位',
								width : 370,
								height : 205,
								left : 500,
								top : 200,
								modal : true
							})

						}
					}, '-', {
						iconCls : 'icon-remove',
						text : '删除选中',
						handler : function() {
							var job = $('#dg').datagrid('getSelected');
							$.get("jobDeleteAjax.action", {
								'job_id' : job.job_id
							}, function(result) {
								if (result) {
									$('#dg').datagrid('reload'); // reload the user data
								}
							})

						}
					}, '-', {
						text : '编辑',
						iconCls : 'icon-edit',
						handler : function() {
							var job = $('#dg').datagrid('getSelected');
							$('#p').window({

								height : 170,
								width : 410,
								left : 500,
								top : 150,
								title : '编辑岗位',
								closable : true,
								href : "jobToUpdate.action?job_id=" + job.job_id,
								modal : true
							});

						}
					} ],
					onClickRow : function() {
						$("#dg_2div").show();
						var job = $('#dg').datagrid('getSelected');
						$("#dg_2").datagrid({
							url : 'personListJson.action?job_id=' + job.job_id,
							width : 500,

							columns : [ [ {
								field : 'checkbox',
								checkbox : "true"
							}, {
								field : 'p_name',
								title : '员工姓名',
								width : 100
							}, {
								field : 'age',
								title : '员工年龄',
								width : 100
							}, {
								field : 'info',
								title : '员工信息',
								width : 100
							}, {
								field : 'job_name',
								title : '职务',
								width : 100
							}, {
								field : 'dept_name',
								title : '所属部门',
								width : 100
							}, ] ],
							checkbox : true,
							fitColumns : true,
							singleSelect : true,
							toolbar : [ {
								text : '添加',
								iconCls : 'icon-add',
								handler : function() {
									$('#p2').window({
										title : '添加人员',
										width : 400,
										height : 350,
										left : 500,
										top : 200,
										href : "personToAdd.action",
										modal : true
									})

								}
							}, '-', {
								iconCls : 'icon-remove',
								text : '删除选中',
								handler : function() {
									var person = $('#dg_2').datagrid('getSelected');
									$.get("personDelete.action", {
										'person_id' : person.person_id
									}, function(result) {
										if (result) {
											$('#dg_2').datagrid('reload'); // reload the user data
										}
									})

								}
							}, '-', {
								text : '编辑',
								iconCls : 'icon-edit',
								handler : function() {
									var person = $('#dg_2').datagrid('getSelected');
									$('#p3').window({

										height : 400,
										width : 430,
										left : 500,
										top : 150,
										title : '编辑岗位',
										closable : true,
										href : "personToUpdate.action?person_id=" + person.person_id,
										modal : true
									});

								}
							} ],

						});
					},

				});

			},

		});

		$('#btn').bind('click', function() {
			//var dept_id = $("#tree").tree('getSelected').id;
			if($("#tree").tree('getSelected')==null){
				alert("请先在左侧选择组织机构");
			}
			var job_name = $("#job_name").val();
			$.post("jobAdd.action", {
				'dept_id' : $("#tree").tree('getSelected').id,
				'job_name' : job_name
			}, function(result) {
				if (result) {
					$('#dg').datagrid('reload'); // reload the user data
				}
			});
			$('#win').window('close');
		});

		$('#deptdelbtn').bind('click', function() {
			var dept_id = $("#tree").tree('getSelected').id;
			$.get("deptDel.action", {
				'dept_id' : dept_id
			}, function(result) {
				if (result) {
					$('#tree').tree('reload'); // reload the user data
				}
			})
		});

		$('#deptaddbtn').bind('click', function() {

			$('#win2').show();
			$('#win2').window({
				title : '添加部门',
				width : 370,
				height : 205,
				left : 500,
				top : 200,
				modal : true
			});

		});
		$('#depteditbtn').bind('click', function() {

			$('#p4').show();
			$('#p4').window({
				title : '修改部门',
				width : 370,
				height : 205,
				left : 500,
				top : 200,
				href : 'deptToUpdate.action?dept_id='+$("#tree").tree('getSelected').id,
				modal : true
			});

		});

		$('#btn_2').bind('click', function() {
			var dename = $("#dename").val();
			var tree = $("#tree").tree('getSelected');
			var fdept_id;
			if ($("#tree").tree('getSelected') == null) {
				fdept_id = 0;
				//alert(fdept_id);
			} else {
				fdept_id = tree.id;
				//alert(fdept_id);
			}
			$.post("deptAdd.action", {
				'fdept_id' : fdept_id,
				'dept_name' : dename
			}, function(result) {
				if (result) {
					$('#tree').tree('reload'); // reload the user data
				}
			});
			$('#win2').window('close');
		});
		$('#reload').bind('click', function() {

			$('#tree').tree('reload');
		});

		$('#alljob').bind('click', function() {

			$("#dg_2div").hide();
			$("#dg").datagrid({
				url : 'jobsListJson.action',
				width : 500,
				columns : [ [ {
					field : 'checkbox',
					checkbox : "true"
				}, {
					field : 'job_id',
					title : '序号',
					width : 100
				}, {
					field : 'job_name',
					title : '岗位名称',
					width : 100
				}, {
					field : 'dept_name',
					title : '所属部门',
					width : 100
				}, {
					field : 'fdept_name',
					title : '父部门',
					width : 100
				}, ] ],
				checkbox : true,
				fitColumns : true,
				singleSelect : true,
				toolbar : [ {
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
						$('#win').show();
						$('#win').window({
							title : '添加岗位',
							width : 370,
							height : 205,
							left : 500,
							top : 200,
							modal : true
						})

					}
				}, '-', {
					iconCls : 'icon-remove',
					text : '删除选中',
					handler : function() {
						var job = $('#dg').datagrid('getSelected');
						$.get("jobDeleteAjax.action", {
							'job_id' : job.job_id
						}, function(result) {
							if (result) {
								$('#dg').datagrid('reload'); // reload the user data
							}
						})

					}
				}, '-', {
					text : '编辑',
					iconCls : 'icon-edit',
					handler : function() {
						var job = $('#dg').datagrid('getSelected');
						$('#p').window({

							height : 170,
							width : 410,
							left : 500,
							top : 150,
							title : '编辑岗位',
							closable : true,
							href : "jobToUpdate.action?job_id=" + job.job_id,
							modal : true
						});

					}
				} ],
				onClickRow : function() {
					$("#dg_2div").show();
					var job = $('#dg').datagrid('getSelected');
					$("#dg_2").datagrid({
						url : 'personListJson.action?job_id=' + job.job_id,
						width : 500,

						columns : [ [ {
							field : 'checkbox',
							checkbox : "true"
						}, {
							field : 'p_name',
							title : '员工姓名',
							width : 100
						}, {
							field : 'age',
							title : '员工年龄',
							width : 100
						}, {
							field : 'info',
							title : '员工信息',
							width : 100
						}, {
							field : 'job_name',
							title : '职务',
							width : 100
						}, {
							field : 'dept_name',
							title : '所属部门',
							width : 100
						}, ] ],
						checkbox : true,
						fitColumns : true,
						singleSelect : true,
						toolbar : [ {
							text : '添加',
							iconCls : 'icon-add',
							handler : function() {
								$('#p2').window({
									title : '添加人员',
									width : 400,
									height : 350,
									left : 500,
									top : 200,
									href : "personToAdd.action",
									modal : true
								})

							}
						}, '-', {
							iconCls : 'icon-remove',
							text : '删除选中',
							handler : function() {
								var person = $('#dg_2').datagrid('getSelected');
								$.get("personDelete.action", {
									'person_id' : person.person_id
								}, function(result) {
									if (result) {
										$('#dg_2').datagrid('reload'); // reload the user data
									}
								})

							}
						}, '-', {
							text : '编辑',
							iconCls : 'icon-edit',
							handler : function() {
								var person = $('#dg_2').datagrid('getSelected');
								$('#p3').window({

									height : 400,
									width : 430,
									left : 500,
									top : 150,
									title : '编辑岗位',
									closable : true,
									href : "personToUpdate.action?person_id=" + person.person_id,
									modal : true
								});

							}
						} ],

					});
				},

			});

		})

		$('#allperson').bind('click', function() {

			$("#dg_2div").show();
			$("#dg_2").datagrid({
				url : 'personsList.action',
				width : 500,

				columns : [ [ {
					field : 'checkbox',
					checkbox : "true"
				}, {
					field : 'p_name',
					title : '员工姓名',
					width : 100
				}, {
					field : 'age',
					title : '员工年龄',
					width : 100
				}, {
					field : 'info',
					title : '员工信息',
					width : 100
				}, {
					field : 'job_name',
					title : '职务',
					width : 100
				}, {
					field : 'dept_name',
					title : '所属部门',
					width : 100
				}, ] ],
				checkbox : true,
				fitColumns : true,
				singleSelect : true,
				toolbar : [ {
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
						$('#p2').window({
							title : '添加人员',
							width : 400,
							height : 350,
							left : 500,
							top : 200,
							href : "personToAdd.action",
							modal : true
						})

					}
				}, '-', {
					iconCls : 'icon-remove',
					text : '删除选中',
					handler : function() {
						var person = $('#dg_2').datagrid('getSelected');
						$.get("personDelete.action", {
							'person_id' : person.person_id
						}, function(result) {
							if (result) {
								$('#dg_2').datagrid('reload'); // reload the user data
							}
						})

					}
				}, '-', {
					text : '编辑',
					iconCls : 'icon-edit',
					handler : function() {
						var person = $('#dg_2').datagrid('getSelected');
						$('#p3').window({

							height : 400,
							width : 430,
							left : 500,
							top : 150,
							title : '编辑岗位',
							closable : true,
							href : "personToUpdate.action?person_id=" + person.person_id,
							modal : true
						});

					}
				} ],

			});

		});
		$('#alldept').bind('click', function() {
			$('#win3').show();
			$('#eudg4').datagrid('reload');
			$('#eudg4').datagrid({
				toolbar : '#tb'

			});
			$('#win3').window({
				width : 600,
				height : 600,
				left : 300,
				top : 100,
			});

		});
		
		$('#win3deptdel').bind('click', function() {
			$.get("deptDel.action", {
				'dept_id' : $('#eudg4').datagrid('getSelected').dept_id
			}, function(result) {
				if (result) {
					$('#eudg4').datagrid('reload'); // reload the user data
				}
			})
			

		});

		$('#win3deptedit').bind('click', function() {
			$('#p4').show();
			$('#p4').window({
				title : '修改部门',
				width : 370,
				height : 205,
				left : 500,
				top : 200,
				href : 'deptToUpdate.action?dept_id='+$('#eudg4').datagrid('getSelected').dept_id,
				modal : true
			});
			
		
		});
		
		$('#win3reload').bind('click', function() {

			$('#eudg4').datagrid('reload');
		});
	})
</script>

</head>
<body>
	<div class="easyui-panel" style="width:230px;padding:5px">

		<span><a id="alldept" href="javascript:void(0)"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-search'">查看全部部门列表</a> </span><br>
		<span><a id="alljob" href="javascript:void(0)"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-search'">查看全部岗位列表</a> </span><br>
		<span><a id="allperson" href="javascript:void(0)"
			class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-search'">查看全部人员列表</a> </span><br>
	</div>
	<div class="easyui-panel" style="width:230px;padding:5px">
		<div>
			部门管理<br /> <span>
			<a id="deptaddbtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a> </span><span>
			<a id="deptdelbtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">删除</a> </span><span>
			<a id="depteditbtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">编辑</a> </span><span>
			<a id="reload" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'">刷新</a> </span><br>

		</div>
		当前部门列表<br>
		<ul id="tree" style="width: 206px;"></ul>
	</div>

	<div style="position: absolute;left: 300px;top:0px;padding:5px;">

		<table id="dg" title="岗位管理"></table>
	</div>

	<div id="win" style="display: none;">


		<input type="hidden" name="dept_id" id="dept_id">
		<div class="easyui-panel" style="width:350px;padding:20px 40px"
			data-options="fit:true">
			<div style="margin-bottom:20px">
				<div>岗位名称:</div>
				<input class="easyui-textbox" type="text" name="job_name"
					id="job_name" data-options="prompt:'请输入岗位名称'"
					style="width:100%;height:32px">
			</div>
			<a id="btn" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'">添加</a>
		</div>
		<!-- <table align="center">
				<tr>
					<td>岗位名称</td>
					<td><input class="easyui-textbox" type="text" name="job_name" id="job_name"></td>
				</tr>
			</table> -->
	</div>

	<div id="win2" style="display: none;">
		<div class="easyui-panel" style="width:350px;padding:20px 40px"
			data-options="fit:true">
			<div style="margin-bottom:20px">
				<div>部门名称:</div>
				<input class="easyui-textbox" type="text" name="dept_name"
					id="dename" data-options="prompt:'请输入部门名称'"
					style="width:100%;height:32px">
			</div>
			<a id="btn_2" href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'">添加</a>
		</div>
	</div>

	<div id="p"></div>
	<div id="p2"></div>
	<div id="p3"></div>
	<div id="p4"></div>
	<div id="win3" style="display: none;" title="所有部门">
		<div id="tb">
			<a id="win3deptdel" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
			<a id="win3deptedit" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
			<a id="win3reload" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">刷新</a>
		</div>

		<table id="eudg4" class="easyui-datagrid"
			style="width:400px;height:250px;"
			data-options="url:'deptListJson.action',fitColumns:true,singleSelect:true,fit:true">
			<thead>
				<tr>
					<th data-options="field:'dept_id',width:100">编号</th>
					<th data-options="field:'dept_name',width:100">部门名称</th>
					<th data-options="field:'fdept_name',width:100">父部门</th>
				</tr>
			</thead>
		</table>

	</div>

	<div id="dg_2div"
		style="position: absolute;left: 900px;top:0px;padding:5px;">
		<table id="dg_2" title="职员管理"></table>
	</div>
</body>
</html>

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

<title>自由库数据</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="<%=path%>/js/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/js/themes/icon.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.post('<%=path%>/findData1.action', {
			tableId : 34
		}, function(data) {
			// 处理表头（列）
			if (data.cols && data.cols.length > 0) {
				var thead = '<tr>';
				for (var i = 0; i < data.cols.length; i++) {
					thead += '<td>' + data.cols[i].params + '</td>';
				}
				thead += '</tr>';
				$('#table thead').html(thead);
				// 处理数据
				if (data.datas && data.datas.length > 0) {
					var tbody = '<tr>';
					for (var i = 0; i < data.datas.length; i++) {
						tbody += ''
						for (var j = 0; j < data.cols.length; j++) {
							tbody += '<td>' + (data.datas[i][data.cols[j].params] ? data.datas[i][data.cols[j].params] : '') + '</td>';
						}
						tbody += '</tr>';
					}
					$('#table tbody').html(tbody);
				}
			}
		}, 'json');
	})
	$(function() {
		$('#dg').datagrid({
			// fit : true,
			striped : true,
			border : true,
			idField : 'person_id',
			rownumbers : true,
			fitColumns : true,
			singleSelect : false,
			pagination : true,
			pageSize : 5,
			pageList : [5, 10],
			url : '<%=path%>/personsList1.action',
			queryParams : {},
			method : 'get',
			columns : [[{
						"field" : "person_id",
						"title" : "person_id"
					}, {
						"field" : "p_name",
						"title" : "p_name"
					}]],
			loadMsg : '数据载入中...'
		});
		/* $('#dg').datagrid('getPager').pagination({
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录    共 {total} 条记录'
		}); */
	});
</script>
</head>

<body>
	<table id="table">
		<thead></thead>
		<tbody></tbody>
	</table>
	<a href="<%=path%>/tableList.action">返回</a>
	<table id="dg" class="easyui-datagrid" title="123"></table>
</body>
</html>

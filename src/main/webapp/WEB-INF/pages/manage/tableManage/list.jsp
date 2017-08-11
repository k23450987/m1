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

<title>自由库列表</title>

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
	$(function() {

	})

	function delTable(id) {
		//alert(id);
		var a = confirm("确定删除自由库吗？");
		if (a == true) {
			$.ajax({
				url : "tableDel.action",
				type : "GET",
				data : {
					tableId : id
				},
				// 	判断是否删除成功
				success : function(result) {
					if (result == 'true') {
						alert("删除成功");
						window.location = "tableList.action";
						//alert("hello");
					} else {
						alert("自由库中有数据，无法删除");

					}

				}

			});

		}
	}
</script>
</head>

<body>
	<table>
		<tr>
			<td>编号</td>
			<td>自由库名称</td>
			<td>表格列</td>
			<td>库数据</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>

		<c:forEach items="${tables }" var="t">
			<tr>
				<td>${t.id }</td>
				<td>${t.name }</td>
				<td><a href="<%=path%>/colsList.action?tableId=${t.id }">表格列</a>
				</td>
				<td><a href="<%=path%>/toFindData.action?tableId=${t.id }">库数据</a>
				</td>
				<td><a href="<%=path%>/tabletoEdit.action?tableId=${t.id }">编辑</a>
				</td>
				<td><a id="${t.id }" href="javascript:void(0)"
					onclick="delTable(id)">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="<%=path%>/toAddTable.action">新增自由库</a>
</body>
</html>

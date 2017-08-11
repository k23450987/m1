<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'pageTest.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="<%=path%>/js/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<script src="<%=path%>/js/bootstrap/js/jquery-2.0.3.min.js"
	type="text/javascript"></script>
<script src="<%=path%>/js/bootstrap/js/bootstrap.js"
	type="text/javascript"></script>
<script src="<%=path%>/js/bootstrap/js/jquery.twbsPagination.js"
	type="text/javascript"></script>

</head>

<body>
	<table id="table" align="center" width="350px" style="padding: 10px">
		<thead>
			<tr></tr>
		</thead>
		<tbody></tbody>


	</table>
	<div class="text-center" align="center">
		<ul id="pagination-demo" class="pagination-sm"></ul>
	</div>
	<script type="text/javascript">
		$(function() {

			$.getJSON("findData2?tableId=34&pageNum=1", function(json) {
				var page = Math.ceil(json.count / 10);
				var columns = json.cols;
				var datas = json.datas;
				for ( var i = 0; i < columns.length; i++) {
					var column = columns[i].params;
					$("#table thead tr").append("<td>" + column + "</td>");
				}
				//alert(page);
				$('#pagination-demo').twbsPagination({
					totalPages : page,
					visiblePages : 5,
					version : '1.1',
					onPageClick : function(event, pageNum) {
						$.getJSON("findData2?tableId=34&pageNum=" + pageNum, function(json) {
							var columns = json.cols;
							var datas = json.datas;
							var tbody;
							for ( var j = 0; j < datas.length; j++) {
								tbody += '<tr>';
								tbody += ' ';
								for ( var k = 0; k < columns.length; k++) {
									var column = columns[k].params;
									//alert(column);
									var data = datas[j][column];
									tbody += '<td>' + (data ? data : '') + '</td>';
								}
								tbody += '</tr>';
							}
							$('#table tbody').html(tbody);

						});
					}
				});

			})

		})
	</script>
</body>

</html>

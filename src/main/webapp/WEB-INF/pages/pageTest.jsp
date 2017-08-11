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

<title>查看自由库数据</title>

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
	<div id="searchid" align="center" style="padding: 5px">
	
		<span> 
			<select name="params" id="selectId">
				<option>模糊查询:请选择查询条件</option>
			</select> 
		</span> 
		
		<span> 
			<input type="text" name="text">每页条数
			<select name="pagesize" id="pagesizeid">
					<option value=10>10</option>
					<option value=20>20</option>
			</select> 
			<a href="javascript:void(0)" onclick="search_like()">查询</a> 
			<a href="javascript:void(0)" onclick="window.location.reload()">清空查询结果</a>
		</span>
		
	</div>
	
	<table id="table" border="1px" align="center" cellpadding="6px" style="padding: 10px">
		<thead>
			<tr></tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	<div class="text-center" align="center">
		<ul id="pagination-demo" class="pagination-sm"></ul>
	</div>

	<script type="text/javascript">
		var tableId = '${tableId}';
		var $pagination;
		$(function() {

			$.getJSON("<%=path%>/findData2?tableId=" + tableId + "&pageNum=1", function(json) {
				// 计算总页数
				var page = Math.ceil(json.count / 10);
				// 自由库列信息
				var columns = json.cols;
				// 自由库数据
				var datas = json.datas;
				// 判断自由库中有数据吗
				if (datas && datas.length > 0) {
					// 遍历列的集合
					for ( var i = 0; i < columns.length; i++) {
						var column = columns[i].params;
						// 添加到 thead 中
						$("#table thead tr").append("<td>" + column + "</td>");
					}
					//alert(page);
					$pagination = $('#pagination-demo').twbsPagination({
						totalPages : page,
						visiblePages : page > 5 ? 5 : page,
						version : '1.1',
						first : "首页",
						prev : "上一页",
						next : "下一页",
						last : "尾页",
						onPageClick : function(event, pageNum) {
							$.getJSON("<%=path%>/findData2?tableId=" + tableId + "&pageNum=" + pageNum, function(json) {
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
										tbody += '<td width=100px>' + (data ? data : '') + '</td>';
									}
									tbody += '</tr>';
								}
								$('#table tbody').html(tbody);

							});
						}
					});
				} else {
					alert("该表无数据");
					window.location.href = "<%=path%>/tableList.action";

				}
			})

			$.getJSON("<%=path%>/getCollist.action", {
				tableId : tableId
			}, function(json) {
				var option;
				for ( var i = 0; i < json.length; i++) {
					var params = json[i].params
					var colid = json[i].colid
					option += "<option value='"+colid+"'>" + params + "</option>";
				}
				$("#selectId").append(option);
			});

		})
		function search_like(num) {
			var $text = $("#searchid span input").val();
			var $colid = $("#selectId option:selected").val();
			var $pagesize = $("#pagesizeid option:selected").val();
			var pageNum = num?num:1;
			$.ajax({
				type : "POST",
				url : "<%=path%>/selectLike.action",
				data : {
					tableId : tableId,
					text : $text,
					colid : $colid,
					pageNum : pageNum,
					pagesize : $pagesize,

				},
				success : function(result) {
					//alert(result);
					var cols = result.cols;
					var datas = result.datas;
					if (datas && datas.length > 0) {
						var pages = Math.ceil(result.count / $pagesize);
						$pagination.twbsPagination('destroy');
						$('#pagination-demo').twbsPagination({
							totalPages : pages,
							visiblePages : pages > 5 ? 5 : pages,
							first : "首页",
							prev : "上一页",
							next : "下一页",
							last : "尾页",
							onPageClick : function(event, page) {
								$.getJSON("selectLike.action", {
									tableId : tableId,
									text : $text,
									colid : $colid,
									pageNum : page,
									pagesize : $pagesize,
								}, function(json) {
									var tbody;
									for ( var i = 0; i < json.datas.length; i++) {
										tbody += "<tr>";
										for ( var j = 0; j < json.cols.length; j++) {
											var data = json.datas[i][json.cols[j].params];
											tbody += "<td width=100px>" + (data ? data : " ") + "</td>"
										}
										tbody += "</tr>";
									}
									$("#table tbody").html(tbody);
								});
							}
						});
					} else {
						alert("抱歉，没有找到与 " + $text + " 相关的结果。");
					}
				}
			});

		}
	</script>
</body>

</html>

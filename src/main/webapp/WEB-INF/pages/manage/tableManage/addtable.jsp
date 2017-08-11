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

<title>添加自由库</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<%-- <script type="text/javascript" src="<%=path %>/js/jquery-serialize-object.js"></script> --%>
<!-- <script type="text/javascript">
	$.fn.serializeObject = function() {
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name] !== undefined) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};
</script> -->
<script type="text/javascript">
	$(function() {
		var tr_id = $("#table tbody tr:last").attr("id");
		
		$("#test").bind('click', function() {
			var tableName = $("#tableName").val();
			//alert(tableName);
			//alert(tr_id);
			//var fields = '[{"params":"a","type":"varchar","unique":"true"},{"params":"s","type":"int"},{"params":"d","type":"int"},{"params":"f","type":"int"},{"params":"g","type":"int"},{"params":"h","type":"int"}]';
			var fields = [];
			// 处理添加的多列
			var trs = $('#form table tbody tr');
			for (var i = 0; i < trs.length; i++) {
				var params = $(trs[i]).find('[name="params"]').val();
				var type = $(trs[i]).find('[name="type"]').val();
				var unique = $(trs[i]).find('[name="unique"]').is(':checked');
				fields.push({
					params : params,
					type : type,
					unique : unique
				});
			}
			//alert(JSON.stringify(fields));
			 $.ajax({
			    url : "addTable.action",
			    type : "POST", 
			    dataType:"json",
			    //contentType: "application/json;charset=utf-8",
			    data : {
			    	tableName : tableName,
			    	json : JSON.stringify(fields)
			    },
			    success : function(result){
			    	if(result){
			    		window.location="tableList.action";
			    		//alert("hello");
			    	}
			    	
			    }
			}); 
			/*  $.ajax({
			    url : "test2",
			    type : "POST", 
			    dataType:"json",
			    contentType: "application/json;charset=utf-8",
			    data : JSON.stringify(fields)
			}); */
		});
		
		$("#add").bind('click', function() {
			tr_id++;
			$("#table tbody").append("<tr id ="+tr_id+"><td><input type='hidden' name='id' value='"+tr_id+"' /></td><td><input type='text' name='params' id='add_titleName' /></td><td><select name='type'><option value='int'>整数</option><option value='varchar'>字符串</option></select></td><td><input type='checkbox' name='unique' value='true'></td><td><input type='button' value='删除该行' onclick='func_rowdel(this)'></td></tr>");

		});
		
		
		$("#tableName").bind('keyup', function() {
			var tableName = $("#tableName").val();
			$.ajax({
				url : "checkTableName.action",
				type : "POST",
				data : {
					tableName : tableName
				},
				success : function(result){
					if(result=='false'){
						$("#spanid").empty();
						$("#spanid").append("<font color='red'>自由库已存在</font>");
						$("#test").hide();
					}else if (result=='true') {
						$("#spanid").empty();
						$("#test").show();
					}
				
				
				}
			
			})
		
		});
	})
	function func_rowdel(dom) {
			$(dom).parents('tr').remove();
		}
</script>
</head>

<body>
	<form action="<%=path%>/creatTable" id="form" method="post">
		请输入表名：<input type="text" name="tableName" id="tableName" /><span id="spanid"></span><br />
	<a href="javascript:void(0)" id="add">新增一行</a>
		<table id="table">
			<thead>
				<tr>
					<td></td>
					<td>列名</td>
					<td>类型</td>
					<td>唯一</td>
					<td>删除</td>
				</tr>
			</thead>
			<tbody>
				<tr id="1">
					<td><input type="hidden" name="id" id="id1" value="1" /></td>
					<td><input type="text" name="params" id="add_titleName" /></td>
					<td>
						<select name="type">
							<option value="int">整数</option>
							<option value="varchar">字符串</option>
						</select>
					</td>
					<td><input type="checkbox" name="unique" value="true"></td>
					<td><input type="button" value="删除该行" onclick="func_rowdel(this)"></td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<a href="javascript:void(0)" id="test">提交</a>
	<a href="<%=path%>/tableList.action">返回</a>
</body>
</html>

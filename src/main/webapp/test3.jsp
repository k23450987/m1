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

<title>My JSP 'test3.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
</head>
<body>
	<table border="1px #ooo" id="test"  class="test"
		cellpadding="0" cellspacing="0" width="20%">
		<tr>
				<td></td>
				<td>列名</td>
				<td>类型</td>
				<td>唯一</td>
		</tr>
		<tr id="1">
			<td><input type="hidden" name="id" value="1" /></td>
			<td width="30%"><input type="text" name="params" /></td>

			<td width="30%">
				<select name="type">
						<option value="int">整数</option>
						<option value="varchar">字符串</option>
				</select>
			</td>

			<td width="30%"><input type="checkbox" name="unique" value="true"></td>
		</tr>
</table>

	<input type="button" name="button" value="add" onclick="addtr('test');">
	<input type="button" name="button" value="del" onclick="deltr('test');">
</body>
<script>
	//在id为test的table的最后增加一行

	function addtr(id) {
		var tr_id = $("#test>tbody>tr:last").attr("id");

		tr_id++; //alert(tr_id);

		str = "<tr id = '"+tr_id+"'><td><input type='hidden' name='id' value='"+tr_id+"' /></td><td width='30%'><input type='text' name='params' /></td><td width='30%'><select name='type'><option value='int'>整数</option><option value='varchar'>字符串</option></select></td><td width='30%'><input type='checkbox' name='unique' value='true'></td></tr>";

		$('#' + id).append(str);
	} //删除id为test的table的最后一行

	function deltr(id) {
		var tr_id = $("#test>tbody>tr:last").attr("id");
		$('#' + tr_id).remove();

	}
</script>
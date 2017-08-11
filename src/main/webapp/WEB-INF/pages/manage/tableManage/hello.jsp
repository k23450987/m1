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
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<c:if test="${set==null }">
		该表无数据
	</c:if>
	<table style="width: 300px">
	<tr>
		<c:forEach items="${set }" var="s">
			<td>${s }</td>
		</c:forEach>
		</tr>
			<c:forEach items="${maps}" var="map">
				<tr>
					<c:forEach items="${map }" var="m">
						<td>${m.value }</td>
					</c:forEach>
				</tr>
			</c:forEach>
	</table>
	
	<table>
		<thead></thead>
		<tbody></tbody>
	</table>
	<a href="<%=path%>/tableList.action">返回</a>
<script type="text/javascript">


</script>
</body>
</html>

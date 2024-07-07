<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/style.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/common.js"></script>
</head>
<script type="text/javascript">
	
</script>
<style>
table {
	table-layout: fixed;
	word-break: break-all;
	word-wrap: break-word;
}
</style>
<body onload="initParentFrameHeight();">
	<table class="table table-bordered table-hover definewidth m10"
		id="table1">
		<thead>
			<tr>
				<th>手机号</th>
				<th>姓名</th>
				<th>邀请时间</th>
				<th>出资金额</th>
			</tr>
		</thead>
		<c:forEach items="${financialMoneysDailyList}" var="financial">
			<tr>
				<td>${financial.daily_phone}</td>
				<td>${financial.daily_name}</td>
				<td>${financial.daily_create_timeStr}</td>
				<td>${financial.daily_user_money}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp"%>
</html>

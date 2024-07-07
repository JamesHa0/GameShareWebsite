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
// 	function updateActivity(financial_id) {
// 		window.parent.location.href = "financial.do?addOrUpdateFinancial&flag=update&financial_id="
// 				+ financial_id;
// 	}

// 	function deleteActivity(financial_id) {
// 		window.parent.location.href = "financial.do?jyFinancial&financial_id=" + financial_id;
// 	}
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
				<th>用户名</th>
				<th>内容</th>
				<th>反馈时间</th>
			</tr>
		</thead>
		<c:forEach items="${feedBackList}" var="feedBack">
			<tr>
				<td>${feedBack.user_name}</td>
				<td>${feedBack.context}</td>
				<td>${feedBack.create_dateStr}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp"%>
</html>

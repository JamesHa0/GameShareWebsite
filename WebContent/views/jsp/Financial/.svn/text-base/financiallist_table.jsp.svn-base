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
	function updateActivity(financial_id) {
		window.parent.location.href = "financial.do?addOrUpdateFinancial&flag=update&financial_id="
				+ financial_id;
	}

	function deleteActivity(financial_id) {
		window.parent.location.href = "financial.do?jyFinancial&financial_id=" + financial_id;
	}
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
				<th>邀请码</th>
				<th>工号</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>创建者</th>
				<th>所属地区</th>
				<th>邀请用户</th>
			</tr>
		</thead>
		<c:forEach items="${financialList}" var="financial">
			<tr>
				<td>${financial.financial_phone}</td>
				<td>${financial.financial_name}</td>
				<td>${financial.financial_code}</td>
				<td></td>
				<td>
				 <c:choose>
						<c:when test="${financial.financial_state=='1'}">
						禁用
						</c:when>
						<c:when test="${financial.financial_state=='0'}">
						正常
						</c:when>
					</c:choose></td>
				<td>${financial.financial_create_timeStr}</td>
				<td>${financial.financial_create_name}</td>
				<td>${financial.financial_location}</td>
				<td><a href="javascript:void('0');"
					onclick="updateActivity('${financial.financial_id}');">编辑</a> <a
					href="javascript:void('0');"
					onclick="deleteActivity('${financial.financial_id}');">禁用</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp"%>
</html>

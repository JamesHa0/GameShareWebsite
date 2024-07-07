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
	function updateActivity(notSupportCardId) {
		window.parent.location.href = "notSupportCard.do?addOrUpdateNotSupportCard&flag=update&notSupportCardId="
				+ notSupportCardId;
	}

	function deleteActivity(notSupportCardId) {
		window.parent.location.href = "notSupportCard.do?deleteNotSupportCard&notSupportCardId=" + notSupportCardId;
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
				<th>卡号前六位</th>
				<th>发卡行</th>
				<th>卡名</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${notSupportCardList}" var="notSupportCard">
			<tr>
				<td>${notSupportCard.cardNumSix}</td>
				<td>${notSupportCard.bankName }</td>
				<td>${notSupportCard.cardName}</td>
				<td><a href="javascript:void('0');"
					onclick="updateActivity('${notSupportCard.cardId}');">编辑</a> <a
					href="javascript:void('0');"
					onclick="deleteActivity('${notSupportCard.cardId}');">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp"%>
</html>

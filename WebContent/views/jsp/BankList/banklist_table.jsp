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
	function updateActivity(bankId) {
		window.parent.location.href = "bank.do?addOrUpdateBank&flag=update&bankId="
				+ bankId;
	}

	function deleteActivity(bankId) {
		window.parent.location.href = "bank.do?deleteBank&bankId=" + bankId;
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
				<th>银行名称</th>
				<th>银行类型</th>
				<th>银行编号</th>
				<th>是否可用</th>
				<th>单笔限额</th>
				<th>单日限额</th>
				<th>单月限额</th>
			</tr>
		</thead>
		<c:forEach items="${bankList}" var="bank">
			<tr>
				<td>${bank.bankName}</td>
				<td>
					<!--            1 富友 2 银联 3 通联 4 财付通 --> <c:choose>
						<c:when test="${bank.bankType=='1'}">
						富友
						</c:when>
						<c:when test="${bank.bankType=='2'}">
						银联
						</c:when>
						<c:when test="${bank.bankType=='3'}">
						通联
						</c:when>
						<c:otherwise>
						通联
						</c:otherwise>
					</c:choose></td>
				<td>${bank.bankCode}</td>
				<td>
				 <c:choose>
						<c:when test="${bank.bankEnabled=='1'}">
						可用
						</c:when>
						<c:otherwise>
						不可用
						</c:otherwise>
					</c:choose>
				</td>
				<td>${bank.bankdanbi }</td>
				<td>${bank.bankdanri }</td>
				<td>${bank.bankdanyue }</td>
				<td><a href="javascript:void('0');"
					onclick="updateActivity('${bank.bankId}');">编辑</a> <a
					href="javascript:void('0');"
					onclick="deleteActivity('${bank.bankId}');">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp"%>
</html>

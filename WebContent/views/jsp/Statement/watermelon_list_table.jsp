<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	src="<%=request.getContextPath()%>/views/Js/jquery-1.4.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/common.js"></script>
</head>
<body onload="initParentFrameHeight();">
	<table class="table table-bordered table-hover definewidth m10"
		id="table1">
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th>注册人数</th>
				<th>入金人数</th>
				<th>入金金额</th>
			</tr>
		</thead>
		<tr>
			<td>&nbsp;</td>
			<c:if test="${registerCount!=null }">
				<td>${registerCount}</td>
			</c:if>
			<c:if test="${funderCount!=null }">
				<td>${funderCount}</td>
			</c:if>
			<c:if test="${FundingTotalMoney!=null }">
				<td>${FundingTotalMoney}</td>
			</c:if>
		</tr>
	</table>
</body>
<%-- <%@ include file="../common/pageHiddenInfo.jsp" %> --%>
</html>

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
	src="<%=request.getContextPath()%>/views/Js/common.js"></script>
</head>
<body onload="initParentFrameHeight();">
	<table class="table table-bordered table-hover definewidth m10"
		id="table1">
		<thead>
			<tr>
				<th>消息用户</th>
				<th>消息内容</th>
				<th>消息状态</th>
				<th>消息插入时间</th>

			</tr>
		</thead>
		<c:if test="${fn:length(list)!=0}">
			<c:forEach items="${list}" var="message">
				<tr>
					<td>${message.mes_user_name}</td>
					<td>${message.mes_content}</td>

					<td><c:if test="${message.mes_status=='0' }">未读</c:if> 
					<c:if test="${message.mes_status=='1' }">已读</c:if>
					</td>
					<td>${message.messageTime}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${fn:length(list)==0}">
			<tr>
				<td>&nbsp;</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:if>
	</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp"%>
</html>

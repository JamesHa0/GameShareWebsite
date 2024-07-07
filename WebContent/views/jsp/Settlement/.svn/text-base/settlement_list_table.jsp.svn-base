<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
</head>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>流水号</th>
        <th>类型</th>
        <th>富友账户</th>
        <th>请求时间</th>
        <th>返回码</th>
        <th>返回时间</th>
    </tr>
    </thead>
	<c:if test="${fn:length(list)!=0}">
		<c:forEach items="${list}"  var="user">
			<tr >
				<td>${user.seSeq}</td>
				<td>
					<c:if test="${user.seType=='1' }">开户</c:if>
					<c:if test="${user.seType=='2' }">预授权</c:if>
					<c:if test="${user.seType=='3' }">查询余额</c:if>
					<c:if test="${user.seType=='4' }">充值</c:if>
					<c:if test="${user.seType=='5' }">提现</c:if>
				</td>
				<td>${user.seReqMess}</td>
				<td>${user.seReqTimeStr}</td>
				<td>${user.seResult}</td>
				<td>${user.seResTimeStr}</td>
			</tr>
		</c:forEach>
    </c:if>
    <c:if test="${fn:length(list)==0}">
			<tr >
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
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

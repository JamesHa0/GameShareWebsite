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
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
</head>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
<!--     	<th><input type="checkbox" onchange="checkAll();"></th> -->
        <th>流水号</th>
        <th>姓名</th>
        <th>赎回金额</th>
        <th>赎回状态</th>
        <th>赎回时间</th>
    </tr>
    </thead>
	<c:if test="${fn:length(list)!=0}">
		<c:forEach items="${list}"  var="fetch">
			<tr >
				<td>${fetch.fetchSeq}</td>
				<td>${fetch.fetchName}</td>
				<td>${fetch.fetchMoney}</td>
				<td>
					<c:if test="${fetch.fetchState=='0' }">失败</c:if>
					<c:if test="${fetch.fetchState=='1' }">成功</c:if>
				</td>
				<td>${fetch.fetchCreateTimeStr}</td>
			</tr>
		</c:forEach>
		<tr>
			<td ></td>
			<td >累计金额(元):</td>
			<td colspan="9">${sumMoney }</td>
		</tr>
    </c:if>
    <c:if test="${fn:length(list)==0}">
			<tr >
<!-- 		       <td>&nbsp;</td> -->
<!-- 		       <td></td> -->
<!-- 		       <td></td> -->
<!-- 		       <td></td> -->
<!-- 		       <td></td> -->
<!-- 		       <td></td> -->
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

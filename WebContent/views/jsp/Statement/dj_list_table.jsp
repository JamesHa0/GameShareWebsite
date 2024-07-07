<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
        <th>兑奖编号</th>
        <th>联系人姓名</th>
        <th>联系人手机号</th>
        <th>联系人地址</th>
        <th>兑换的奖品</th>
        <th>出资金额</th>
        <th>注册手机号</th>
        <th>注册用户的ID</th>
        <th>兑奖时间</th>
    </tr>
    </thead>
    <c:if test="${fn:length(list)!=0}">
    	<c:forEach items="${list}"  var="dj">
			<tr >
		       <td>${dj.djId}</td>
		       <td>${dj.djName}</td>
		       <td>${dj.djPhone}</td>
		       <td>${dj.djAddress}</td>
		       <td>${dj.djTitle}</td>
		       <td>${dj.djFundMoney }</td>
		       <td>${dj.djRegisterPhone}</td>
		       <td>${dj.djUserId }</td>
		       <td><fmt:formatDate value="${dj.djCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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

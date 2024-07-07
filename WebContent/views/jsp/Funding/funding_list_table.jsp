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
    	<th><input type="checkbox" onchange="checkAll();"></th>
        <th>手机号</th>
        <th>姓名</th>
        <th>理财产品</th>
        <th>出资金额</th>
        <th>出资时间</th>
        <th>冻结状态</th>
        <th>冻结时间</th>
        <th>上传状态</th>
        <th>上传时间</th>
    </tr>
    </thead>
    <c:if test="${fn:length(list)!=0}">
    	<c:forEach items="${list}"  var="user">
			<tr >
				<td align="right">
					<c:if test="${user.fundReqState=='2'  }">
						<input type="checkbox" name="cbox" value="${user.fundId }">
					</c:if>
				</td>
		       <td>${user.fundPhoneNo}</td>
		       <td>${user.fundName}</td>
		       <td>${user.fundProName}</td>
		       <td>${user.fundMoney}</td>
		       <td>${user.fundCreateTimeStr}</td>
		       <td>${user.fundStateDesc }</td>
		       <td>${user.fundFrostTimeStr}</td>
		       <td>${user.fundReqStateDesc }</td>
		       <td>${user.fundDeductTimeStr}</td>
		   </tr>
		</c:forEach>
		<tr>
			<td ></td>
			<td >累计金额(元):</td>
			<td colspan="8">${sumMoney }</td>
		</tr>
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

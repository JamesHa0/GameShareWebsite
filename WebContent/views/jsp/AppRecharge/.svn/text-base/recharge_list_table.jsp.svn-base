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
        <th>流水号</th>
        <th>富友账户</th>
        <th>姓名</th>
        <th>充值金额</th>
        <th>充值状态</th>
        <th>充值时间</th>
        <th>返回码</th>
        <th>返回码描述</th>
        <th>上传状态</th>
        <th>上传时间</th>
    </tr>
    </thead>
    <c:if test="${fn:length(list)!=0}">
    	<c:forEach items="${list}"  var="user">
			<tr >
			   <td>
				   	<c:if test="${user.isUploadSuccess=='2'  }">
						<input type="checkbox" name="cbox" value="${user.rechargeId }">
				    </c:if>
			   </td>
			   
		       <td>${user.rechargeSeq}</td>
		       <td>${user.rechargeFuiouLoginId}</td>
		       <td>${user.rechargeName}</td>
		       <td>${user.rechargeMoney}</td>
		       <td>
		       		<c:if test="${user.rechargeState=='0' }">失败</c:if>
		       		<c:if test="${user.rechargeState=='1' }">成功</c:if>
		       </td>
		       <td>${user.rechargeRespTimeStr}</td>
		       <td>${user.rechargeRespCode}</td>
		       <td>${user.rechargeRespDesc}</td>
		       <td>
		       		<c:if test="${user.isUploadSuccess=='0' }">未上传</c:if>
		       		<c:if test="${user.isUploadSuccess=='1' }">已上传</c:if>
		       		<c:if test="${user.isUploadSuccess=='2' }">上传失败</c:if>
		       </td>
		       <td>${user.rechargeUploadTimeStr}</td>
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
		       <td></td>
		   </tr>
    </c:if>
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

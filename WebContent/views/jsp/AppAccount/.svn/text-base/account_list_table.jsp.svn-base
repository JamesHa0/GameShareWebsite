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
        <th>开户姓名</th>
        <th>身份证号</th>
        <th>手机号</th>
        <th>开户状态</th>
        <th>开户时间</th>
        <th>上传状态</th>
        <th>上传时间</th>
    </tr>
    </thead>
    <c:if test="${fn:length(list)!=0}">
    	<c:forEach items="${list}"  var="user">
			<tr >
			   <td align="right">
					<c:if test="${user.accountIsUpload=='2'  }">
						<input type="checkbox" name="cbox" value="${user.accountId }">
					</c:if>
			   </td>
		       <td>${user.accountSeq}</td>
		       <td>${user.accountName}</td>
		       <td>${user.accountIdNo}</td>
		       <td>${user.accountPhoneNo}</td>
		       <td>
		       		<c:if test="${user.accountIsSuccess=='0' }">失败</c:if>
		       		<c:if test="${user.accountIsSuccess=='1' }">成功</c:if>
		       </td>
		       <td>${user.accountCreateTimeStr}</td>
		       <td>
		       		<c:if test="${user.accountIsUpload=='0' }">未上传</c:if>
		       		<c:if test="${user.accountIsUpload=='1' }">已上传</c:if>
		       		<c:if test="${user.accountIsUpload=='2' }">上传失败</c:if>
		       </td>
		       <td>${user.accountUploadTimeStr}</td>
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
		   </tr>
    </c:if>
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

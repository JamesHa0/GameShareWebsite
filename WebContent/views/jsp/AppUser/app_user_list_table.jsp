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
    	<th></th>
        <th>USERID</th>
        <th>手机号</th>
        <th>姓名</th>
        <th>身份证号</th>
        <th>用户名</th>
        <th>是否绑定</th>
        <th>注册时间</th>
        <th>注册来源</th>
        <th>推荐码</th>
    </tr>
    </thead>
	<c:if test="${fn:length(list)!=0}">
		<c:forEach items="${list}"  var="user">
			<tr onclick="checkOneByTr(this);" style="cursor: hand;">
				<td>
					<input type="checkbox"  name="cbox" value="${user.userId }">
				</td>
				<td>${user.userId}</td>
				<td>${user.userPhoneNo}</td>
				<td>${user.userName}</td>
				<td>${user.userIdCard}</td>
				<td>${user.userNo}</td>
				<td>${user.isBindDesc }</td>
				<td>${user.userCreateTimeStr}</td>
				<td>${user.userRegSourceDesc }</td>
				
				<td>${user.userYqm}</td>
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

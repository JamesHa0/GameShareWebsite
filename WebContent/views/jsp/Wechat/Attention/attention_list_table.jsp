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
        <th>昵称</th>
        <th>OPENID</th>
        <th>性别</th>
        <th>地址</th>
        <th>关注时间</th>
        <th>头像</th>
    </tr>
    </thead>
	<c:if test="${fn:length(list)!=0}">
		<c:forEach items="${list}"  var="user">
			<tr >
				<td>${user.attNickname}</td>
				<td>${user.attOpenId}</td>
				<td>
					<c:if test="${user.attSex=='1' }">男</c:if>
					<c:if test="${user.attSex=='2' }">女</c:if>
					<c:if test="${user.attSex!='1' && user.attSex!='2'}">--</c:if>
				</td>
				<td>${user.attAddress}</td>
				<td>${user.attSubscribeTimedateStr}</td>
				<td style="">
					<a href="${user.attHeadImgUrl }" target="_blank">
						<img alt="头像" src="${user.attHeadImgUrl }"style="width: 20px;height: 20px;">
					</a>
				</td>
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
		   </tr>
    </c:if>
</table>
</body>
<%@ include file="../../common/pageHiddenInfo.jsp" %>
</html>

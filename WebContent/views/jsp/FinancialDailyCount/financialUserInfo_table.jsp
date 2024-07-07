<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="crf.util.PageUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/tld/tyTag.tld" prefix="tyTag"%>
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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/page.css" />	
</head>
<style>
table {
	table-layout: fixed;
	word-break: break-all;
	word-wrap: break-word;
}
</style>
<body onload="initParentFrameHeight();">

	<table class="table table-bordered table-hover definewidth m10"
		id="table1">
		<thead>
			<tr>
				<th>用户名</th>
				<th>手机号</th>
				<th>邀请时间</th>
				<th>注册时间</th>
			</tr>
		</thead>
		<c:forEach items="${appUsersByYqm}" var="appUser">
			<tr>
				<td>${appUser.userName}</td>
				<td>${appUser.userPhoneNo}</td>
				<td>${appUser.userCreateTimeStr}</td>
				<td>${appUser.userRegisterDateStr}</td>
			</tr>
		</c:forEach>
	</table>

</body>

<%@ include file="../common/pageHiddenInfo.jsp"%>

</html>

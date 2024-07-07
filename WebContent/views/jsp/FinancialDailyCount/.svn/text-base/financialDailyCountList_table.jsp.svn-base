<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript">
		function showInfo(daily_code,daily_create_timeStr){
			if(daily_code!=null&&daily_code!=undefined && daily_code!=""){
				window.parent.location.href="<%=request.getContextPath()%>/financialDailyCount/showFinancialDailyCountInfo.do?daily_code="+daily_code+"&daily_create_timeStr="+daily_create_timeStr;
			}else{
				alert("理财师的用户邀请码不能为空");
			}
		}
	</script>
</head>
<script type="text/javascript">

</script>
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
				<th>手机号</th>
				<th>姓名</th>
				<th>工号</th>
				<th>邀请码</th>
				<th>状态</th>
				<th>日志创建时间</th>
				<th>所属地区</th>
				<th>邀请用户数</th>
				<th>邀请用户</th>
			</tr>
		</thead>
		<c:forEach items="${financialDailyCountList}" var="financialDailyCount">
			<tr>
				<td>${financialDailyCount.daily_phone}</td>
				<td>${financialDailyCount.daily_name}</td>
				<td></td>
				<td>${financialDailyCount.daily_code}</td>
				<td>
				 <c:choose>
						<c:when test="${financialDailyCount.daily_state=='1'}">
						禁用
						</c:when>
						<c:when test="${financialDailyCount.daily_state=='0'}">
						正常
						</c:when>
					</c:choose></td>
				<td>${financialDailyCount.daily_create_timeStr}</td>
				<td>${financialDailyCount.daily_location}</td>
				<td>${financialDailyCount.daily_user_count}</td>
				<td><a href="javascript:void('0');" onclick="showInfo('${financialDailyCount.daily_code}','${financialDailyCount.daily_create_timeStr}');">查看</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
<%@ include file="../common/pageHiddenInfo.jsp"%>
</html>

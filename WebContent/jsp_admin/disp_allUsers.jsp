<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示页面</title>
<link rel="stylesheet" type="text/css" href="css/disp_Student.css">

</head>
<body>
<%
//pageContext.setAttribute("allStudent", request.getAttribute("allStudent"));
%>
	<table>
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>学院</th>
		</tr>
		<c:forEach items="${allStudent }" var="i">
			<tr>
				<td>${i.sno }</td><!-- 切记：s小写 -->
				<td>${i.sname }</td>
				<td>${i.ssex }</td>
				<td>${i.sbir }</td>
				<td>${i.sinstitude }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
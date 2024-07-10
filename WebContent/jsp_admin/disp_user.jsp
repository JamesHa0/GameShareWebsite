<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示页面</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>姓名</th>
			<th>昵称</th>
			<th>手机号</th>
			<th>邮箱</th>
			<th>角色</th>
			<th>性别</th>
			<th>地址</th>
		</tr>
		     
		<tr>
			<td>${user.uid}</td>
			<td>${user.uname }</td>
			<td>${user.utel }</td>
			<td>${user.uemail }</td>
			<td>${user.urole }</td>
			<td>${user.ugender }</td>
			<td>${user.uaddress }</td>
		</tr>
	</table>
	<a href="jsp_admin/admin_query.jsp">返回</a>
</body>
</html>
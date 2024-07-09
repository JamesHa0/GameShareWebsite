<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退出登录</title>
</head>
<body>
	<%
		session.invalidate();
		request.setAttribute("userLogin_msg", "您已登出！请重新登录");
	%>
	<jsp:forward page="LR.jsp" />
</body>
</html>
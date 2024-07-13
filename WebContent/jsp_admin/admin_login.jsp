<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	// String path = request.getContextPath();
	// String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	// String flag=(String)request.getAttribute("flag");
%>

<!DOCTYPE HTML>
<html>
<head>
<title>欢迎登录游戏管理系统</title>
<!-- 	<link href="../views/Css/login/style.css" rel="stylesheet" type="text/css" /> -->
<link rel="stylesheet" type="text/css" href="../css/public.css" />
<link rel="stylesheet" type="text/css" href="../css/admin_login.css" />
<!--     <script language="JavaScript" src="../views/Js/login/jquery.js"></script> -->
<!--     <script src="../views/Js/login/cloud.js" type="text/javascript"></script> -->
</head>
<body>
	<div class="head">
		<div class="shouye_head">
			<a href="../index.jsp">返回首页</a>
		</div>
	</div>
	<div class="dowebok" id="dowebok">
		<div class="login-container">
			<h2>管理员登录</h2>
			<form action="../AdminServlet.do" method="post">
				<input type="text" name="utel" id="utel" placeholder="用户名" required style="width:250px"><br />
				<input type="password" name="upsw" id="upsw" placeholder="密码" required style="width:250px"><br />
				<img class="checkbox" src="../CheckCodeServlet" alt="验证码"><br />
				<input type="text" name="checkinput" id="checkinput" placeholder="请输入验证码" required><br />
				<button type="submit">点击登录</button>
			</form>
		</div>
	</div>


	<jsp:include page="../footer.html" flush="true" />
</body>
</html>

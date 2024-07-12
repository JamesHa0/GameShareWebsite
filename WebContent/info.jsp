<%@page import="sun.security.util.Length"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="game.bean.Game" %>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/game.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"
	charset="utf-8"></script>

</head>
<body>
	<div class="head">
		<div class="head_zi">
			<div class="huan">
				<a href="index.jsp">返回首页</a>
			</div>
			<div class="info">
				<a href="info.jsp"><img src="images/info.png" height="28px"></a>
			</div>
			<div class="login">
				<%
					String userName = (String)session.getAttribute("Login_uname");
					if(userName == null){
				%>
				<div class="login2">
					<a href="LR.jsp">登录&注册</a>
				</div>
				<%
					} else {
				%>
				<div class="ulogin">
					<p>欢迎您，${sessionScope.Login_uname}</p>
				</div>
				<div class="login2"><a href="logout.jsp">登出</a></div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<div class="dowebok" id="dowebok">
	
	
	
	
	
	</div>

	<jsp:include page="footer.html" flush="true" />
</body>
</html>


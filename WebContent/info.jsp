<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="game.bean.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/game.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
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
					String userName = (String) session.getAttribute("Login_uname");
					User user = (User) session.getAttribute("Login_user");
					if (user != null) {
						userName = user.getUname();
				%>
				<div class="ulogin">
					<p>欢迎您，${sessionScope.Login_uname}</p>
				</div>
				<div class="login2">
					<a href="logout.jsp">登出</a>
				</div>
				<%
					} else {
				%>
				<div class="login2">
					<a href="LR.jsp">登录&注册</a>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>


	<div class="dowebok" id="dowebok">
		<div class="showPurchase">
			<table border="0px" align="center">
				<tr>
					<th colspan="2">个人信息</th>
				</tr>
				<tr>
					<td>用户ID:</td>
					<td>${sessionScope.Login_user.uid }</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td>${sessionScope.Login_user.uname }</td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>${sessionScope.Login_user.ugender }</td>
				</tr>
				<tr>
					<td>注册手机号:</td>
					<td>${sessionScope.Login_user.utel }</td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td>${sessionScope.Login_user.uemail }</td>
				</tr>
				<tr>
					<td>拥有积分:</td>
					<td>${sessionScope.Login_user.upoint }</td>
				</tr>
				<tr>
					<td>购买的游戏</td>
					<td>${sessionScope.Login_user.uaddress }</td>
				</tr>
				<tr>
					<td>地址:</td>
					<td>${sessionScope.Login_user.uaddress }</td>
				</tr>
			</table>
		</div>



	</div>

	<jsp:include page="footer.html" flush="true" />
</body>
</html>


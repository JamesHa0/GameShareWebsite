<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="game.bean.Game"%>
<%@ page import="game.bean.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>购买结果</title>
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
		<%
			String onumber = (String) request.getAttribute("onumber");
			String gid = (String) request.getAttribute("gid");
			String upoint = user.getUpoint();
			String msg = (String) request.getAttribute("msg");
		%>
		<div class="showPurchase">
			<table border="0px" align="center">
				<tr>
					<th colspan="2">${msg }</th>
				</tr>
				<tr>
					<td>当前剩余积分：</td>
					<td><%=upoint%></td>
				</tr>
				<%
					if (onumber == null) {
				%>
				<tr>
					<td><a href="DetailServlet.do?gid=${gid }"><button class="myButton">返回游戏详情页</button></a></td>
					<td><a href="index.jsp"><button class="myButton">返回首页</button></a></td>
				</tr>
				<%
					} else {
				%>
				<tr>
					<td>订单号：</td>
					<td><%=onumber%></td>
				</tr>
				<tr>
					<td><a href="DetailServlet.do?gid=${gid }"><button class="myButton">返回游戏详情页</button></a></td>
					<td><a href="DownloadGameServlet.do?gid=${gid }"><button class="myButton">点击下载</button></a></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>



	<jsp:include page="footer.html" flush="true" />
</body>
</html>


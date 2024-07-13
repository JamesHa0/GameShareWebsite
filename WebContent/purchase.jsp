<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="game.bean.User" %>
<%@ page import="game.bean.Game" %>
<html>
<head>
<meta charset="UTF-8">
<title>购买页面</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/game.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"
	charset="utf-8"></script>

</head>
<body>
	<%	
		Game game = (Game)request.getAttribute("game");
		User user = (User)session.getAttribute("Login_user");
		String upoint = user.getUpoint();
	%>
	<div class="head">
		<div class="head_zi">
			<div class="huan">
				<a href="DetailServlet?gid=${game.gid }">返回游戏详情页</a>
			</div>
			<div class="info">
				<a href="info.jsp"><img src="images/info.png" height="28px"></a>
			</div>
			<div class="login">
				<%
					String userName = (String) session.getAttribute("Login_uname");
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
	<div class="gtitle">${game.gzhname }</div>
	<hr/>
	<div class="gcover">
		<img src="images/game/${game.gid }/1.jpg"/>
		<table border="0";align="center">
			<tr><td>游戏名：</td><td>${game.gname }</td></tr>
			<tr><td>价格：</td><td>${game.gprice }积分</td></tr>
			<% 	String onumber = (String)request.getAttribute("onumber");
				if(onumber == null){
			%>
			<tr><td>是否购买？<br/>(当前账户剩余积分:<%=upoint %>)</td><td><div id="steam"><a href="PurchaseServlet?gid=${game.gid }&uid=${Login_uid}"><img  src="images/yes.png"/></a></div></td></tr>
			<% }else{ %>
			<tr><td>是否购买？<br/>(当前账户剩余积分:<%=upoint %>)</td><td>您已购买此游戏</td></tr>
			<tr><td>订单编号:</td><td>${onumber }</td></tr>
			<tr><td>是否立即下载？</td><td><div id="steam"><a href=""><img  src="images/yes.png"/></a></div></td></tr>
			<% } %>
		</table>
	</div>
	
	
	</div>

	<jsp:include page="footer.html" flush="true" />
</body>
</html>

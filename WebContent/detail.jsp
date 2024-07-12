<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="game.bean.Game" %>
<html>
<head>
<meta charset="UTF-8">
<title>游戏详情</title>
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
	
	
	<% String message = (String) request.getAttribute("msg");
		if("gamenotfound".equals(message)){ 
	%>
	<div class="error">
		<img class="errorImg" src="images/gameNotFound.png" />
		<br/><br/>
		<span class="errorMsg">游戏不见了！</span>
	</div>
	<% } else {%>
	
	
	<div class="gtitle">${game.gzhname}</div>
	<hr/>
	<div class="gcover">
		<img src="images/game/${game.gid }/1.jpg"/>
		<table border="0">
			<tr><td>游戏名：</td><td>${game.gname}</td></tr>
			<tr><td>游戏类型：</td><td>${game.gtag}</td></tr>
			<tr><td>价格：</td>
			<% 	Game game = (Game)request.getAttribute("game");
				String gid=game.getGid();
				if (gid.length() < 9 ){ %>
			<td>${game.gprice}RMB</td></tr>
			<% }else{%>
			<td>${game.gprice}积分</td></tr>
			<% }%>
			<tr><td>制造商：</td><td>${game.gdeveloper }</td></tr>
			<tr><td>发行商：</td><td>${game.gpublisher }</td></tr>
			<tr><td>发行日期：</td><td>${game.grelease_date }</td></tr>
			<% if (gid.length() < 9 ){ %>
			<tr><td>在steam上购买：</td><td><div id="steam"><a href="https://store.steampowered.com/app/${game.gid }"><img  src="images/steam.png"/></a></div></td></tr>
			<% }else{%>
			<tr><td>使用${game.gprice}积分兑换：</td><td><div id="steam"><a href="QueryPurchaseServlet?gid=${game.gid }"><img  src="images/download.jpg"/></a></div></td></tr>
			<% }%>
		</table>
	</div>
	<div class="gdescription">
		<div class="description">游戏简介：</div>
		<div class="gtext">${game.gdescription }</div>
	</div>
	<div class="gimg">
		<img src="images/game/${game.gid }/2.jpg" />
		<img src="images/game/${game.gid }/3.jpg" />
		<img src="images/game/${game.gid }/4.jpg" />
		<img src="images/game/${game.gid }/5.jpg" />
	</div>
	<div class="icon">
		<table border="0px";align="center">
			<tr><td><img src="images/like.png"/></td>
			<td><img src="images/comment.png"/></td></tr>
			<tr><td>点赞量</td>
			<td>评论量</td></tr>
		</table>
	</div>
	<div class="gcomment">
		<div class="comment">玩家评论：</div>
		<div class="ucomment">${game.gdescription }</div>
	</div>
	
	
	
	<% }%>
	</div>

	<jsp:include page="footer.html" flush="true" />
</body>
</html>

<%@page import="sun.security.util.Length"%>
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
		<div class="shouye_head">
			<a href="index.jsp">返回首页</a>
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
			<tr><td>价格：</td><td>${game.gprice}RMB</td></tr>
			<tr><td>制造商：</td><td>${game.gdeveloper }</td></tr>
			<tr><td>发行商：</td><td>${game.gpublisher }</td></tr>
			<tr><td>发行日期：</td><td>${game.grelease_date }</td></tr>
			<% 	Game game = (Game)request.getAttribute("game");
				String gid=game.getGid();
				if (gid.length() < 9 ){ %>
			<tr><td>在steam上购买：</td><td><div id="steam"><a href="https://store.steampowered.com/app/${game.gid }"><img  src="images/steam.png"/></a></div></td></tr>
			<% }else{%>
			<tr><td>使用积分兑换：</td><td><div id="steam"><a href=#"><img  src="images/steam.png"/></a></div></td></tr>
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
		<table border="0px">
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

	<div class="footer">
		<div class="translate">
			<div class="footer-links">
				<h5>官方网站</h5>
				<ul>
					<li><a href="https://store.steampowered.com">steam官网</a></li>
					<li><a href="https://www.epicgames.com/site/zh-CN/home">Epic官网</a></li>
					<li><a href="https://www.origin.com">Origin官网</a></li>
					<li><a href="https://www.ubisoft.com/zh-tw">Ubisoft官网</a></li>
					<li><a href="https://www.wegame.com.cn">Wegame官网</a></li>
				</ul>
			</div>
			<div class="footer-links">
				<h5>游戏攻略</h5>
				<ul>
					<li><a href="https://www.3dmgame.com">3DM游戏网站</a></li>
					<li><a href="https://www.gamersky.com">游民星空</a></li>
					<li><a href="https://www.ucg.cn">游戏机实用技术</a></li>
					<li><a href="https://www.vgtime.com">游戏时光</a></li>
					<li><a href="https://nga.178.com">NGA</a></li>
					<li><a href="https://gl.ali213.net">游侠攻略</a></li>
				</ul>
			</div>
			<div class="footer-links">
				<h5>游戏MOD</h5>
				<ul>
					<li><a href="https://www.nexusmods.com">Nexus Mods</a></li>
					<li><a href="https://steamcommunity.com/workshop">steam创意工坊</a></li>
					<li><a href="https://mod.3dmgame.com">3DM Mod站</a></li>
					<li><a href="https://down.gamersky.com/oth/mod">游民星空下载站</a></li>
					<li><a href="https://patch.ali213.net/">游侠补丁</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>GameShareWebsite</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/front_page.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<%
		String user_id = request.getParameter("user_id");
	%>
	<div class="head">
		<div class="head_zi">
			<div class="huan">
				<p>GameShareWebsite</p>
			</div>
			<div class="info">
				<a href="info.jsp"><img src="images/info.png" height="28px"></a>
			</div>
			<div class="login">
				<%
					String userName = (String)session.getAttribute("uname");
					if(userName == null){
				%>
				<div>
					<a href="LR.jsp">登录&注册</a>
				</div>
				<%
					} else {
				%>
				<div>
					<p>欢迎您，${sessionScope.uname}</p>
				</div>
				<div><a href="logout.jsp">登出</a></div>
				<%
					}
				%>
			</div>

		</div>
	</div>
	<!--搜索框-->
	<div class="search_kuang">
		<div class="search">
			<input type="text" class="text">
			<button>
				<img src="images/search.png" width="40px">
			</button>
		</div>
	</div>
	<div class="shop">
		<div class="picture">
			<div class="picture-area">
				<ul id="item">
					<li class="item">
						<img src="images/game/1091500/1.jpg" >
					</li>
					<li class="item">
						<img src="images/game/1086940/1.jpg" >
					</li>
					<li class="item">
						<img src="images/game/1245620/1.jpg" >
					</li>
					<li class="item">
						<img src="images/game/1174180/1.jpg" >
					</li>
					<li class="item">
						<img src="images/game/2358720/1.jpg" >
					</li>
				</ul>
			</div>
			<div id="btn-left"><</div>
			<div id="btn-right">></div>
			<ul id="circle">
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
			</ul>
		</div>
		<div class="content">
		<div class="box_tit w">
				<h2 class="title">&emsp;本站游戏</h2>
				<div class="content_pohot">
					<ul>
						<li class="game_tu"><a href="DetailServlet?gid=phone01">
								<div class="ph">
									<img src="images/gameNotFound.png">
								</div>
								<div class="na">待定</div>
						</a></li>

						<li class="game_tu"><a href="DetailServlet?gid=phone02">
								<div class="ph">
									<img src="images/gameNotFound.png">
								</div>
								<div class="na">待定</div>
						</a></li>

						<li class="game_tu"><a href="DetailServlet?gid=phone03">
								<div class="ph">
									<img src="images/gameNotFound.png">
								</div>
								<div class="na">待定</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet?gid=phone04">
								<div class="ph">
									<img src="images/gameNotFound.png">
								</div>
								<div class="na">待定</div>
						</a></li>
					</ul>
				</div>
			</div>
			<div class="box_tit w">
				<h2 class="title">&emsp;近期推荐</h2>
				<div class="content_pohot">
					<ul>
						<li class="game_tu"><a href="DetailServlet?gid=2420110">
								<div class="ph">
									<img src="images/game/2420110/1.jpg">
								</div>
								<div class="na">地平线：西之绝境</div>
						</a></li>

						<li class="game_tu"><a href="DetailServlet?gid=1245620">
								<div class="ph">
									<img src="images/game/1245620/1.jpg">
								</div>
								<div class="na">艾尔登法环</div>
						</a></li>

						<li class="game_tu"><a href="DetailServlet?gid=1623730">
								<div class="ph">
									<img src="images/game/1623730/1.jpg">
								</div>
								<div class="na">幻兽帕鲁</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet?gid=2358720">
								<div class="ph">
									<img src="images/game/2358720/1.jpg">
								</div>
								<div class="na">黑神话：悟空</div>
						</a></li>
					</ul>
				</div>
			</div>
			<div class="box_tit w">
				<h2 class="title">&emsp;高分神作</h2>
				<div class="content_pohot">
					<ul>
						<li class="game_tu"><a href="DetailServlet?gid=205100">
								<div class="ph">
									<img src="images/game/205100/1.jpg">
								</div>
								<div class="na">耻辱系列</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet?gid=413410">
								<div class="ph">
									<img src="images/game/413410/1.jpg">
								</div>
								<div class="na">弹丸论破系列</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet?gid=49520">
								<div class="ph">
									<img
										src="images/game/49520/1.jpg">
								</div>
								<div class="na">无主之地2</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet?gid=268050">
								<div class="ph">
									<img src="images/game/268050/1.jpg">
								</div>
								<div class="na">恶灵附身</div>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="nav">
		<ul>
			<li class="current">手机</li>
			<li>电脑</li>
			<li>家居</li>
			<li>服饰</li>
			<div class="back">返回顶部</div>
		</ul>
	</div> -->

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

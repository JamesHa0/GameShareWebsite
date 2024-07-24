<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="game.bean.User"%>
<html>
<head>
<title>GameShareWebsite</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="head">
		<div class="head_zi">
			<!-- 网站名 -->
			<div class="huan">
				<p>GameShareWebsite</p>
			</div>
			<!-- 页眉（包括欢迎语/登录&注册，个人资料logo） -->
			<jsp:include page="header.jsp" />
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
	<!-- shop（商品栏） -->
	<div class="shop">
		<!-- 轮播图 -->
		<div class="picture">
			<div class="picture-area">
				<ul id="item">
					<li class="item"><img src="images/game/1091500/1.jpg">
					</li>
					<li class="item"><img src="images/game/1086940/1.jpg">
					</li>
					<li class="item"><img src="images/game/1245620/1.jpg">
					</li>
					<li class="item"><img src="images/game/1174180/1.jpg">
					</li>
					<li class="item"><img src="images/game/2358720/1.jpg">
					</li>
				</ul>
			</div>
			<div id="btn-left"></div>
			<div id="btn-right"></div>
			<ul id="circle">
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
			</ul>
		</div>
		<div class="content">
			<!-- 本站游戏 -->
			<div class="box_tit w">
				<h2 class="title">&emsp;本站游戏</h2>
				<div class="content_pohot">
					<ul>
						<li class="game_tu"><a href="DetailServlet.do?gid=100000001">
								<div class="ph">
									<img src="images/game/100000001/1.jpg">
								</div>
								<div class="na">植物大战僵尸</div>
						</a></li>

						<li class="game_tu"><a href="DetailServlet.do?gid=100000002">
								<div class="ph">
									<img src="images/game/100000002/1.jpg">
								</div>
								<div class="na">魔塔2023</div>
						</a></li>

						<li class="game_tu"><a href="DetailServlet.do?gid=0">
								<div class="ph">
									<img src="images/gameNotFound.png">
								</div>
								<div class="na">待定</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet.do?gid=0">
								<div class="ph">
									<img src="images/gameNotFound.png">
								</div>
								<div class="na">待定</div>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- steam站内游戏 -->
			<div class="box_tit w">
				<h2 class="title">&emsp;近期推荐</h2>
				<div class="content_pohot">
					<ul>
						<li class="game_tu"><a href="DetailServlet.do?gid=2420110">
								<div class="ph">
									<img src="images/game/2420110/1.jpg">
								</div>
								<div class="na">地平线：西之绝境</div>
						</a></li>

						<li class="game_tu"><a href="DetailServlet.do?gid=1245620">
								<div class="ph">
									<img src="images/game/1245620/1.jpg">
								</div>
								<div class="na">艾尔登法环</div>
						</a></li>

						<li class="game_tu"><a href="DetailServlet.do?gid=1623730">
								<div class="ph">
									<img src="images/game/1623730/1.jpg">
								</div>
								<div class="na">幻兽帕鲁</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet.do?gid=2358720">
								<div class="ph">
									<img src="images/game/2358720/1.jpg">
								</div>
								<div class="na">黑神话：悟空</div>
						</a></li>
					</ul>
				</div>
			</div>
			<!-- 也是steam站内游戏 -->
			<div class="box_tit w">
				<h2 class="title">&emsp;高分神作</h2>
				<div class="content_pohot">
					<ul>
						<li class="game_tu"><a href="DetailServlet.do?gid=205100">
								<div class="ph">
									<img src="images/game/205100/1.jpg">
								</div>
								<div class="na">耻辱系列</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet.do?gid=413410">
								<div class="ph">
									<img src="images/game/413410/1.jpg">
								</div>
								<div class="na">弹丸论破系列</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet.do?gid=49520">
								<div class="ph">
									<img src="images/game/49520/1.jpg">
								</div>
								<div class="na">无主之地2</div>
						</a></li>
						<li class="game_tu"><a href="DetailServlet.do?gid=268050">
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
	
	
	<!-- 页脚 -->
	<jsp:include page="footer.html"  />
</body>
</html>

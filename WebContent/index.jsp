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
<body onload="onload();">

	<!-- 页眉 -->
	<jsp:include page="header.jsp" />
	
	<!--搜索框-->
	<div class="search-bar">
		<input type="text" class="text">
		<button>
			<img src="images/search.png" width="40px">
		</button>
	</div>
	
	<!-- shop（商品栏） -->
	<article class="shop">
	
		<!-- 轮播图 -->
		<section class="picture">
			<div class="picture-area">
				<ul id="item" >
					<li class="item"><img src="images/game/1091500/1.jpg"></li>
					<li class="item"><img src="images/game/1086940/1.jpg"></li>
					<li class="item"><img src="images/game/1245620/1.jpg"></li>
					<li class="item"><img src="images/game/1174180/1.jpg"></li>
					<li class="item"><img src="images/game/2358720/1.jpg"></li>
				</ul>
			</div>
			<div id="btn-left">&lt;</div>
			<div id="btn-right">&gt;</div>
			<ul id="circle">
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
				<li class="circle"></li>
			</ul>
		</section>
		
		<!-- 游戏一览 -->
		<section class="content">
			<!-- 本站游戏 -->
			<div class="game-box">
				<h2 class="title">&emsp;本站游戏</h2>
			    <section class="game-gallery">
			        <article class="game-item">
		               <figure>
				            <a href="DetailServlet.do?gid=100000001"  onclick="click_forLoading()">
				            	<img src="images/game/100000001/1.jpg" alt="植物大战僵尸">
				            </a>
		                    <figcaption>植物大战僵尸</figcaption>
		               </figure>
			        </article>
			        <article class="game-item">
		                <figure>
		            		<a href="DetailServlet.do?gid=100000002" onclick="click_forLoading()">
		                    	<img src="images/game/100000002/1.jpg" alt="魔塔2023">
		                    </a>
		                    <figcaption>魔塔2023</figcaption>
		                </figure>
			        </article>
			        <article class="game-item game-not-found">
			            <figure>
			            	<a href="DetailServlet.do?gid=0"  onclick="click_forLoading()">
			                	<img src="images/gameNotFound.png" alt="游戏图片未找到">
			                </a>
			                <figcaption>待定</figcaption>
			            </figure>
			        </article>
			        <article class="game-item game-not-found">
			            <figure>
			            	<a href="DetailServlet.do?gid=0"  onclick="click_forLoading()">
			                	<img src="images/gameNotFound.png" alt="游戏图片未找到">
			                </a>
			                <figcaption>待定</figcaption>
			            </figure>
			        </article>
			    </section>
			</div>
			
			<!-- steam站内游戏 -->
			<div class="game-box">
				<h2 class="title">&emsp;近期推荐</h2>
				<section class="game-gallery">
					<article class="game-item">
						<figure>
							<a href="DetailServlet.do?gid=2420110" onclick="click_forLoading()">
								<img src="images/game/2420110/1.jpg">
							</a>
							<figcaption>地平线：西之绝境</figcaption>
						</figure>
					</article>
					<article class="game-item">
						<figure>
							<a href="DetailServlet.do?gid=1245620" onclick="click_forLoading()">
								<img src="images/game/1245620/1.jpg">
							</a>
							<figcaption>艾尔登法环</figcaption>
						</figure>
					</article>
					<article class="game-item">
						<figure>
							<a href="DetailServlet.do?gid=1623730" onclick="click_forLoading()">
								<img src="images/game/1623730/1.jpg">
							</a>
							<figcaption>幻兽帕鲁</figcaption>
						</figure>
					</article>
					<article class="game-item">
						<figure>
							<a href="DetailServlet.do?gid=2358720" onclick="click_forLoading()">
								<img src="images/game/2358720/1.jpg">
							</a>	
							<figcaption>黑神话：悟空</figcaption>
						</figure>
					</article>
				</section>
			</div>
			<!-- 也是steam站内游戏 -->
			<div class="game-box">
				<h2 class="title">&emsp;高分神作</h2>
				<section class="game-gallery">
						<article class="game-item">
							<figure>
								<a href="DetailServlet.do?gid=205100" onclick="click_forLoading()">
									<img src="images/game/205100/1.jpg">
								</a>	
								<figcaption>耻辱系列</figcaption>
							</figure>
						</article>
						<article class="game-item">
							<figure>
								<a href="DetailServlet.do?gid=413410" onclick="click_forLoading()">
									<img src="images/game/413410/1.jpg">
								</a>	
								<figcaption>弹丸论破系列</figcaption>
							</figure>
						</article>
						<article class="game-item">
							<figure>
								<a href="DetailServlet.do?gid=49520" onclick="click_forLoading()">
									<img src="images/game/49520/1.jpg">
								</a>	
								<figcaption>无主之地2</figcaption>
							</figure>
						</article>
						<article class="game-item">
							<figure>
								<a href="DetailServlet.do?gid=268050" onclick="click_forLoading()">
									<img src="images/game/268050/1.jpg">
								</a>	
								<figcaption>恶灵附身</figcaption>
							</figure>
						</article>
				</section>
			</div>
		</section>
		
	</article>
	
	
	<!-- 页脚 -->
	<jsp:include page="footer.html"  />
	
</body>

</html>

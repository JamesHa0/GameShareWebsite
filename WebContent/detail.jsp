<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="game.bean.Game" %>
<%@ page import="game.bean.User" %>
<html>
<head>
<meta charset="UTF-8">
<title>游戏详情</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/detail.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/detail.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
	<div class="head">
		<div class="head_zi">
			<!-- 返回按钮 -->
			<div class="huan">
				<a href="index.jsp" onclick="click_forLoading()">返回首页</a>
			</div>
			<!-- 页眉 -->
			<jsp:include page="header.jsp"/>
		</div>
	</div>
	
	<!-- 正文 -->
	<article class="dowebok" id="dowebok">
		<!-- 封面、参数、价格等 -->
		<c:choose>
			<c:when test="${requestScope.game==null }" >
				<div class="error">
					<img class="errorImg" src="images/gameNotFound.png" alt="游戏不见了"/>
					<br><br>
					<span class="errorMsg">游戏不见了！</span>
					<br><br>
				</div>
			</c:when>
			<c:otherwise>
				<div class="gtitle">${game.gzhname}</div>
				<hr/>
				<div class="gcover">
					<img src="images/game/${game.gid }/1.jpg"/>
					<table style="border:0">
						<!-- 基本游戏信息 -->
						<tr><td>游戏名：</td><td>${game.gname}</td></tr>
						<tr><td>游戏类型：</td><td>${game.gtag}</td></tr>
						<tr><td>价格：</td>
							<td>
								<c:if test="${game.gid.length()<9 }">
									${game.gprice}RMB
								</c:if>
								<c:if test="${game.gid.length()>=9 }">
									${game.gprice}积分
								</c:if>
							</td>
						</tr>
						<tr><td>制造商：</td><td>${game.gdeveloper }</td></tr>
						<tr><td>发行商：</td><td>${game.gpublisher }</td></tr>
						<tr><td>发行日期：</td><td>${game.grelease_date }</td></tr>
						<!-- 购买&下载按钮： -->
						<c:choose>
							<c:when test="${game.gid.length()<9 }">
								<!-- steam外站下载业务 -->
								<tr>
									<td>在steam上购买：</td>
									<td>
										<div id="steam"><a href="https://store.steampowered.com/app/${game.gid }" onclick="click_forLoading()">
										<img  src="images/steam.png"/></a></div>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<!-- 本站游戏下载业务 -->
								<c:if test="${purchase == null }"><!-- 尚未购买 -->
									<tr>
										<td>是否购买？<br/>（剩余积分:${user.upoint }）</td>
										<td><div id="steam"><a href="PurchaseServlet.do?gid=${game.gid }&uid=${Login_uid}" onclick="click_forLoading()">
										<img  src="images/yes.png"/></a></div></td>
									</tr>
								</c:if>
								<c:if test="${purchase != null }"><!-- 业已购买 -->
									<tr>
										<td>购买情况：</td>
										<td>您已购买此游戏</td>
									</tr>
									<tr>
										<td>订单编号:</td>
										<td>${purchase.onumber }</td>
									</tr>
									<tr>
										<td>是否立即下载？</td>
										<td><div id="steam"><a href="DownloadGameServlet.do?gid=${game.gid }">
										<img  src="images/yes.png"/></a></div></td>
									</tr>
								</c:if>
							</c:otherwise>
						</c:choose>	
					</table>
				</div>
		<!-- 游戏简介及内容截屏 -->
		<section class="gdescription">
			<div class="description">游戏简介：</div>
			<div class="gtext">${game.gdescription }</div>
		</section>
		<section class="gimg">
			<img src="images/game/${game.gid }/2.jpg" />
			<img src="images/game/${game.gid }/3.jpg" />
			<img src="images/game/${game.gid }/4.jpg" />
			<img src="images/game/${game.gid }/5.jpg" />
		</section>
		<!-- 游戏的点赞和评论 -->
		<section class="icon">
			<table>
				<tr>
					<td><img onclick="click_like(this,${user.uid},${game.gid })" src="images/like${isLiked? '_yes': '' }.png"/></td>
					<td><img onclick="click_comment(this)" src="images/comment.png"/></td>
				</tr>
				<tr>
					<td id="td_likeNum">${likeNum }</td>
					<td>${allComments.size() }</td>
				</tr>
			</table>
		</section>
		<!-- 评论模块 --><br><br><br>
		<section class="comment-module" style="display:none">
				<!-- 标题 -->
			<div class="comment-header">玩家评论：</div>
				<!-- 评论发表文本框 -->
			<div class="comment-input">
		        <h2>发表评论</h2>
		        <form onsubmit="return submit_comment(this,'${user.uid}','${game.gid }', &quot;${user.uname }&quot;)"  ><!-- 注意这里要用&quot;（双引号符） -->
		            <textarea id="comment-textarea" name="comment" placeholder="写下你的评论..." required></textarea>
		            <div><button type="submit">提交评论</button></div>
        		</form>
  			</div>
  				<!-- 评论区 -->
			<div class="comments">
					<!-- 无评论时显示的沙发图案 -->
				<c:if test="${empty allComments }"><img id="sofa" src="images/sofa.png" draggable="false"></c:if>
					<!-- 循环遍历所有评论 -->
				<c:forEach items="${allComments }" var="comment">
					<!-- 单条评论（single-comment） -->
			        <c:set var="sharpNum" value="${fn:length(comment.cpath) - fn:length(comment.cpath.replace('#', ''))}" /><!-- sharpNum 指#号的数量 -->	
					<c:set var="sharpNum" value="${sharpNum>4? 4: sharpNum }" />
					<div class="comment-container" style="padding-left:${20+sharpNum * 60}px">	    
					    <!-- 评论者和日期 -->
					    <span class="comment-uname">${comment.uname} :</span>
					    <span class="comment-ctime">[${comment.ctime}]</span>
					    <!-- 评论的点赞和回复图标 -->
					    <img id="comment-like"  onclick="click_comment_like(this,  
							${comment.cid},${comment.gid},&quot;${comment.cpath}&quot; ,${comment.clike } )"  
							src="images/comment_like${isLikedComment? '_yes': '' }.png"/>
					    <span class="comment-likeNum"  >${comment.clike == 0 ? "" : comment.clike }</span>
					    <img id="comment-reply" onclick="click_comment_reply(this,  
							${comment.cid},${comment.gid}, &quot;${comment.cpath}&quot; , &quot;${comment.uname }&quot; )"  
							src="images/comment_reply.png"/>
					    <!-- 评论内容 -->
					    <p style="display:block" class="comment-text"> ${comment.comment }</p>
					</div>
				</c:forEach>
			</div>
		</section>

			</c:otherwise>
		</c:choose>
	</article>
	
	<!-- 页脚 -->
	<jsp:include page="footer.html"  />
	

</body>
</html>

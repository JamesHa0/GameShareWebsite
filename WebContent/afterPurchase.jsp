<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="game.bean.Game"%>
<%@ page import="game.bean.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>购买结果详情页</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/afterPurchase.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

	<!-- 页眉 -->
	<jsp:include page="header.jsp"/>

	<div class="dowebok" id="dowebok">
		<div class="showPurchase">
			<table style="border:0 ;text-align:center">
				<tr>
					<th colspan="2">${msg }</th>
				</tr>
				<tr>
					<td>购买后剩余积分：</td>
					<td>${upoint }</td>
				</tr>
				<tr>
					<td>订单号：</td>
					<td>${onumber }</td>
				</tr>
				<tr>
					<td>
						<a href="DetailServlet.do?gid=${gid }">
						<button class="myButton" onclick="click_forLoading()">返回游戏详情页</button></a>
					</td>
					<td>
						<a href="DownloadGameServlet.do?gid=${gid }">
						<button class="myButton" >点击下载</button></a>
					</td>
				</tr>
			</table>
		</div>
	</div>


	<!-- 页脚 -->
	<jsp:include page="footer.html"/>
	
</body>
</html>


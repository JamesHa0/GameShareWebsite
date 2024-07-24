<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="game.bean.User"%>
<%@ page import="game.bean.GameLog"%>
<html>
<head>
<meta charset="UTF-8">
<title>购买记录</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/info.css" /><!-- 借用css -->
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"
	charset="utf-8"></script>

</head>
<body>
	<div class="head">
		<div class="head_zi">
			<!-- 返回按钮 -->
			<div class="huan">
				<a href="index.jsp">返回首页</a>
			</div>
			<!-- 页眉 -->
			<jsp:include page="header.jsp"/>
		</div>
	</div>


	<div class="dowebok" id="dowebok">
		<div class="new_table">
			<table>
				<tr>
					<td class="table_head" style="width: 200px;height: 60px;">游戏名</td>
					<td class="table_head" style="width: 200px;height: 60px;">所需积分</td>
					<td class="table_head" style="width: 200px;height: 60px;">购买时间</td>
					<td class="table_head" style="width: 200px;height: 60px;">订单编号</td>
				</tr>
				<c:forEach items="${gameLogList}" var="log">
					<tr>
						<td>${log.gzhname}</td>
						<td>${log.gprice}</td>
						<td>${log.otime}</td>
						<td>${log.onumber}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4"><a href="QueryInfoServlet.do">返回</a></td>
				</tr>
			</table>
		</div>



	</div>
	<!-- 页脚 -->
	<jsp:include page="footer.html"  />
</body>
</html>


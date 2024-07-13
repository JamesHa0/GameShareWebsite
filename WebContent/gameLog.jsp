<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="game.bean.User"%>
<%@ page import="game.bean.GameLog"%>
<html>
<head>
<meta charset="UTF-8">
<title>购买记录</title>
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
				<script>window.location.href = "LR.jsp";</script>
				<%
					}
				%>
			</div>
		</div>
	</div>


	<div class="dowebok" id="dowebok">
		<div class="new_table">
			<table>
				<thead>
					<td class="table_head" style="width: 200px;height: 60px;">游戏名</td>
					<td class="table_head" style="width: 200px;height: 60px;">购买时间</td>
					<td class="table_head" style="width: 200px;height: 60px;">订单编号</td>
				</thead>
				<c:forEach items="${gameLogList}" var="log">
					<tr>
						<td>${log.gzhname}</td>
						<td>${log.otime}</td>
						<td>${log.onumber}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3"><a href="info.jsp">返回</a></td>
				</tr>
			</table>
		</div>



	</div>

	<jsp:include page="footer.html" flush="true" />
</body>
</html>


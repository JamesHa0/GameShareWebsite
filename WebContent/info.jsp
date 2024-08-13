<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="game.bean.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="http://game.com/mytags" %>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/info.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/info.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
	<!-- 页眉 -->
	<jsp:include page="header.jsp"/>


	<div class="dowebok" id="dowebok">
		<div class="new_table">
			<table>
				<tr>
					<td class="table_head" colspan="2" style="width: 600px;height: 60px;">个人信息</td>
				</tr>
				<tr>
					<td>用户ID:</td>
					<td>${Info_user.uid }</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td>${Info_user.uname }</td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>${Info_user.ugender }</td>
				</tr>
				<tr>
					<td>注册手机号:</td>
					<td>${Info_user.utel }</td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td>${Info_user.uemail }</td>
				</tr>
				<tr>
					<td>拥有积分:</td>
					<td>&emsp;&emsp;&emsp;<span class="pointNum">${Info_user.upoint }</span>&emsp;&emsp;&emsp;
					<span class="checkin"  onclick='click_checkin(${my:toJson(Info_user)})'  style="user-select: none;">点此签到</span></td>
				</tr>
				<tr>
					<td>购买的游戏:</td>
					<td><a href='QueryUserGameLogServlet.do?uid=${Info_user.uid }' onclick="click_forLoading()">点此查看已购买的游戏</a></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td>${Info_user.uaddress }</td>
				</tr>
			</table>
		</div>



	</div>

	<jsp:include page="footer.html" flush="true" />
</body>
</html>


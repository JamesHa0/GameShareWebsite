<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="game.bean.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/info.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"
	charset="utf-8"></script>
	
<%
User user=(User)request.getAttribute("Info_user");
System.out.println("info.jsp中："+user);
%>

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
					<td>&emsp;&emsp;&emsp;${Info_user.upoint }&emsp;&emsp;&emsp;<a href="#">点此签到</a></td>
				</tr>
				<tr>
					<td>购买的游戏:</td>
					<td><a href='QueryUserGameLogServlet.do?uid=${Info_user.uid }'>点此查看已购买的游戏</a></td>
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


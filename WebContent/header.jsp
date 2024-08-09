<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>页眉</title>
<link rel="stylesheet" type="text/css" href="css/header.css" />
<script src="js/header.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<!-- 小猪loading -->
	<iframe src="小猪loading.html" id="loadingFrame" style=
	"display: none;width:100%;height:100%;border:none;
	position: fixed;z-index: 1000;"></iframe>

			<%
			//从Cookie获取当前登录者信息：
	        String Login_uid = "0";
	        String Login_uname = "获取cookie（Login_uname）失败";
	        String Login_urole = "获取cookie（Login_urole）失败";
	        Cookie[] cookie=request.getCookies();
	        if(cookie !=null) {
	        	for(Cookie c:cookie) {
	        		if("Login_uid".equals(c.getName())) {
	        			Login_uid=c.getValue();
	        		}else if("Login_uname".equals(c.getName())) {
	        			Login_uname=c.getValue();
	        		}else if("Login_urole".equals(c.getName())) {
	        			Login_urole=c.getValue();
	        		}
	        	}
	        }
			%>
			
			<!-- info（个人信息） -->
			<div class="info">
				<img src="images/info.png" height="28px" title="个人资料" onclick="click_forLoading()">
			</div>
			<!-- 登录&注册按钮 -->
			<div class="login">
				<%
				if ("0".equals(Login_uid)) {
					%><div class="login2"><a href="LR.jsp"  onclick="click_forLoading()" >登录﹠注册</a></div><%
				} else {%>
					<div class="ulogin" title="<%=Login_uname %>"><p>欢迎您，<%=Login_uname %></p></div>
					<div class="login2"><a href="LogoutServlet.do" onclick="click_forLoading()">登出</a></div>
				<%}%>
			</div>
</body>
</html>
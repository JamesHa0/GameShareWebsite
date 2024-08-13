<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
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
	
	
	
	<!-- 页眉 -->
	<div class="header">
			<!-- 左侧文本 -->
			<div class="left-text"  onclick="click_forLoading()">
			<!-- 判断uri，若为index页面则发生修改 -->
			<c:choose>
				<c:when test="${fn:endsWith(pageContext.request.servletPath,'index.jsp')}">
					<p>GameShareWebsite（点击测试小猪loading）</p>
				</c:when>
				<c:otherwise>
					<a href="index.jsp" onclick="click_forLoading()">返回首页</a>
				</c:otherwise>
			</c:choose>
			</div>
			<!-- 个人资料logo-->
			<div class="info">
				<img src="images/info.png" height="28px" title="个人资料" onclick="click_forLoading()">
			</div>
			<!-- 右侧文本 -->
			<div class="right-text">
			<c:choose>
				<c:when test="${empty cookie.Login_uid.value }">
					<!-- 账户操作 -->
					<div class="account">
						<a href="LR.jsp"  onclick="click_forLoading()" >登录﹠注册</a>
					</div>
				</c:when>
				<c:otherwise>
					<!-- 欢迎语 -->
					<p class="hello" title="${cookie.Login_uname.value }">欢迎您，${cookie.Login_uname.value }</p>
					<!-- 账户操作 -->
					<div class="account">
						<a href="LogoutServlet.do" onclick="click_forLoading()">登出</a>
					</div>
				</c:otherwise>
			</c:choose>
			</div>
	</div>
</body>
</html>
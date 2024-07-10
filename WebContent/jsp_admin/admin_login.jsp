<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
// String path = request.getContextPath();
// String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// String flag=(String)request.getAttribute("flag");
%>

<!DOCTYPE HTML>
<html>
<head>
<title>
	欢迎登录游戏管理系统
</title>
<!-- 	<link href="../views/Css/login/style.css" rel="stylesheet" type="text/css" /> -->
    <link rel="stylesheet" href="../css/page_login.css">
<!--     <script language="JavaScript" src="../views/Js/login/jquery.js"></script> -->
<!--     <script src="../views/Js/login/cloud.js" type="text/javascript"></script> -->
</head>
<body style="background-color: #1c77ac;
		background-repeat: no-repeat; background-position: center top; 
		overflow: hidden;" onload="init();">
    <div id="mainBody">
        <div id="cloud1" class="cloud"></div>
        <div id="cloud2" class="cloud"></div>
    </div>
    <div class="logintop">
        <span>游戏后台管理系统</span>
        <ul>
            <li><a href="#">回首页</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
        </ul>
    </div>
    
    
<div class="container">
    <div class="Login">
        <h2>Login Page</h2>
    </div>
    <form class="InputAndButton" action="../AdminServlet.do" method="post">
        <label for="utel">用户名：</label>
        <input type="text" id="utel" name="utel" 
        	value="${param.UserName}" required>

        <label for="upsw">密码：</label>
        <input type="password" id="upsw" name="upsw" maxlength="18"  placeholder="" required>

        <label for="checkinput">验证码：</label><img class="checkbox" src="../CheckCodeServlet" alt="验证码"><br>
        <input class="input" type="text" name="checkinput" id="checkinput" required><br>
        
        
        <button type="submit">点击登录</button>
    </form>
</div>
    
    


    <div class="loginbm">
       	2组&nbsp;&nbsp;&nbsp;&nbsp;责任无限公司 
    </div>
</body>
</html>

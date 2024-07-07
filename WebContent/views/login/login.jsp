<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String flag=(String)request.getAttribute("flag");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>
	欢迎登录后台管理系统
</title>
	<link href="<%=path %>/views/Css/login/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="<%=path %>/views/Js/login/jquery.js"></script>
    <script src="<%=path %>/views/Js/login/cloud.js" type="text/javascript"></script>
    <script language="javascript">
        $(function () {
            $('.loginbox').css({ 'position': 'absolute', 'left': ($(window).width() - 692) / 2 });
            $(window).resize(function () {
                $('.loginbox').css({ 'position': 'absolute', 'left': ($(window).width() - 692) / 2 });
            });
        }); 
        function init(){
    		document.forms[0].username.focus();
    		if("1"==<%=flag %>){
    			alert("用户不存在或密码错误");
    		}else if("2"==<%=flag %>){
    			alert("该用户已被禁用");
    		}else if("3"==<%=flag %>){
    			alert("用户名为 "+'${hasLoginUname}'+" 的用户已经在该机器登录，请换台机器再试");
    		}
    	}
        function submitForm(){
        	document.form1.action="<%=path%>/pc_LoginController.do?login";
			document.form1.submit();
			return false;
		}
   	 </script>
</head>
<body style="background-color: #1c77ac;
/*  background-image: url(http://admin.cxso.cn/manage/images/light.png);  */
		background-repeat: no-repeat; background-position: center top; 
		overflow: hidden;" onload="init();">
    <form name="form1" method="post" action=""
			onsubmit="return submitForm()" id="form1">
    <div id="mainBody">
        <div id="cloud1" class="cloud"></div>
        <div id="cloud2" class="cloud"></div>
    </div>
    <div class="logintop">
        <span>欢迎登录移动理财后台管理系统</span>
        <ul>
            <li><a href="#">回首页</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
        </ul>
    </div>
    <div class="loginbody">
<!--         <span class="systemlogo"></span> -->
        <div class="loginbox">
            <ul>
                <li>
                    <input name="username" type="text" id="username" class="loginuser" />
                </li>
                <li>
                    <input name="password" type="password" id="password" class="loginpwd" />
                </li>
                <li>
                    <input type="submit" name="button"  value="登录"  class="loginbtn" />
                </li>
            </ul>
        </div>
    </div>
    <div class="loginbm">
       	上海信而富&nbsp;&nbsp;&nbsp;&nbsp;版权所有 2015 
    </div>
</form>
</body>
</html>

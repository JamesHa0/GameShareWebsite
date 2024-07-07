<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String backstage=request.getContextPath()+"/views/backstage";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/views/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/views/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/views/assets/css/main-min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/views/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/views/assets/js/bui-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/views/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/views/assets/js/config-min.js"></script>
</head>
<body>
	<div style="height: 63px; width: 100%; background-image: url(views/Images/bg01.gif);">
		<img alt="logo" width="475px;" src="views/Images/logo.jpg">
	</div>
	<div class="header">
		<div class="dl-log">
			<span class="dl-log-user">欢迎您，${sessionScope.user.realname }</span>
			<span><a href="javascript:void('0');" onclick="logOut('${sessionScope.user.username }');" title="退出系统" class="dl-log-quit">[退出系统]</a></span>	
		</div>
	</div>
	<div >
		<ul id="J_NavContent" class="dl-tab-conten"></ul>
	</div>
	<script>
	    BUI.use('common/main',function(){
	      var config = <%=request.getAttribute("json")%>;
	      new PageUtil.MainPage({
	        modulesConfig : config
	      });
	    });
  </script>
  <script type="text/javascript">
  	function logOut(username){
  		if(confirm("确定退出吗?")){
  			window.location.href="pc_SystemController.do?logOut&username="+username;
  		}
  	}
  </script>
</body>
</html>

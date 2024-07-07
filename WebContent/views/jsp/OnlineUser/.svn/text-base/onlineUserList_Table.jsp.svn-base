<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="crf.system.entity.UserBean"%>
<%@page import="crf.system.entity.OnlineUsers"%>
<%@ page isELIgnored="false"%>
<%-- <%
// 	Map<String, OnlineUsers> map=(Map<String, OnlineUsers>)request.getAttribute("map");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js" ></script>
</head>
<script type="text/javascript">
	function updateUser(username){
		if(confirm("确定将该用户断开连接？")){
			window.parent.location.href="pc_SystemController.do?rejectUser&username="+username;
		}
	}
</script>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>序号</th>
        <th>用户名</th>
        <th>姓名</th>
        <th>登录ip</th>
        <th>登录时间</th>
        <th>最后操作时间</th>
        <th>sessionId</th>
        <th>操作</th>
    </tr>
    </thead>
     <%
     	int i=0;
 		for(String key : OnlineUsers.sessionMap.keySet()){
			OnlineUsers oper = OnlineUsers.sessionMap.get(key);
 			UserBean ub=(UserBean)oper.getUb();
 			out.print("<tr>");
 			out.print("<td>"+(++i)+"</td>");
 			out.print("<td>"+ub.getUsername()+"</td>");
 			out.print("<td>"+ub.getRealname()+"</td>");
 			out.print("<td>"+ub.getLast_login_ip()+"</td>");
 			out.print("<td>"+ub.getLast_login_time()+"</td>");
 			out.print("<td>"+oper.getLastAccessedTime()+"</td>");
 			out.print("<td>"+oper.getSession().getId()+"</td>");
 			out.print("<td>");
 			out.print("<a href='javascript:void('0');' onclick=\"updateUser('"+ub.getUsername()+"');\">断开连接</a>");
 			out.print("</td>");
 			out.print("</tr>");
 		}
	%> 
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

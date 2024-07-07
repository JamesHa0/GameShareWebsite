<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
</head>
<script type="text/javascript">
	function updateUser(username){
		window.parent.location.href="pc_SystemController.do?addOrUpdateUser&flag=update&username="+username;
	}
	function closeOrOpen(username,is_enable){
		var desc="确定禁用该用户吗？";
		if(is_enable=="0"){
			desc="确定启用该用户吗？";
		}
		if(confirm(desc)){
			window.parent.location.href="pc_SystemController.do?closeOrOpenUser&is_enable="+is_enable+"&username="+username;
		}
	}
	function allotRoles(username,realname){
		window.parent.location.href="pc_SystemController.do?allotRoles&username="+username+"&realname="+realname;
	}
</script>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>用户名</th>
        <th>真实姓名</th>
        <th>手机</th>
        <th>邮箱</th>
        <th>状态</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${userList}"  var="user">
     <tr >
           <td >${user.username}</td>
           <td>${user.realname}</td>
           <td>${user.mobile}</td>
           <td>${user.email}</td>
           <td>${user.is_enable_desc }</td>
           <td>${user.createname }</td>
           <td>${user.createtime }</td>
           <td>
               <a href="javascript:void('0');" onclick="updateUser('${user.username}');">编辑</a> 
               <a href="javascript:void('0');" onclick="closeOrOpen('${user.username}','${user.is_enable }');">
               	<c:if test="${user.is_enable=='1' }">禁用</c:if>
               	<c:if test="${user.is_enable=='0' }">启用</c:if>	
               </a>
               <a href="javascript:void('0');" onclick="allotRoles('${user.username}','${user.realname }');">分配角色</a>     
           </td>
       </tr>
      </c:forEach>	
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

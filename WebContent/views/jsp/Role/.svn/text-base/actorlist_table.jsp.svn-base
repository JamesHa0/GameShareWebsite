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
	<script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js" ></script>
</head>
<script type="text/javascript">
	function updateUser(username){
		window.parent.location.href="pc_SystemController.do?addOrUpdateActor&flag=update&actor_no="+username;
	}
	function allotOperation(actor_no,actor_name){
		window.parent.location.href="pc_SystemController.do?allotOperation&actor_no="+actor_no+"&actor_name="+actor_name;
	}
</script>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1" >
    <thead>
    <tr>
        <th>角色编号</th>
        <th>角色名称</th>
        <th>角色描述</th>
        <th>状态</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${userList}"  var="user">
     <tr >
           <td>${user.actor_no}</td>
           <td>${user.actor_name}</td>
           <td>${user.actor_desc}</td>
           <td>${user.is_enable_desc }</td>
           <td>${user.createname }</td>
           <td>${user.createtime }</td>
           <td>
               <a href="javascript:void('0');" onclick="updateUser('${user.actor_no}');">编辑</a> 
               <a href="javascript:void('0');" onclick="allotOperation('${user.actor_no}','${user.actor_name }');">分配权限</a> 
           </td>
       </tr>
      </c:forEach>	
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

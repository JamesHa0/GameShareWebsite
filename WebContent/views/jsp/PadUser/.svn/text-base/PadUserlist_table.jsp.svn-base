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
	//编辑pad用户
	function updateUser(padUname){
		window.parent.location.href = "pc_ParamSetController.do?addOrUpdatePadUser&flag=update&padUname="+padUname;
	}
	//删除pad用户
	function deleteUser(padUname) {
		if(window.confirm("确认删除该用户么？"))
		window.parent.location.href = 
			"pc_ParamSetController.do?delPadUserByNo&padUname=" + padUname;
	}
</script>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1" >
    <thead>
	    <tr>
	        <th>PAD用户名</th>
	        <th>所属分组</th>
	        <th>状态</th>
	        <th>创建人</th>
	        <th>创建时间</th>
	        <th>操作</th>
	    </tr>
    </thead>
    <c:forEach items="${userList}"  var="user">
	    <tr >
	           <td>${user.padUname}</td>
	           <td>${user.group_name}</td>
	           <td>${user.is_enable_desc}</td>
	           <td>${user.createname }</td>
	           <td>${user.createtime }</td>
	           <td>
	               <a href="javascript:void('0');" onclick="updateUser('${user.padUname}');">编辑</a>
	               <a href="javascript:void('0');" onclick="deleteUser('${user.padUname}');">删除</a>  
	           </td>
	     </tr>
     </c:forEach>	
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

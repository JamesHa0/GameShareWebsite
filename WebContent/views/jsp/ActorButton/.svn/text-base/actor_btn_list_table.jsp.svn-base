<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
    <script type="text/javascript">
	    function updateActorBtn(id){
			window.parent.location.href="pc_SystemController.do?addOrUpdateActorBtn&flag=update&id="+id;
		}
    </script>
</head>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>角色编号</th>
        <th>角色名称</th>
        <th>按钮ID</th>
        <th>状态</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th>按钮描述</th>
        <th>操作</th>
    </tr>
    </thead>
	<c:if test="${fn:length(list)!=0}">
		<c:forEach items="${list}"  var="user">
			<tr >
				<td>${user.actor_no}</td>
				<td>${user.actor_name}</td>
				<td>${user.button_id}</td>
				<td>${user.is_enable_desc}</td>
				<td>${user.createname}</td>
				<td>${user.createtime}</td>
				<td>${user.button_desc}</td>
				<td><a href="javascript:void('0');" onclick="updateActorBtn('${user.id}');">编辑</a></td>
			</tr>
		</c:forEach>
    </c:if>
    <c:if test="${fn:length(list)==0}">
			<tr >
		       <td>&nbsp;</td>
		       <td></td>
		       <td></td>
		       <td></td>
		       <td></td>
		       <td></td>
		       <td></td>
		       <td></td>
		   </tr>
    </c:if>
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

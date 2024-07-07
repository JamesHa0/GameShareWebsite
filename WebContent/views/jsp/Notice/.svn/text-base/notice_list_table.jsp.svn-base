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
    	function updateAAA(noticeId){
    		window.parent.location.href = "msgController.do?toVae&flag=edit&noticeId="+noticeId;
    	}
    </script>
</head>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>消息ID</th>
        <th>消息内容</th>
<!--         <th>是否弹窗</th> -->
        <th>消息状态</th>
        <th>消息创建时间</th>
        <th>创建人</th>
        <th>操作</th>
    </tr>
    </thead>
	<c:if test="${fn:length(list)!=0}">
		<c:forEach items="${list}"  var="user">
			<tr >
				<td>${user.noticeId}</td>
				<td>${user.noticeContentInx}</td>
<!-- 				<td> -->
<!-- 					<c:if test="${user.noticeFlag=='1' }">否</c:if> -->
<!-- 					<c:if test="${user.noticeFlag=='2' }">是</c:if> -->
<!-- 				</td> -->
				<td>
					<c:if test="${user.noticeStatus=='0' }">停用</c:if>
					<c:if test="${user.noticeStatus=='1' }">启用</c:if>
				</td>
				<td>${user.noticeCreateTimeStr}</td>
				<td>${user.createname}</td>
				<td>
					<a href="javascript:void('0');" onclick="updateAAA('${user.noticeId}');">编辑</a>
				</td>
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
		   </tr>
    </c:if>
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

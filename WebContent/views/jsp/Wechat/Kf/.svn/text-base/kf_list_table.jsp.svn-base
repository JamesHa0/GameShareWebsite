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
    function updateKf(kfPId){
		window.parent.location.href="wechatController.do?toAddOrUpdateKf&flag=update&kfPId="+kfPId;
	}
    function deleteKf(kfPId,kf_account){
    	if(confirm("确定删除吗？")){
    		window.parent.location.href="wechatController.do?deleteKf&kfPId="+kfPId+"&kf_account="+kf_account;
    	}
	}
    </script>
</head>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>客服账号</th>
        <th>客户昵称</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${fn:length(list)!=0}">
    	<c:forEach items="${list}"  var="user">
			<tr >
		       <td>${user.kf_account}</td>
		       <td>${user.nickname}</td>
		       <td>${user.createname}</td>
		       <td>${user.kfCreateTimeStr}</td>
		        <td>
					<a href="javascript:void('0');" onclick="updateKf('${user.kfPId}');">编辑</a> 
					<a href="javascript:void('0');" onclick="deleteKf('${user.kfPId}','${user.kf_account }');">删除</a> 
				</td>
		   </tr>
		</c:forEach>
    </c:if>
    <c:if test="${fn:length(list)==0}">
			<tr >
		       <td>&nbsp;&nbsp;</td>
		       <td></td>
		       <td></td>
		       <td></td>
		       <td></td>
		   </tr>
    </c:if>
</table>
</body>
<%@ include file="../../common/pageHiddenInfo.jsp" %>
</html>

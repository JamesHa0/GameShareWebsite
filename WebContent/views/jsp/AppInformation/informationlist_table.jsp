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
	function updateInformation(newid){
		window.parent.location.href="appInformation.do?addOrUpdateInformation&flag=update&newid="+newid;
	}
	
// 	function deleteInformation(activityid){
// 		window.parent.location.href="appInformation.do?deleteAppInformation&newid="+activityid;
// 	}
	
	function onInformation(activityid){
		window.parent.location.href="appInformation.do?onOffAppInformation&newid="+activityid+"&activitystatus=0";
	}
	
	function offInformation(activityid){
		window.parent.location.href="appInformation.do?onOffAppInformation&newid="+activityid+"&activitystatus=1";
	}
</script>
<style> 
	table { table-layout:fixed; word-break: break-all; word-wrap: break-word; }  
</style> 
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>资讯标题</th>
        <th>资讯描述</th>
        <th>图片的url地址</th>
        <th>单击跳转地址</th>
        <th>活动创建时间</th>
        <th>活动创建人</th>
        <th>活动状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${InformationList}"  var="appInformation">
     <tr >
           <td >${appInformation.title}</td>
           <td >${appInformation.ndesc}</td>
           <td >${appInformation.img_url}</td>
           <td >${appInformation.click_url}</td>
           <td >${appInformation.create_time }</td>
           <td >${appInformation.create_name }</td>
           <td >
    			<c:if test="${appInformation.state == 0}">
    				正常
    			</c:if>
    			<c:if test="${appInformation.state== 1}">
    				禁用
    			</c:if>
           </td>
           <td >
               <a href="javascript:void('0');" onclick="updateInformation('${appInformation.new_id}');">编辑</a>
               <!-- <a href="javascript:void('0');" onclick="deleteInformation('${appInformation.new_id}');">删除</a> -->
    			<c:if test="${appInformation.state == 0}">
                	<a href="javascript:void('0');" onclick="offInformation('${appInformation.new_id}');">禁用</a>
    			</c:if>
    			<c:if test="${appInformation.state == 1}">
                	<a href="javascript:void('0');" onclick="onInformation('${appInformation.new_id}');">启用</a>
				</c:if>
           </td>
       </tr>
      </c:forEach>	
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

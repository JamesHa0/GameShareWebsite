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
	function updateActivity(activityid){
		window.parent.location.href="appActivity.do?addOrUpdateActivity&flag=update&activityid="+activityid;
	}
	
// 	function deleteActivity(activityid){
// 		window.parent.location.href="appActivity.do?deleteAppActivity&activityid="+activityid;
// 	}
	
	function onActivity(activityid){
		window.parent.location.href="appActivity.do?onOffAppActivity&activityid="+activityid+"&activitystatus=0";
	}
	
	function offActivity(activityid){
		window.parent.location.href="appActivity.do?onOffAppActivity&activityid="+activityid+"&activitystatus=1";
	}
</script>
<style> 
	table { table-layout:fixed; word-break: break-all; word-wrap: break-word; }  
</style> 
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>活动名称</th>
        <th>活动描述</th>
        <th>图片的url地址</th>
        <th>单击跳转地址</th>
        <th>活动组别</th>
        <th>活动顺序</th>
        <th>活动创建时间</th>
        <th>活动创建人</th>
        <th>活动状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${activityList}"  var="appActivity">
     <tr >
           <td >${appActivity.activity_name}</td>
           <td >${appActivity.activity_desc}</td>
           <td >${appActivity.activity_img_url}</td>
           <td >${appActivity.activity_click_url}</td>
           <td >${appActivity.activity_group }</td>
           <td >${appActivity.activity_seq }</td>
           <td >${appActivity.activity_create_time }</td>
           <td >${appActivity.activity_create_name }</td>
           <td >
    			<c:if test="${appActivity.activity_status == 0}">
    				正常
    			</c:if>
    			<c:if test="${appActivity.activity_status == 1}">
    				禁用
    			</c:if>
           </td>
           <td >
               <a href="javascript:void('0');" onclick="updateActivity('${appActivity.activity_id}');">编辑</a>
               <!-- <a href="javascript:void('0');" onclick="deleteActivity('${appActivity.activity_id}');">删除</a> -->
    			<c:if test="${appActivity.activity_status == 0}">
                	<a href="javascript:void('0');" onclick="offActivity('${appActivity.activity_id}');">禁用</a>
    			</c:if>
    			<c:if test="${appActivity.activity_status == 1}">
                	<a href="javascript:void('0');" onclick="onActivity('${appActivity.activity_id}');">启用</a>
				</c:if>
           </td>
       </tr>
      </c:forEach>	
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

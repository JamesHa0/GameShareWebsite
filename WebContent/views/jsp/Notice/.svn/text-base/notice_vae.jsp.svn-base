<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/style.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/ckform.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/common.js"></script>
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<script type="text/javascript">
	function init(noticeFlag, noticeStatus, flag) {
		//状态
		if (noticeFlag == "2")
			document.getElementsByName("noticeFlag")[1].checked = "checked";
		if (noticeStatus == "0")
			document.getElementsByName("noticeStatus")[1].checked = "checked";
		document.form0.noticeStatus = noticeStatus;
	}
	/**
	 *表单校验
	 */
	function checkForm() {
		if (trim(document.form0.noticeContent.value) == "") {
			alert("消息内容不能为空！");
			return false;
		}
		return true;
	}
	function submitForm() {
		if (checkForm()) {
			if (confirm("确定保存吗？")) {

// 				var arr = "";
// 				var checkbox = document.getElementByName('cb');
// 				for ( var i = 0; i < checkbox.length(); i++) {
// 					if (checkbox[i].checked == true) {
// 						arr=arr+checkbox[i].value+",";
// 					}
// 				}
// 				arr = arr.substring(0, arr.length-1);
// 				var form = document.getElementByName('form0');
// 				form.action = 
				document.form0.submit();
			}
		}
	}
</script>
</head>
<body
	onload="init('${notice.noticeFlag}','${notice.noticeStatus }','${flag }');">
	<form name="form0"  action="msgController.do?saveNotice" method="post"
		class="definewidth m20">
		<input type="hidden" name="flag" value="${flag}"> <input
			type="hidden" name="noticeId" value="${notice.noticeId}" />
		<table class="table table-bordered table-hover definewidth m10">
			<!--         <tr> -->
			<!--             <td style="width: 20%;" class="tableleft">消息通知id</td> -->
			<!--             <td><input type="text" readonly="readonly" name="noticeId" value="${notice.noticeId}"/></td> -->
			<!--         </tr> -->
			<tr>
				<td class="tableleft">消息内容</td>
				<td><textarea name="noticeContent" rows="3" cols="*">${notice.noticeContent }</textarea>
				</td>
			</tr>
	        <tr style="display: none">
		        <td class="tableleft">是否弹窗</td>
		        <td>
		            <input type="radio" name="noticeFlag" value="1" checked="checked"/>否
		            <input type="radio" name="noticeFlag" value="2" /> 是
		        </td>
	    	</tr> 
<!-- 			<tr> -->
<!-- 				<td class="tableleft">发送到哪个平台</td> -->
<!-- 				<td><input type="checkbox" name="cb" value="H5" /> H5 <input -->
<!-- 					type="checkbox" name="cb" value="APP" /> APP</td> -->
<!-- 			</tr> -->
			<tr>
				<td class="tableleft">消息状态</td>
				<td><input type="radio" name="noticeStatus" value="1"
					checked="checked" /> 启用 <input type="radio" name="noticeStatus"
					value="0" /> 禁用</td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button class="btn btn-primary" type="button"
						onclick="submitForm();">保存</button> &nbsp;&nbsp;
					<button type="button"
						onclick="window.location.href='msgController.do?queryNoticeList'"
						class="btn btn-success" name="backid" id="backid">返回列表</button></td>
			</tr>
		</table>
	</form>
</body>
</html>

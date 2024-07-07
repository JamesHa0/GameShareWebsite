<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	src="<%=request.getContextPath()%>/views/Js/checkForm.js"></script>
<script type="text/javascript">
	function returnList() {
		window.location.href = "appInformation.do?queryAppInformationList";
	}
	function init(flag) {
		if (flag == "add") {
			document.form0.title.readOnly = "";
		}
	}

	function beforeSubmit(form) {
		if (form.activity_group.value == '') {
			alert('组名不能为空！');
			form.activity_group.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body onload="init('${flag}');">
	<form name="form0" action="appInformation.do?saveAppInformation" enctype="multipart/form-data"
		method="post" class="definewidth m20" onsubmit="return beforeSubmit(this)">
		<input type="hidden" name="new_id"
			value="${appInformation.new_id}" /> <input type="hidden"
			name="flag" value="${flag}">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td style="width: 20%;" class="tableleft">资讯标题</td>
				<td><input type="text" name="title"
					value="${appInformation.title}" title="资讯标题" />
				</td>
			</tr>
			<tr>
				<td class="tableleft">资讯描述</td>
				<td><input type="text" name="ndesc"
					value="${appInformation.ndesc}" title="资讯描述" />
				</td>
			</tr>
			<tr>
				<td class="tableleft">图片的url地址</td>
				<td><input type="file" name="img_url"
					value="${appInformation.img_url}" />
				</td>
			</tr>
			<tr>
				<td class="tableleft">单击跳转地址</td>
				<td><input type="text" name="click_url"
					value="${appInformation.click_url}" title="单击跳转地址" />
				</td>
			</tr>
			
			<tr>
				<td class="tableleft">来源</td>
				<td><input type="text" name="source"
					value="${appInformation.source}" title="来源" />
				</td>
			</tr>
			<tr>
				<td class="tableleft">资讯状态</td>
				<td>
					 <select name="state" >
					 	<c:if test="${appInformation.state == 0}">
					 		<option id="sid1" value="0" selected="selected">正常</option>
						 	<option id="sid2" value="1">禁用</option>
					 	</c:if>
					 	<c:if test="${appInformation.state == 1}">
					 		<option id="sid1" value="0">正常</option>
						 	<option id="sid2" value="1" selected="selected">禁用</option>
					 	</c:if>
					 </select>
				</td>

			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button class="btn btn-primary" type="submit"
						>保存</button> &nbsp;&nbsp;
					<button type="button" onclick="returnList();"
						class="btn btn-success" name="backid" id="backid">返回列表</button></td>
			</tr>
		</table>
	</form>
</body>
</html>

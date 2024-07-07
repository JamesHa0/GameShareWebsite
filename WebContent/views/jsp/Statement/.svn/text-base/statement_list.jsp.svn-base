<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="crf.util.PageUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="/WEB-INF/tld/tyTag.tld" prefix="tyTag"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AppUserInit</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/page.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/Css/bootstrap-responsive.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/ckform.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/views/Js/common.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/views/97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<form name="form0" class="form-inline definewidth m20" method="post"
		enctype="multipart/form-data">
		<table width="100%" align="center" border="0" class="q-cls">
			<tr>
				<td align="left" style="padding-right: 2%;"><input
					id="excel_file" type="file" name="filename" accept="xls" size="50"
					align="left" /></td>
					<td align="right" style="padding-right: 2%;" >
        	<button type="button" class="btn btn-info" onclick="updateCCC();" 
				style="margin-left: 2px;" >导入</button>
			<button type="button" class="btn btn-info" onclick="updateBBB();" 
				style="margin-left: 2px;" >导出</button>
				</td>
			</tr>
		</table>
		<%-- <tyTag:page tarFrame="frame1" method="fundingController.do?queryStatementListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
<tyTag:actorBtnTag value="${btn_ids }"></tyTag:actorBtnTag> --%>
	</form>
	<table class="table table-bordered table-hover definewidth m10"
		id="table1">
		<thead>
			<tr>
				<th></th>
				<th>日期</th>
				<th>时间</th>
				<th>用戶ID</th>
				<th>手机号</th>
				<th>是否开户</th>
				<th>入金金额</th>
			</tr>
		</thead>
		<c:if test="${fn:length(list)!=0}">
			<c:forEach items="${list}" var="excel">
				<tr onclick="checkOneByTr(this);" style="cursor: hand;">
					<td></td>
					<td>${excel.date }</td>
					<td>${excel.time }</td>
					<td>${excel.userId }</td>
					<td>${excel.phoneNo }</td>
					<td>${excel.openAccount }</td>
					<td>${excel.totalMoney }</td>
					<%-- <tr onclick="checkOneByTr(this);" style="cursor: hand;">
				<td>${sheet[0] }</td> --%>
					<%-- 	<td>${sheet[0] }</td>
				<td>${sheet[0] }</td>
				<td>${sheet[0] }</td>
				<td>${sheet[0] }</td>
				<td>${sheet[0] }</td> --%>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${fn:length(list)==0}">
			<tr>
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
<%@ include file="../common/pageHiddenInfo.jsp"%>
<script type="text/javascript">
	function updateBBB() {
		if (confirm("确认导出吗?")) {
			if (getCookie("imExport") == "1") {
				document.forms[0].action = "reportController.do?exportStatementList";
				document.forms[0].target = "_self";
				document.forms[0].submit();
				removeCookie("imExport");
			} else {
				alert("亲，请导入！");
			}
		}
	}
	function updateCCC() {
		if (confirm("确认导入吗?")) {
			var excel_file = $("#excel_file").val();
			if (excel_file == "" || excel_file.length == 0) {
				alert("请选择文件路径！");

			} else {
				document.forms[0].action = "reportController.do?importStatementList";
				document.forms[0].target = "_self";
				document.forms[0].submit();
				setCookie("imExport", "1", 30);
			}

		}
	}
	function setCookie(name, value, iDay) {
		var oDate = new Date();

		oDate.setDate(oDate.getDate() + iDay);

		document.cookie = name + '=' + encodeURIComponent(value) + ';expires='
				+ oDate;
	}

	function getCookie(name) {
		var arr = document.cookie.split('; ');
		var i = 0;
		for (i = 0; i < arr.length; i++) {
			//arr2->['username', 'abc']
			var arr2 = arr[i].split('=');

			if (arr2[0] == name) {
				var getC = decodeURIComponent(arr2[1]);
				return getC;
			}
		}

		return '';
	}

	function removeCookie(name) {
		setCookie(name, '1', -1);
	}
</script>

</html>

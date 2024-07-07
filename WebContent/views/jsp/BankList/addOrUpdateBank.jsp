<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		window.location.href = "bank.do?queryBankList";
	}
	function init(flag) {
		if (flag == "add") {
			document.form0.bank_name.readOnly = "";
		}
	}

	/* function beforeSubmit(form) {
		if (form.bank_group.value == '') {
			alert('组名不能为空！');
			form.bank_group.focus();
			return false;
		}
		return true;
	} */
</script>
</head>
<body onload="init('${flag}');">
	<form name="form0" action="bank.do?saveBank" method="post"
		class="definewidth m20" >
		<input type="hidden" name="bankId" value="${bank.bankId}" /> <input
			type="hidden" name="flag" value="${flag}">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td style="width: 20%;" class="tableleft">银行名称</td>
				<td><input type="text" name="bankName"
					value="${bank.bankName}" title="银行名称" /></td>
			</tr>
			<tr>
				<td class="tableleft">银行类型</td>
				<td><select name="bankType">
<!-- 				 		1 富友 2 银联 3 通联 4 财付通 -->
						<option value="1" selected="selected">富友</option>
						<option value="2">银联</option>
						<option value="3">通联</option>
						<option value="4">财付通</option>
				</select></td>
			</tr>
			<tr>
				<td class="tableleft">银行代码</td>
				<td><input type="text" name="bankCode" value="${bank.bankCode}" />
				</td>
			</tr>
			<tr>
				<td class="tableleft">是否可用</td>
				<td><select name="bankEnabled">
<!-- 				 		是否可用 1 是 0 否 默认1 -->
						<option value="1" selected="selected">可用</option>
						<option value="0">不可用</option>
				</select></td>
			</tr>
			<tr>
				<td class="tableleft">单笔限额</td>
				<td><input type="text" title="单笔限额" name="bankdanbi"
					value="${bank.bankdanbi}" /></td>
			</tr>
			<tr>
				<td class="tableleft">单日限额</td>
				<td><input type="text" name="bankdanri"
					value="${bank.bankdanri}" title="单日限额" /></td>

			</tr>
			<tr>
				<td class="tableleft">单月限额</td>
				<td><input type="text" name="bankdanyue"
					value="${bank.bankdanyue}" title="单月限额" /></td>

			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button class="btn btn-primary" type="submit">保存</button>
					&nbsp;&nbsp;
					<button type="button" onclick="returnList();"
						class="btn btn-success" name="backid" id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

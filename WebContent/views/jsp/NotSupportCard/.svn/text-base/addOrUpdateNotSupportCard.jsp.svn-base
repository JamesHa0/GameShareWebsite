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
		window.location.href = "notSupportCard.do?queryNotSupportCardList";
	}
	function init(flag) {
		if (flag == "add") {
			document.form0.bank_name.readOnly = "";
		}
	}
</script>
</head>
<body onload="init('${flag}');">
	<form name="form0" action="notSupportCard.do?saveNotSupportCard" method="post"
		class="definewidth m20" >
		<input type="hidden" name="cardId" value="${notSupportCard.cardId}" /> <input
			type="hidden" name="flag" value="${flag}">
			
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td style="width: 20%;" class="tableleft">卡号前六位</td>
				<td><input type="text" name="cardNumSix"
					value="${notSupportCard.cardNumSix}"/></td>
			</tr>
			<tr>
				<td class="tableleft">发卡行</td>
				<td><input type="text" name="bankName"
					value="${notSupportCard.bankName}" /></td>
			</tr>
			<tr>
				<td class="tableleft">卡名</td>
				<td><input type="text" name="cardName"
					value="${notSupportCard.cardName}" /></td>
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

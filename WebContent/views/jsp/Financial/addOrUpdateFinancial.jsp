<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
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
		window.location.href = "financial.do?queryFinancialList";
	}
	function init(flag,state) {
		if (flag == "update") {
			document.form0.financial_create_time.readOnly = "true";
			document.form0.financial_create_name.readOnly = "true";
			document.form0.financial_code.readOnly = "true";
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
	<form name="form0" action="financial.do?saveFinancial" method="post"
		class="definewidth m20" >
		<input type="hidden" name="financial_id" value="${financial.financial_id}" /> 
		<input type="hidden" name="flag" value="${flag}">
		<input type="hidden" name="financial_create_id" value="${financial.financial_create_id}" /> 
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td style="width: 20%;" class="tableleft">手机号</td>
				<td><input type="text" name="financial_phone"
					value="${financial.financial_phone}" title="手机号" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" required="required" /></td>
			</tr>
			<tr>
				<td class="tableleft">姓名</td>
				<td><input type="text" name="financial_name" value="${financial.financial_name}" />
				</td>
			</tr>
			<tr>
				<td class="tableleft">工号</td>
				<td></td>
			</tr>
			<tr>
				<td class="tableleft">邀请码</td>
				<td><input type="text" name="financial_code" value="${financial.financial_code}" />
				</td>
			</tr>
			<tr>
				<td class="tableleft">是否可用</td>
				<td>
				
				<select name="financial_state">
<!-- 				 		是否可用 1 是 0 否 默认1 -->
						<c:if test="${financial.financial_state=='1'}" >
							<option id="oid1" value="0" >正常</option>
							<option id="oid2" value="1" selected="selected">禁用</option>
						</c:if>
						<c:if test="${financial.financial_state=='0'}" >
							<option id="oid1" value="0"  selected="selected">正常</option>
							<option id="oid2" value="1">禁用</option>
						</c:if>
						<c:if test="${financial.financial_state==null}" >
							<option id="oid1" value="0" selected="selected">正常</option>
							<option id="oid2" value="1" >禁用</option>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<td class="tableleft">所属地区</td>
				<td><input type="text" title="所属地区" name="financial_location"
					value="${financial.financial_location}"/></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td class="tableleft">创建者</td> -->
<!-- 				<td><input type="text" name="financial_create_name" -->
<!-- 					value="${financial.financial_create_name}" title="创建者"  /></td> -->

<!-- 			</tr> -->
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

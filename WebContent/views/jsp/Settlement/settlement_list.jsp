<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  import="crf.util.PageUtil" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/tyTag.tld" prefix="tyTag"%> 
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户列表Init</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/page.css" />
</head>
<body>
<form name="form0" class="form-inline definewidth m20" method="post">
<table width="100%" align="center" border="0"  class="q-cls">
	<tr>
		<td width="7%" align="right">富友账户:</td>
		<td width="8%" align="left"><input  type="text"  name="seReqMess"></td>
		
		<td width="7%" align="right">操作类型:</td>
		<td width="8%" align="left">
			 <select name="seType" >
			 	<option value="">--请选择--</option>
			 	<option value="1">开户</option>
			 	<option value="2">预授权</option>
			 	<option value="3">查询余额</option>
			 	<option value="4">充值</option>
			 	<option value="5">提现</option>
			 </select>
		</td>
		
		<td width="7%" align="right">数据来源:</td>
		<td width="8%" align="left">
			 <select name="dataSource" >
			 	<option value="">--请选择--</option>
			 	<option value="H5">H5</option>
			 	<option value="APP">APP</option>
			 </select>
		</td>
		
		<td align="right" style="padding-right: 2%;">
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
		</td>
	</tr>
</table>
<tyTag:page tarFrame="frame1" method="settlementController.do?querySettlementListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "settlementController.do?querySettlementListTable";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    </script>
</html>

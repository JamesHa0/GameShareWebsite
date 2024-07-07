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
	<script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/views/97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form name="form0" class="form-inline definewidth m20"  method="post">
<table width="100%" align="center" border="0" class="q-cls">
	<tr>
		<td width="7%" align="right">消息内容:</td>
		<td width="8%" align="left"><input type="text"  name="noticeContent"></td>
		<td width="7%" align="right">是否弹窗:</td>
		<td width="8%" align="left">
			 <select name="noticeFlag">
			 	<option value="">--请选择--</option>
			 	<option value="1">否</option>
			 	<option value="2">是</option>
			 </select>
		</td>
		<td width="7%" align="right">消息状态:</td>
		<td width="8%" align="left">
			 <select name="noticeStatus" >
			 	<option value="" selected="selected">--请选择--</option>
			 	<option value="1">启用</option>
			 	<option value="0">停用</option>
			 </select>
		</td>
		
		<td align="right" style="padding-right: 2%;">
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
			<button type="button" class="btn btn-success" onclick="addAAA();">新增</button>
		</td>
	</tr>
</table>
<tyTag:page tarFrame="frame1" method="msgController.do?queryNoticeListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
<tyTag:actorBtnTag value="${btn_ids }"/>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "msgController.do?queryNoticeListTable";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    	function addAAA(){
    		window.location.href = "msgController.do?toVae&flag=add";
    	}
    </script>
</html>

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
		<td width="7%" align="right">客服昵称:</td>
		<td width="8%" align="left"><input  type="text"  name="kfNickname"></td>
		
		<td width="7%" align="right">会话时间:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()"  name="recordStartTime"></td>
		<td width="7%" align="right">至:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()" name="recordEndTime"></td>
	
		<td align="right" style="padding-right: 2%;">
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
		</td>
	</tr>
</table>
<tyTag:page tarFrame="frame1" method="wechatController.do?queryReportListTable" pageTurn="<%=PageUtil.TURN_NO %>"></tyTag:page>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "wechatController.do?queryReportListTable";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    </script>
</html>
<!-- <input class="Wdate" type="text"  onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" > -->
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
<form name="form0" class="form-inline definewidth m20" 
		action="appInformation.do?queryAppInformationListTable" method="post">
<table  align="center" border="0" class="q-cls">
	<tr>
		<td width="6%" align="right">资讯标题:</td>
		<td width="10%" align="left"><input id="ackeyword" style="width: 150px;" type="text"  name="acname"></td>
		<td align="right" style="padding-right: 2%">
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
			<button type="button" class="btn btn-success" onclick="addInformation();">新增资讯</button>
		</td>
	</tr>
</table>
<tyTag:page tarFrame="frame1" method="appInformation.do?queryAppInformationListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "appInformation.do?queryAppInformationListTable&keyword="+document.getElementById("ackeyword").value;
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    	function addInformation(){
    		window.location.href="appInformation.do?addOrUpdateInformation&flag=add";
    	}
    </script>
</html>

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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/page.css" />
</head>
<body>
<form name="form0" class="form-inline definewidth m20" 
		action="pc_SystemController.do?queryActorListTable" method="post">
<table align="center" border="0" class="q-cls">
	<tr>
		<td width="7%" align="right">角色名称:</td>
		<td width="8%" align="left"><input style="width: 150px;" type="text"  name="actor_name"></td>
		<td align="right" style="padding-right: 2%">
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
			<button type="button" class="btn btn-success" onclick="addActor();">新增角色</button>
		</td>
	</tr>
</table>
<tyTag:page tarFrame="frame1" method="pc_SystemController.do?queryActorListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "pc_SystemController.do?queryActorListTable";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    	function addActor(){
    		window.location.href="pc_SystemController.do?addOrUpdateActor&flag=add";
    	}
    </script>
</html>

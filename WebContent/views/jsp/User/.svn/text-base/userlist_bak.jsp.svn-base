<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/tyTag.tld" prefix="tyTag"%> 
<%@ page  import="crf.util.PageUtil" %> 
<%@ page isELIgnored="false"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户列表Init</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/page.css" />
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "pc_UserController.do?queryUserListTable&flag=query";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    </script>
</head>
<body>
<form name="form0" class="form-inline definewidth m20" 
	action="pc_UserController.do?queryUserListTable" method="post">
  
 用户名称:<input type="text" name="username" id="username" class="abc input-default"  value="">&nbsp;&nbsp;  
      <button type="button" onclick="query();" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>

<!-- 自定义标签替代注释代码 -->
<div>
	<iframe name="frame1" frameborder="0" scrolling="no"  height="30%" width="100%" src="" ></iframe>
</div>
<input name="method" id="method" type="hidden" value="pc_UserController.do?queryUserListTable">
<input name="pageTurn" id="pageTurn" type="hidden" value="<%=PageUtil.TURN_YES%>" >
<%@ include file="../common/page.jsp" %>

</form>
</body>
</html>

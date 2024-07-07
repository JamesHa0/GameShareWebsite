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
<form name="form0" class="form-inline definewidth m20"  method="post">
	<table width="95%" align="center" border="0">
		<tr>
			<td align="right">
			<button type="button" onclick="query();" class="btn btn-primary">更新产品列表</button>
			</td>
		</tr>
	</table>
<!-- <table width="95%" align="center" border="0"> -->
<!-- 	<tr> -->
<!-- 		<td width="6%" align="left">提现账号:</td> -->
<!-- 		<td width="10%" align="left"><input style="width: 150px;" type="text"  name="productFuiouLoginId"></td> -->
<!-- 		<td align="right"> -->
<!-- 			<button type="button" onclick="query();" class="btn btn-primary">查询</button> -->
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- </table> -->
<tyTag:page tarFrame="frame1" method="productController.do?queryProductListTable" pageTurn="<%=PageUtil.TURN_NO %>"></tyTag:page>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "productController.do?updateProduct";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    </script>
</html>

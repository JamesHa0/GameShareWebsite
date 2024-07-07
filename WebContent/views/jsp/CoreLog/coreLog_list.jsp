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
<table  align="center" border="0" class="q-cls">
	<tr >
		<td width="7%" align="right">手机号:</td>
		<td width="8%" align="left"><input  type="text"  name="userPhoneNo"></td>
		
		<td width="7%" align="right">接口类型:</td>
		<td width="8%" align="left">
			 <select name="coreTypeDesc" >
			 	<option value="">--请选择--</option>
			 	<option value="产品更新接口">产品更新接口</option>
			 	<option value="人次出资总额">人次出资总额</option>
			 	<option value="充值上送">充值上送</option>
			 	<option value="再投资金">再投资金</option>
			 	<option value="再投资金明细">再投资金明细</option>
			 	<option value="出资记录">出资记录</option>
			 	<option value="出资记录明细">出资记录明细</option>
			 	<option value="密码重置">密码重置</option>
			 	<option value="开户上送">开户上送</option>
			 	<option value="提现上送">提现上送</option>
			 	<option value="注册接口">注册接口</option>
			 	<option value="登录接口">登录接口</option>
			 	<option value="获取富有账户">获取富有账户</option>
			 	<option value="获取用户信息">获取用户信息</option>
			 	<option value="认购上送">认购上送</option>
			 	<option value="获取红包列表">获取红包列表</option>
			 	<option value="批量获取富有账户">批量获取富有账户</option>
			 	<option value="微信点赞红包">微信点赞红包</option>
			 	<option value="修改手机号">修改手机号</option>
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
		
		<td align="right" style="padding-right: 2%">
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
		</td>
	</tr> 
</table>
<tyTag:page tarFrame="frame1" method="coreLogController.do?queryCoreLogListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "coreLogController.do?queryCoreLogListTable";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    </script>
</html>

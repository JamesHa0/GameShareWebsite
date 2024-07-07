<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  import="crf.util.PageUtil" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tld/tyTag.tld" prefix="tyTag"%> 
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>AppUserInit</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/page.css" />
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/views/97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form name="form0" class="form-inline definewidth m20"  method="post">
<table width="100%" align="center" border="0" class="q-cls">
	<tr>
		<td width="7%" align="right">手机号:</td>
		<td width="8%" align="left"><input  type="text"  name="userPhoneNo"></td>
		<td width="7%" align="right">用户名:</td>
		<td width="8%" align="left"><input  type="text"  name="userNo"></td>
		<td width="7%" align="right">身份证号:</td>
		<td width="8%" align="left"><input  type="text"  name="userIdCard"></td>
	</tr>
	<tr>
		<td width="7%" align="right">姓名:</td>
		<td width="8%" align="left"><input  type="text"  name="userName"></td>
		<td width="7%" align="right">是否绑定:</td>
		<td width="8%" align="left" >
			 <select name="isBind" >
			 	<option value="">--请选择--</option>
			 	<option value="N">未绑定</option>
			 	<option value="Y">已绑定</option>
			 </select>
		</td>
		<td width="7%" align="right">注册来源:</td>
		<td width="8%" align="left" >
			 <select name="userRegSource" >
			 	<option value="">--请选择--</option>
			 	<option value="1">微信</option>
			 	<option value="2">PC</option>
			 	<option value="3">APP</option>
			 </select>
		</td>
	</tr>
	<tr>
		<td width="7%" align="right">渠道:</td>
		<td width="8%" align="left" >
			 <select name="userChannel" >
			 	<option value="">--请选择--</option>
			 	<option value="201501XGLC">西瓜理财</option>
			 </select>
		</td>
		<td width="7%" align="right">注册时间:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()"  name="startTime"></td>
		<td width="7%" align="right">至:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()" name="endTime"></td>
	</tr>
	<tr>
		<td width="7%" align="right">推荐码:</td>
		<td width="8%" align="left"><input  type="text"  name="userYqm"></td>
		<td width="7%" align="right"></td>
		<td width="8%" align="left"></td>
		<td width="7%" align="right"></td>
		<td width="8%" align="left" ></td>
		<td align="right" style="padding-right: 2%;" >
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
			<button type="button" class="btn btn-success" onclick="updateAAA();" 
				style="margin-left: 2px;display: none;" id = "btn_edit_auser">编辑</button>
			<button type="button" class="btn btn-info" onclick="updateBBB();" 
				style="margin-left: 2px;" >导出</button>
		</td>
	</tr>
</table>
<tyTag:page tarFrame="frame1" method="appUserController.do?queryAppUserListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
<tyTag:actorBtnTag value="${btn_ids }"></tyTag:actorBtnTag>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "appUserController.do?queryAppUserListTable";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    	function updateAAA(){
    		var cbox = window.frame1.document.getElementsByName("cbox");
    		var userid = "";
			var count = 0;    		
    		for(var i = 0; i <cbox.length; i++){
    			box = cbox[i];
    			if(box.checked){
    				userid = userid+box.value;
    				count++;
    			}
    		}
    		if(count != 1){
    			alert("请选中一条数据进行编辑！");
    			return ;
    		}
       		document.forms[0].action = "appUserController.do?toUpdateAppUser&userId="+userid;
       		document.forms[0].target="_self";
       		document.forms[0].submit();
    	}
    	function updateBBB(){
    		if(confirm("确认导出吗?")){
    			document.forms[0].action = "appUserController.do?exportAppUserList";
           		document.forms[0].target="_self";
           		document.forms[0].submit();
    		}
    	}
    </script>
</html>

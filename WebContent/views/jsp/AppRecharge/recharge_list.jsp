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
		<td width="7%" align="right">手机号:</td>
		<td width="8%" align="left"><input  type="text"  name="rechargeFuiouLoginId"></td>
		
		<td width="7%" align="right">充值状态:</td>
		<td width="8%" align="left">
			 <select name="rechargeState" >
			 	<option value="" selected="selected">--请选择--</option>
			 	<option value="1">充值成功</option>
			 	<option value="0">充值失败</option>
			 </select>
		</td>
		<td width="7%" align="right">上传状态:</td>
		<td width="8%" align="left">
			 <select name="isUploadSuccess" >
			 	<option value="">--请选择--</option>
			 	<option value="0">未上传</option>
			 	<option value="1">上传成功</option>
			 	<option value="2">上传失败</option>
			 </select>
		</td>
	</tr>
	<tr>
		<td width="7%" align="right">姓名:</td>
		<td width="8%" align="left"><input  type="text"  name="rechargeName"></td>
		<td width="7%" align="right">充值时间:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()"  name="startTime"></td>
		<td width="7%" align="right">至:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()" name="endTime"></td>
		
		<td align="right" style="padding-right: 2%">
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
			<button type="button" class="btn btn-success" onclick="updateAAA();" id="btn_reupload"
				style="margin-left: 2px;display: none;">重新上传</button>
		</td>
	</tr>
</table>
<tyTag:page tarFrame="frame1" method="appRecharge.do?queryRechargeListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
<tyTag:actorBtnTag value="${btn_ids }"/>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "appRecharge.do?queryRechargeListTable";
    		document.forms[0].target="frame1";
    		document.forms[0].submit();
    	}
    	function updateAAA(){
    		var cbox = window.frame1.document.getElementsByName("cbox");
    		var selectlist = "";
    		for(var i = 0; i <cbox.length; i++){
    			box = cbox[i];
    			if(box.checked)
    				selectlist = selectlist+box.value+",";
    		}
    		if(selectlist.indexOf(",")==-1){
    			alert("请先选中重新上传的数据！");
    			return ;
    		}
    		if(confirm("确认提交吗?")){
    			document.getElementById("selectlist").value = selectlist;
        		document.forms[0].action = "appRecharge.do?updateUploadStatus";
        		document.forms[0].target="_self";
        		document.forms[0].submit();
    		}
    	}
    </script>
</html>

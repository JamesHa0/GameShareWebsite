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
		<td width="8%" align="left"><input style="width: 200px;" type="text"  name="fundPhoneNo"></td>
		
		<td width="7%" align="right">冻结状态:</td>
		<td width="8%" align="left">
			 <select name="fundState" >
			 	<option value="" selected="selected">--请选择--</option>
			 	<option value="0">未冻结</option>
			 	<option value="1">已冻结</option>
			 	<option value="2">交易过期</option>
			 	<option value="3">交易取消</option>
			 </select>
		</td>
		<td width="7%" align="right">上传状态:</td>
		<td width="8%" align="left">
			 <select name="fundReqState" >
			 	<option value="">--请选择--</option>
			 	<option value="0">未上传</option>
			 	<option value="1">上传成功</option>
			 	<option value="2">上传失败</option>
			 </select>
		</td>
	</tr>
	<tr>
		<td width="7%" align="right">出资时间:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()"  name="startTime"></td>
		<td width="7%" align="right">至:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()" name="endTime"></td>
		<td width="7%" align="right">姓名:</td>
		<td width="8%" align="left" ><input style="width: 200px;" type="text"  name="fundName"></td>
	</tr>
	<tr>
		<td width="7%" align="right">冻结时间:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()"  name="freezeStartTime"></td>
		<td width="7%" align="right">至:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()" name="freezeEndTime"></td>
		<td></td><td></td>
	</tr>
	<tr>
		<td width="7%" align="right">上传时间:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()"  name="uploadStartTime"></td>
		<td width="7%" align="right">至:</td>
		<td width="8%" align="left"><input  class="Wdate" type="text" onClick="WdatePicker()" name="uploadEndTime"></td>
		<td></td>
		<td align="right" style="padding-right: 2%">
			<button type="button" onclick="query();" class="btn btn-primary">查询</button>
			<button type="button" class="btn btn-success" onclick="updateAAA();" 
				style="margin-left: 2px;display: none;" id="btn_reupload">重新上传</button>
			<button type="button" class="btn btn-info" onclick="updateBBB();" 
				style="margin-left: 2px;" >导出</button>
		</td>
	</tr>
</table>
<tyTag:page tarFrame="frame1" method="appFunding.do?queryFundingListTable" pageTurn="<%=PageUtil.TURN_YES %>"></tyTag:page>
<tyTag:actorBtnTag value="${btn_ids }"/>
</form>
</body>
    <script type="text/javascript">
    	function query(){
    		document.forms[0].action = "appFunding.do?queryFundingListTable";
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
        		document.forms[0].action = "appFunding.do?updateUploadStatus";
        		document.forms[0].target="_self";
        		document.forms[0].submit();
    		}
    	}
    	function updateBBB(){
    		if(confirm("确认导出吗?")){
        		document.forms[0].action = "appFunding.do?exportFundingList";
        		document.forms[0].target="_self";
        		document.forms[0].submit();
    		}
    	}
    </script>
</html>

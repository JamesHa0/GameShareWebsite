<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js" ></script>
</head>
<script type="text/javascript">
	//编辑
	function updateCcardData(loanContractNo){
		window.parent.location.href = "pc_CcardDataController.do?addOrUpdateCcardData&flag=update&loanContractNo=" 
			+ loanContractNo;
	}
	//分配任务
	function allotOperation(){
		var areaNo = window.parent.document.getElementById("areaNo").value;
		if(areaNo == "") {
			alert("请筛选出同一个地区的任务");
			return;
		}
		var str = "";
		var index = 0;
		var el = document.getElementsByName("checkId");
		for(var i = 0; i < el.length; i ++){
			if(el[i].checked) {
				index ++;
				str += el[i].value + ", ";
			}
		}
		if(index <= 0) {
			alert("未选中任务");
			return;
		}
		window.parent.location.href = "pc_CcardDataController.do?turnToAllocaCcardData&checkId=" 
								+ str +"&areaNo=" + areaNo;
	}
	//全选
	function checkAll(name) {
		var check = document.getElementById("checkAll");
		var isChecked = false;
		if(check.checked == true){
			isChecked = true;
		}
		var el = document.getElementsByName(name);
		for(var i = 0; i < el.length; i ++){
			el[i].checked = isChecked;
		}
	}
	//回收任务
	function recoverCcradData() {
		if(window.confirm("确认将选中的任务全部回收？")){
			var str = "";
			var index = 0;
			var el = document.getElementsByName("checkId");
			for(var i = 0; i < el.length; i ++){
				if(el[i].checked) {
					index ++;
					str += el[i].value + ", ";
				}
			}
			if(index <= 0) {
				alert("未选中任务");
				return;
			}
			window.location.href="pc_CcardDataController.do?recoverCcardData&checkId=" + str;
		}
	}
</script>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1" >
    <thead>
	    <tr>
	    	<th><input type="checkbox" onclick="checkAll('checkId');" id="checkAll"/>全选</th>
	        <th>合同号</th>
	        <th>姓名</th>
	        <th>身份证号</th>
	        <th>逾期天数</th>
	        <th>应还总金额</th>
	        <th>已还罚息金额</th>
	        <th>已还逾期利息</th>
	        <th>所属用户</th>
	        <th>所属分组</th>
	        <th>是否标记</th>
	        <th>创建时间</th>
	        <th>操作</th>
	    </tr>
    </thead>
    <c:forEach items="${userList}"  var="user">
	    <tr >
	    	   <td style="text-align: center;"><input type="checkbox" value="${user.id }" name="checkId"/></td>
	           <td>${user.loanContractNo}</td>
	           <td>${user.loanName}</td>
	           <td>${user.idCard}</td>
	           <td>${user.deliquencyDay }</td>
	           <td>${user.sumAmount }</td>
	           <td>${user.paidPenaltyInterest }</td>
	           <td>${user.paidLateInterest }</td>
	           <td>${user.padUser }</td>
	           <td>${user.groupName }</td>
	           <td>
		           <c:choose>
		           		<c:when test="${user.is_deal eq 1}">
		           			已标记
		           		</c:when>
		        		<c:otherwise>
		         			未标记
		          		</c:otherwise>
		          	</c:choose>
	           	</td>
	           <td>${user.creatTime }</td>
	           <td>
	               <a href="javascript:void('0');" onclick="updateCcardData('${user.loanContractNo}');">编辑</a> 
	           </td>
	     </tr>
     </c:forEach>	
     <tr>
	    <td style="text-align: right;" colspan="13">
	    	<button onclick="allotOperation();">任务分配</button>
	    	<button onclick="recoverCcradData();">任务回收</button>
	    </td>
	 </tr>
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

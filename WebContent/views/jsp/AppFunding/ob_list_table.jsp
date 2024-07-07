<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
    	function view(fundPhoneNo){
    		var yue = "--";
    		var cwz = "--";
    		$.ajax({
    			url:"appFunding.do?queryFuiouBalance",
    			type:"POST",//默认GET
    			data:{"cust_no":fundPhoneNo},
    			timeout:5000,//设置超时 仅对异步请求有效
    			dataType:"json",//返回类型xml、html、script、json、jsonp、text
    			success:function(json){
    				if(json != null){
    					yue = json.yue;
        				cwz = json.cwz;
    				}
    				alert("账户可用余额: "+yue+" 元\n"+
    		    			  "充值未转金额: "+cwz+" 元");
    			}
    		});
    	}
    </script>
</head>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>手机号</th>
        <th>姓名</th>
        <th>身份证号</th>
        <th>理财产品</th>
        <th>认购金额</th>
        <th>认购时间</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${fn:length(list)!=0}">
    	<c:forEach items="${list}"  var="user">
			<tr >
		       <td>${user.fundPhoneNo}</td>
		       <td>${user.fundName}</td>
		       <td>${user.fundIdCard}</td>
		       <td>${user.fundProName}</td>
		       <td>${user.fundMoney}</td>
		       <td>${user.fundCreateTimeStr }</td>
		       <td>未冻结</td>
		       <td><a href="javascript:void('0')" onclick="view('${user.fundPhoneNo}')">查看余额</a></td>
		   </tr>
		</c:forEach>
		<tr>
			<td >累计金额(元):</td>
			<td colspan="7">${sumMoney }</td>
		</tr>
    </c:if>
    <c:if test="${fn:length(list)==0}">
		<tr >
	       <td>&nbsp;</td>
	       <td></td>
	       <td></td>
	       <td></td>
	       <td></td>
	       <td></td>
	       <td></td>
	       <td></td>
	   </tr>
    </c:if>
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

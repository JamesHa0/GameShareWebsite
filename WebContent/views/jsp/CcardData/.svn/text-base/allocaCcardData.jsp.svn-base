<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 催收任务 分配界面-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
    <script type="text/javascript">
    	//确认任务分配
    	function allocaCcardData(){
    		var el = document.getElementsByName("check");
    		var padUname = "";
    		for(var i = 0; i < el.length; i ++){
    			if(el[i].checked) {
    				padUname = el[i].value;
    				document.getElementById("padUname").value = padUname;
    			}
	    	}
    	}
    	//选中数据时，确保只选中一条
    	function testCheck(val) {
    		if(val.checked){
    			var el = document.getElementsByName("check");
	    		for(var i = 0; i < el.length; i ++){
	    			el[i].checked = false;
	    		}
	    		val.checked = true;
    		}
    	}
    	function reback() {
    		window.history.go(-1);
    	}
    </script>
</head>
<body >
<form name="form0" action="pc_CcardDataController.do?allocaCcardData" method="post" class="definewidth m20">
<input type="hidden" name="checkId" value="${checkId}" id="checkedId">
<input type="hidden" name="padUname" value="" id="padUname"/>
<input type="hidden" name="city" value="${city }">
	当前所属地区：${city }
    <table class="table table-bordered table-hover definewidth m10">
        <thead>
        	<tr>
        		<th></th>
        		<th>工作人员姓名</th>
        		<th>所属分组</th>
        		<th>分组名称</th>
        	</tr>
        </thead>
        	<c:forEach items="${userList}"  var="user">
        		<tr>
        			<td style="text-align: center;">
        				<input type="checkBox" value="${user.padUname }" 
        					name="check" onclick="testCheck(this);"/>
        			</td>
        			<td>${user.padUname }</td>
        			<td>${user.group_no }</td>
        			<td>${user.group_name }</td>
        		</tr>
        	</c:forEach>
        	<tr >
        		<td colspan="4" style="text-align: right;">
        			<button onclick="reback();">返回</button>
        			<button onclick="allocaCcardData();">确认分配</button>
        		</td>
        	</tr>
    </table>
</form>
</body>
</html>

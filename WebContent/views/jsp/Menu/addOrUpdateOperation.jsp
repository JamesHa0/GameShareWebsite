<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
    	function returnList(){
    		window.location.href="pc_SystemController.do?getOperationList";
    	}
    	function init(is_enable,parent_id,flag){
    		if(flag=="add"){
    			document.form0.operation_no.readOnly="";
    		}
    			
    		//状态
    		if(is_enable=="1"){
    			document.getElementsByName("is_enable")[0].checked="checked";
    		}else if(is_enable=="0"){
    			document.getElementsByName("is_enable")[1].checked="checked";
    		}
    		//父菜单
    		if(parent_id==""){
    			parent_id="0";
    		}
    		document.form0.parent_id.value=parent_id;
    	}
    	/**
    	 *表单校验
    	 */
    	function checkForm(){
    		if(trim(document.form0.operation_no.value)==""){
    			alert("菜单编号不能为空！");
    			return false;
    		}
    		if(trim(document.form0.operation_name.value)==""){
    			alert("菜单名称不能为空！");
    			return false;
    		}
    		var flag=document.form0.flag.value;
    		if(flag=="update"){
    			if(trim(document.form0.parent_id.value)=="0"){
        			alert("请选择父菜单！");
        			return false;
        		}
    		}else{
    			if(trim(document.form0.parent_id.value)=="0"){
    				document.form0.operation_url.value="";
        		}
    		}
    		return true;
    	}
    	function submitForm(){
    		if(checkForm()){
    			if(confirm("确定保存吗？")){
    				document.form0.submit();
    			}
    		}
    	}
    </script>
</head>
<body onload="init('${user.is_enable}','${user.parent_id }','${flag }');">
<form name="form0" action="pc_SystemController.do?saveOperation" method="post" class="definewidth m20">
<input type="hidden" name="id" value="${user.id}" />
<input type="hidden" name="flag" value="${flag}">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td style="width: 20%;" class="tableleft">菜单编号</td>
            <td><input type="text" readonly="readonly" name="operation_no" value="${user.operation_no}"/></td>
        </tr>
        <tr>
            <td class="tableleft">菜单名称</td>
            <td><input type="text" name="operation_name" value="${user.operation_name }"/></td>
        </tr>
        <tr>
            <td class="tableleft">菜单地址</td>
            <td><textarea name="operation_url" rows="3" cols="*">${user.operation_url }</textarea></td>
        </tr>
        <tr>
            <td class="tableleft">父菜单</td>
            <td>
            	<select name="parent_id" >
            		<option value="0">--请选择--</option>
            		<c:forEach items="${parentOperList }" var="parentOper">
            			<option value="${parentOper.operation_no }">${parentOper.operation_name }</option>
            		</c:forEach>
            	</select>
            	<c:if test="${flag=='add' }"><span style="color: gray;">（*如不选择父菜单则默认为一级菜单）</span></c:if>
            </td>	
        </tr>
        <tr>
            <td class="tableleft">菜单序号</td>
            <td><input type="text" name="operation_seq" value="${user.operation_seq }"/></td>
        </tr>
        <tr>
	        <td class="tableleft">状态</td>
	        <td>
	            <input type="radio" name="is_enable" value="1" checked="checked"/> 启用
	            <input type="radio" name="is_enable" value="0" /> 禁用
	        </td>
    	</tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button class="btn btn-primary" type="button" onclick="submitForm();">保存</button>
                &nbsp;&nbsp;<button type="button" onclick="returnList();" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

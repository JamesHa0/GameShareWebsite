<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/checkForm.js"></script>
    <script type="text/javascript">
    	function returnList(){
    		window.location.href="pc_SystemController.do?getUserList";
    	}
    	function init(flag){
    		if(flag=="add"){
    			document.form0.username.readOnly="";
    		}
    	}
    	/**
    	 *提交表单
    	 */
    	function submitForm(){
    		var form0=document.forms[0];
    		if(checkForm(form0)){
    			if(trim(form0.password.value)!=trim(form0.is_password.value)){
    				alert("两次密码不一致!");
    				return false;
    			}
    			if(confirm("确认提交吗?")){
    				document.form0.submit();
    			}
    		}
    	}
    </script>
</head>
<body onload="init('${flag}');">
<form name="form0" action="userController.do?method=saveUser" method="post" class="definewidth m20">
<input type="hidden" name="is_enable" value="${user.is_enable}" />
<input type="hidden" name="flag" value="${flag}">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td style="width: 20%;" class="tableleft">用户名</td>
            <td><input type="text" name="username" value="${user.username}" title="用户名" isneed="Y"  readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="password" value="${user.password }" title="密码" isneed="Y"  /></td>
        </tr>
        <tr>
            <td class="tableleft">确认密码</td>
            <td><input type="password"  name="is_password" value="${user.password }"/></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text"  name="realname" value="${user.realname}" title="真实姓名" isneed="Y"  checkType="Chinese" /></td>
        </tr>
        <tr>
            <td class="tableleft">手机</td>
            <td><input type="text" title="手机" name="mobile" value="${user.mobile}" isneed="Y"  checkType="number"  /></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="${user.email}" title="邮箱"  checkType="email" /></td>
        
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

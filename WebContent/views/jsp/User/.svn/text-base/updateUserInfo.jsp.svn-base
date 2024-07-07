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
    		window.location.href="pc_SystemController.do?getUserList";
    	}
    	function init(flag){
    		if(flag=="add"){
    			document.form0.username.readOnly="";
    		}
    	}
    	/**
    	 *表单校验
    	 */
    	function checkForm(){
    		if(trim(document.form0.username.value)==""){
    			alert("用户名不能为空！");
    			return false;
    		}
    		if(trim(document.form0.password.value)==""){
    			alert("密码不能为空！");
    			return false;
    		}
    		if(trim(document.form0.password.value).length<6){
    			alert("请输入至少六位密码!");
    			return false;
    		}
    		if(trim(document.form0.password.value)!=trim(document.form0.is_password.value)){
    			alert("两次密码不一致！");
    			return false;
    		}
    		if(trim(document.form0.realname.value)==""){
    			alert("真实姓名不能为空！");
    			return false;
    		}
    		if(trim(document.form0.mobile.value)==""){
    			alert("手机号不能为空！");
    			return false;
    		}
    		if(trim(document.form0.email.value)==""){
    			alert("邮箱不能为空！");
    			return false;
    		}
    		return true;
    	}
    	/**
    	 *提交表单
    	 */
    	function submitForm(){
    		if(checkForm()){
    			if(confirm("确认提交吗?")){
    				document.form0.submit();
    			}
    		}
    	}
    </script>
</head>
<body onload="init('${flag}');">
<form name="form0" action="pc_SystemController.do?saveUserInfo" method="post" class="definewidth m20">
<input type="hidden" name="is_enable" value="${user.is_enable}" />
<input type="hidden" name="flag" value="${flag}">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td style="width: 20%;" class="tableleft">用户名</td>
            <td><input type="text" maxlength="16" name="username" value="${user.username}" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" maxlength="16" name="password" value="${user.password }"/></td>
        </tr>
        <tr>
            <td class="tableleft">确认密码</td>
            <td><input type="password" maxlength="16" name="is_password" value="${user.password }"/></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="realname" value="${user.realname}"/></td>
        </tr>
        <tr>
            <td class="tableleft">手机</td>
            <td><input type="text" maxlength="11" name="mobile" value="${user.mobile}"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button class="btn btn-primary" type="button" onclick="submitForm();">保存</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

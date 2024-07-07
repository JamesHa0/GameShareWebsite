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
    		window.location.href="pc_SystemController.do?queryActorBtnList";
    	}
    	function init(is_enable,flag){
    		if(is_enable=="1"){
    			document.getElementsByName("is_enable")[0].checked="checked";
    		}else if(is_enable=="0"){
    			document.getElementsByName("is_enable")[1].checked="checked";
    		}
    		if(flag=="add"){
    			document.form0.actor_no.readOnly="";
    		}
    	}
    	/**
    	 *表单校验
    	 */
    	function checkForm(){
    		if(trim(document.form0.userYqm.value)==""){
    			alert("推荐码不能为空！");
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
<body >
<form name="form0" action="appUserController.do?saveAppUser" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td style="width: 20%;" class="tableleft">USERID</td>
            <td><input type="text"  name="userId" value="${user.userId}" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">手机号</td>
            <td><input type="text" readonly="readonly" name="userPhoneNo" value="${user.userPhoneNo }"/></td>
        </tr>
        <tr>
            <td class="tableleft">推荐码</td>
            <td><input type="text" name="userYqm" value="${user.userYqm }"/></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button class="btn btn-primary" type="button" onclick="submitForm();">保存</button>&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>

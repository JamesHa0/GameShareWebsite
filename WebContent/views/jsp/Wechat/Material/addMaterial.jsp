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
    <script type="text/javascript">
    	function returnList(){
    		window.location.href="wechatController.do?queryMaterialList";
    	}
    	/**
    	 *表单校验
    	 */
    	function checkForm(){
    		var matDesc = trim(document.form0.matDesc.value);
    		if(matDesc==""){
    			alert("素材标题不能为空！");
    			return false;
    		}
    		var pic = trim(document.form0.pic.value);
    		if(pic==""){
    			alert("请选择文件！");
    			return false;
    		}
    		return true;
    	}
    	/**
    	 *提交表单
    	 */
    	function submitForm(){
    		if(checkForm()){
    			if(confirm("确认上传该素材吗?")){
    				document.form0.submit();
    			}
    		}
    	}
    </script>
</head>
<body onload="init('${flag }');">
<form name="form0" action="wechatController.do?saveMaterial" 
	method="post" class="definewidth m20" enctype="multipart/form-data">
<input type="hidden" name="matType" value="image" >
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td style="width: 20%;" class="tableleft">素材标题</td>
            <td>
            	<input type="text" maxlength="10" name="matDesc" value="" />
            	<span style="color: gray;">(可以通过标题检索素材，请谨慎填写)</span>
            </td>
        </tr>
        <tr>
            <td style="width: 20%;" class="tableleft"></td>
            <td>
            	<input type="file" name="pic"/>
            	<span style="color: gray;">(只能上传jpg格式文件)</span>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button class="btn btn-primary" type="button" onclick="submitForm();">上传素材</button>
                &nbsp;&nbsp;
                <button type="button" onclick="returnList();" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

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
    		window.location.href="bookController.do?method=queryBookList";
    	}
    	function init(flag){
    		if(flag=="add"){
    			document.form0.bookname.readOnly="";
    		}
    	}
    	/**
    	 *提交表单
    	 */
    	function submitForm(){
    		var form0=document.forms[0];
    		if(checkForm(form0)){
    			if(confirm("确认提交吗?")){
    				document.form0.submit();
    			}
    		}
    	}
    </script>
</head>
<body onload="init('${flag}');">
<form name="form0" action="bookController.do?method=saveBook" method="post" class="definewidth m20">
<input type="text" name="id" value="${book.id}" />
<input type="hidden" name="flag" value="${flag}">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td style="width: 20%;" class="tableleft">书名</td>
            <td><input type="text" name="bookname" value="${book.bookname}"   readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">价格</td>
            <td><input type="text" name="price" value="${book.price }"   /></td>
        </tr>
        
        <tr>
            <td class="tableleft">作者名</td>
            <td><input type="text"  name="author" value="${book.author}"   /></td>
        </tr>
        
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

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
    	function reback(){
			window.history.go(-1);
    	}
    	function init(is_enable,flag){
    		if(is_enable=="1"){
    			document.getElementsByName("is_enable")[0].checked="checked";
    		}else if(is_enable=="0"){
    			document.getElementsByName("is_enable")[1].checked="checked";
    		}
    		if(flag=="add"){
    			document.form0.padUname.readOnly="";
    		}
    	}
    	
    	/**
    	 *提交表单
    	 */
    	function submitForm(){
    		if(confirm("确认提交吗?")){
    			document.form0.submit();
    		}
    	}
    </script>
</head>
<body onload="init('${user.is_enable}','${flag }');">
<form name="form0" action="pc_ParamSetController.do?savePadUser" method="post" class="definewidth m20">
<input type="hidden" name="flag" value="${flag}">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
        	<td style="width: 20%;" class="tableleft">用户名</td>
        	<td>
	        	<c:choose>
	        		<c:when test="${!empty user.padUname}">
	            		<input type="text" name="padUname" value="${user.padUname}" readonly="readonly"/>
	        		</c:when>
	        		<c:otherwise>
	        			<input type="text" name="padUname" value="${user.padUname}" />
	        		</c:otherwise>
	        	</c:choose>
        	</td>
        </tr>
        <c:if test="${'add' eq flag}">
	        <tr>
	        	<td class="tableleft">用户密码</td>
	            <td><input type="text" name="padPwd" value="${user.padPwd }" /></td>
	        </tr>
        </c:if>
        <tr>
            <td class="tableleft">所属分组</td>
            <td>
            	<c:if test="${'add' eq flag}">
            		<select name="group_no">
						<option value=""></option>
						<c:forEach items="${groupList}" var="group">
							<option value="${group.group_no }">
								${group.group_name }
							</option>
						</c:forEach>
					</select>
        		</c:if>
        		<c:if test="${'update' eq flag}">
        			<input type="hidden" name="group_no" value="${user.group_no }"/>
            		<input type="text" name="group_name" value="${user.group_name }" readonly="readonly"/>
            	</c:if>
            </td>
        </tr>
        <c:if test="${!empty user.createtime}">
	        <tr>
	        	<td class="tableleft">创建时间</td>
	            <td><input type="text" name="createtime" value="${user.createtime }" readonly="readonly"/></td>
	        </tr>
        </c:if>
        <c:if test="${!empty user.createid}">
	        <tr>
	        	<td class="tableleft">创建人</td>
	            <td>
	            <input type="hidden" name="id" value="${user.id }"/>
	            <input type="hidden" name="createid" value="${user.createid }"/>
	            <input type="text" name="createname" value="${user.createname }" readonly="readonly"/></td>
	            
	        </tr>
        </c:if>
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
                &nbsp;&nbsp;<button type="button" onclick="reback();" class="btn btn-success" name="backid" id="backid">返回</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

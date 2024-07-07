<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
 <head>
  <title> 失败页面</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="<%=path %>/views/Css/error/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="<%=path %>/views/Css/error/page-min.css" rel="stylesheet" type="text/css" />  

 </head>
 <body>
  
  <div class="container">
    <div class="row">
      <div class="span10">
        <div class="tips tips-large tips-warning">
          <span class="x-icon x-icon-error">×</span>
          <div class="tips-content">
            <h2>
            	<c:if test="${oper_desc == '' ||  oper_desc == null}">
            		对不起，您的操作失败了，请重新操作!
            	</c:if>
            	<c:if test="${oper_desc != '' }">
            		${oper_desc }
            	</c:if>
             </h2>
            <br>
<!--             <p class="auxiliary-text"> -->
<!--               你可以继续操作以下内容： -->
<!--             </p> -->
<!--             <p> -->
<!--               <a class="page-action" data-type="setTitle" title="编辑用户个性化功能权限" href="#">编辑用户个性化功能权限</a> -->
<!--               <a class="page-action" data-type="setTitle" title="配置用户数据权限" href="#">配置用户数据权限</a> -->
<!--               <a class="page-action" data-type="setTitle" title="返回用户管理" href="#">返回用户管理</a> -->
<!--             </p> -->
          </div>
        </div>
      </div> 
    </div>
  </div>
<body>
</html>

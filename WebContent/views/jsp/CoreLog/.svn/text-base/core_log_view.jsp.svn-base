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
</head>
<body >
<form name="form0" action="pc_SystemController.do?saveOperation" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr style="display: none;">
            <td style="width: 20%;" class="tableleft">自增ID</td>
            <td><input type="text" readonly="readonly"  value="${coreLog.coreId}"/></td>
        </tr>
          <tr style="display: none;">
            <td class="tableleft">操作类型</td>
            <td><input type="text"  value="${coreLog.coreType }"/></td>
        </tr>
        <tr>
            <td style="width: 20%;" class="tableleft">手机号</td>
            <td><input type="text" readonly="readonly"  value="${coreLog.userPhoneNo}"/></td>
        </tr>
        <tr>
            <td style="width: 20%;" class="tableleft">用户ID</td>
            <td><input type="text" readonly="readonly"  value="${coreLog.coreUserId}"/></td>
        </tr>
        <tr >
            <td class="tableleft">接口类型描述</td>
            <td><input readonly="readonly" type="text"  value="${coreLog.coreTypeDesc }"/></td>
        </tr>
        <tr>
            <td class="tableleft">请求数据</td>
            <td><textarea disabled="disabled" rows="3" cols="*">${coreLog.coreReqMess }</textarea></td>
        </tr>
        <tr >
            <td class="tableleft">请求时间</td>
            <td><input readonly="readonly" type="text"  value="${coreLog.coreReqTimeStr }"/></td>
        </tr>
        <tr>
            <td class="tableleft">返回数据</td>
            <td><textarea disabled="disabled" rows="3" cols="*">${coreLog.coreResMess }</textarea></td>
        </tr>
        <tr >
            <td class="tableleft">返回时间</td> 
            <td><input readonly="readonly" type="text"  value="${coreLog.coreResTimeStr }"/></td>
        </tr>
    </table>
</form>
</body>
</html>

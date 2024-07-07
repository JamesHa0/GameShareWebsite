<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@page import="crf.system.entity.*"%>
<%@ page isELIgnored="false"%>
<%
Map<Operation, List<Operation>>map=(Map<Operation, List<Operation>>)request.getAttribute("map");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js" ></script>
</head>
<script type="text/javascript">
	function updateUser(username){
		window.parent.location.href="pc_SystemController.do?addOrUpdateOperation&flag=update&operation_no="+username;
	}
	function delUser(username){
		if(confirm("确定删除吗?")){
			window.parent.location.href="pc_SystemController.do?delOperationByNo&operation_no="+username;
		}
	}
</script>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr>
        <th>菜单编号</th>
        <th>菜单名称</th>
        <th>菜单排序</th>
        <th>菜单地址</th>
        <th>父菜单</th>
        <th>菜单状态</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <%-- <%
		for(Operation operation : map.keySet()){
			out.print("<tr><td>"+operation.getOperation_no()+"</td><td>"+operation.getOperation_name()+"</td><td>"+operation.getOperation_seq()+"</td><td colspan='6'></td></tr>");
			List<Operation>list=map.get(operation);
			for(Operation oper:list){
				out.print("<tr>");
				out.print("<td>"+oper.getOperation_no()+"</td>");
				out.print("<td>"+oper.getOperation_name()+"</td>");
				out.print("<td>"+oper.getOperation_seq()+"</td>");
				out.print("<td>"+oper.getOperation_url()+"</td>");
				out.print("<td>"+oper.getParent_name()+"</td>");
				out.print("<td>"+oper.getIs_enable_desc()+"</td>");
				out.print("<td>"+oper.getCreatename()+"</td>");
				out.print("<td>"+oper.getCreatetime()+"</td>");
				out.print("<td>");
				out.print("<a href='javascript:void('0');' onclick=\"updateUser('"+oper.getOperation_no()+"');\">编辑</a>  ");
				out.print("<a href='javascript:void('0');' onclick=\"delUser('"+oper.getOperation_no()+"');\">删除</a>");
				out.print("</td>");
				out.print("</tr>");
			}
		}
	%> --%>
    
    
    
<!--     <c:forEach items="${userList}"  var="user"> -->
<!--      <tr > -->
<!--            <td>${user.operation_no}</td> -->
<!--            <td>${user.operation_name}</td> -->
<!--            <td>${user.operation_seq}</td> -->
<!--            <c:if test="${user.parent_id=='0' }"> -->
<!-- 	           <td colspan="6"></td> -->
<!--            </c:if> -->
<!--            <c:if test="${user.parent_id!='0' }"> -->
<!-- 	           <td>${user.operation_url}</td> -->
<!-- 	           <td>${user.parent_name }</td> -->
<!-- 	           <td>${user.is_enable_desc }</td> -->
<!-- 	           <td>${user.createname }</td> -->
<!-- 	           <td>${user.createtime }</td> -->
	           
<!-- 	           <td> -->
<!-- 	               <a href="javascript:void('0');" onclick="updateUser('${user.operation_no}');">编辑</a> -->
<!-- 	               <a href="javascript:void('0');" onclick="delUser('${user.operation_no}');">删除</a>  -->
<!-- 	           </td> -->
<!--            </c:if> -->
<!--        </tr> -->
<!--       </c:forEach>	 -->

</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

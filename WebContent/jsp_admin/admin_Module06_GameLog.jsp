<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="admin_query_purchase.jsp" />
<%
	Object allGameLogs = request.getAttribute("allGameLogs");
	String path = "admin_Module06_GameLog.jsp";
	
	request.setAttribute("path", path);
	
	String query = request.getParameter("query");
	if (allGameLogs == null) { // 对象为空
	    System.out.println("【主页检测】空   ：allGameLogs为空。query=" + query);
	    if ("queryAll".equals(query) || query == null) { // 自动全查 和 手动全查
	        request.getRequestDispatcher("../QueryAllGameLogServlet.do?path=" + path).forward(request, response);
	    } else {/* query = none（没查到） 或 get_it（查到了）。不做任何处理。*/}
	} else {
	    System.out.println("【主页检测】√   ：allGameLogs非空。query=" + query);
	}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>显示页面</title>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="../js/admin_Module06_GameLog.js"></script>
<style>
table input {
	border: none;
	padding: 0;
	height: 30px;
	width: 100px;
	background-color: transparent;
	font-family: Arial, sans-serif;
	font-size: 16px;
}

.hidden {
	display: none;
}

.read-only {
	cursor: not-allowed;
}
</style>

</head>

<body>

	<button id="addBtn" onclick="addBtn(this)">增添记录</button>


	<table border=""
		style="border-collapse: collapse; border: 1px solid black;">
		<tr>
			<th>用户ID</th>
			<th>游戏ID</th>
			<th width="220px">订单编号</th>
			<th width="150px">下单时间</th>
			<th>删除操作</th>
		</tr>

		<!-- 增添栏 -->
		<tr class="hidden" id="addRow">
			<th><input class="hidden" name="uid" required></th>
			<th><input class="hidden" name="gid" required></th>
			<th>——</th>
			<th>——</th>
			<th>——</th>
		</tr>

		<c:forEach items="${allGameLogs}" var="gameLog">
			<tr>
				<td><input class="editing" readonly name="uid"
					value="${gameLog.uid}"></td>
				<td><input class="editing" readonly name="gid"
					value="${gameLog.gid}"></td>
				<td><input class="editing" readonly name="onumber"
					value="${gameLog.onumber}" style="width: 100%;"></td>
				<td><input class="editing" readonly name="otime"
					value="${gameLog.otime}" style="width: 100%;"></td>
				<td>
					<button class="deleteBtn"
						onclick="confirmDelete('${gameLog.onumber}')">删除</button>
				</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>
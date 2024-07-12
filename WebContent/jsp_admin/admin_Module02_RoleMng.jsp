<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page="admin_query.jsp" />
<%
	Object x=request.getAttribute("allUsers");
	if(x == null){
		String path="admin_Module02_RoleMng.jsp";
		request.setAttribute("path", path);
		session.setAttribute("path", path);
		System.out.println("test");
		request.getRequestDispatcher("../QueryAllUserServlet.do?"+path).forward(request, response);
	}
%>
<!DOCTYPE html><html>
<head>
<meta charset="UTF-8">
<title>角色管理</title>
  <script type="text/javascript" src="../js/jquery-3.6.0.js"></script>
  <script type="text/javascript" src="../js/admin_Module02_RoleMng.js"></script>
<style>
table {
  border-collapse: collapse;
  border: 1px solid black;
}
table input {
  border: none;
  padding: 0;
  height: 30px;
  width: 100px;
  background-color: transparent;
  font-family: Arial, sans-serif;
  font-size: 16px;
}
.none{
	display:none;
}

  .read-only {
 		cursor: not-allowed;
}
   
</style>
</head>
<body>
	<table border="">
		<tr>
			<th>id</th>
			<th>昵称</th>
			<th>手机号</th>
			<th style="width:600px">角色</th>
     		<th>修改</th>
		</tr>
		
		<c:forEach items="${allUsers}" var="user">
      <tr>
        <td>${user.uid}</td>
        <td>${user.uname}</td>
        <td>${user.utel}</td>
        <!-- urole 角色修改： -->
        <td>
		    <label for="role-user">user:</label>
		    <input readonly class="editing_radio" type="radio" name="urole_${user.uid }" value="user" 
		    	<c:if test="${user.urole eq 'user'}">checked</c:if>>
		    <label for="role-vip">vip:</label>
		    <input readonly class="editing_radio" type="radio" name="urole_${user.uid }" value="vip" 
		    	<c:if test="${user.urole eq 'vip'}">checked</c:if>>
		    <label for="role-admin">admin:</label>
		    <input readonly class="editing_radio" type="radio" name="urole_${user.uid }" value="admin" 
		    	<c:if test="${user.urole eq 'admin'}">checked</c:if>>
	    </td>
	    <!-- 修改按钮 -->
	    <td><button class="updateBtn" onclick="enableEditing(this.parentNode.parentNode)">修改</button></td>
       
	    <!-- 隐藏： -->
	    <td class="none"><input class="none" name="uid"  		value="${user.uid}"    ></td>
        <td class="none"><input class="none" name="uname"  	value="${user.uname}"  ></td>
        <td class="none"><input class="none" name="utel"  	value="${user.utel}"  ></td>
        <td class="none"><input class="none" name="uemail"  	value="${user.uemail}" 	></td>
	    <td class="none"><input class="none" name="ugender"  	value="${user.ugender}" ></td>   
        <td class="none"><input class="none" name="uaddress" 	value="${user.uaddress}"></td> 
        <td class="none"><input class="none" name="upsw"  	value="${user.upsw}"  type="password"></td> 
        <td class="none"><input class="none" name="upoint"  	value="${user.upoint}" 	></td>
	
      </tr>
	    </c:forEach>
	    
	    
        </table>
</body>
</html>
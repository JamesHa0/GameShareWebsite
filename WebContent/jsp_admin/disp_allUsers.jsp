<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="admin_query.jsp" />
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>显示页面</title>
<!--   <link rel="stylesheet" type="text/css" href="xxx.css"> -->
  <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
  <script type="text/javascript" src="js/disp_allUsers.js"></script>
  <style>
  .editing { 
     border: none; 
     padding: 0; 
     height:30px; 
     width:100px; 
     background-color: transparent; 
     font-family: Arial, sans-serif;  
     font-size: 16px; 
   } 
   .read-only {
  		cursor: not-allowed;
	}
   
  </style>

</head>

<body>
	
	
	
  <table border="" style="border-collapse: collapse; border: 1px solid black;">
    <tr>
      <th>id</th>
      <th>昵称</th>
      <th>手机号</th>
      <th>邮箱</th>
      <th>角色</th>
      <th>性别</th>
      <th>地址</th>
      <th>密码</th>
      <th>积分</th>
      <th>删除操作</th>
      <th>修改操作</th>
    </tr>
    
	
	
    <c:forEach items="${allUsers}" var="user">
      <tr>
        <td><input class="editing" readonly name="uid"  		value="${user.uid}"    ></td>
        <td><input class="editing" readonly name="uname"  	value="${user.uname}"  ></td>
        <td><input class="editing" readonly name="utel"  	value="${user.utel}"  ></td>
        <td><input class="editing" readonly name="uemail"  	value="${user.uemail}" 	></td>
        <td><input class="editing" readonly name="urole"  	value="${user.urole}"  ></td>
        <td><input class="editing" readonly name="ugender"  	value="${user.ugender}" ></td>   
        <td><input class="editing" readonly name="uaddress" 	value="${user.uaddress}"></td> 
        <td><input class="editing" readonly name="upsw"  	value="${user.upsw}"  ></td> 
        <td><input class="editing" readonly name="upoint"  	value="${user.upoint}" 	></td>
        <td>  <button class="updateBtn" onclick="enableEditing(this.parentNode.parentNode)">修改</button></td>
        <td>  <button class="deleteBtn" onclick="confirmDelete('${user.uid}')">删除</button></td>
      </tr>
	    </c:forEach>
  </table>


</body>
</html>
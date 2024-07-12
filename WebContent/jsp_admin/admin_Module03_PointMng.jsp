<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page="admin_query.jsp" />
<jsp:include page="header_123.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色管理</title>
  <script type="text/javascript" src="../js/jquery-3.6.0.js"></script>
  <script type="text/javascript" src="../js/admin_Module03_PointMng.js"></script>

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
input[name=upoint]{
	width:400px;
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

	
<c:if test="${param.query == 'none'}">
	<h3>查找的用户不存在。</h3>
</c:if>

<c:if test="${param.query != 'none'}">
	<table border="">
		<tr>
			<th>id</th>
			<th>昵称</th>
			<th>手机号</th>
			<th>修改积分</th>
     		<th>修改</th>
		</tr>
		
<c:forEach items="${allUsers}" var="user">
      <tr>
      	<!-- 基本数据： -->
        <td>${user.uid}</td>
        <td>${user.uname}</td>
        <td>${user.utel}</td>
        
        <!-- upoint 积分修改： -->
        <td>
		    <label for="upoint">修改积分:</label>
		    <input readonly class="editing"  id="upoint" name="upoint"  	value="${user.upoint}"    >
	    </td>
	    
	    <!-- 修改按钮 -->
	    <td><button class="updateBtn" onclick="enableEditing(this.parentNode.parentNode)">修改</button></td>
       
	    <!-- 隐藏项： -->
	    <td class="none"><input class="editing" name="uid"  	value="${user.uid}"    ></td>
	    <td class="none"><input class="editing" name="urole_${user.uid}"  	value="${user.urole}"    ></td>
        <td class="none"><input class="editing" name="uname"  	value="${user.uname}"  ></td>
        <td class="none"><input class="editing" name="utel"  	value="${user.utel}"  ></td>
        <td class="none"><input class="editing" name="uemail"  	value="${user.uemail}" 	></td>
	    <td class="none"><input class="editing" name="ugender"  	value="${user.ugender}" ></td>   
        <td class="none"><input class="editing" name="uaddress" 	value="${user.uaddress}"></td> 
        <td class="none"><input class="editing" name="upsw"  		value="${user.upsw}"  type="password"></td> 
	
      </tr>
</c:forEach>
	    
	    
        </table>
        
</c:if>
</body>
</html>
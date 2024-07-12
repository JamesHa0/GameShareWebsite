<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>日志显示页面</title>
  <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
  <script type="text/javascript" src="js/disp_allUsers.js"></script>
  <style>
  table input{ 
     border: none; 
     padding: 0; 
     height:30px; 
     width:100px; 
     background-color: transparent; 
     font-family: Arial, sans-serif;  
     font-size: 16px; 
   } 
   .hidden{
   		display:none;
   }
   .read-only {
  		cursor: not-allowed;
	}
   
  </style>

</head>

<body>
	
	<button id="addBtn" onclick="addBtn(this)">增添记录</button>
	
	
  <table border="" style="border-collapse: collapse; border: 1px solid black;">
    <tr>
      <th>日志id</th>
      <th>操作者id</th>
      <th>操作角色</th>
      <th>操作时间</th>
      <th>操作内容</th>
      <th>是否成功</th>
      
      <th>删除日志</th>
    </tr>
    	
    <c:forEach items="${logs}" var="user">
      <tr>
        <td>${logs.uid}</td>
        <td>${logs.urole}</td>
        <td>  <button class="deleteBtn" onclick="confirmDelete('${logs.uid}')">删除</button></td>
      </tr>
	    </c:forEach>
  </table>


</body>
</html>
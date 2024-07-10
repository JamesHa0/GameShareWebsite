<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示页面</title>
<link rel="stylesheet" type="text/css" href="css/disp_Student.css">

</head>
<body>
	<table border="1" style="border-collapse: collapse; border: 1px solid black;">
		<tr>
			<th>id</th>
			<th>昵称</th>
			<th>手机号</th>
			<th>邮箱</th>
			<th>角色</th>
			<th>性别</th>
			<th>地址</th>
			<th>删除操作</th>
			<th>修改操作</th>
		</tr>
		
		
		
		<c:forEach items="${allUsers }" var="user">
			<tr>
				<td>${user.uid}</td>
				<td>${user.uname }</td>
				<td>${user.utel }</td>
				<td>${user.uemail }</td>
				<td>${user.urole }</td>
				<td>${user.ugender }</td>
				<td>${user.uaddress }</td>
				<td><button onclick="confirmDelete()">删除</button></td>
				<td><button onclick="confirmUpdate()">修改</button></td>
			</tr>
		</c:forEach>
	</table>
	
	<script>
    function confirmDelete() {
        var result = confirm("是否删除？");
        if (result) {
            window.location.href = "../x?uid="+"${user.uid}";//携带uid参数 
        }
    }
    function confirmUpdate() {
           window.location.href = "../x?uid="+"${user.uid}";//携带uid参数 
    }
    
    function confirmDelete2() {
        var userResponse = confirm("您确定要删除吗？");
        if (userResponse) {
            // 创建一个XMLHttpRequest对象
            var xhr = new XMLHttpRequest();
            // 配置请求类型、URL及异步处理方式
            xhr.open("GET", "/path/to/your/servlet", true);
            xhr.onload = function () {
                if (xhr.status === 200) {
                    alert('删除成功');
                } else {
                    alert('操作失败');
                }
            };
            // 发送请求
            xhr.send();
        }
    }
	</script>
	

</body>
</html>
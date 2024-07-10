<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询页面</title>
<link rel="stylesheet" type="text/css" href="../css/admin_query.css">
</head>
<body>
	<form action="..//QueryUserServlet.do" method="post">
		请输入该用户的id、手机号或邮箱：（填写一项即可） <br>
		<select name="select" onchange="changeNameOfInput(this)"><!-- this指此select元素 -->
            <option value="1" selected="selected">id</option>
            <option value="2">手机号</option>
            <option value="3">邮箱</option>
        </select>
        <input name="uid" id="val">
        
		<script>
        function changeNameOfInput(select) {
            // 根据选择的选项值设置 input 的 name 属性
            if (select.value === "1") {
            	document.getElementById('val').name = "uid";
            } else if (select.value === "2") {
            	document.getElementById('val').name = "utel";
            } else if (select.value === "3") {
            	document.getElementById('val').name = "uemail";
            }
        }
    	</script>
		
		<input type="submit" value="提交">
	</form>
</body>
</html>
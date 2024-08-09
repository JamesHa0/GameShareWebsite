<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>报错页面</title>
<link rel="stylesheet" type="text/css" href="css/error.css">
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script>
    setTimeout(function() {//通过js设置1s后跳转
        window.location.href = '${requestScope.path}';
    }, 1000);
</script>
</head>

<body>
	<div class="container">
	  <p class="message">${requestScope.msg }</p>
	</div>
</body>
</html>
	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询页面</title>
 
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/admin_query.css">
</head>
<body>
	<form action="../QueryGameLogServlet.do" method="post">
		<select name="select" id="admin_query_jsp_select" onchange="changeNameOfInput(this)"><!-- this指此select元素 -->
            <option value="1" selected="selected" >游戏id</option>
            <option value="2">用户id</option>
        </select>
        <input name="gid" id="admin_query_jsp_input" placeholder="请输入待查询游戏的id或用户id：（填写一项即可）">
        
		<script>
        function changeNameOfInput(select) {
            // 根据选择的选项值设置 input 的 name 属性
            if (select.value === "1") {
            	select.nextElementSibling.name="gid";
            } else if (select.value === "2") {
            	select.nextElementSibling.name="uid";
            } 
        }
    	</script>
		
		<input class="querySubmit" type="submit" value="提交" >
	</form>
</body>
</html>
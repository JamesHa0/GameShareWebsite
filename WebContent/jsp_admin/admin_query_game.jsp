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
	<%
	//获取主jsp的文件名：
		String URI = request.getRequestURI();//例如/GameShareWebsite/jsp_admin/admin_Module01_UserMng.jsp
		int i = URI.lastIndexOf("/");
		String path=URI.substring(i+1);//例如admin_Module01_UserMng.jsp
		

		System.out.println("【test!!】---path="+path+" ; ");
	%>
	<form action="../QueryGameServlet.do?path=<%=path %>" method="post">
		<select name="select" id="admin_query_jsp_select" onchange="changeNameOfInput(this)"><!-- this指此select元素 -->
            <option value="1" selected="selected" >游戏id</option>
            <option value="2">游戏名</option>
        </select>
        <input name="gid" id="admin_query_jsp_input" placeholder="请输入待查询游戏的id或游戏名：（填写一项即可）">
        
		<script>
        function changeNameOfInput(select) {
            // 根据选择的选项值设置 input 的 name 属性
            if (select.value === "1") {
            	select.nextElementSibling.name="gid";
            } else if (select.value === "2") {
            	select.nextElementSibling.name="gname";
            } 
        }
    	</script>
		
		<input class="querySubmit" type="submit" value="提交" >
	</form>
</body>
</html>
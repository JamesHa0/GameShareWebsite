<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询页面</title>
<%-- <%="当前项目根目录为："+ request.getContextPath()%> --%>
<%--  <%="当前servletPath为："+ request.getServletPath() %> --%>
<%--  <%="当前RequestURI为："+ request.getRequestURI() %> --%>
 
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
	<form action="../QueryUserServlet.do?path=<%=path %>" method="post">
		<select name="select" id="admin_query_jsp_select" onchange="changeNameOfInput(this)"><!-- this指此select元素 -->
            <option value="1" selected="selected" >id</option>
            <option value="2">手机号</option>
            <option value="3">邮箱</option>
        </select>
        <input name="uid" id="admin_query_jsp_input" placeholder="请输入待查询用户的id、手机号或邮箱：（填写一项即可）">
        
		<script>
        function changeNameOfInput(select) {
            // 根据选择的选项值设置 input 的 name 属性
            if (select.value === "1") {
            	select.nextElementSibling.name="uid";
            } else if (select.value === "2") {
            	select.nextElementSibling.name="utel";
            } else if (select.value === "3") {
            	select.nextElementSibling.name="uemail";
            }
        }
    	</script>
		
		<input class="querySubmit" type="submit" value="提交" >
	</form>
</body>
</html>
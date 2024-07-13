<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用于被Module123模块包含的jsp头部脚本</title>
</head>
<body>
<%
System.out.println("——————————————————————————————————————————————到了模块主页：————————————————————————————————————————");
	Object allUsers=request.getAttribute("allUsers");
	//获取主jsp的文件名：
	String URI = request.getRequestURI();//例如/GameShareWebsite/jsp_admin/admin_Module01_UserMng.jsp
	int i = URI.lastIndexOf("/");
	String path=URI.substring(i+1);//例如admin_Module01_UserMng.jsp
	
	request.setAttribute("path", path);
	session.setAttribute("path", path);
	String query=request.getParameter("query");
	
	if(allUsers == null){//对象为空
	    System.out.println("【主页检测】空   ：allUsers为空。query=" + query);
		if("queryAll".equals(query) || query == null){ // 自动全查 和 手动全查
			request.getRequestDispatcher("../QueryAllUserServlet.do?path="+path).forward(request, response);
		}else {
	        // query = none（没查到） 或 get_it（查到了）。不做任何处理。
	    }
	}else{
	    System.out.println("【主页检测】√   ：allUsers非空。query=" + query);
	}
%>
</body>
</html>
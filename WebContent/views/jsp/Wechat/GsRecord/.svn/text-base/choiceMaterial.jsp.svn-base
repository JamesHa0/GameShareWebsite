<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'choiceMaterial.jsp' starting page</title>
<script type="text/javascript">
	function callBack(matMediaId,matUrl,tag){
		window.opener.document.getElementById(tag).style.width= "120px";
		window.opener.document.getElementById(tag).style.height= "60px";
		window.opener.document.getElementById(tag).src= matUrl;
		window.opener.document.getElementsByName(tag)[0].value=matMediaId;
		window.close();
	}
</script>
</head>
<body  onblur="self.focus();" >
	<c:forEach items="${list}"  var="user">
		<img  onclick="callBack('${user.matMediaId }','${user.matUrl}','${tag }')" src="${user.matUrl}" 
				style="width: 200px;height: 200px;cursor: hand;">
	</c:forEach>
</body>
</html>

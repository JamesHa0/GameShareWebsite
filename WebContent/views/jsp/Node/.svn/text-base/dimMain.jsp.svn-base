<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>dimMain</title>
  </head>
	<frameset rows="*" cols="230,*" framespacing="1"  frameborder="no" border="0" >
   		<frame src="pc_SystemController.do?dimLeft" name="mainLeft" marginwidth="0" marginheight="0"  scrolling="yes"  />
<!-- 		<frame src="pc_SystemController.do?dimRight&dim_id=001&dim_type=T&parentid=0&tree_id=001&node_level=1'" name="mainRight" id="mainRight" title="mainRight" marginwidth="0" marginheight="0"  frameborder="0" scrolling="auto" /> -->
   		<frame src="${pageContext.request.contextPath}/pc_SystemController.do?dimNew&dim_id=0&parentid=0&dim_type=M&tree_id=&node_level=0" name="mainRight" id="mainRight" title="mainRight" marginwidth="0" marginheight="0"  frameborder="0" scrolling="auto" />
   	</frameset>
  <body>
  </body>
</html>

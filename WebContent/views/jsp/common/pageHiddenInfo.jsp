<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<script type="text/javascript">
		window.parent.document.getElementById("currentPage_font").innerHTML="${currentPage}";
		window.parent.document.getElementById("totalPage_font").innerHTML="${totalPage}";
		window.parent.document.getElementById("totalCount_font").innerHTML="${totalCount}";
		window.parent.document.getElementById("currentPage").value="${currentPage}";
		window.parent.document.getElementById("totalPage").value="${totalPage}";
	</script>
  </head>
  <body>
  </body>
</html>

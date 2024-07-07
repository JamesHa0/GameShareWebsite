<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
</head>
<script type="text/javascript">
	function updateBook(id){
		window.parent.location.href="bookController.do?method=addOrUpdateBook&flag=update&id="+id;
	}
	function deleteBook(id){
		window.parent.location.href="bookController.do?method=deleteBook&id="+id;
	}
	

</script>
<body onload="initParentFrameHeight();">
<table class="table table-bordered table-hover definewidth m10" id="table1">
    <thead>
    <tr >
        <th>书名</th>
        <th>价格</th>
        <th>作者</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${bookList}"  var="book">
     <tr >
           <td >${book.bookname}</td>
           <td>${book.price}</td>
           <td>${book.author}</td>

           <td>
               <a href="javascript:void('0');" onclick="updateBook('${book.id}');">编辑</a> 
               <a href="javascript:void('0');" onclick="deleteBook('${book.id}');">删除</a> 
           </td>
       </tr>
      </c:forEach>	
</table>
</body>
<%@ include file="../common/pageHiddenInfo.jsp" %>
</html>

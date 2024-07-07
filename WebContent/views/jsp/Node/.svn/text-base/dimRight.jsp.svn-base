<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="crf.system.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
DimNode node = null;
DimTree tree = null;

String dim_type = (String) request.getAttribute("dim_type");
String dim_id = (String) request.getAttribute("dim_id");
String parentid = (String) request.getAttribute("parentid");
String tree_id = (String) request.getAttribute("tree_id");
String node_level = (String) request.getAttribute("node_level");
String dim_name = "", dim_no = "";
String msg = (String) request.getAttribute("message");

if ("T".equals(dim_type)) {
	tree = (DimTree) request.getAttribute("result");
	dim_name = tree.getTree_name();
	dim_no = dim_id;

} else if ("N".equals(dim_type)) {
	node = (DimNode) request.getAttribute("result");
	dim_name = node.getNode_name();
	dim_no = node.getNode_no();
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>dimRight</title>
    <link rel=stylesheet href="${pageContext.request.contextPath}/views/Css/main.css">
    <script type="text/javascript" src="<%=path %>/views/Js/jquery.js"></script>
    <script type="text/javascript">
    function Trim(s) {
        var m = s.match(/^\s*(\S+(\s+\S+)*)\s*$/);
        return (m == null) ? "": m[1];
    }
    var freshtag = false;

    function IsNotNumber(str) {
        str = trim(str);
        if (str == '') return true;
        var number_chars = "1234567890";
        var i;
        for (i = 0; i < str.length; i++) {
            if (number_chars.indexOf(str.charAt(i)) == -1) return true;
        }
        return false;
    }

    function refresh() {
        if (freshtag == true) parent.frames["mainLeft"].location.href = "${pageContext.request.contextPath}/pc_SystemController.do?dimLeft";
    }

    function newdim() {
    	document.forms[0].action="pc_SystemController.do?dimNew";
        document.forms[0].submit();

    }

    function deldim() {
        var delPrompt = "你真的要删除 [" + document.forms[0].dim_name.value + "] 节点吗？";
        if (confirm(delPrompt)) {
            freshtag = true;
            document.forms[0].action="pc_SystemController.do?delDim";
            document.forms[0].submit();
        } 
    }

    function submitdim() {
    	document.forms[0].action="pc_SystemController.do?updateDim";
        document.forms[0].submit();
    }

    if ("<%=msg%>" != "null" && "<%=msg%>" != "" && "<%=msg%>" != null) {
        freshtag = true;
        refresh();
    };
    </script>
  </head>
  
  <body  bgcolor="#FFFFFF" leftmargin="0" topmargin="0" onunload="refresh()">
  	<form action = "/DimAction"method = "POST">

	<input type = "hidden"name = "method" > <input name = "dim_type"type = "hidden"id = "dim_type"maxlength = "10"value = "<%=dim_type%>" > <input name = "dim_id"type = "hidden"id = "dim_id"maxlength = "10"value = "<%=dim_id%>" > <input name = "parentid"type = "hidden"id = "parentid"maxlength = "10"value = "<%=parentid%>"readonly = "" > <input name = "tree_id"type = "hidden"id = "tree_id"maxlength = "10"value = "<%=tree_id%>"readonly = "" > 
	<input name = "node_level"type = "hidden"id = "node_level"maxlength = "10"value = "<%=node_level%>"readonly = "" >
	
	<table width = "100%"border = "0"cellspacing = "0"cellpadding = "0" > <tr > <td bgcolor = "EFF6FE"align = "center"height = "27"class = "text" > 维度信息 </td>
			  </tr > </table>
	
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg1">
						<table width="100%" border="0" cellpadding="1" cellspacing="1"
							bgcolor="819CB9">
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%" border="0" cellspacing="0" cellpadding="8">
										<tr>
											<td bgcolor="EFF6FE">
												<table width="99%" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr >
													<td class="ftd_1">
														维度编号
														<span class="red">*</span > </td>
													<td class="ftd_2">
														<input name="dim_no" type="text" id="dim_no" maxlength="25"
															value="<%=dim_no%>" <%if("T".equals(dim_type)){%>
															readonly="true" <%}%> >
													</td > </tr>
													<tr >
													<td class="ftd_1">
														维度名称
														<span class="red">*</span > </td>
													<td class="ftd_2">
														<input name="dim_name" type="text" id="dim_name"
														maxlength="20" value="<%=dim_name%>" >
													</td > </tr>
										
												</table > </td>
										</tr > </table>
								</td > </tr>
						</table >
						 <table width = "100%"align ="center"border = "0"cellspacing = "0"cellpadding = "0" > 
						 <tr> <td height = "5" > </td>
							</tr > <tr align = "right" > 
								<td > <img src = "${pageContext.request.contextPath}/views/Images/button/xz.gif" border = "0"onclick = "javascript:newdim()"style = "cursor: hand" >
								 <img src = "${pageContext.request.contextPath}/views/Images/button/bc.gif"border = "0"onclick = "javasrcipt:submitdim()"style = "cursor: hand" >
								  <img src = "${pageContext.request.contextPath}/views/Images/button/sc.jpg"border = "0"onclick = "javasrcipt:deldim()" style = "cursor:hand" >
								</td>
							</tr > </table>

					</td > </tr>
			</table > </form>
  </body>
</html>

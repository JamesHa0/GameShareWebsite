<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="crf.system.entity.*"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	String dim_type = (String) request.getAttribute("dim_type");
	String dim_id = (String) request.getAttribute("dim_id");
	String parentid = (String) request.getAttribute("parentid");
	String tree_id = (String) request.getAttribute("tree_id");
	String node_level = (String) request.getAttribute("node_level");
%>

<html>
	<head>
		<script type="text/javascript" language="javascript">
	
   	function Trim(s){var m = s.match(/^\s*(\S+(\s+\S+)*)\s*$/);return (m == null)?"":m[1];}
	var total=0;
	function refresh()
	{
   		parent.frames["mainLeft"].location.href = "${pageContext.request.contextPath}/pc_SystemController.do?dimLeft";
	}

	function newdim() {
	    addrow();
	}

	function submitdim() {
	    var the_table = document.getElementById("the_table");
	    itotal = the_table.rows.length;
	    if (itotal == 2) {
	        return false;
	    }
	    var sum = 0;
	    for (var i = 2; i < itotal; i++) {
	        var id = the_table.rows[i].id;
	        var o = "dim_no" + id;
	        t = document.getElementById(o);
	        if (Trim(t.value) == "") {
	            alert("请输入维度编号");
	            t.focus();
	            return false;
	        }
	        sum = 0;
	        for (var j = 2; j < itotal; j++) {
	            var pos = the_table.rows[j].id;
	            var o1 = "dim_no" + pos;
	            t1 = document.getElementById(o1);
	            if (Trim(t.value) == Trim(t1.value)) {
	                sum = sum + 1;
	            }
	        }

	        if (sum > 1) {
	            alert("有重复维度编号");
	            t.focus();
	            return false;
	        }

	        o = "dim_name" + id;
	        t = document.getElementById(o);
	        if (Trim(t.value) == "") {
	            alert("请输入维度名称");
	            t.focus();
	            return false;
	        }

	        sum = 0;
	        for (j = 2; j < itotal; j++) {
	            pos = the_table.rows[j].id;
	            o1 = "dim_name" + pos;
	            t1 = document.getElementById(o1);
	            if (Trim(t.value) == Trim(t1.value)) {
	                sum = sum + 1;
	            }
	        }
	        if (sum > 1) {
	            alert("有重复维度名称");
	            t.focus();
	            return false;
	        }
	    }
	    document.forms[0].action="pc_SystemController.do?newDimSubmit";
	    document.forms[0].submit();
	}
	//增加一行记录
	function addrow() {
	    var newrow = the_table.insertRow(the_table.rows.length);
	    newrow.cellpadding = "0";
	    newrow.cellspacing = "1";

	    newrow.bgColor = "#FFFFFF";
	    newrow.id = total;
	    // 	  newrow.ln=total;
	    the_cell = newrow.insertCell(0);

	    the_cell.innerHTML = "<INPUT SIZE=\"25\"  TYPE=\"text\" NAME='dim_no' id=dim_no" + total + ">";
	    the_cell.align = "center";
	    the_cell = newrow.insertCell(1);
	    the_cell.innerHTML = "<INPUT SIZE=\"30\" TYPE=\"text\" NAME='dim_name' id=dim_name" + total + ">";
	    the_cell.align = "center";
	    the_cell = newrow.insertCell(2);
	    the_cell.align = "center";
	    // the_cell.innerHTML="<input   type=button   value='删除'   ln="   +   total   +   "   onclick=\"javascript:delrow('','');\">";
	    the_cell.innerHTML = "<img src=\"${pageContext.request.contextPath}/views/Images/button/sc.jpg\" border=\"0\"   ln=" + total + "   onclick=\"javascript:delrow(" + total + ");\" style=\"cursor: hand\">";
	    total++;
	}
   //删除一行   
	function   delrow(tr_id)  
	{   
	  var table = document.getElementById("the_table");
	  var row = document.getElementById(tr_id);
	  table.deleteRow(row.rowIndex);
	}   
	
   </script>
		<title>新增维度信息</title>
	</head>
	<link rel=stylesheet href="${pageContext.request.contextPath}/views/Css/main.css">


	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0"
		onunload="refresh()">

		<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		  <tr> 
		    <td bgcolor="EFF6FE"  align="center" height="27" class="text">新增维度</td>
		  </tr>
		</table>
 	


		<table width="100%" border="0" align="center" cellpadding="2"
			cellspacing="0">
			<tr>
				<td>
					<form action="pc_SystemController.do?newDimSubmit" method="POST">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<input type="hidden" name="method">

								<td>
									<table width="80%" align="center" border="0" cellpadding="2"
										cellspacing="1" bgcolor="88B3E0" id="the_table">
										<tr>
											<td align="center" bgcolor="EFF6FE" 
												background="${pageContext.request.contextPath}/views/Images/main/bg03.gif">
												节点类型
											</td>
											<td  bgcolor="EFF6FE" align="center"
												background="${pageContext.request.contextPath}/views/Images/main/bg03.gif">
												<INPUT TYPE="radio" name="nodeprod" value="1" checked>
												同级节点
												<INPUT TYPE="radio" name="nodeprod" value="0">
												子节点
											</td>
											<td height="24" align="center"  bgcolor="EFF6FE"
												background="${pageContext.request.contextPath}/views/Images/main/bg03.gif">
											</td>
										</tr>
										<tr>
											<td  bgcolor="EFF6FE"
												background="${pageContext.request.contextPath}/views/Images/main/bg03.gif">
												<p align="center">
													维度编号
											</td>
											<td  bgcolor="EFF6FE"
												background="${pageContext.request.contextPath}/views/Images/main/bg03.gif">
												<p align="center">
													维度名称
											</td>
											<td  bgcolor="EFF6FE"
												background="${pageContext.request.contextPath}/views/Images/main/bg03.gif">
												<p align="center">
													操作
											</td>
										</tr>
										<%--  <tr  id="1" bgColor="#FFFFFF" cellpadding="0" cellspacing="1">
											<td align="center">
												<input SIZE="25"  TYPE="text" NAME='dim_no1' id="dim_no1">
											</td>
											<td align="center">
												<input SIZE="30"  TYPE="text" NAME='dim_name1' id="dim_name1">
											</td>
											<td align="center">
												<img src="${pageContext.request.contextPath}/views/Images/button/sc.jpg" 
													 border="0" onclick="javascript:delrow('1');" style="cursor: hand">
											</td>
										</tr>  --%>
									</table>

									<table width="80%" align="center" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="5"></td>
										</tr>
										<tr align="right">
											<td>
												<input name="dim_type" type="hidden" id="dim_type"
													maxlength="10" value="<%=dim_type%>">
												<input name="dim_id" type="hidden" id="dim_id"
													maxlength="10" value="<%=dim_id%>" readonly="">
												<input name="parentid" type="hidden" id="parentid"
													maxlength="10" value="<%=parentid%>" readonly="">
												<input name="tree_id" type="hidden" id="tree_id"
													maxlength="10" value="<%=tree_id%>" readonly="">
												<input name="node_level" type="hidden" id="node_level"
													maxlength="10" value="<%=node_level%>" readonly="">


												<img src="${pageContext.request.contextPath}/views/Images/button/xz.gif" border="0"
													onclick="javascript:newdim()" style="cursor: hand">
												<img src="${pageContext.request.contextPath}/views/Images/button/bc.gif" border="0"
													onclick="javasrcipt:submitdim()" style="cursor: hand">

											</td>
										</tr>
									</table>								

								</td>
							</tr>

						</table>

					</form>
				</td>
			</tr>

		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" height="300px;">
				<tr>
					<td class="bg1">
						<table width="100%" border="0" cellpadding="1" cellspacing="1"
							bgcolor="819CB9">
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%" border="0" cellspacing="0" cellpadding="8">
										<tr>
											<td bgcolor="EFF6FE">
												<span style="list-style-type:none; font-size: 15px;">操作说明：</span><br>
														<span  style="list-style-type:none; font-size: 13px;">&nbsp;&nbsp;1.维度编号不能重复并且请按照编号规则填写</span><br>
														<span  style="list-style-type:none; font-size: 13px;">&nbsp;&nbsp;2.有子节点的维度不能删除</span><br>
<!-- 														<span  style="list-style-type:none; font-size: 13px;">&nbsp;&nbsp;2.系统申请单表头和系统申请单申请类型 节点下的生产系统名称要和本系统中注册的生产系统名称相一致，请不要随意更改</span> -->
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	</body>

</html>
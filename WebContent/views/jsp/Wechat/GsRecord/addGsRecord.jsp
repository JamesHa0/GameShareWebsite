<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>HEHE</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
	<script type="text/javascript">
		function returnList(){
			window.location.href="wechatController.do?queryGsRecordList";
		}
		function choice(tag){
			var url = "wechatController.do?toChoiceMaterial&tag="+tag.id;
			var w = window.open(url,'newwindow','height=600,width=900,left=250,top=50,scrollbars=yes,resizable=no,location=no, status=yes'); 
			w.focus();
		}
		function submitForm(){
			for(var i=1;i<=5;i++){
				var artTitle = "artTitle"+i;
				var artContent = "artContent"+i;
				var artTmi = "artTmi"+i;
				
				var artTitleValue = trim(document.getElementsByName(artTitle)[0].value);
				var artContentValue = trim(document.getElementsByName(artContent)[0].value); 
				var artTmiValue = trim(document.getElementsByName(artTmi)[0].value);
				
				
				if(artTitleValue=='' && artTmiValue=='' && artContentValue=='')
					continue;
				if(artTitleValue=='' || artTmiValue=='' || artContentValue==''){
					alert("内容、标题和素材是必填项");
					return;
				}
			}
			for(var i=1;i<=5;i++){
				var artTitle = "artTitle"+i;
				var artTitleValue = trim(document.getElementsByName(artTitle)[0].value);
				
				if(artTitleValue!=''){
					if(confirm("确认群发消息吗?")){
						document.form0.submit();
					}
					break;
				}
			}
		}
	</script>
</head>
<body>
<form name="form0" action="wechatController.do?doGroupSend" 
	method="post" class="definewidth m20" >
	<table class="table table-bordered table-hover m10">
		<tr>
			<td>标题<span style="color: red;">(*)</span></td>
			<td>内容<span style="color: red;">(*)</span></td>
			<td>链接</td>
			<td>封面<span style="color: red;">(*)</span></td>
		</tr>
		<tr>
			<td style="vertical-align: middle;"><input name="artTitle1" type="text"></td>
			<td style="vertical-align: middle;"><textarea rows="2" cols="20" name="artContent1"></textarea></td>
			<td style="vertical-align: middle;"><input name="artCsu1" type="text"></td>
			<td style="vertical-align: middle;"><img id="artTmi1" style="cursor: hand;" src="<%=path %>/views/Images/choiceImg.jpg" alt="选择素材" onclick="javascript:choice(this);"/></td>
			<td style="display: none;"><input type="hidden" name="artTmi1"></td>
		</tr>
		<tr>
			<td style="vertical-align: middle;"><input name="artTitle2" type="text"></td>
			<td style="vertical-align: middle;"><textarea rows="2" cols="20" name="artContent2"></textarea></td>
			<td style="vertical-align: middle;"><input name="artCsu2" type="text"></td>
			<td style="vertical-align: middle;"><img id="artTmi2" style="cursor: hand;" src="<%=path %>/views/Images/choiceImg.jpg" alt="选择素材" onclick="javascript:choice(this);"/></td>
			<td style="display: none;"><input type="hidden" name="artTmi2"></td>
		</tr>
		<tr>
			<td style="vertical-align: middle;"><input name="artTitle3" type="text"></td>
			<td style="vertical-align: middle;"><textarea rows="2" cols="20" name="artContent3"></textarea></td>
			<td style="vertical-align: middle;"><input name="artCsu3" type="text"></td>
			<td style="vertical-align: middle;"><img id="artTmi3" style="cursor: hand;" src="<%=path %>/views/Images/choiceImg.jpg" alt="选择素材" onclick="javascript:choice(this);"/></td>
			<td style="display: none;"><input type="hidden" name="artTmi3"></td>
		</tr>
		<tr>
			<td style="vertical-align: middle;"><input name="artTitle4" type="text"></td>
			<td style="vertical-align: middle;"><textarea rows="2" cols="20" name="artContent4"></textarea></td>
			<td style="vertical-align: middle;"><input name="artCsu4" type="text"></td>
			<td style="vertical-align: middle;"><img id="artTmi4" style="cursor: hand;" src="<%=path %>/views/Images/choiceImg.jpg" alt="选择素材" onclick="javascript:choice(this);"/></td>
			<td style="display: none;"><input type="hidden" name="artTmi4"></td>
		</tr>
		<tr>
			<td style="vertical-align: middle;"><input name="artTitle5" type="text"></td>
			<td style="vertical-align: middle;"><textarea rows="2" cols="20" name="artContent5"></textarea></td>
			<td style="vertical-align: middle;"><input name="artCsu5" type="text"></td>
			<td style="vertical-align: middle;"><img id="artTmi5" style="cursor: hand;" src="<%=path %>/views/Images/choiceImg.jpg" alt="选择素材" onclick="javascript:choice(this);"/></td>
			<td style="display: none;"><input type="hidden" name="artTmi5"></td>
		</tr>
	</table>
	<table width="100%;">
		<tr align="center" >
			<td >
				<button class="btn btn-primary" type="button" onclick="submitForm();">群发</button>
				<button type="button" onclick="returnList();" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</td>
		</tr>
	</table>
</form>	
</body>
</html>
<!-- 		<tr> -->
<!-- 			<td><input name="atrAutor6" type="text"></td> -->
<!-- 			<td><input name="artTitle6" type="text"></td> -->
<!-- 			<td><input name="artCsu6" type="text"></td> -->
<!-- 			<td><input name="artDigest6" type="text"></td> -->
<!-- 			<td><input name="artTmi6" type="text"></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td><input name="atrAutor6" type="text"></td> -->
<!-- 			<td><input name="artTitle6" type="text"></td> -->
<!-- 			<td><input name="artCsu6" type="text"></td> -->
<!-- 			<td><input name="artDigest6" type="text"></td> -->
<!-- 			<td><input name="artTmi6" type="text"></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td><input name="atrAutor8" type="text"></td> -->
<!-- 			<td><input name="artTitle8" type="text"></td> -->
<!-- 			<td><input name="artCsu8" type="text"></td> -->
<!-- 			<td><input name="artDigest8" type="text"></td> -->
<!-- 			<td><input name="artTmi8" type="text"></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td><input name="atrAutor9" type="text"></td> -->
<!-- 			<td><input name="artTitle9" type="text"></td> -->
<!-- 			<td><input name="artCsu9" type="text"></td> -->
<!-- 			<td><input name="artDigest9" type="text"></td> -->
<!-- 			<td><input name="artTmi9" type="text"></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td><input name="atrAutor10" type="text"></td> -->
<!-- 			<td><input name="artTitle10" type="text"></td> -->
<!-- 			<td><input name="artCsu10" type="text"></td> -->
<!-- 			<td><input name="artDigest10" type="text"></td> -->
<!-- 			<td><input name="artTmi10" type="text"></td> -->
<!-- 		</tr> -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  import="crf.util.PageUtil" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>css 分页样式2</title>
</head>
<body>
<div id="page_div" class="pages" >
	<span style="font-size: 13px;">
		共<font id="totalCount_font"></font>条记录，
		第<font id="currentPage_font"></font>/<font id="totalPage_font"></font>页
	</span>
	<a href="javascript:turn('first');">首页</a>
	<a href="javascript:turn('-1');">上一页</a>
	<a href="javascript:turn('+1');">下一页</a>
	<a href="javascript:turn('end');">尾页</a>
	<span>跳转至<input type="text" name="jumpPage" style="width: 30px;">页 
		<a href="javascript:turn('jump');">跳转</a>
	</span>
</div>
<input name="currentPage" id="currentPage" type="hidden" value="">
<input name="totalPage" id="totalPage" type="hidden" value="">
<input name="turn" id="turn" type="hidden" value="">
<script type="text/javascript">
	var url=document.getElementById("method").value;
	document.forms[0].action = url;
	document.forms[0].target="frame1";
	document.forms[0].submit();
	
	function turn(type){
		if(type=="first"){
			document.forms[0].currentPage.value=1;
		}else if(type=="end"){
			document.forms[0].currentPage.value=document.forms[0].totalPage.value;
		}else if(type=="+1"){
			var currentPage=eval(document.forms[0].currentPage.value)+1;
			if(eval(currentPage)>eval(document.forms[0].totalPage.value)){
				currentPage=document.forms[0].totalPage.value;
			}
			document.forms[0].currentPage.value=currentPage;
		}else if(type=="-1"){
			var currentPage=eval(document.forms[0].currentPage.value)-1;
			if(eval(currentPage)<=0){
				currentPage=1;
			}
			document.forms[0].currentPage.value=currentPage;
		}else if(type=="jump"){
			var jumpPage=document.forms[0].jumpPage.value;
			if(jumpPage!=""){
				if(eval(jumpPage)>eval(document.forms[0].totalPage.value)){
					document.forms[0].currentPage.value=document.forms[0].totalPage.value;
				}
				if(eval(jumpPage)<=0){
					document.forms[0].currentPage.value=1;
				}
				if(!(eval(jumpPage)>eval(document.forms[0].totalPage.value) &&
						(!eval(jumpPage)<=0))){
					document.forms[0].currentPage.value=jumpPage;
				}
				document.forms[0].jumpPage.value="";
			}
		}
		document.getElementById("turn").value="turn";
		var url=document.getElementById("method").value;
		document.forms[0].action = url;
		document.forms[0].target="frame1";
		document.forms[0].submit();
		document.getElementById("turn").value="";
	}
</script>
</body>
</html>

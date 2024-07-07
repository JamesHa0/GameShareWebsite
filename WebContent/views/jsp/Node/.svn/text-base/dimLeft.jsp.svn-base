<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="crf.system.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List treeList = (List) request.getAttribute("dimTree");
List nodeList = (List) request.getAttribute("dimNode");

DimNode node = null;
DimNode nodeTemp = null;
DimTree tree = null;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'MyJsp.jsp' starting page</title>
    <link href="${pageContext.request.contextPath}/views/Css/dtree.css" type="text/css" rel="StyleSheet">
	<script src="${pageContext.request.contextPath}/views/Js/dtree.js" type="text/javascript"></script>
 	<script type="text/javascript">
		function doChoice(strUrl){     
			parent.frames["mainRight"].location.href = strUrl;
		}
	</script>
 	
 
  </head>
  
  <body>
  <div  style="margin:5 0 8 5;">
	<script type="text/javascript">
		d = new dTree('d');
		d.icon = {

			root				: '${pageContext.request.contextPath}/views/Images/tree/base.gif',
	
			folder				: '${pageContext.request.contextPath}/views/Images/tree/folder.gif',
	
			folderOpen			: '${pageContext.request.contextPath}/views/Images/tree/folderopen.gif',
	
			node				: '${pageContext.request.contextPath}/views/Images/tree/page.gif',
	
			empty				: '${pageContext.request.contextPath}/views/Images/tree/empty.gif',
	
			line				: '${pageContext.request.contextPath}/views/Images/tree/line.gif',
	
			join				: '${pageContext.request.contextPath}/views/Images/tree/join.gif',
	
			joinBottom			: '${pageContext.request.contextPath}/views/Images/tree/joinbottom.gif',
	
			plus				: '${pageContext.request.contextPath}/views/Images/tree/plus.gif',
	
			plusBottom			: '${pageContext.request.contextPath}/views/Images/tree/plusbottom.gif',
	
			minus				: '${pageContext.request.contextPath}/views/Images/tree/minus.gif',
	
			minusBottom			: '${pageContext.request.contextPath}/views/Images/tree/minusbottom.gif',
	
			nlPlus				: '${pageContext.request.contextPath}/views/Images/tree/nolines_plus.gif',
	
			nlMinus				: '${pageContext.request.contextPath}/views/Images/tree/nolines_minus.gif'
							
		};
		d.add(0,-1,'系统维度','javascript:doChoice(\'${pageContext.request.contextPath}/pc_SystemController.do?dimNew&dim_id=0&parentid=0&dim_type=M&tree_id=&node_level=0\');','','_self','${pageContext.request.contextPath}/views/Images/tree/base.gif');
		
		<%
  		for(int i=0;i<treeList.size();++i)
        {
          tree=(DimTree)treeList.get(i);
          
         boolean btag=false;
          for(int t=0;t<nodeList.size();t++)
		  {
		    	node=(DimNode)nodeList.get(t);
		    	
		    	String parentid="";
				if("0".equals(node.getParent_id()))
					parentid=node.getTree_id();
				else
					parentid=node.getParent_id();
				
			 	if(node.getTree_id().equals(tree.getTree_id())){
			 		btag=true;
			 		break;
			 	}
		  }
		  
		  if(btag){
		%>
		    d.add('<%=tree.getTree_id()%>','0','<%=tree.getTree_name()%>','javascript:doChoice(\'${pageContext.request.contextPath}/pc_SystemController.do?dimInfo&dim_id=<%=tree.getTree_id()%>&dim_type=T&parentid=0&tree_id=<%=tree.getTree_id()%>&node_level=1\');','','_self','${pageContext.request.contextPath}/views/Images/icon/fold01_close.gif','${pageContext.request.contextPath}/views/Images/icon/fold01_open.gif');
		<%} else{%>
		 	d.add('<%=tree.getTree_id()%>','0','<%=tree.getTree_name()%>','javascript:doChoice(\'${pageContext.request.contextPath}/pc_SystemController.do?dimInfo&dim_id=<%=tree.getTree_id()%>&dim_type=T&parentid=0&tree_id=<%=tree.getTree_id()%>&node_level=1\');','','_self','${pageContext.request.contextPath}/views/Images/icon/icon_18.gif');
		<%}
			for(int j=0;j<nodeList.size();j++)
			{
				node=(DimNode)nodeList.get(j);
				
				String parentid="";
				if("0".equals(node.getParent_id()))
					parentid=node.getTree_id();
				else
					parentid=node.getParent_id();
				
				if(node.getTree_id().equals(tree.getTree_id())){
				
				 boolean bfind=false;
				 
				  for(int jj=0;jj<nodeList.size();++jj)
       			 {
        			nodeTemp=(DimNode)nodeList.get(jj);
        			if(nodeTemp.getParent_id().equals(node.getNode_id())){
        			bfind=true;
        			break;
        			}	
       			 } 
       			 
       			 if(bfind){         
			%>
				d.add('<%=node.getNode_id()%>','<%=parentid%>','<%=node.getNode_name()%>','javascript:doChoice(\'${pageContext.request.contextPath}/pc_SystemController.do?dimInfo&dim_id=<%=node.getNode_id()%>&dim_type=N&parentid=<%=node.getParent_id()%>&tree_id=<%=tree.getTree_id()%>&node_level=<%=node.getNode_level()%> \');','','_self','${pageContext.request.contextPath}/views/Images/icon/fold01_close.gif','${pageContext.request.contextPath}/views/Images/icon/fold01_open.gif');	
			<%}else {%>
				d.add('<%=node.getNode_id()%>','<%=parentid%>','<%=node.getNode_name()%>','javascript:doChoice(\'${pageContext.request.contextPath}/pc_SystemController.do?dimInfo&dim_id=<%=node.getNode_id()%>&dim_type=N&parentid=<%=node.getParent_id()%>&tree_id=<%=tree.getTree_id()%>&node_level=<%=node.getNode_level()%> \');','','_self','${pageContext.request.contextPath}/views/Images/icon/icon_18.gif');
				<%}
				}
				
			}		
 		}
		%>
	
		document.write(d);
	</script>
		</div>
  
  </body>
</html>

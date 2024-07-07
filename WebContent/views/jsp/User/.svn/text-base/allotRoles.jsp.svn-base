<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="crf.system.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>角色分配</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/backstageCss/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/backstageCss/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/views/Js/common.js"></script>
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
    <script type="text/javascript">
    	function init(sb){
    		var ss=sb.split(",");
    		for(var i=0;i<ss.length;i++){
    			if(ss[i]=='')
    				continue;
    			document.getElementById(ss[i]).checked="checked";
    		}
    	}
    	function returnList(){
    		window.location.href="pc_SystemController.do?getUserList";
    	}
    </script>
</head>
<body onload="init('${sb}');">
<form action="pc_SystemController.do?saveUserActor" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
   		 <tr>
            <td class="tableleft">姓名</td>
            <td><input type="text" name="realname" readonly="readonly" value="${realname}"/></td>
        </tr>
        <tr>
            <td style="width: 20%;" class="tableleft">用户名</td>
            <td><input type="text" name="username" readonly="readonly" value="${username}"/></td>
        </tr>
        <tr>
            <td style="width: 20%;" class="tableleft">角色</td>
            <td>
				<table width="100%" >
					<%
					List<Actor>actorList=(List<Actor>)request.getAttribute("actorList");
					int size=actorList.size();
					Actor actor=new Actor();
					for(int i=0;i<size;i++){
					%>
						<tr>
							<% if(i==size) break; actor=actorList.get(i); %>
							<td style="border: 0;"><label><input name="actor" id="<%=actor.getActor_no() %>" type="checkbox" style="border:0" value="<%=actor.getActor_no() %>" /><%=actor.getActor_name() %></label></td>
							<% i++; if(i==size) break; actor=actorList.get(i); %>
							<td style="border: 0;"><label><input name="actor" id="<%=actor.getActor_no() %>" type="checkbox" style="border:0" value="<%=actor.getActor_no() %>" /><%=actor.getActor_name() %></label></td>
							<% i++; if(i==size) break; actor=actorList.get(i); %>
							<td style="border: 0;"><label><input name="actor" id="<%=actor.getActor_no() %>" type="checkbox" style="border:0" value="<%=actor.getActor_no() %>" /><%=actor.getActor_name() %></label></td>
							<% i++; if(i==size) break; actor=actorList.get(i); %>
							<td style="border: 0;"><label><input name="actor" id="<%=actor.getActor_no() %>" type="checkbox" style="border:0" value="<%=actor.getActor_no() %>" /><%=actor.getActor_name() %></label></td>
						</tr>
					<%}%>
			  </table>
			</td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button class="btn btn-primary" type="submit">保存</button>
                &nbsp;&nbsp;<button type="button" onclick="returnList();" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

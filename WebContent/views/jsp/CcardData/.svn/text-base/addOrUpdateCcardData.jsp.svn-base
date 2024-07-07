<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/views/Css/style.css" />
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
    	function returnList(){
    		window.history.go(-1);
    	}
    	function init(is_deal,flag){
    		if(is_deal=="1"){
    			document.getElementsByName("is_deal")[0].checked="checked";
    		}else if(is_deal=="0"){
    			document.getElementsByName("is_deal")[1].checked="checked";
    		}
    		if(flag=="add"){
    			document.form0.id.readOnly="";
    		}
    	}
    	/**
    	 *提交表单
    	 */
    	function submitForm(){
    		if(confirm("确认提交吗?")){
    			document.form0.submit();
    		}
    	}
    </script>
</head>
<body onload="init('${user.is_deal}','${flag }');">
<form name="form0" action="pc_CcardDataController.do?saveCcardData" method="post" class="definewidth m20">
<input type="hidden" name="flag" value="${flag}">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td style="width: 20%;" class="tableleft">逾期数据编号</td>
            <td><input type="text" name="id" value="${user.id}" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">合同编号</td>
            <td><input type="text" name="loanContractNo" value="${user.loanContractNo }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">贷款人</td>
            <td><input type="text" name="loanname" value="${user.loanName }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">身份证</td>
            <td><input type="text" name="idcard" value="${user.idCard }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">逾期天数</td>
            <td><input type="text" name="deliquencyDay" value="${user.deliquencyDay }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">应还逾期利息</td>
            <td><input type="text" name="duetoLateInterest" value="${user.duetoLateInterest }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">已还逾期利息</td>
            <td><input type="text" name="paidLateInterest" value="${user.paidLateInterest }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">所属用户</td>
            <td><input type="text" name="padUser" value="${user.padUser }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">创建时间</td>
            <td><input type="text" name="creatTime" value="${user.creatTime }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">还款期数</td>
            <td><input type="text" name="payTerm" value="${user.payTerm }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">已还期数</td>
            <td><input type="text" name="paidTerm" value="${user.paidTerm }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">账户标识</td>
            <td><input type="text" name="accountFlag" value="${user.accountFlag }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">还款账号</td>
            <td><input type="text" name="repayAccountNo" value="${user.repayAccountNo }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">还款银行</td>
            <td><input type="text" name="repayOpenBank" value="${user.repayOpenBank }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">应还总金额</td>
            <td><input type="text" name="sumAmount" value="${user.sumAmount }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">应还本息</td>
            <td><input type="text" name="sumBenxi" value="${user.sumBenxi }" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">应还罚息</td>
            <td><input type="text" name="sumFaxi" value="${user.sumFaxi }" readonly="readonly"/></td>
        </tr>
        <tr>
	        <td class="tableleft">是否标记</td>
	        <td>
	            <input type="radio" name="is_deal" value="1" checked="checked"/> 标记
	            <input type="radio" name="is_deal" value="0" /> 未标记
	        </td>
    	</tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button class="btn btn-primary" type="button" onclick="submitForm();">保存</button>
                &nbsp;&nbsp;<button type="button" onclick="returnList();" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

/*
-------------------------------------------------------------------------------
文件名称：checkForm.js
说    明：JavaScript脚本，验证表单中的数据项
版    本：1.0
修改纪录:
-------------------------------------------------------------------------------
说明:
isneed:
	Y：非空
length:
	length=10 必须10位数字
	length=10~100 长度在10~100之间
	length=10~N 至少1位
checkType:
	number 数字
	date 日期
	Chinese 中文
	email 邮箱验证
------------------------------------------------------------------------------- 	
*/

function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

function checkForm(objFrm){
	var len = 0;
	len = objFrm.elements.length;
  
	var i = 0;
	var objCheck;
	//文本框
	for(i = 0; i < len; i ++){
		objCheck = objFrm.elements[i];
		if(objCheck.disabled==false){
			if((objCheck.type =="text"||objCheck.type =="textarea"||
				objCheck.tagName=="SELECT"||objCheck.type =="password") && !f_checkTextValid(objCheck) ){
				return false;			
			}
		}
	}
	return true;
}

function f_checkTextValid(obj){
	//不能为空
	if(obj.getAttribute("isneed")=="Y"){
		if(f_checkIsNeed(obj) == false){
			return false;
		}
	}
	//不为空的时候去校验类型
	if(trim(obj.value)!=""){
		if(obj.getAttribute("length") != null){
			if(f_checkLength(obj) == false) return false;
		}
		var checkType = obj.getAttribute("checkType");
		if(checkType==null||checkType=="")
			return true;
		
		if (checkType.indexOf("number") >=0){
			if(f_isNumber(obj) == false)  return false;
		}
		if (checkType.indexOf("date") >=0){
			if(f_checkDate(obj) == false) return false;
		}
	    if(checkType.indexOf("email") >=0){
			if(isEmail(obj) == false) return false;
		}
	    if(checkType.indexOf("Chinese") >=0){
			if(isChinese(obj) == false) return false;
		}
	}
	return true;
}

function f_checkIsNeed(obj){
	if(trim(obj.value)==""){
		 f_alert(obj," 不能为空");
		return false;		
	}
	return true;
}
function f_isNumber(obj){
	if(isNaN(obj.value)){
		 f_alert(obj," 应为数值类型");
		return false;		
	}
	return true;

}
function f_checkDate(obj) {
	if(checkDate(obj) ==false){
		 f_alert(obj," 不是合法日期格式！");
		return false;		
	}
	return true;
}
//校验长度
function f_checkLength(obj){
	var length = obj.getAttribute("length");
	//不包含~
	if(length.indexOf("~")==-1){
		if(trim(obj.value).length!=Math.abs(length)){
			 f_alert(obj," 为"+length+"位长度！");
			 return false;
		}
	}
	//长度在区间之内
	else{
		var minLen=length.split("~")[0];
		var maxLen=length.split("~")[1];
		if(maxLen=="N"){
			if(trim(obj.value).length< Math.abs(minLen) ){
				f_alert(obj," 长度至少"+minLen+"位");
				return false;
			}
		}else{
			if(trim(obj.value).length< Math.abs(minLen) || 
					trim(obj.value).length>Math.abs(maxLen)){
				f_alert(obj," 长度应在"+length+"位之间");
				return false;
			}
		}
		
	}
	return true;
}

function  f_alert(obj,alertStr){
	var fielName = obj.getAttribute("title");
	if(fielName == null)
		fielName = "";
	alert(fielName+alertStr);
	obj.select();
	obj.focus();
}

function f_isPositive(obj){
	var numReg =/[\-]/;
	var re = new RegExp("^[0-9]*[1-9][0-9]*$");
	if(re.test(obj.value) == false){
		f_alert(obj, "必须为正整数!");
		return false;
	}
	if(numReg.test(obj.value) == true){
		f_alert(obj, "必须为正数!");
		return false;
	}
	return true;
}

//校验是否为空
function isEmpty (s) {
  if (s == null || trim(s) == "") return true;
  return false;
}

function isEmail(obj){
	var s=obj.value;
	if(isEmailV(s,false)==false){
	f_alert(obj, "输入的EMAIL格式不对!");
		  return false;
	}
	return true;
}

function isChinese(obj){
	var re = new RegExp("^[\u4e00-\u9fa5]+$");
	if(re.test(obj.value) == false){
		f_alert(obj, "必须为中文!");
		return false;
	}
	return true;
}

//校验是否为email地址
//sign - 如果要校验的对象为空，返回该值(必须为boolean型)，默认为false
function isEmailV(s,sign) {
	if (isEmpty(s)) return (arguments.length == 2 && sign == true);
  var emailPat=/^(.+)@(.+)$/;
  var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
  var validChars="\[^\\s" + specialChars + "\]";
  var quotedUser="(\"[^\"]*\")";
  var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
  var atom=validChars + '+';
  var word="(" + atom + "|" + quotedUser + ")";
  var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
  var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
  var matchArray=s.match(emailPat);
  if (matchArray == null)  return false;
  var user=matchArray[1];
  var domain=matchArray[2];
  if (user.match(userPat) == null)   return false;
  var IPArray = domain.match(ipDomainPat);
  if (IPArray != null) {
    for (var i = 1; i <= 4; i++) {
      if (IPArray[i] > 255) return false;
    }
    return true;
  }
  var domainArray=domain.match(domainPat);
  if (domainArray == null)  return false;
  var atomPat=new RegExp(atom,"g");
  var domArr=domain.match(atomPat);
  var len=domArr.length;
  if ((domArr[domArr.length-1].length < 2) || (domArr[domArr.length-1].length > 3)) {
    return false;
  }
  if (len < 2) return false;
  return true;
}                     

/***
 * 防止表单多次提交函数
 * 如果是第一次提交表单，函数返回true，表示可以提交，否则不能提交
 * frm - 表单对象。第一次提交表单后，会将表单内的所有的button置为不可用
 */
var FRM_SUBMITED = false;
function confirmSubmited(frm){
  
  if(!FRM_SUBMITED){
    FRM_SUBMITED = true;
    //为了视觉效果，将表单内所有的按钮置为不可用    
    if(frm){   
      var eles = frm.elements;
      for(var i=0; i < eles.length; i++) {    
        obj= eles.item(i);
        type=obj.type;
        if((type == "button" || type == "submit") && obj.disabled == false){        
          obj.disabled = true;
        }
      }
    }     
    return true;
  }
  return false;
}

function checkDate(obj){
	var date = obj.value;
	if(""==trim(date)){
		return;
	}
	 var result = date.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
	 if(result==null)
     {
         obj.value="";
         return false;
     }else{
    	 var ss=date.split("-");
    	 var year=ss[0];
    	 var month=ss[1];
    	 var day=ss[2];
    	 if(eval(month)<=9){
    		 month="0"+eval(month);
    	 }
    	 if(eval(day)<=9){
    		 day="0"+eval(day);
    	 }
    	 obj.value=year+"-"+month+"-"+day;
     }
	 return true;
}

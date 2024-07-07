/**
 * Created with JetBrains PhpStorm.
 * User: kk
 * Date: 13-8-28
 * Time: 涓嬪崍4:44
 */
function U() {
    var url = arguments[0] || [];
    var param = arguments[1] || {};
    var url_arr = url.split('/');

    if (!$.isArray(url_arr) || url_arr.length < 2 || url_arr.length > 3) {
        return '';
    }

    if (url_arr.length == 2)
        url_arr.unshift(_GROUP_);

    var pre_arr = ['g', 'm', 'a'];

    var arr = [];
    for (d in pre_arr)
        arr.push(pre_arr[d] + '=' + url_arr[d]);

    for (d in param)
        arr.push(d + '=' + param[d]);

    return _APP_+'?'+arr.join('&');
}
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
function initParentFrameHeight()
{
	 var frame1 = window.parent.document.getElementById("frame1");
     var tableHeight = document.getElementById("table1");
     if(frame1!=null && tableHeight!=null)
     {
         frame1.height = tableHeight.offsetHeight+10;
     }
}
//全选
var isAllCheck = false;
function checkAll(){
	if(isAllCheck==false){
		$(':checkbox').attr('checked','checked'); 
		isAllCheck = true;
	}else{
		$(':checkbox').removeAttr('checked');
		isAllCheck = false;
	}
}
//单选
function checkOne(e){
	$(':checkbox').removeAttr('checked');
	e.checked='checked';
}
//点击行单选
function checkOneByTr(tr){
	var tds = tr.getElementsByTagName("td");
	var td = tds[0];
	var checkbox = td.getElementsByTagName("input")[0];
	$(':checkbox').removeAttr('checked');
	checkbox.checked='checked';
}


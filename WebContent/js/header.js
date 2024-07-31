
window.onload = function() {
	//点击info图标，跳转
	var info=document.getElementsByClassName("info")[0];
	info.onclick=function(){
		console.debug('点击了info图标。');
		window.location = 'QueryInfoServlet.do';
	}
}

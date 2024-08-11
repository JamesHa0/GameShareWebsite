
/*****负责小猪loading的动画显示 */
function click_forLoading(){
//	let body = document.querySelector('body');
//	body.querySelectorAll('body > *:not(.head)').forEach(el => {
//	  el.style.display = 'none';	//body下所有目标子元素隐藏，除存放小猪的header
//	});
	document.querySelector('#loadingFrame').style.display="block";	//小猪loading显示
}

/********创建dialog弹窗*/
function createDialog(message,color) {
	if(message==undefined)message='默认消息';
	if(color==undefined)color='#ffffff';
	//生成容器：
    const Div_container = document.createElement('div');	//造元素
    Div_container.id = 'dialog';	//写id名
	//生成内容：
    Div_container.innerHTML = `
        <p style="color:${color}">${message}</p>
    `;
	
    Div_container.style.display = "block";	//显示弹窗
    let body=document.getElementsByTagName('body')[0];
    body.appendChild(Div_container)
    setTimeout(function() {
            Div_container.style.display = "none";
    }, 4000); // 等待动画完成后彻底隐藏弹窗
}
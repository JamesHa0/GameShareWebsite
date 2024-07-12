//**********************************************************************
//**********************************************************************
//**********************************************************************
//**********************************************************************
//************************************【修改记录】模块：
//************************************【修改记录】模块：
//************************************【修改记录】模块：
//***添加【只读禁止光标】（初始化）： */

window.onload=function readonly_cursor(){
    // 获取所有具有 readonly 属性的 input 元素
    var readonlyInputs = document.querySelectorAll('input[readonly]');
    // 为当前所有 readonly input 元素添加 read-only css类
    readonlyInputs.forEach(function(input) {
        input.classList.add('read-only');
    });
}


//点击【修改按钮】触发该函数：
function enableEditing(row) {//row=td,td子节点为input
console.log('点击了修改按钮。');
	//【input】取消只读：
     var upoint=(row.querySelectorAll('input[name="upoint"]'))[0];
     upoint.readOnly=false;//取消只读
	 upoint.classList.remove('read-only');//取消光标css
    //【提交按钮】改变：
      var button = row.getElementsByTagName('button')[0];
      button.innerHTML = '提交'; //改为提交按钮
      button.setAttribute('onclick', 'submitChanges(this.parentNode.parentNode)');
}

//点击【提交按钮】触发该函数：
function submitChanges(row) {
console.log('点击了提交按钮。');
//填data：
    var inputs=row.querySelectorAll('input[class="editing"]');
    var data = new URLSearchParams(); 
    inputs.forEach(function(input) {
        data.append(input.name, input.value);
		input.classList.add('read-only');//添加光标css
    });
data.forEach(function(value, key) {
    console.log(key + ': ' + value);
});
//开始fetch：
    fetch('../UpdateUserServlet.do', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' 
        },
        body: data 
    })
    .then(response => response.text()) 
    .then(result => console.log(result))
    .then(data => {
        console.log('服务器发来的响应数据：', data);
    })
    .catch(error => {
		alert('请求失败'+error);
    })
    .finally(()=>{
		// 重置【input】为只读
        inputs.forEach(function(input) {
            input.readOnly = true;
        })
        // 重置【修改按钮】
        var button = row.getElementsByClassName('updateBtn')[0];
        button.innerText = '修改';
        button.onclick = function() { enableEditing(row); };
	});
}
//**********************************************************************
//**********************************************************************
//**********************************************************************
//***************************************【删除按钮】模块： */    
//***************************************【删除按钮】模块： */    
//***************************************【删除按钮】模块： */    
    
    function confirmDelete(uid) {
        var isDelete = confirm("您确定要删除吗？");
        if (isDelete) {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "DeleteUserServlet.do?uid="+uid  , true);// 配置请求类型、URL及异步处理方式
            xhr.onload = function () {
                if (xhr.status === 200) {
                    alert('删除成功');
                    window.location.href="QueryAllUserServlet.do";
                } else {
                    alert('操作失败');
                }
            };
            xhr.send();
        }
    }
    
    
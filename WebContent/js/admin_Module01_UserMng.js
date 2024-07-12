//**********************************************************************
//**********************************************************************
//**********************************************************************
//**********************************************************************
//**********************************************************************
//****************************************【增添记录】模块： */
//****************************************【增添记录】模块： */
//****************************************【增添记录】模块： */
function addBtn(button){
	//取消hidden：（包括tr和input）
	var tr_and_inputs=Array.from(document.getElementsByClassName('hidden')) ;
	tr_and_inputs.forEach(function(input) {
        input.classList.remove('hidden')
    });
    //改变按钮：
      button.innerHTML = '提交'; //改为提交按钮
      button.setAttribute('onclick', 'submitAdds()');//修改点击函数
}

//点击【提交按钮】触发该函数：
function submitAdds() {
console.log('点击了提交按钮。');
	var row=document.getElementById("addRow");
    var inputs = row.querySelectorAll('input');
    var data = new URLSearchParams();
    inputs.forEach(function(input) {
        data.append(input.name, input.value);
    });
    fetch('../InsertUserServlet.do', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' 
        },
        body: data 
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('增添失败');
        }
        return response.text();
    })
    .then(result => {
        console.log('服务器发来的响应数据：', result);
    })
    .catch(error => {
        console.error('请求失败：', error);
        alert('请求失败：' + error.message);
    })
    .finally(()=>{
        // 重置【修改按钮】
        var button =document.getElementById("addBtn");
        button.innerText = '增添记录 ';
        button.onclick = function() { addBtn(row); };
	});
}





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
    
//    // 移除之前可能添加的所有 read-only css类
//    var allInputs = document.querySelectorAll('input.read-only');
//    allInputs.forEach(function(input) {
//        input.classList.remove('read-only');
//    });

    // 为当前所有 readonly input 元素添加 read-only css类
    readonlyInputs.forEach(function(input) {
        input.classList.add('read-only');
    });
}
//	//获取所有具有.readonly类的input元素
//	var readonlyInputs = document.querySelectorAll('input[readonly]');
//	
//	console.log('readonlyInputs='+readonlyInputs.length);
//	
//	readonlyInputs.forEach(function(input) {
//	input.addEventListener('mouseover', function() {
//	// console.log('鼠标移入了');
//	 this.classList.add('read-only'); // 添加read-only类
//});
//	// console.log('鼠标又出来了');
//	input.addEventListener('mouseout', function() {
//	 this.classList.remove('read-only'); // 移除read-only类
//	});
//});
//	
//}



//点击【修改按钮】触发该函数：
function enableEditing(row) {//row=td,td子节点为input
console.log('点击了修改按钮。');
//console.log('row是个什么东西？'+row+row.tagName);
	//【login】取消只读：
      var tds = row.querySelectorAll('td');
      tds.forEach(function(td) {
		var input=td.getElementsByTagName('input')[0];
		if(input)
			if(input.name == 'uid' || input.name=='urole' || input.name == 'upsw' ){
			//不能改的，pass
			}else{
				input.readOnly = false; // 取消只读
				input.classList.remove('read-only');//取消光标css
			}
        
    });
    //【提交按钮】改变：
      var button = row.getElementsByTagName('button')[0];
      button.innerHTML = '提交'; //改为提交按钮
      button.setAttribute('onclick', 'submitChanges(this.parentNode.parentNode)');
}



//点击【提交按钮】触发该函数：
function submitChanges(row) {
console.log('点击了提交按钮。');
    // 【提交数据到服务器：（使用 fetch API）】
    var inputs = row.querySelectorAll('input');
    var data = new URLSearchParams(); // 使用 URLSearchParams 来构建键值对
    inputs.forEach(function(input) {
        data.append(input.name, input.value);
		input.classList.add('read-only');//取消光标css
    });
data.forEach(function(value, key) {
    console.log(key + ': ' + value);
});
    
    fetch('../UpdateUserServlet.do', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' // 设置内容类型为 x-www-form-urlencoded
        },
        body: data // URLSearchParams 对象可以直接作为 body 发送
    })
    .then(response => response.text()) 
    .then(result => console.log(result))
    .then(data => {
        console.log('服务器发来的响应数据：', data);
        
    })
    .catch(error => {
		alert('修改失败'+error);
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
            xhr.open("GET", "../DeleteUserServlet.do?uid="+uid  , true);// 配置请求类型、URL及异步处理方式
            xhr.onload = function () {
                if (xhr.status === 200) {
                    alert('删除成功');
                    location.reload();
//                    window.location.href="../QueryAllUserServlet.do";
                } else {
                    alert('删除失败');
                }
            };
            xhr.send();
        }
    }
    
    

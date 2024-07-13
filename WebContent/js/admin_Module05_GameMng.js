//**********************************************************************
//**********************************************************************
//**********************************************************************
//**********************************************************************
//**********************************************************************
//****************************************【增添】模块： */
//****************************************【增添】模块： */
//****************************************【增添】模块： */
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
	var row=document.getElementById("addRow"); // 获取 增添行
    var inputs = row.querySelectorAll('input');
    var data = new URLSearchParams();
    inputs.forEach(function(input) {
        data.append(input.name, input.value);
    });
    fetch('../InsertGameServlet.do', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' 
        },
        body: data 
    })
    .then(response => {
        if (!response.ok) {
			location.reload();
            throw new Error('增添失败，状态码：' + response.status);
        }else{
			location.reload();
			alert('增添成功');
			
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
        // 重置【增添按钮】
        var button =document.getElementById("addBtn");
        button.innerText = '继续增添';
        button.onclick = function() { addBtn(row); };
	});
}



//点击【提交按钮】触发该函数：
//function queryBtn(){
//console.log('点击了查询按钮。');
//	var input=document.getElementById("admin_query_jsp_input");
//    var data = new URLSearchParams();
//        data.append(input.name, input.value);
//        
//data.forEach(function(value, key) {
//    console.log(key + ': ' + value);
//});
//        
//    fetch('../QueryUserServlet.do', {
//        method: 'POST',
//        headers: {
//            'Content-Type': 'application/x-www-form-urlencoded' 
//        },
//        body: data 
//    })
//    .then(response => {
//        if (!response.ok) {
//            alert('查询失败')
//            throw new Error('查询失败');
//        }else{
//			window.location.href="../admin_Module01_UserMng.jsp";
//			alert('查询成功');
//		}
//        return response.text();
//    })
//    .catch(error => {
//        console.error('请求失败：', error);
//        alert('请求失败：' + error.message);
//    })
//}



//**********************************************************************
//**********************************************************************
//**********************************************************************
//**********************************************************************
//************************************【修改记录】模块：
//************************************【修改记录】模块：
//************************************【修改记录】模块：
//***添加【只读禁止光标】（初始化）： */

window.onload=function onload_setCursorBannedClass(){
    // 获取所有具有 readonly 属性的 input 元素
    var readonlyInputs = document.querySelectorAll('input[readonly]');

    // 为当前所有 readonly input 元素添加 read-only css类
    readonlyInputs.forEach(function(input) {
        input.classList.add('cursor-banned');
    });
}

//点击【修改按钮】触发该函数：
function updateBtn(row) {//row=td,td子节点为input
console.log('点击了修改按钮。');
	//【login】取消只读：
      var tds = row.querySelectorAll('td');
      tds.forEach(function(td) {
		var input=td.getElementsByTagName('input')[0];
		if(input)
			if(input.name == 'gid'){
				//不能改的，pass
			}else{
				input.readOnly = false; // 取消只读
				input.classList.remove('cursor-banned');//取消光标css
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
    
    fetch('../UpdateGameServlet.do', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' // 设置内容类型为 x-www-form-urlencoded
        },
        body: data 
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('修改失败');
        }else{
			location.reload();
			alert('修改成功');
			
		}
        return response.text();
    })
    .then(result => console.log(result))
    .then(data => {
        console.log('服务器发来的响应数据：', data);
        
    })
    .catch(error => {
		alert('修改失败'+error);
    }
    )
    .finally(()=>{
		// 重置【input】为只读
        inputs.forEach(function(input) {
            input.readOnly = true;
        });
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
    
    function deleteBtn(gid) {
        var isDelete = confirm("您确定要删除吗？");
        if (isDelete) {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "../DeleteGameServlet.do?gid="+gid  , true);
            xhr.onload = function () {
                if (xhr.status === 200) {
                    alert('删除成功');
                    location.reload();
                } else {
                    alert('删除失败');
                }
            };
            xhr.send();
        }
    }
    
    

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
    //radio禁止点击：
    var allRadios = document.querySelectorAll('input[type="radio"]');
	allRadios.forEach(function(radio) {
        radio.disabled = true;
    });
}


//点击【修改按钮】触发该函数：
function updateBtn(row) {//row=td,td子节点为input
console.log('点击了修改按钮。');
	//【input】取消只读：
     var radios=row.querySelectorAll('input[type="radio"]');
      radios.forEach(function(radio) {
		radio.disabled= false; // 取消只读
		radio.classList.remove('read-only');//取消光标css
    });
    //【提交按钮】改变：
      var button = row.getElementsByTagName('button')[0];
      button.innerHTML = '提交'; //改为提交按钮
      button.setAttribute('onclick', 'submitChanges(this.parentNode.parentNode)');
}

//点击【提交按钮】触发该函数：
function submitChanges(row) {
console.log('点击了提交按钮。');
//填data：
    var inputs = row.querySelectorAll('input:not([type="radio"])');
    var radios=row.querySelectorAll('input[type="radio"]');
    var checkedRadio = null;
    var data = new URLSearchParams(); 
    inputs.forEach(function(input) {
        data.append(input.name, input.value);
		input.classList.add('read-only');//添加光标css
    });
    radios.forEach(function(radio) {
        if (radio.checked) {
            checkedRadio = radio;
        }
    });
console.log(checkedRadio+'='+checkedRadio.name+":"+checkedRadio.value);
    if (checkedRadio) {
        data.append(checkedRadio.name, checkedRadio.value);
        checkedRadio.classList.add('read-only'); // 添加光标CSS样式
    }
//test:
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
    .then(response => {
        if (!response.ok) {
            throw new Error('修改失败');
        }else{
			location.reload();
			alert('修改成功');
			
		}
        return response.text();
    })
    .finally(()=>{
		// 重置【input】为只读
        inputs.forEach(function(input) {
            input.readOnly = true;
        })
        // 重置【修改按钮】
        var button = row.getElementsByClassName('updateBtn')[0];
        button.innerText = '修改';
        button.onclick = function() { updateBtn(row); };
	});
}

/*点击点赞按钮后会触发相应的Ajax*/
function click_like(img,uid,gid){
	var action=img.src.endsWith('like.png')? 'like': 'unlike';
	// 跳转到servlet，传递action=like/unlike参数
	fetch('LikeServlet.do?action='+action+'&uid='+uid+'&gid='+gid,{
		method:'GET'
	})
	.then(response => {
        if (!response.ok) {
			throw new Error('操作失败');
        }else{
			console.log('操作成功')
			var td_likeNum=document.getElementById('td_likeNum')
			var num=parseInt(td_likeNum.textContent, 10);	//获取td内容（数字）
			if(action==="like"){
				img.src = "images/like_yes.png"	//点亮
				td_likeNum.textContent=num+1;	//更新赞数：+1
			}else{
				img.src = "images/like.png" //点灭
				td_likeNum.textContent=num-1;
			}
		}
	})
	.catch(error=>{
		alert(error.message)
	})
}





/*点击评论按钮后会改变图片*/
//var click_comment_isFirstClick=true;	//标记首次点击的全局变量
function click_comment(img){
	var gcomment=document.getElementsByClassName('gcomment')[0];
	var display=gcomment.style.display==="none"? "none": "block";
//	var formData=new URLSearchParams(); 	//URLSearchParams()用来获取[查询串]的参数内容
	
	if(display==="none"){
		gcomment.style.display="block";//显示评论区
		img.src = "images/comment_yes.png" //显示对勾
	}else if(display==="block"){
		gcomment.style.display="none";//隐藏评论区
		img.src = "images/comment.png"	   //隐藏对勾
	}
	
//	if(click_comment_isFirstClick){
//		click_comment_isFirstClick=false;	//标记首次点击变量为false
//		formData.append('action','showComment')
//		formData.append('uid',uid)
//		formData.append('gid',gid)
//		fetch('CommentServlet.do',{
//			method:'POST',
//	        headers: {
//	            'Content-Type': 'application/x-www-form-urlencoded' 
//	        },
//			body:formData
//		})
//		.then(response=>{
//			if(!response.ok){
//				throw new Error('获取评论失败')
//			}else{
//				console.debug('获取评论成功')
//			}
//			console.debug('响应体内容：\n'+response.body); // 打印响应体以调试
//			return response.text();	//这里需要json格式化响应数据，以便下面对data进行处理
//		})
//		.then(text => {
//		    // 打印响应体的文本内容
//		    //console.log('文本内容为：'+text);
//		    // 尝试解析文本为JSON（如果预期响应是JSON）
//		    try {
//		      const data = JSON.parse(text);
//		      console.log(data);
//		    } catch (error) {
//		      console.error('Failed to parse JSON:', error);
//		    }
//		})
//		.then(data=>{
//			if(data.allComments && data.allComments.length === 0){
//				console.debug('评论数为0')
//			}else{
//				console.debug('评论数为'+data.allComments.length)
//			}
//				
//		})
//		.catch(error=>{
//			alert(error.message)
//		})
//	}
}

/*创建单个评论区域的整个div*/
function createCommentElement(commentData) {
	var uid=commentData.uid;
	var ctime=commentData.ctime;
	var comment=commentData.comment;
	
    // 创建div
    var Div_container = document.createElement('div');	//造元素
    Div_container.className = 'comment-container';	//写类名

    // 创建uid部分
    var Span_uid = document.createElement('span');	//造元素
    Span_uid.className = 'comment-uid';			//写类名
    Span_uid.textContent = uid+" :";		//填内容

    // 创建ctime部分
    var Span_date = document.createElement('span');	//造元素
    Span_date.className = 'comment-ctime';		//写类名
    Span_date.textContent = `[${ctime}]`;	//填内容

    // 创建comment部分
    var P_comment = document.createElement('p');
    P_comment.className = 'comment-text';
    P_comment.textContent = comment;

    // 将所有元素添加到评论容器中
    Div_container.appendChild(Span_uid);
    Div_container.appendChild(Span_date);
    Div_container.appendChild(P_comment);

    // 返回创建的DOM元素
    return Div_container;
}

/*写评论后提交表单*/
function submit_comment(form,uid,gid){
	var textarea=document.getElementById('comment-textarea')
	var formData=new URLSearchParams(new FormData(form)); // 使用FormData API收集表单数据
	
	formData.append('uid',uid)
	formData.append('gid',gid)
	
/*	console.debug('【data内容如下：】')
formData.forEach(function(value,key){//注意这里是value在前
	console.debug(key+":"+value)
})*/
	fetch('CommentServlet.do',{
		method:"POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' 
        },
		body:formData
	})
	.then(response=>{
		if(!response.ok){
			throw new Error('提交失败');
		}else{
			console.debug('提交成功');
			textarea.value="";		//清空文本域的内容
			return response.json();
		}
	})
	.then(json=>{// 从JSON响应中提取属性
	    var commentData = {
	        uid: json.uid,
	        ctime: json.ctime,
	        comment: json.comment
	    };
	    //开始生成评论
	    var newCommentElement = createCommentElement(commentData);//调用函数
	    var parentElement = document.querySelector('.ucomment');//父节点
	    if (parentElement.firstChild) {//若父节点有子节点：插入到首元素之前
            parentElement.insertBefore(newCommentElement, parentElement.firstChild);
        } else {// 若父节点没有子节点：追加到容器末尾
            parentElement.appendChild(newCommentElement);
        }
	})
	.catch(error=>{
		alert(error.message)
	})
	return false;	//阻止提交表单避免跳转
}


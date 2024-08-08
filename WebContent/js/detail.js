/**********************************************************工具函数： */
function insertAfter(newElement,targetElement){
    var parent = targetElement.parentNode;
    if(parent.lastChild == targetElement){
        parent.appendChild(newElement);
    }else{
        parent.insertBefore(newElement,targetElement.nextSibling);
    }
}
function getCookieValue(name) {
    // 获取文档的所有cookie
    let cookies = document.cookie.split(';');
    // 遍历cookie数组
    for (let i = 0; i < cookies.length; i++) {
        let cookie = cookies[i].trim(); // 去除空白字符
        // 查找名称和值
        let equals = cookie.indexOf('=');
        if (equals > -1) {
            let cookieName = cookie.substring(0, equals); // 获取cookie名称
            // 检查名称是否匹配
            if (cookieName === name) {
                // 返回cookie的值
                return cookie.substring(equals + 1);
            }
        }
    }
    // 如果没有找到cookie或名称不匹配，则返回null
    return null;
}
/*创建单个评论区域的整个div*/
function createSingleComment(commentData) {//全9参
console.debug('create的整个评论对象为：')
console.debug(commentData)
	//从cookie获取当前用户信息：
	let uname=getCookieValue('Login_uname')
	//进行剪切,计算出被回复者的uname：
	let suffix;
	if(commentData.uname_upper==undefined || commentData.uname_upper==null){
		suffix="";
console.debug(`suffix=''`)
	}else{
		suffix='&nbsp;&nbsp;回复&nbsp;&nbsp;'+commentData.uname_upper.split("  回复  ")[0];
	}
    //计算缩进：A  回复  B
    let sharpNum = (commentData.cpath.match(/#/g) || []).length;	//中间数组为["#", "#"]（假设有两个#号
    if(sharpNum>4)sharpNum=4;	//控制最大缩进量
	//生成容器：
    const Div_container = document.createElement('div');	//造元素
    Div_container.className = 'comment-container';	//写类名
    Div_container.style=`padding-left:${20 + sharpNum * 60}px`; //负责缩进
	//生成内容：
    Div_container.innerHTML = `
        <span class="comment-uname">${uname}${suffix}:</span>
        <span class="comment-ctime">[${commentData.ctime}]</span>
        <img id="comment-like" onclick="click_comment_like(this,  
${commentData.cid},${commentData.gid},  &quot;${commentData.cpath}&quot; ,${commentData.clike } )" src="images/comment_like.png" />
        <span class="comment-likeNum"  >${commentData.clike == 0 ? "" : commentData.clike }</span>
        <img id="comment-reply" onclick="click_comment_reply(this,  
${commentData.cid},${commentData.gid},  &quot;${commentData.cpath}&quot; ,  &quot;${commentData.uname }&quot;)" src="images/comment_reply.png" />
        <p style="display:block" class="comment-text">${commentData.comment}</p>
    `;
//alert('生成评论完毕')
    return Div_container;
}


let _________TheDelimiter = () => {
       return "This is The Delimiter";
   };

/*************************************************业务函数： */
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
		alert(`游戏点击赞异常：${error.message}`)
	})
}

/*点击评论按钮后会改变图片*/
function click_comment(img){
	var comment_module=document.getElementsByClassName('comment-module')[0];
	var display=comment_module.style.display==="none"? "none": "block";

	if(display==="none"){
		comment_module.style.display="block";//显示评论区
		img.src = "images/comment_yes.png" //显示对勾
	}else if(display==="block"){
		comment_module.style.display="none";//隐藏评论区
		img.src = "images/comment.png"	   //隐藏对勾
	}
}

//function submit_comment(form,uid,gid,uname){
// alert('进函数')	
// return false;
//}
/*写一级评论后提交表单*/
function submit_comment(form,uid,gid,uname){
	var textarea=document.getElementById('comment-textarea')
	var urlSearchParams=new URLSearchParams(new FormData(form)); // 使用FormData API收集表单数据
	
	urlSearchParams.append('uid',uid)
	urlSearchParams.append('gid',gid)
	urlSearchParams.append('uname',uname)
	urlSearchParams.append('cid_upper',null)
	urlSearchParams.append('cpath_upper',null)
	fetch('CommentServlet.do',{
		method:"POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' 
        },
		body:urlSearchParams	//comment,uid,gid,uname,cid_upper,cpath_upper 这6个参数传到servlet
	})
	.then(response=>{
		if(!response.ok){
			throw new Error('提交失败');
		}else{
			console.debug('提交成功');
			textarea.value="";//清空文本
			return response.json();
		}
	})
	.then(json=>{// 全9参
	    var commentData = {
			cid: json.cid,
	        uid: json.uid,
	        gid: json.gid,
	        uname: json.uname,
	        clike: json.clike,
	        ctime: json.ctime,
	        comment: json.comment,
	        cparentid: json.cparentid,
	        cpath: json.cpath
	    };
	    //开始生成评论
	    var newCommentElement = createSingleComment(commentData);//调用函数
	    var parentElement = document.querySelector('.comments');//父节点
	    if (parentElement.firstChild) {//若父节点有子节点：插入到首元素之前
            parentElement.insertBefore(newCommentElement, parentElement.firstChild);
			const sofa=document.getElementById('sofa')	//删除沙发图片
            if (sofa && sofa.parentNode) {
		        sofa.parentNode.removeChild(sofa);
				console.debug('沙发被占')
		    }
        } else {// 若父节点没有子节点：追加到容器末尾
            parentElement.appendChild(newCommentElement);
        }
		console.debug('评论生成成功')
	})
	.catch(error=>{
		alert(`提交评论异常：${error.message}`)
	})
	
	return false;	//阻止提交表单避免跳转
}


function click_comment_like(img,cid,gid,cpath,clike){ //【clike】
	let urlSearchParams=new URLSearchParams();
	let action=img.src.endsWith('comment_like.png')? 'like': 'unlike';
	let likeChange=action=='like'? clike+1: clike;//注意后者为取消点赞，因为clike值的实时性问题，故为之
	urlSearchParams.append('cid',cid)
	urlSearchParams.append('gid',gid)
	urlSearchParams.append('cpath',cpath)
	urlSearchParams.append('likeChange',likeChange)
console.debug(`likeChange=${likeChange}`)
	
	fetch('CommentServlet.do',{
		method:"POST",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' 
        },
		body:urlSearchParams	//cid,gid,cpath,【likeChange】
	})
	.then(response=>{
		if(!response.ok){
			throw new Error('操作失败');
		}else{
			console.debug('操作成功。')
			img.src = action=='like'
				? "images/comment_like_yes.png"	//点亮
					: "images/comment_like.png";	//点灭
			let Span_likeNum = img.nextSibling;
			while (Span_likeNum.tagName !== "SPAN") {
			    Span_likeNum = Span_likeNum.nextSibling;
			}
			Span_likeNum.textContent =(`${likeChange == 0 ? "" : likeChange }`) 
		}
	})
	.catch(error=>{
		alert(`评论点击赞异常：${error.message}`)
	})
	
}

function click_comment_reply(img,cid,gid,cpath,uname){
	//创建容器div：
	const Div_reply=document.createElement('div')
	Div_reply.className='comment-reply-container'
    
	Div_reply.innerHTML=`
		<h2>回复评论</h2>
        <form onsubmit="return submit_comment_reply(this,${cid},${gid},  &quot;${cpath}&quot;  ,  &quot;${uname}&quot; )" >
            <textarea id="comment-textarea" name="comment" placeholder="写下你的回复..."  required></textarea>
            <div><button type="submit">提交评论</button></div>
		</form>
	`;

	let reply_Divs=document.getElementsByClassName('comment-reply-container');
	if(reply_Divs){	//增加评论框前检查场上有无旧的评论框，删之
		Array.from(reply_Divs).forEach(function(Div_reply) {
		    if (Div_reply.parentNode) {
		        Div_reply.parentNode.removeChild(Div_reply);
		    }
		});
	}
	insertAfter(Div_reply,img.parentNode)	//增添回复框
}
function submit_comment_reply(form,cid,gid,cpath,uname_upper){
//alert('传参进函数完毕')
	//从cookie获取当前用户信息：
	let uid=getCookieValue('Login_uid')
	let uname=getCookieValue('Login_uname')
	var urlSearchParams=new URLSearchParams(new FormData(form));
	urlSearchParams.append('uid',uid);
	urlSearchParams.append('gid',gid);
	urlSearchParams.append('uname',uname);
	urlSearchParams.append('cid_upper',cid);
	urlSearchParams.append('cpath_upper',cpath);
	urlSearchParams.append('uname_upper',uname_upper)
	fetch('CommentServlet.do',{
		method: "POST",
		headers:{
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: urlSearchParams
	})
	.then(response=>{
		if(!response.ok){
			throw new Error();
		}else{
//alert('Ajax顺利完成')
			console.debug('操作成功')
			return response.json();
		}
	})
	.then(json=>{
//alert('开始读取json')
		var commentData={
			cid: json.cid,
			uid: json.uid,
			gid: json.gid,
			uname: json.uname,
			ctime: json.ctime,
			comment: json.comment,
			clike: json.clike,
			cparentid: json.cparentid,
			cpath: json.cpath,
			uname_upper: uname_upper	//上一级评论的uname
		};
		//开始生成评论
//alert('开始生成评论')
	    var newCommentElement = createSingleComment(commentData);
		var Div_reply = document.querySelector('.comment-reply-container');
		insertAfter(newCommentElement,Div_reply); //插入到该评论之后
        
		var Div_reply = document.querySelector('.comment-reply-container');
		if (Div_reply.parentNode) {//删除评论回复框
		    Div_reply.parentNode.removeChild(Div_reply);
		}
		console.debug('评论生成成功')
//alert('评论生成成功')

	})
	.catch(error=>{
		alert(`提交评论时出现异常：${error.message}`)
	})
	return false;
}
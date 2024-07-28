/*点击点赞按钮后会触发相应的Ajax*/
function click_like(img,uid,gid){
	var action=img.src.endsWith('like.png')? 'like': 'unlike';
	// 跳转到servlet，传递action=like/unlike参数
	fetch('LikeServlet.do?action='+action+'&uid='+uid+'&gid='+gid,{
		method:'GET'
	})
	.then(response => {
        if (!response.ok) {
			alert('操作失败');
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





/*点击评论按钮后会触发相应的Ajax*/
function click_comment(img,uid,gid){
	console.log('点击评论按钮')
	if(img.src.endsWith('comment.png')){ //未评论状态
		//todo: 跳转到servlet，传递action=like参数
		img.src = "images/comment_yes.png"
	}else{ //已点赞状态
		//反之，unlike参数
		img.src = "images/comment.png"
	}
}
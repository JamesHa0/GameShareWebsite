<template>
  <!-- 游戏的点赞和评论 -->
    <!-- 点赞模块 -->
<article>
    
    <section class="icon">
        <table>
            <tr>
                <td><img @click="doLike()" :src="likeImg"/></td>
                <td><a href="#comment-input"><img src="@images/comment.png"/></a></td>
            </tr>
            <tr>
                <td>{{newLikeNum }}</td>
                <td>{{commentNum }}</td>
            </tr>
        </table>
    </section>

    
    <!-- 评论模块 --><br><br><br>
    <section class="comment-module">
            <!-- 标题 -->
        <div class="comment-header">玩家评论：</div>
            <!-- 评论发表文本框 -->
        <div class="comment-input" id="comment-input">
            <h2>发表评论</h2>
            <form onsubmit="return submit_comment(this,'${user.uid}','${game.gid }', &quot;${user.uname }&quot;)"  ><!-- 注意这里要用&quot;（双引号符） -->
                <textarea id="comment-textarea" name="comment" placeholder="写下你的评论..." required></textarea>
                <div><button type="submit">提交评论</button></div>
            </form>
        </div>

        <!-- 评论区 -->
        <div class="comments">
            <!-- 无评论时显示的沙发图案 -->
            <img v-if="comments == null" id="sofa" src="@images/sofa.png" draggable="false">
            <!-- 循环遍历所有评论 -->
            <div v-for="comment in comments"  :key="comment.cid"
                    class="comment-container" :style="'padding-left:' + this.getCommentIndent(comment.cpath) + 'px'">	    
                <!-- 评论者和日期 -->
                <span class="comment-uname" v-html="comment.uname + ' ：'"></span>
                <span class="comment-ctime">[{{comment.ctime}}]</span>
                <!-- 评论的点赞和回复图标 -->
                <img id="comment-like" @click="doCommentLike(comment)" src="@images/comment_like.png"/>
                <span class="comment-likeNum"  >{{ showClike(comment.clike)}}</span>
                <img id="comment-reply" @click="doCommentReply()"   src="@images/comment_reply.png"/>
                <!-- 评论内容 -->
                <p style="display:block" class="comment-text"> {{comment.comment }}</p>
            </div>
            <!-- 分页 -->
            <el-pagination
                class="pagination"
                v-model:current-page="currentPage"
                v-model:page-size="pageSize"
                :total="commentNum"
                :background="true"
                layout="sizes, prev, pager, next, jumper"
                :page-sizes="[10, 20, 50, 100, 500]"
                :hide-on-single-page="false"
                @current-change="handleCurrentChange"
                @size-change="handleSizeChange"
                />
        </div>
    </section>
    
</article>
</template>

<script>
import axios from 'axios'

export default {
    props:['user', 'game', 'order',
        'isLiked', 'likeNum',
        'likedComments', 'commentNum'
    ],
    data(){
        return{
            currentPage: 1,
            pageSize: 10,
            comments: null,
            newIsLiked: this.isLiked,
            newLikeNum: this.likeNum,
            likeImg: this.isLiked ? 'src/assets/images/like_yes.png': 'src/assets/images/like.png'
        }
    },
    created(){
        this.getCommentByPage(this.currentPage, this.pageSize)
    },
    methods:{
        getCommentByPage(current, size){
            axios.get('/comment/listByPage/'+this.game.gid+'/'+current+'/'+size)
            .then(res=>{
                console.log('=> 评论数据：')
                console.log(res.data.data.comments);
                this.comments = res.data.data.comments
            })
            .catch(error=>{console.error('请求失败:', error);})
        },
        handleCurrentChange(val){
            this.getCommentByPage(val, this.pageSize)
        },
        handleSizeChange(val){
            this.getCommentByPage(this.currentPage, val)
        },
        getCommentIndent(cpath){   // 计算每条评论的缩进宽度（px）
            if(cpath == null) return 0;
            let sharpNum = cpath.length - cpath.replace(/#/g, '').length
            if(sharpNum > 4)
                sharpNum = 4
            return sharpNum*60 + 20; 
        },
        showClike(clike){
            return clike==null? 0: clike
        },
        doLike(){
            const action=this.likeImg.endsWith('like.png')? 'like': 'dislike';
            // 请求数据，传递action(like/dislike)参数
            axios.post('/game/doLike', {
                uid: this.user.uid,
                gid: this.game.gid,
                action: action,
            },{
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then(response => {
                if (response.status !== 200) {
                    throw new Error('操作失败');
                }else{
                    if(action==="like"){
                        this.likeImg = 'src/assets/images/like_yes.png'	//点亮
                        this.newLikeNum ++;	//更新赞数：+1
                    }else{
                        this.likeImg = 'src/assets/images/like.png' //点灭
                        this.newLikeNum --;
                    }
                }
            })
            .catch(error=>{
                alert(`点赞操作异常：${error.message}`)
	        })
        },
        doCommentLike(comment){
            console.log(comment)
            axios.post('/comment/doLike/'+this.user.uid+'/'+comment.cid+'/', 
            {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then(response => {
                if (response.status !== 200) {
                    throw new Error('操作失败');
                }else{
                    console.log('点赞/取消赞成功')
                }
            })
        },
    }

}
</script>

<style>

/******************<!-- 游戏的点赞和评论 -->***********************/
.icon {
	padding-top: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.icon table {
	text-align: center;
}

.icon img {
	padding: 0 50px;
	width: 60px;
	cursor:pointer;
}


/***********************<!-- 评论模块 -->*********************/
.comment-module {
	padding: 50px 20px;
	position: relative;
}

.comment-header {
	font-size: 20px;
	font-weight: bold;
	padding-left: 40px;
	position: relative;
}

/*发表评论****************/
.comment-input {
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    max-width: 800px;
    margin: 30px auto;
    
/*     position: fixed; 固定定位在视口中 */
/*     top: 0; 顶部固定 */
/*     left: 0; 左侧固定，根据需要调整 */
/*     right: 0; 右侧固定，根据需要调整 */
/*     background: rgba(0,0,0,0.5); 背景色 */
/*     z-index: 100; 确保在其他内容的上方 */
/*     box-shadow: 0 2px 4px rgba(0,0,0,0.1); 添加阴影，提升层次感 */
}

.comment-input h2 {
	font-size: 25px;
    color: #400000;
}

.comment-input form {
    display: flex;
    flex-direction: column;
}

.comment-input form textarea {
    margin-top: 10px;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    min-height: 30px;
    resize: vertical;
}

.comment-input form div{
    margin-top: 20px;
    text-align: right;
}

.comment-input form button {
    background-color: #804000;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.comment-input form button:hover {
    background-color: #400000;
}


/*<!-- 评论区 -->***********************/
.comments {
	padding: 20px 40px;
	position: relative;
}

.comments #sofa{
	width:800px;
}

/* 评论区容器样式 */
.comment-container {
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 1em;
    margin-bottom: 1em;
    background-color: #f9f9f9;
    max-width: 1000px; /* 限制评论容器的最大宽度 */
    word-wrap: break-word; /* 长单词自动换行 */
}

/* 评论者用户名样式 */
.comment-uname {
    font-size: 1em;
    font-weight: bold;
    color: #333;
    margin-right: 5px; /* 与日期的间距 */
}

/* 评论日期样式 */
.comment-ctime {
    float: right;
    font-size: 0.9em;
    color: #888;
    margin-left: 10px; /* 与用户名的间距 */
}
/* 点赞和回复图标样式 */
#comment-reply,
#comment-like{
	width: 30px; /* 图标宽度 */
    cursor: pointer;
	position: relative;
	float:right;
    transition: transform 0.3s; /* 平滑变化效果 */
}
#comment-reply{
	padding-right:30px;
}
/* 点赞量样式 */
.comment-likeNum {
	float:right;
    font-size: 0.9em; /* 字体大小略小 */
    color: #888; /* 较浅的字体颜色 */
    /* 定位在点赞图标下方 */
    position: relative;
    top: 5px; /* 根据图标大小和内边距调整 */
    left: 0; /* 根据需要调整，确保位置正确 */
    white-space: nowrap; /* 防止换行 */
}

#comment-like:hover,
#comment-reply:hover {
    transform: scale(1.1); /* 鼠标悬浮时放大 */
}

/* 点赞图标选中状态 */
.is-liked {
    filter: brightness(0.8); /* 调整亮度 */
}

/* 评论文本样式 */
.comment-text {
    margin-top: 0.5em;
    font-size: 1em;
    color: #444;
    white-space: pre-wrap;
    word-wrap: break-word;
}

/*******************************回复评论的生成评论框*********/
/* 回复评论容器样式 */
.comment-reply-container {
	margin:0 auto;
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 1em;
    margin-bottom: 1em;
    background-color: #f9f9f9;
    max-width: 300px; /* 限制评论容器的最大宽度 */
    word-wrap: break-word; /* 长单词自动换行 */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 阴影 */
}

/* 回复评论标题样式 */
.comment-reply-container h2 {
    margin-bottom: 1em; /* 与表单的间距 */
    color: #333334; /* 字体颜色 */
    font-size: 1.5em; /* 字体大小 */
}

/* 回复评论表单样式 */
.comment-reply-container form {
    display: flex;
    flex-direction: column;
}

/* 回复评论文本域样式 */
#comment-textarea {
    flex-grow: 1; /* 让文本域占据可用空间 */
    margin-bottom: 1em; /* 与提交按钮的间距 */
    padding: 0.5em; /* 文本域内边距 */
    border: 1px solid #cccccc; /* 边框 */
    border-radius: 4px; /* 圆角边框 */
    resize: vertical; /* 允许垂直方向调整大小 */
}

/* 回复评论按钮样式 */
.comment-reply-container button {
    background-color: #804000; /* 背景颜色 */
    color: white; /* 字体颜色 */
    border: none; /* 无边框 */
    padding: 0.75em 1.5em; /* 内边距 */
    border-radius: 4px; /* 圆角边框 */
    cursor: pointer; /* 鼠标悬停时显示手形图标 */
    transition: background-color 0.3s; /* 平滑过渡背景颜色 */
}

.comment-reply-container button:hover {
    background-color: #400000; /* 鼠标悬浮时的背景颜色 */
}

/* 回复评论按钮容器样式 */
.comment-reply-container div {
    display: flex;
    justify-content: flex-end; /* 将按钮靠右对齐 */
    margin-top: 0.5em; /* 与文本域的间距 */
}
/* 分页样式 */
.pagination{
    display: flex;
    justify-content: center;
    padding: 30px;
}
</style>
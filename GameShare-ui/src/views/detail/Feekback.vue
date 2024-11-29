<template>
  <!-- 游戏的点赞和评论 -->
    <!-- 点赞模块 -->
<article>
    
    <section class="icon">
        <table>
            <tr>
                <td><img @click="doLike()" :src="showLikeImg()"/></td>
                <td><a href="#comment-input"><img :src="constCImg"/></a></td>
            </tr>
            <tr>
                <td>{{tempLikeNum }}</td>
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
            <form  @submit.prevent="doComment()">
                <textarea id="comment-textarea" name="comment" v-model="commentText" placeholder="写下你的评论..." required></textarea>
                <div><button type="submit">提交评论</button></div>
            </form>
        </div>

        <!-- 评论区 -->
        <div class="comments">
            <!-- 无评论时显示的沙发图案 -->
            <img v-if="comments == null" id="sofa" :src="constSofa" draggable="false">
            <!-- 循环遍历所有评论 -->
            <div v-for="comment in comments" :key="comment.cid"
                    class="comment-container" :style="getCStyle(comment)">	    
                
                <!-- 评论者和日期 -->
                <span class="comment-uname">{{comment.uname}} <span v-if="comment.parentUname">{{'&emsp;回复&emsp;' +comment.parentUname }}</span> ：</span>
                <div class="comment-ctime">[{{comment.ctime }}]</div>

                <!-- 评论的点赞和回复图标 -->
                <img id="comment-like" @click="doCLike(comment)" :src="showCLikeImg(comment)"/>
                <span class="comment-likeNum"  >{{ showCLike(comment)}}</span>
                <img id="comment-reply" @click="doCReply(comment)"   :src="constCommentReply"/>

                <!-- 评论内容 -->
                <p v-if="comment.delFlag == '2'" style="display:block;color:#d0d0d0"  class="comment-text">该评论已被删除！</p >
                <p v-else style="display:block" class="comment-text"> {{comment.comment }}</p>

                <!-- 回复区 -->
                <div v-if="showCReply(comment)">
                    <el-divider content-position="left">回复 Ta：</el-divider>
                    <div id="commentBox" contenteditable="true"></div>
                </div>
                
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
import { ElMessage } from 'element-plus'

export default {
    props:['user', 'game', 'order',
        'isLiked', 'likeNum',
        'likedCids', 'commentNum'
    ],
    data(){
        return{
            /*  const常量： */
            currentPage: 1,// 当前页码
            pageSize: 10,// 每页条数
            constSofa: 'src/assets/images/sofa.png',// 沙发图案
            constCImg: 'src/assets/images/comment.png',
            constLikeImg: {// 游戏点赞图标
                'off': 'src/assets/images/like.png',   // 点灭图标
                'on': 'src/assets/images/like_yes.png',   // 点亮图标
            },
            constCommentReply: 'src/assets/images/comment_reply.png',// 回复图标
            constCommentLikeImg: {// 单一评论点赞图标
                'off': 'src/assets/images/comment_like.png', 
                'on': 'src/assets/images/comment_like_yes.png', 
            },            
            /*  数据库数据： */
            comments: null,
            /*  临时数据： */
            tempIsLiked: this.isLiked,
            tempLikeNum: this.likeNum,
            tempComments: {},   // comments对象的临时数组，随用随改；包含属性：clike、isLiked
            /* 表单数据： */
            commentText: '',
        }
    },
    created(){
        this.getCommentByPage(this.currentPage, this.pageSize)
    },
    methods:{
        getCommentByPage(current, size){
            axios.get('/comment/listByPage/'+this.game.gid+'/'+current+'/'+size)
            .then(res=>{
                console.debug('=> 评论数据：')
                console.debug(res.data.data.comments);
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
        showLikeImg(){
            return this.tempIsLiked ? this.constLikeImg.on : this.constLikeImg.off
        },
        doLike(){
            axios.post('/game/doLike', {
                uid: this.user.uid,
                gid: this.game.gid,
            },{
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then (response => {
                if (response.status !== 200) {
                    throw new Error('操作失败');
                } else {
                    const action = response.data.data.action
                    if (action==="doLike"){
                        this.tempIsLiked = true
                        this.tempLikeNum ++;	//更新赞数：+1
                    } else {
                        this.tempIsLiked = false
                        this.tempLikeNum --;
                    }
                }
            })
            .catch (error => {
                alert(`点赞操作异常：${error.message}`)
	        })
        },
        doComment(){
            axios.post('/comment/doComment', {
                uid: this.user.uid,
                gid: this.game.gid,
                comment: this.commentText
            },{
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then (response => {
                if (response.status !== 200) {
                   throw new Error('操作失败');
                } else {
                    this.commentText = ''
                    ElMessage({
                        message: '评论成功',
                        type: 'success',
                    })
                    this.getCommentByPage(this.currentPage, this.pageSize)
                }
            })
            .catch (error => {
                alert(`评论操作异常：${error.message}`)
	        })
        },
        getCStyle(comment){
            const cpath = comment.cpath
            let padding = null  // 每条评论的缩进宽度（px）
            let sharpNum = cpath.length - cpath.replace(/#/g, '').length
            if(sharpNum > 4)
                sharpNum = 4
            padding = cpath == null? 0 : sharpNum*60+20
            return  'padding-left:' + padding + 'px'
        },
        showCLike(comment){
            const cid = comment.cid
            // 找内存中tempComments[cid].clike的值：
            if(this.tempComments[cid] == undefined || this.tempComments[cid].clike == undefined){
                return comment.clike    // 不存在，则取数据库中的值；
            }else{
                return this.tempComments[cid].clike    // 存在，取之。
            }
        },
        showCLikeImg(comment){
            const cid = comment.cid
            // 找内存中isLiked的值：（当前会话的点赞行为检验：isLiked值存在则证实了有过点赞操作，反之亦然）
            if(this.tempComments[cid] == undefined || this.tempComments[cid].isLiked == undefined){
                // 不存在，则取数据库中值：
                return this.likedCids.includes(cid) ? this.constCommentLikeImg.on : this.constCommentLikeImg.off
            }else{
                // 存在，则取之
                return this.tempComments[cid].isLiked ? this.constCommentLikeImg.on : this.constCommentLikeImg.off
            }
        },
        doCLike(comment){
            const cid = comment.cid
            axios.post('/comment/doLike', {
                uid: this.user.uid,
                gid: this.game.gid,
                cid: comment.cid,
            },{
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then(response => {
                if (response.status !== 200) {
                    throw new Error('操作失败');
                }else{
                    console.log('操作成功')
                    // 给rawCid赋值：若是第一次点击，则赋值为数据库中的comment.clike；若是第二或更多次点击，则赋值为内存中的tempComments[cid].clike。
                    const rawCid = this.tempComments[cid] == undefined ? comment.clike : this.tempComments[cid].clike
                    if (response.data.data.action == "doLike"){  // 得知当前进行的是点赞操作
                        this.tempComments[cid] = {clike: parseInt(rawCid) + 1}  // 改变点赞数
                        this.tempComments[cid].isLiked = true   // 点赞状态，连带改变亮灭图标
                    } else {  // 取消赞操作
                        this.tempComments[cid] = {clike: parseInt(rawCid) - 1}
                        this.tempComments[cid].isLiked = false
                    }
                }
            })
            .catch(error=>{
                alert(`点赞操作异常：${error.message}`)
	        })
        },
        showCReply(comment){
            const cid = comment.cid
            // 找内存中isReplied的值：
            if(this.tempComments[cid] == undefined || this.tempComments[cid].isReplied == undefined){
                return false    // 不存在，则取false；
            }else{
                return this.tempComments[cid].isReplied    // 存在，取之。
            }
        },
        doCReply(comment){
            const cid = comment.cid
            console.log('doCommentReply:')
            if(this.tempComments[cid] == undefined || this.tempComments[cid].isReplied == undefined){
                this.tempComments[cid] = {isReplied: true}
            }else{
                this.tempComments[cid].isReplied = !this.tempComments[cid].isReplied
            }
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

#commentBox {
  border: 1px solid #ccc;
  min-height: 30px;
  padding: 10px;
  margin: 20px 20px 10px 10px;
  border-radius: 5px;
  overflow: auto; /* 确保内容超出时可以滚动 */
}

#commentBox:focus {
  outline: none; /* 移除焦点时的轮廓线 */
  border-color: #007bff; /* 当聚焦时改变边框颜色 */
}

</style>
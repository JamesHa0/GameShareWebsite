<template>
<main>
    <!-- 游戏的点赞和评论图标 -->
    <article class="icon">
        <table class="icon-table">
            <tr>
                <td><img class="icon-img" @click="doLike()" :src="showLikeImg()"/></td>
                <td><img class="icon-img" @click="showCommentModule = !showCommentModule" :src="constCImg"/></td>
            </tr>
            <tr>
                <td>{{tempLikeNum }}</td>
                <td>{{commentNum }}</td>
            </tr>
        </table>
    </article>
    
    <!-- 评论模块 --><br><br><br>
    <article class="comment-module" v-show="showCommentModule">
        <!-- 标题 -->
        <div class="header">玩家评论：</div>

        <!-- 评论发表 -->
        <section class="comment-release">
            <h2 class="title">发表评论</h2>
            <form class="release-form" @submit.prevent="doComment()" @keyup.ctrl.enter="doComment()" >
                <textarea class="input" v-model="commentText" placeholder="文明发言，友善互动 (*^▽^*)       （Ctrl+Enter 提交评论）" required></textarea>
                <div class="submit"><button class="btn" type="submit">提交评论</button></div>
            </form>
        </section>

        <!-- 评论区 -->
        <section class="comments-container">
            <!-- 无评论时显示的沙发图案 -->
            <img v-if="comments == null" class="sofa" :src="constSofa" draggable="false">
            <!-- 循环遍历所有评论 -->
            <article v-for="comment in comments" :key="comment.cid"
                    class="single-comment" :style="getCStyle(comment)">	    
                
                <!-- 评论信息 -->
                <section class="comment-info">
                    <div class="observer">{{comment.uname}} <span v-if="comment.parentUname"><span style="font-size: 15px;color: #ccc;">&nbsp;回复&nbsp;</span>{{comment.parentUname }}</span> ：</div>
                    <article class="info-right-items">
                        <time class="time">[{{comment.ctime }}]</time>
                        <img class="reply" :class="{ 'disable': comment.delFlag==2 ? true : false }" @click="enableCReply(comment)"   :src="constCommentReply"/>
                        <img class="like" :class="{ 'disable': comment.delFlag==2 ? true : false }" @click="doCLike(comment)" :src="showCLikeImg(comment)"/>
                        <div class="like-num"  >{{ showCLike(comment)}}</div>
                    </article>
                </section>
                <!-- 评论内容 -->
                <section class="comment-text" v-if="comment.delFlag == '2'" style="display:block;color:#d0d0d0" >该评论已被删除！</section >
                <section class="comment-text" v-else style="display:block"> {{comment.comment }}</section>
                <!-- 回复区 -->
                <section v-if="showCReply(comment)">
                    <el-divider content-position="left">回复 Ta：</el-divider>
                    <el-container>
                        <el-main class="reply-container">
                            <div class="reply-box" 
                                contenteditable="true" 
                                @input="updateReplyContext($event, comment)"
                                ></div>
                        </el-main>
                        <el-aside width="70px">
                            <el-button class="reply-btn"
                                type="primary" 
                                @click="doCReply(comment)">回复</el-button>
                        </el-aside>
                    </el-container>
                </section>
            </article>
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
        </section>
    </article>
    
</main>
</template>

<script>
import { ElMessage } from 'element-plus'
import util from '@/utils/public'
import { doLike } from '@/api/game'
import { getCommentByPage, addComment, doCommentLike, doCommentReply } from '@/api/comment'

export default {
    props:['user', 'game', 'order',
        'isLiked', 'likeNum',
        'likedCids', 'commentNum'
    ],
    data(){
        return{
            showCommentModule: false,   // 默认不显示评论模块
            /*  const常量： */
            currentPage: 1, // 当前页码
            pageSize: 10,   // 每页条数
            constSofa: 'src/assets/images/sofa.png',// 沙发图案
            constCImg: 'src/assets/images/comment.png',
            constLikeImg: { // 游戏点赞图标
                'off': 'src/assets/images/like.png',   // 点灭图标
                'on': 'src/assets/images/like_yes.png',   // 点亮图标
            },
            constCommentReply: 'src/assets/images/comment_reply.png',// 回复图标
            constCommentLikeImg: {  // 单一评论点赞图标
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
            getCommentByPage(this.game.gid, current, size)
            .then(res=>{
                console.debug('===> 评论数据：')
                console.debug(res.data.comments);
                this.comments = res.data.comments
            })
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
            doLike(this.user.uid, this.game.gid)
            .then(res=>{
                const action = res.data.action
                if (action==="doLike"){
                    this.tempIsLiked = true
                    this.tempLikeNum ++;	//更新赞数：+1
                } else {
                    this.tempIsLiked = false
                    this.tempLikeNum --;
                }
            })
        },
        doComment(){
            addComment(this.user.uid, this.game.gid, this.commentText)
            .then(res=>{
                this.commentText = ''
                ElMessage({ message: '评论成功', type: 'success' })
                this.getCommentByPage(this.currentPage, this.pageSize)
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
            if(util.isUndefined((this.tempComments[cid] || {}).clike)){
                return comment.clike    // 不存在，则取数据库中的值；
            }else{
                return this.tempComments[cid].clike    // 存在，取之。
            }
        },
        showCLikeImg(comment){
            const cid = comment.cid
            // 找内存中isLiked的值：（当前会话的点赞行为检验：isLiked值存在则证实了有过点赞操作，反之亦然）
            if(util.isUndefined((this.tempComments[cid] || {}).isLiked)){
                // 不存在，则取数据库中值：
                return this.likedCids.includes(cid) ? this.constCommentLikeImg.on : this.constCommentLikeImg.off
            }else{
                // 存在，则取之
                return this.tempComments[cid].isLiked ? this.constCommentLikeImg.on : this.constCommentLikeImg.off
            }
        },
        doCLike(comment){
            const cid = comment.cid
            doCommentLike(this.user.uid, this.game.gid, comment.cid)
            .then(res=>{
                // 确保tempComments[cid]存在，若不存在，则创建之：
                this.tempComments[cid] = this.tempComments[cid] || {}
                // 给rawCid赋值：1，若是第一次点击，则赋值为数据库中的comment.clike；2，若是第二或更多次点击，则赋值为内存中的tempComments[cid].clike。
                const rawCid = util.isUndefined(this.tempComments[cid].clike) ? comment.clike : this.tempComments[cid].clike;
                if (res.data.action == "doLike"){  // 得知当前进行的是点赞操作
                    this.tempComments[cid].clike = parseInt(rawCid) + 1;  // 改变点赞数
                    this.tempComments[cid].isLiked = true;   // 改变点赞状态，连带改变亮灭图标
                    console.debug('点赞成功');
                } else {  // 取消赞操作
                    this.tempComments[cid].clike = parseInt(rawCid) - 1;
                    this.tempComments[cid].isLiked = false;
                    console.debug('取消赞成功');
                }
            })
        },
        showCReply(comment){
            const cid = comment.cid;
            // 找内存中isReplied的值：
            if(util.isUndefined((this.tempComments[cid] || {}).isReplied)){
                return false    // 不存在，则取false；
            }else{
                return this.tempComments[cid].isReplied    // 存在，取之。
            }
        },
        enableCReply(comment){
            const cid = comment.cid
            if (util.isUndefined((this.tempComments[cid] || {}).isReplied)){   // 不存在，则创建之。
                this.tempComments[cid] = {isReplied: true}
            } else {
                this.tempComments[cid].isReplied = !this.tempComments[cid].isReplied
            }

        },
        updateReplyContext(event, comment){
            event.preventDefault(); 
            let cid = comment.cid
            this.tempComments[cid].replyText = event.target.innerText
            console.debug(event.target.innerText)
        },
        doCReply(comment){
            const cid = comment.cid
            doCommentReply(
                this.user.uid, 
                this.game.gid, 
                this.tempComments[cid].replyText, 
                comment.cid, 
                comment.uid
            )
            .then(res=>{
                this.tempComments[cid].isReplied = false
                this.tempComments[cid].replyText = ''
                ElMessage({ message: '回复成功', type: 'success' })
                this.getCommentByPage(this.currentPage, this.pageSize)
            })
        },
    }

}
</script>

<style scoped>

/******************<!-- 游戏的点赞和评论 -->***********************/
.icon {
	padding-top: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.icon-table {
	text-align: center;
}

.icon-img {
	padding: 0 50px;
	width: 60px;
	cursor:pointer;
}


/***********************<!-- 评论模块 -->*********************/
.comment-module {
	padding: 50px 20px;
	position: relative;
}
.comment-module > .header {
	font-size: 20px;
	font-weight: bold;
	padding-left: 40px;
	position: relative;
}
.comment-module > .comment-release {
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
.comment-release > .title {
	font-size: 25px;
    color: #400000;
}
.comment-release > .release-form {
    display: flex;
    flex-direction: column;
}
.release-form > .input {
    margin-top: 10px;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    min-height: 30px;
    resize: vertical;
}
.release-form > .submit{
    margin-top: 20px;
    text-align: right;
}
.release-form > .submit > .btn {
    background-color: #804000;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}
.release-form > .submit > .btn:hover {
    background-color: #400000;
}

/*<!-- 评论区 -->***********************/
.comments-container {
	padding: 20px 40px;
	position: relative;
    display: flex;
    flex-direction: column;
}
.comments-container > .sofa{
	width:800px;
}
.single-comment {
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 1em;
    margin-bottom: 1em;
    background-color: #f9f9f9;
    max-width: 1000px; /* 限制评论容器的最大宽度 */
    word-wrap: break-word; /* 长单词自动换行 */
    display: flex;
    flex-direction: column;
}
.comment-info{
    display: flex;
    align-items: center;
    flex-direction: row;
    justify-content: space-between;
}
.comment-info > .observer {
    font-size: 1em;
    font-weight: bold;
    color: #333;
    max-width: 500px; /* 限制容器的最大宽度 */
}
.info-right-items{
    display: flex;
    align-items: center;
    justify-content: space-between;
    min-width: 260px;
}
.info-right-items > .time {
    font-size: 0.9em;
    color: #888;
}
.info-right-items > .like{
	width: 30px; /* 图标宽度 */
    margin: 10px 0 10px 0;
    cursor: pointer;
    transition: transform 0.3s; /* 平滑变化效果 */
}
.info-right-items > .reply{
	width: 34px;  /*图标宽度 */
	margin:5px;
    cursor: pointer;
    transition: transform 0.3s; /* 平滑变化效果 */
}
.info-right-items > .like-num {
    font-size: 0.9em; /* 字体大小略小 */
    color: #888; /* 较浅的字体颜色 */
    white-space: nowrap; /* 防止换行 */
    position: relative;
    margin-left: -6px
}
.info-right-items > .like:hover,
.info-right-items > .reply:hover {
    transform: scale(1.1); 
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
.reply-container{
    padding:0   /* 去除el-main容器自带边距 */
}
.reply-box {
    border: 1px solid #ccc;
    min-height: 30px;
    padding: 10px 10px 3px 10px;
    margin: 0 20px 10px 10px;
    border-radius: 5px;
    overflow: auto; 
}
.reply-box:focus {
  outline: none; /* 移除焦点时的轮廓线 */
  border-color: #007bff; /* 当聚焦时改变边框颜色 */
}
.reply-btn{
    margin-left: 5px;
    margin-top: 5px
}
/* 分页样式 */
.pagination{
    display: flex;
    justify-content: center;
    padding: 30px;
}

/************************动态生成的css样式*******/
/* 点赞图标选中状态 */
.is-liked {
    filter: brightness(0.8); /* 调整亮度 */
}
/* 被禁止点击状态（已删除评论的图标） */
.disable{
  pointer-events: none;
  opacity: 0.5; /*使元素看起来被禁用 */
  user-select: none;
}
</style>
<template>
<main>
    <!-- 游戏的点赞和评论图标 -->
    <article class="icon">
        <table class="icon-table">
            <tr>
                <td><img class="icon-img" @click="doLikeAction()" :src="showLikeImg()"/></td>
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
                    class="single-comment" :style="showCommentStyle(comment)">	    
                
                <!-- 评论信息 -->
                <section class="comment-info">
                    <div class="commenter">{{comment.uname}}<span v-if="comment.parentUname"><span class="literal-reply">回复</span>{{comment.parentUname }}</span> ：</div>
                    <article class="info-right-items">
                        <time class="time">[{{comment.ctime }}]</time>
                        <img class="reply" :class="{ 'disable': comment.delFlag==2 ? true : false }" @click="enableCommentReply(comment)" :src="constCommentReply"/>
                        <img class="like" :class="{ 'disable': comment.delFlag==2 ? true : false }" @click="doCommentLikeAction(comment)" :src="showCommentLikeImg(comment)"/>
                        <div class="like-num"  >{{ showCommentLike(comment)}}</div>
                    </article>
                </section>
                <!-- 评论内容 -->
                <section class="comment-text" v-if="comment.delFlag == '2'" style="color:#d0d0d0" >该评论已被删除！</section >
                <section class="comment-text" v-else> {{comment.comment }}</section>
                <!-- 回复区 -->
                <section v-show="showCommentReply(comment)">
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
                                @click="doReply(comment)">回复</el-button>
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

<script setup>
import { ref } from 'vue';
import { ElMessage } from 'element-plus';
import util from '@/utils/public';
import { doLike } from '@/api/game'
import { getCommentByPage, addComment, doCommentLike, doCommentReply } from '@/api/comment';

// Constants
const constSofa = 'src/assets/images/sofa.png';
const constCImg = 'src/assets/images/comment.png';
const constLikeImg = {
  'off': 'src/assets/images/like.png',
  'on': 'src/assets/images/like_yes.png',
};
const constCommentReply = 'src/assets/images/comment_reply.png';
const constCommentLikeImg = {
  'off': 'src/assets/images/comment_like.png',
  'on': 'src/assets/images/comment_like_yes.png',
};

// Props
const props = defineProps({
  user: Object,
  game: Object,
  order: Object,
  isLiked: Boolean,
  likeNum: Number,
  likedCids: Array,
  commentNum: Number
});

// Reactive variables
const showCommentModule = ref(false);
const comments = ref([]);
const tempIsLiked = ref(props.isLiked);
const tempLikeNum = ref(props.likeNum);
const tempComments = ref([]);
const commentText = ref('');

// Pagination
const currentPage = ref(1);
const pageSize = ref(10);

// Get comments
const getComment = (page, size) => {
  getCommentByPage(props.game.gid, page, size)
    .then(res => {
      comments.value = res.data.comments;
    });
};

// Initial comments
getComment(currentPage.value, pageSize.value);

// Pagination handlers
const handleCurrentChange = (val) => {
  getComment(val, pageSize.value);
};

const handleSizeChange = (val) => {
  getComment(currentPage.value, val);
};

// Like handling
const showLikeImg = () => {
  return tempIsLiked.value ? constLikeImg.on : constLikeImg.off;
};

const doLikeAction = () => {
  doLike(props.user.uid, props.game.gid)
    .then(res => {
      const action = res.data.action;
      if (action === "doLike") {
        tempIsLiked.value = true;
        tempLikeNum.value++;
      } else {
        tempIsLiked.value = false;
        tempLikeNum.value--;
      }
    });
};

// Comment handling
const doComment = () => {
  addComment(props.user.uid, props.game.gid, commentText.value)
    .then(res => {
      commentText.value = '';
      ElMessage({ message: '评论成功', type: 'success' });
      getComment(currentPage.value, pageSize.value);
    });
};

// Comment style
const showCommentStyle = (comment) => { // 根据cpath属性，计算该评论的padding-left样式
  const cpath = comment.cpath;
  let padding = cpath == null ? 0 : (cpath.length - cpath.replace(/#/g, '').length > 4 ? 4 : cpath.length - cpath.replace(/#/g, '').length) * 60 + 20;
  return `padding-left: ${padding}px`;
};

/// Comment like handling
const showCommentLike = (comment) => {
  return util.isUndefined(tempComments.value[comment.cid]?.clike)   // 当前会话内尚未点击过,
    ? comment.clike   // 则返回数据库中的点赞数;
    : tempComments.value[comment.cid].clike;  // 否则返回内存中记录的点赞数。
};

const showCommentLikeImg = (comment) => {
  let isLiked = false;
  if (util.isUndefined(tempComments.value[comment.cid]?.isLiked)) {  // 当前会话内尚未点击过，
    isLiked = props.likedCids.includes(comment.cid);   // 则返回数据库中的点赞状态;
  } else {  // 点击过，
    isLiked = tempComments.value[comment.cid].isLiked;  // 则返回内存中记录的点赞状态。
  }
  return isLiked ? constCommentLikeImg.on : constCommentLikeImg.off;  // 根据布尔值返回对应的图片地址常量。
};

const doCommentLikeAction = (comment) => {
  const cid = comment.cid;
  doCommentLike(props.user.uid, props.game.gid, comment.cid)
    .then(res => {
      tempComments.value[cid] = tempComments.value[cid] || {};
      const rawCid = util.isUndefined(tempComments.value[cid].clike) ? comment.clike : tempComments.value[cid].clike;
      if (res.data.action === "doLike") {
        tempComments.value[cid].clike = parseInt(rawCid) + 1;
        tempComments.value[cid].isLiked = true;
      } else {
        tempComments.value[cid].clike = parseInt(rawCid) - 1;
        tempComments.value[cid].isLiked = false;
      }
    });
};

/// Comment reply handling
const enableCommentReply = (comment) => {
  const cid = comment.cid;
  if (util.isUndefined(tempComments.value[cid])) { // 对象不存在，
    tempComments.value[cid] = { isOpenedBox: true };  // 则新建对象及其属性；
  } else if (util.isUndefined(tempComments.value[cid].isOpenedBox)) { // 属性不存在，
    tempComments.value[cid].isOpenedBox = true; // 则新建属性；
  } else {  // 属性已存在，
    tempComments.value[cid].isOpenedBox = !tempComments.value[cid].isOpenedBox; // 则属性值取反。
  }
};

const showCommentReply = (comment) => {
    if (util.isUndefined(tempComments.value[comment.cid]?.isOpenedBox)) { // 属性值不存在，
        return false; // 则不显示回复框；
    } else {  // 属性值存在，
        return tempComments.value[comment.cid]?.isOpenedBox;  // 则根据属性值判断是否显示回复框。
    }
};

const updateReplyContext = (event, comment) => {  // 用于回复框内文字的反射动作
  event.preventDefault();
  tempComments.value[comment.cid].replyText = event.target.innerText;
};

const doReply = (comment) => {  // 回复评论
  const cid = comment.cid;
  doCommentReply(props.user.uid, props.game.gid, tempComments.value[cid].replyText, comment.cid, comment.uid)
    .then(res => {
      tempComments.value[cid].isOpenedBox = false;
      tempComments.value[cid].replyText = '';
      ElMessage({ message: '回复成功', type: 'success' });
      getComment(currentPage.value, pageSize.value);
    });
};
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
.literal-reply{
    display: inline-block;
    margin: 0 3px 0 3px;
    font: 12px 'Microsoft YaHei';
    color: #ccc;
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
.comment-info > .commenter {
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
    font-size: 0.9em;
    color: #888; 
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
  outline: none;
  border-color: #007bff;
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

/************************动态生成的样式*******/
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
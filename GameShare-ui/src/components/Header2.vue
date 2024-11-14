<template>
  <div class="header">
			<!-- 最左侧的文本 -->
			<div class="left-text">
                <p v-if=" $route.fullPath =='/' ">GameShareWebsite</p><!-- 判断uri，若为index页面则发生修改；当前路径为：{{ $route.fullPath }} -->
                <router-link v-else to="/">返回首页</router-link>
			</div>

			<!-- 最右侧的个人资料logo-->
			<router-link to="/info" class="info">
				<img src="../assets/images/info.png" height="28px" title="个人资料" >
			</router-link>

			<!-- 中间的文本 -->
			<div class="middle-text">
				<router-link v-if="1" to="/LR" >登录﹠注册</router-link>
                <p v-if="0" class="hello" title="xxx">欢迎您，xxx<a href="">登出</a></p>
			</div>
	</div>
</template>

<script>
import { getToken } from '@/assets/js/myPublic.js'

export default {
	data(){
		return {
			uid: null
		}
	},
	created(){
		this.uid = getToken().sub
	},

}
</script>

<style>
/*****************************<!-- 页眉 -->*********/

*{
	margin: 0;
	padding: 0;
}
/* <!-- 网站名 --> */
.header {
	position: relative;
	height: 45px;
	color:#ffffff;
	background-color: #4d4343;
	margin: 0px auto;
}

.header *{
	line-height:45px; /*  子元素全部垂直居中  */
}


.header .left-text *{ 
	margin-left: 20px;
	float: left;
	font-size: 22px;
	font-weight: 600;
	color:#ffffff;
	line-height: 45px;
}

.header .middle-text{
	float:right;
	right:100px;
	padding-right:30px;
	display:flex;
	flex-direction:row;
	font-size:15px;
}
.header .middle-text a {
	padding-left:60px;;
	color:#ffffff;
}
.header .right-text  a:hover {
	color: #f10215;
	color:#f22334;
}

/* <!-- info（个人信息） --> */
.header .info {
	float:right;
	position: relative;
	height: 45px;
	background-color: #919198;
}


.header .info img {
	margin-top: 8px;
	margin-left: 10px;
	margin-right: 10px;
}
</style>
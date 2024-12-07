<template>
<article class="header">
	<!-- 最左侧的文本 -->
	<section class="left-text">
		<p v-if=" $route.fullPath =='/' ">GameShareWebsite</p><!-- 判断uri，若为index页面则发生修改；当前路径为：{{ $route.fullPath }} -->
		<router-link v-else to="/">返回首页</router-link>
	</section>

	<!-- 中间的文本 -->
	<section class="middle-text">
		<router-link v-if="isAuth" to="/LR" >登录﹠注册</router-link>
		<template v-else>
			<p :title="getName">欢迎您，{{ getName }} </p>
			<p class="logout" @click="logout()">登出</p>
		</template>
	</section>

	<!-- 最右侧的个人资料logo-->
	 <section class="right-text">
		<router-link :to="{name:'Info'}" class="info">
			<img src="../assets/images/info.png" height="28px" title="个人资料" >
		</router-link>
	</section>
</article>
</template>

<script>
import { getDecodedToken } from '@/utils/auth.js'
import { startLoading, endLoading } from '@/utils/public.js'
import { ElMessage } from 'element-plus'

export default {
	data() {
		return {
			jwt: null
		}
	},
	created() {
		this.jwt = getDecodedToken();
	},
	computed: {
		isAuth() {
			return this.jwt === null;
		},
		getName() {
			return this.jwt.uname
		}
	},
	methods: {
		logout() {
			startLoading()
			localStorage.removeItem('Token')
			this.$router.push('/LR')
			endLoading()
			ElMessage({
				message: '登出成功',
				type: 'success'
			})
		}
	}
}
</script>

<style scoped>
/*****************************<!-- 页眉 -->*********/
*{
	line-height:45px; /*  子元素全部垂直居中  */
}
.header {
	height: 45px;
	color:#ffffff;
	background-color: #4d4343;
	margin: 0px auto;
	display: flex;
	justify-content: space-between;
	align-items: center;
	flex-direction: row;
}
.left-text{
	margin-left: 20px;
	font-size: 22px;
	font-weight: 600;
	color:#ffffff;
	line-height: 45px;
	min-width: 216px;
}
.middle-text{
	font-size:15px;
	margin-left: 700px;
	display: flex;
	flex-direction: row;
}
.middle-text a{	/* 注意这里是router-link内置的a标签的样式，只能用后代选择器 */
	padding-left:60px;
	color:#ffffff;
}
.middle-text .logout{
	padding-left:60px;
	cursor: pointer;
}
.right-text a:hover {
	color: #f10215;
}

/* <!-- info（个人信息） --> */
.info {
	float:right;
	position: relative;/**/
	height: 45px;
	background-color: #919198;
}
.info > img {
	margin-top: 8px;
	margin-left: 10px;
	margin-right: 10px;
}
</style>
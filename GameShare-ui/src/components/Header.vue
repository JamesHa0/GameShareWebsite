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
		<p v-else class="hello" title="xxx">欢迎您，{{ getName }}<a href="">登出</a></p>
	</section>

	<!-- 最右侧的个人资料logo-->
	 <section class="right-text">
		<router-link to="/info" class="info">
			<img src="../assets/images/info.png" height="28px" title="个人资料" >
		</router-link>
	</section>
</article>
</template>

<script>
import { getToken, startLoading, endLoading } from '@js/myPublic.js'
import { ElMessage } from 'element-plus'

export default {
	data() {
		return {
			jwt: null
		}
	},
	created() {
		// console.debug('Header.vue created()');
		try {
			this.jwt = getToken();
		} catch {
			// 所有页面出现jwt无效的异常，全都交给header页面处理（弹窗+重定向）
			startLoading()
			ElMessage({
				message: 'Oops！登录状态异常，请重新登录。 ',
				type: 'error',
				onClose: () => {
					endLoading()
					this.$router.push('/LR')
				},
			})
		}
		// return;    	// 如后续不再可能报错（如：无后续代码），则无需用return中止程序防止意外执行
	},
	computed: {
		isAuth() {
			return this.jwt === null;
		},
		getName() {
			return this.jwt.uname
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
}
.middle-text a{	/* 注意这里是router-link内置的a标签的样式，只能用后代选择器 */
	padding-left:60px;
	color:#ffffff;
}
.right-text a :hover {
	color: #f10215;
	color:#f22334;
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
<template>
  <Header/>
    <div v-if="user" class="background">
		<div class="container">
			<table class="info-table">
				<tr>
					<td class="table-head" colspan="2">个人信息</td>
				</tr>
				<tr>
					<td>用户ID:</td>
					<td>{{user.uid }}</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td>{{user.uname }}</td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>{{user.ugender }}</td>
				</tr>
				<tr>
					<td>注册手机号:</td>
					<td>{{user.utel }}</td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td>{{user.uemail }}</td>
				</tr>
				<tr>
					<td>拥有积分:</td>
					<td><span class="point-num">{{user.upoint }}</span>
					<span class="sign-in"  @click='signIn()'>🪙点此签到</span>
					</td>
				</tr>
				<tr>
					<td>购买的游戏:</td>
					<td class="go-order"><router-link :to="{ name: 'Order' }" >📜查看订单</router-link></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td>{{ user.uaddress }}</td>
				</tr>
			</table>
		</div>
    </div>

  <Footer/>
</template>

<script setup>
import { ref } from 'vue'
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import { ElMessage } from 'element-plus'
import { getDecodedToken } from '@/utils/auth'
import { getUser, doSignIn } from '@/api/user'

let jwt = ref(null)
jwt.value = getDecodedToken();

let user = ref(null)
getUser(jwt.value.sub)
.then(res=>{
	user.value = res.data.user;
})

const signIn = () =>{
	doSignIn(user.value.uid)
	.then(res=>{
		user.value.upoint = parseInt(user.value.upoint) + res.data.point;
		ElMessage({ message: `签到成功！获得${res.data.point}积分。`, type: 'success', })
	})
}

</script>



<style scoped>
.background {
	margin: 20px auto 0px;
	background: #fff;
	border-radius: 20px;
	box-shadow: 0 14px 28px rgba(0, 0, 0, .25), 0 10px 10px
		rgba(0, 0, 0, .22);
	position: relative;
	overflow: hidden;
	width: 1000px;
	max-width: 100%;
	min-height: 500px;
}
.background > .container {
	padding:50px 200px;
}
.info-table{
	border-spacing: 0;
	text-align: center;
}
.info-table > tr {
	height: 40px;
	font-size: 14px;
	color: #666666;
	line-height: 14px;
	font-weight: 400;
}
.info-table > tr:nth-child(2n) {
	background-color: #FAFAFA;
}
.table-head {
	width: 600px;
	height: 40px;
	font-size: 30px;
	color: #666666;
	line-height: 14px;
	font-weight: 600;
}
.point-num {
	color: #cccc00;
}
.sign-in {
	position: relative;
	left: 20px;
	color:#ff80c0;
	cursor:pointer;
	user-select: none;
}
.go-order a{
	color:#00c8ff;
	cursor:pointer;
	user-select: none;
}

</style>
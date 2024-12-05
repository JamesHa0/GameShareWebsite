<template>
  <Header/>
    <div v-if="user" class="background">
		<div class="container">
			<table class="info-table">
				<tr>
					<td class="table-head" colspan="2" style="width: 600px;height: 60px;">个人信息</td>
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
					<td>&emsp;&emsp;&emsp;<span class="pointNum">{{user.upoint }}</span>&emsp;&emsp;&emsp;
					<span class="sign-in"  @click='doSignIn()'>点此签到</span>
					</td>
				</tr>
				<tr>
					<td>购买的游戏:</td>
					<td><a href='#' >点此查看已购买的游戏</a></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td>{{user.uaddress }}</td>
				</tr>
			</table>
		</div>
    </div>

  <Footer/>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import axios from 'axios'
import { getToken } from '@/assets/js/myPublic.js'
import { ElMessage } from 'element-plus'

export default {
    components: {
         Header,
         Footer,
    },
    data(){
        return {
            user:null,
			jwt:null,
        }
    },
    created(){
		this.jwt = getToken();
        this.getUser();
    },
	methods:{
		getUser(){
			axios.get('/user/' + this.jwt.sub)
			.then(response => {
				console.log('响应数据data : ', response.data);
				this.user = response.data;
			})
			.catch(error => {
				console.error('请求失败:', error);
			});
		},
		doSignIn(){
			axios.post('/user/signIn/'+this.user.uid)
			.then(response=>{
				console.debug('服务器响应为：')
				console.debug(response);
				const point = response.data.data.point;
				if (response.data.code == 200){
					this.user.upoint = parseInt(this.user.upoint) + point;
					ElMessage({
						message: `签到成功！获得${point}积分。`, 
						type: 'success',
					})
				} else {
					ElMessage({
						message: response.data.message,
						type: 'info',
					})
				}
			})
			.catch(error=>{
				console.error('请求失败:', error);
			})
		}
	}

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
.info-table > .table-head {
	font-size: 30px;
	color: #666666;
	line-height: 14px;
	font-weight: 600;
}

.sign-in{
	color:#ff80c0;
	cursor:pointer;
	user-select: none;
}


</style>
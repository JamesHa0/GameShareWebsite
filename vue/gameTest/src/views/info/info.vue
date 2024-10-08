<template>
  <Header/>
    <div v-if="user" class="container">
		<div class="info_table">
			<table>
				<tr>
					<td class="table_head" colspan="2" style="width: 600px;height: 60px;">个人信息</td>
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
					<span class="sign_in"  onclick='click_sign_in({{my:toJson(user)}})'  style="user-select: none;">点此签到</span></td>
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
import { getToken } from '@/public.js'

export default {
    components: {
         Header,
         Footer,
    },
    data(){
        return {
            uid:null,
            user:null,
        }
    },
    created(){
        this.uid = getToken().sub;
        this.fetchUser();
    },
    
	methods:{
		fetchUser(){
			axios.get('/user/' + this.uid)
			.then(response => {
				console.log('响应数据data : ', response.data);
				this.user = response.data;
			})
			.catch(error => {
				console.error('请求失败:', error);
			});
		}
	}

}
</script>

<style>

.container {
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

.info_table {
	padding:50px 200px;
}

.info_table table {
	border-spacing: 0;
	text-align: center;
}

.info_table table thead tr:nth-child(2n+1) {
	background-color: #FAFAFA;
}

.info_table table tr {
	height: 40px;
	font-size: 14px;
	color: #666666;
	line-height: 14px;
	font-weight: 400;
}

.info_table table tr:nth-child(2n) {
	background-color: #FAFAFA;
}

.info_table table .table_head {
	font-size: 30px;
	color: #666666;
	line-height: 14px;
	font-weight: 600;
}

.sign_in{
	color:#ff80c0;
	cursor:pointer;
}


</style>
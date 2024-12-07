<template>
  <Header/>
	<div class="background" >
		<div class="back-btn">
			<router-link :to="{name:'Info'}">
				<el-button :round="true">返回上页</el-button>
			</router-link>
		</div>
		<div class="container">
			<table class="order-table">
				<tr class="table-head">
					<td class="game-name">游戏</td>
					<td>价格</td>
					<td>购买时间</td>
					<td>订单编号</td>
				</tr>
				<tr  v-for="(i, index) in orderGames" :key="index">
					<td>{{ i.game.gzhname }} <br>（{{ i.game.gname }}）</td>
					<td>{{ i.game.gprice }}</td>
					<td>{{ i.otime }}</td>
					<td>{{ i.onumber }}</td>
				</tr>
			</table>
		</div>
	</div>
  <Footer/>
</template>

<script setup lang='ts'>
import { ref } from 'vue';
import Header from '@comp/Header.vue'
import Footer from '@comp/Footer.vue'
import { getOrderAndItsGame } from '@/api/order.js'
import { getDecodedToken } from '@/utils/auth.js'

let orderGames = ref([])
const uid = getDecodedToken().sub
const getInfo = getOrderAndItsGame(uid)
.then(res => {
	orderGames.value = res.data.orderGames
})

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
.background > .back-btn{
	margin: 50px 0 0 50px;
}
.background > .container {
	padding:0 100px;
}
.order-table{
	border-spacing: 0;
	text-align: center;
}
.order-table > tr {
	height: 40px;
	font-size: 14px;
	color: #666666;
	line-height: 14px;
	font-weight: 400;
}
.order-table > tr:nth-child(2n) {
	background-color: #FAFAFA;
}
.table-head > td {
	font-size: 30px;
	color: #666666;
	width: 200px;height: 60px;
	line-height: 14px;
	font-weight: 600;
}
.table-head > .game-name {
	width: 300px;
}
</style>

<template>
	<article v-if="user && game" class="gcover">
      	<div class="gtitle">{{game.gzhname}}</div>
      	<hr/>
		<img :src="'/src/assets/game/' + game.gid + '/1.jpg'"/>

		<!-- 基本游戏信息 -->
		<table class="topTable">
			<tr><td>游戏名：</td><td>{{game.gname}}</td></tr>
			<tr><td>游戏类型：</td><td>{{game.gtag}}</td></tr>
			<tr><td>价格：</td>
			<td>
				<div v-if="isSteam()">{{game.gprice}}RMB</div>
				<div v-else>{{game.gprice}}积分</div>
			</td>
			</tr>
			<tr><td>制造商：</td><td>{{game.gdeveloper }}</td></tr>
			<tr><td>发行商：</td><td>{{game.gpublisher }}</td></tr>
			<tr><td>发行日期：</td><td>{{game.grelease_date }}<p v-if="game.grelease_date==null">game.grelease_date的值为null</p></td></tr>
		</table>
          
		<!-- 购买&下载按钮： -->
		<table v-if="isSteam()">
		<!-- 1，steam外站下载业务 -->
		<tr>
			<td>在steam上购买：</td>
			<td>
				<div id="steam"><a :href=" 'https://store.steampowered.com/app/' + game.gid " >
				<img  src="/src/assets/images/steam.png"/></a></div>
			</td>
		</tr>
		</table>

		<table v-else>
		<!-- 2，本站游戏下载业务 -->
			<tr><!-- 业已购买 -->
				<td>购买情况：</td>
				<td v-if="order">您已购买此游戏</td>
				<td v-else>尚未购买</td>
			</tr>
			<tr v-if="order == false"><!-- 尚未购买 -->
				<td>是否购买？<br/>（剩余积分:{{user.upoint }}）</td>
				<td><div id="steam"><a href="#">
				<img  src="/src/assets/images/yes.png"/></a></div></td>
			</tr>
			<tr v-if="order">
				<td>订单编号:</td>
				<td>{{order.onumber }}</td>
			</tr>
			<tr>
				<td>是否立即下载？</td>
				<td><div id="steam"><a href="#">
				<img  src="/src/assets/images/yes.png"/></a></div></td>
			</tr>
		</table>

	</article>
  
</template>

<script>

export default {
  props:['user', 'game', 'order'],
  methods:{
    isSteam(){
      return this.game.gid.length<9   // <9表示是steam游戏
    }
  }

}
</script>

<style>
.gtitle {
	text-align: center;
	font-size: 30px;
	font-weight: bold;
	padding-top: 40px;
	position: relative;
}

hr {
	border: 1px solid black;
}

.gcover {
	clear: right;
}

.gcover img {
	width: 500px;
	padding: 50px;
	float: left;
	position: relative;
}

.gcover .topTable {
	padding-top: 50px;
}

.gcover table td {
	height: 30px;
}

#steam img {
	padding: 5px;
	width: 120px;
	border-radius: 20px;
}
</style>
<template>
	<article v-if="isMount()" class="gcover">
      	<div class="gtitle">{{ game.gzhname }}</div>
      	<hr/>
		<img :src="'/src/assets/game/' + game.gid + '/1.jpg'"/>

		<!-- 基本游戏信息 -->
		<table class="topTable">
			<tr><td>游戏名：</td><td>{{ game.gname }}</td></tr>
			<tr><td>游戏类型：</td><td>{{ game.gtag }}</td></tr>
			<tr><td>价格：</td>
			<td>
				<div v-if="isSteam()">{{ game.gprice }}RMB</div>
				<div v-else>{{ game.gprice }}积分</div>
			</td>
			</tr>
			<tr><td>制造商：</td><td>{{ game.gdeveloper }}</td></tr>
			<tr><td>发行商：</td><td>{{ game.gpublisher }}</td></tr>
			<tr><td>发行日期：</td><td>{{ game.greleaseDate }}</td></tr>
		</table>
        

		<!-- 购买&下载按钮： -->
		<table v-if="isSteam()">
		<!-- 1，steam外站下载业务 -->
		<tr>
			<td>在steam上购买：</td>
			<td>
				<div class="btn"><a :href=" 'https://store.steampowered.com/app/' + game.gid " >
				<img  src="/src/assets/images/steam.png"/></a></div>
			</td>
		</tr>
		</table>

		<table v-else >
		<!-- 2，本站游戏下载业务 -->
			<tr><!-- 业已购买 -->
				<td>购买情况：</td>
				<td v-if="order == null">尚未购买</td>
				<td v-else>您已购买此游戏</td>
			</tr>
			<template v-if="order == null"><!-- 尚未购买 -->
				<tr>
					<td>是否购买？<br/><span style="color:#777777;font-size:12px">剩余积分:{{ user.upoint }}</span></td>
					<td><div class="btn">
					<a @click="showDialog = true">
					<img src="/src/assets/images/yes.png"/></a></div></td>
				</tr>
			</template>
			<template v-else><!-- 业已购买 -->
				<tr>
					<td>订单编号:</td>
					<td>{{ order.onumber }}</td>
				</tr>
				<tr>
					<td>是否立即下载？</td>
					<td><div class="btn">
					<a @click="downloadGame()" download>
					<img src="/src/assets/images/yes.png"/></a></div></td>
				</tr>
			</template>
		</table>
	</article>


	<el-dialog
    width="300"
    align-center
	v-model="showDialog"
  >
    <span>确定购买游戏{{ game.gname }}?</span><br>
	<span style="color:#777777;font-size:12px">（价格：{{ game.gprice }}积分）</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="showDialog = false">
          取消
        </el-button>
        <el-button type="primary" @click="showDialog = false;bugGame()">
          确定
        </el-button>
      </div>
    </template>
  </el-dialog>

</template>

<script setup>
import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import { purchaseGame } from '@/api/game'
import util from '@/utils/public'
import { download } from '@/utils/request'

const { user, game, order } = defineProps({
	user: Object, 
	game: Object, 
	order: Object
})
let showDialog = ref(false);

let isMount = () =>{
	// console.debug('isMount:', user, game, !util.isNull(user) && !util.isNull(game));
	return !util.isNull(user) && !util.isNull(game);
}

const isSteam = () => {
    return game.gid.length<9   // <9表示是steam游戏
}

const downloadGame = () => {
	download(`/game/download/${game.gid}.zip`, `${game.gname}.zip`);
}

const bugGame = () => {
	purchaseGame(user.uid, game.gid)
	.then((res)=>{
		this.$router.go(0);		// 刷新页面
		ElMessage({ message: '购买成功。感谢您的购买！', type: 'success'} )
	})
}

</script>


<style scoped>
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
.btn {
    transition: transform 0.3s ease; /* 添加平滑过渡效果 */
    cursor: pointer; /* 设置鼠标悬停时的光标样式 */
}
.btn:hover{
	transform: scale(0.9); /* 使用 transform 属性进行缩放 */
}
.btn img {
	padding: 5px;
	width: 120px;
	border-radius: 20px;
}
</style>
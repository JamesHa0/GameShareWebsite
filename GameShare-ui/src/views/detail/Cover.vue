<template>
	<article v-if="user!=null && game!=null" class="gcover">
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
			<template  v-if="order == null"><!-- 尚未购买 -->
				<tr>
					<td>是否购买？<br/><span style="color:#777777;font-size:12px">剩余积分:{{user.upoint }}</span></td>
					<td><div class="btn">
					<a @click="showDialog = true">
					<img src="/src/assets/images/yes.png"/></a></div></td>
				</tr>
			</template>
			<template v-else><!-- 业已购买 -->
				<tr>
					<td>订单编号:</td>
					<td>{{order.onumber }}</td>
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
    <span>确定购买游戏{{game.gname}}?</span><br>
	<span style="color:#777777;font-size:12px">（价格：{{game.gprice}}积分）</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="showDialog = false">
          取消
        </el-button>
        <el-button type="primary" @click="showDialog = false;purchaseGame()">
          确定
        </el-button>
      </div>
    </template>
  </el-dialog>

	
  
</template>

<script>
import axios from 'axios'
import { ElMessage } from 'element-plus'

export default {
  props:['user', 'game', 'order'],
  data() {
    return {
      showDialog: false,
    }
  },
  methods:{
    isSteam(){
      return this.game.gid.length<9   // <9表示是steam游戏
    },
	downloadGame(){
      axios({
		method: 'get',
		url: 'game/download/' + this.game.gid + '.zip',
		responseType: 'blob',
	  })
      .then(response => {
        if (response.status === 200) {
			console.debug("Response:", response);
			console.debug("Type of response.data is Blob? :", response.data instanceof Blob);
			const url = window.URL.createObjectURL(new Blob([response.data]));	// 创建临时资源url
			const link = document.createElement('a');
			link.href = url;
			link.setAttribute('download', `${this.game.gname}.zip`); 
			document.body.appendChild(link);
			link.click();
			document.body.removeChild(link);
			window.URL.revokeObjectURL(url);	// 释放资源
        } else {
			console.error('下载失败，状态码：', response.status);
        }
      })
      .catch(error => {
		console.error('下载请求失败：', error);
		ElMessage.error('Oops！ 服务器错误，下载异常！错误信息：' + error.message)
      });
    },
	purchaseGame(){
		console.log('正在购买游戏，请稍等……')
		axios.post('/game/purchase/'+this.user.uid+'/'+this.game.gid)
		.then(res=>{
			console.log('服务器响应为：')
			console.log(res);
			if(res.status!=200){
				
			}
			if(res.data.code==200){
				this.$router.go(0);
				ElMessage({
					message: '购买成功。感谢您的购买！',
					type: 'success',
  				})
			}else{
				ElMessage.error('Oops！ 购买失败。'+res.data.message)
			}
		})
		.catch(error=>{
			ElMessage.error('Oops！ 服务器错误，购买失败！请联系管理员。错误信息：' + error.message)
		})

    }

  }

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
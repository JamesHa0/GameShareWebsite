<template>
    <!-- 游戏简介及内容截屏 -->
        <section v-if="game" class="gdescription">
            <div class="description">游戏简介：</div>
            <div class="gtext" v-html="game.gdescription"></div>
        </section>
        <section v-if="game" class="gimg">
            <img v-for="i in range" :src="'/src/assets/game/'+game.gid+'/'+i+'.jpg'" :key="i" />
        </section>
</template>

<script>
export default {
    props:['game'],
    computed:{
        range(){
            return [2, 3, 4, 5];    // 截屏图片的序号
        }
    }
}
</script>

<style scoped>
.gdescription {
    /*height: 500px;*/
	clear: left;
	position: relative;
}

.description {
	font-size: 20px;
	font-weight: bold;
	padding-left: 40px;
	position: relative;
}

.gtext {
	padding: 20px 50px;
	position: relative;
}

.gimg {
    /*height: 2600px;*/
	padding: 20px;
	text-align: center;
}

.gimg img {
	width: 800px;
	padding-top: 20px;
	position: relative;
}

</style>
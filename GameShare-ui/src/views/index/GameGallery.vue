<template>
    <!-- 游戏列表模板 -->
    <div class="game-box">
        <h2 class="title">&emsp;{{title}}</h2>
        <section class="game-gallery">
            <article class="game-item" v-for="game in data" :key="game.id">
                <figure>
                    <router-link class="game-link" :to="'/detail?gid=' + game.gid">
                        <img :src="game.img" :alt="game.name">
                    </router-link>
                    <figcaption class="game-name">{{game.name}}</figcaption>
                </figure>
            </article>
        </section>
    </div>
</template>

<script>
export default {
    props:[ //注册属性名
        'title',    //标题，例如“高分神作”
        'data'      //数据对象数组，例如[{name:"弹丸论破",img:"xxx.jpg"},{...}]
    ],
        
}
</script>

<style scoped>

/************************<!-- 游戏一览 -->*********************/
.game-box{
    width: 1200px;
    height: 940px;
    background-color: #f5f5f5;
    margin-top: 50px;
}
.game-box > .title{
    margin: 0;
    font-size: 22px;
    font-weight: 200;
    line-height: 58px;
    color: #363535;
    border-bottom: 2px solid #3d3d3d;
}

.game-box > .game-gallery{
    display: block;
    padding-left: 10px;
    margin-top: 30px;
}

.game-item{
    display: block;
    float: left;
    width: 450px;
    height: 330px;
    padding-top: 50px;
    margin-left: 95px;
    margin-bottom: 20px;
    background-color: #ffffff;
}
.game-item a{
	display:block;
    text-align: center;
}
.game-link > img{
	width: 400px;
}
.game-name{
    display: block;
    font-size: 16px;
    color: #000000;
    text-align: center;
    height: 50px;
    line-height: 50px;
    width: 190px;
    margin: 8px auto 0;
    overflow: hidden;
}
</style>
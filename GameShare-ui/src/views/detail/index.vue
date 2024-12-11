<template>
    <Header/>
    <!--正文-->
    <article class="detail" id="detail">
        <!-- 封面模块 -->
        <Cover :user="user" :game="game" :order="order"/>
        <!-- 剪影模块 -->
        <Sketch :game="game"/>
        <!-- 反馈模块 -->
        <Feedback v-if="user" :user="user" :game="game" :order="order"
                :isLiked="isLiked" :likeNum="likeNum"
                :likedCids="likedCids" :commentNum="commentNum"
            />
    </article>

    <Footer/>
</template>

<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router'
import Header from '@comp/Header.vue'
import Footer from '@comp/Footer.vue'
import Cover from './Cover.vue'
import Sketch from './Sketch.vue'
import Feedback from './Feekback.vue'
import { getDecodedToken } from '@/utils/auth.js'  
import { getAllDetails } from '@/api/game'
import util from '@/utils/public'

let user = ref(null)
let game = ref(null)
let order = ref(null)
let isLiked = ref(null)
let likeNum = ref(null)
let likedCids = ref(null)
let commentNum = ref(null)
let jwt = ref(getDecodedToken())

const route = useRoute()
const uid = jwt.value.sub
const gid = route.query.gid
if (gid === '0' || util.isUndefined(gid)) {  //若查询参数gid为0或未定义，则路由至 /404
    route.push('/404');
}

getAllDetails(uid, gid)
.then(res => {
    user.value = res.data.user
    game.value = res.data.game
    order.value = res.data.order
    // like:
    isLiked.value = res.data.isLiked
    likeNum.value = res.data.likeNum
    // comment:
    likedCids.value = res.data.likedCids
    commentNum.value = res.data.commentNum
})


</script>


<style scoped>
.detail{
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
</style>
<template>
    <Header/>
    <!--正文-->
    <article class="detail" id="detail">
        <!-- 封面模块 -->
        <Cover :user="user" :game="game" :order="order"/>
        <!-- 剪影模块 -->
        <!-- <Sketch :game="game"/> -->
        <!-- 反馈模块 -->
        <Feedback v-if="user" :user="user" :game="game" :order="order"
                :isLiked="isLiked" :likeNum="likeNum"
                :likedCids="likedCids" :commentNum="commentNum"
            />
    </article>

    <Footer/>
</template>


<script>
import Header from '@comp/Header.vue'
import Footer from '@comp/Footer.vue'
import Cover from './Cover.vue'
import Sketch from './Sketch.vue'
import Feedback from './Feekback.vue'
import { getDecodedToken } from '@/utils/auth.js'  
import { getAllDetails } from '@/api/game'


export default {
    components:{
        Header,
        Footer,
        Cover,
        Sketch,
        Feedback,
    },
    props:['data'],      //接收组件参数
    data(){
        return{
            user:null,
            game:null,
            order:null,
            // like:
            isLiked:null,
            likeNum:null,
            // comment:
            likedCids:null,
            commentNum:null,
            // jwt (from localStorage):
            jwt:null,
        }
    },
    created(){
		this.jwt = getDecodedToken();
        const uid = this.jwt.sub;
        const gid = this.$route.query.gid;
        if (gid === '0' || gid === undefined) {  //若查询参数gid为0或未定义，则路由至 /404
            this.$router.push('/404');
        } else {
            this.setAllDetails(uid, gid)
        }
    },
    methods:{
        setAllDetails(uid, gid){
            getAllDetails(uid, gid)
            .then(res=>{
                console.debug('===> 游戏details 数据：')
                console.debug(res.data);
                this.user = res.data.user
                this.game = res.data.game
                this.order = res.data.order
                // like:
                this.isLiked = res.data.isLiked
                this.likeNum = res.data.likeNum
                // comment:
                this.likedCids = res.data.likedCids
                this.commentNum = res.data.commentNum
            })
        },

    }
}
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
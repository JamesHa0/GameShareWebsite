<template>
    <Header/>
    <!--正文-->
    <article class="detail" id="detail">
        <!-- 封面模块 -->
        <!-- <Cover :user="user" :game="game" :order="order"/> -->
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

import axios from 'axios';
import { getToken } from '@/assets/js/myPublic.js'


export default {
    props:['data'],      //接收组件参数
    components:{
        Header,
        Footer,
        Cover,
        Sketch,
        Feedback,
    },
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
        }
    },
    created(){
        let gid=null;
        let uid=null;
        gid = this.$route.query.gid;
        this.gid = gid;
        const decodedToken = getToken();    //从localStorage中获取token（解码后）
        if (decodedToken) {
            uid = decodedToken.sub;
            // console.log('这里是解析后的token：'+decodedToken);
        }
        if (gid === '0' || gid === undefined) {  //若查询参数gid为0或未定义，则路由至 /404
            // this.$router.push('/404');
        }else{
            // this.fetchUserGameOrder(uid, gid)   // 并发批量查询用户、游戏、订单信息
            this.getAllDetails(uid, gid)
        }
    },
    methods:{
        getAllDetails(uid, gid){
            axios.get('/game/details/'+uid+'/'+gid)
            .then(res=>{
                console.debug('===> 游戏details 数据：')
                console.debug(res.data.data);
                this.user = res.data.data.user
                this.game = res.data.data.game
                this.order = res.data.data.order
                // like:
                this.isLiked = res.data.data.isLiked
                this.likeNum = res.data.data.likeNum
                // comment:
                this.likedCids = res.data.data.likedCids
                this.commentNum = res.data.data.commentNum
            })
            .catch(error=>{
                console.error('请求失败:', error);
            });
        },

    }
}
</script>

<style>
.detail {
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
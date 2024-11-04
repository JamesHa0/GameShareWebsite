<template>
    <Header/>
    <!--正文-->
    <article class="detail" id="detail">
        <!-- 封面模块 -->
        <Cover :user="user" :game="game" :order="order"/>
        <!-- 剪影模块 -->
        <Sketch :game="game"/>
        <!-- 反馈模块 -->
        <Feedback :gid="gid" :user="user" :game="game" :order="order"/>
    </article>

    <Footer/>
</template>




<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import Cover from './Cover.vue'
import Sketch from './Sketch.vue'
import Feedback from './Feekback.vue'

import axios from 'axios';
import {getToken } from '@/public.js';


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
            gid:null,
            user:null,
            game:null,
            order:null,
        }
    },
    created(){
        let gid=null;
        let uid=null;
        gid = this.$route.query.gid;
        this.gid = gid;
        const decodedToken = getToken();    //从localStorage中获取token（解码后）
        if (decodedToken) {  //若存在token，则获取uid
            uid = decodedToken.sub;
            // console.log('这里是解析后的token：'+decodedToken);
        }
        if (gid === '0' || gid === undefined) {  //若查询参数gid为0或未定义，则路由至 /404
            this.$router.push('/404');
        }else{
            this.fetchUserGameOrder(uid, gid)   // 并发批量查询用户、游戏、订单信息
        }
    },
    methods:{
        fetchUserGameOrder(uid, gid){
            // console.log(`正在并发查询用户(${uid})、游戏(${gid})的信息...`);
            const user_promise = axios.get('/user/'+uid);
            const game_promise = axios.get('/game/'+gid);
            const order_promise = axios.get('/order/'+uid+'/'+gid);

            Promise.all([user_promise, game_promise, order_promise])
                .then(([user_promise, game_promise, order_promise])=> {
                    // 处理响应数据
                    this.user = user_promise.data
                    this.game = game_promise.data
                    this.order = order_promise.data

                    console.log('游戏信息:', this.game);
                    console.log('用户信息:', this.user);
                    console.log('订单信息:', this.order);
                })
                .catch(err => {
                    console.error('请求出错:', err);
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
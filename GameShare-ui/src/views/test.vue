<template>
  <div>test</div>
  <button @click="doLogin">登录</button>
  <button @click="doFetch">获取游戏信息</button>
  <button @click="mock">mock测试</button>
  <button @click="detail">detail</button>

  

</template>

<script>
import axios from 'axios';
import { mapState, mapMutations } from 'vuex';

export default {
    methods:{
        doLogin(){
            const utel='root';
            const upsw='root';
            axios.post('/login', {
                'utel': utel,
                'upsw': upsw,
            }, {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then(res=>{
                console.log(res);
                if(res.data.code==200){
                    console.log('登录成功');
                    localStorage.setItem('Token', res.data.data.Token);
                }else{
                    console.log('登录失败');
                }
            })
        }
        ,
        doFetch(){
            const gid=100000001;
            axios.get('/game/'+gid)
            .then(res=>{
                console.log(res);
                if(res.status==200){
                    console.log('获取成功');
                }else{
                    console.log('获取失败');
                }
            })
        }
        ,
        mock(){
            axios.get('/api/user')
            .then(response => {
                console.log(response.data); // 将会输出模拟的用户信息
            })
            .catch(error => {
                console.error('请求失败:', error);
            });
        }
        ,
        detail(){
            console.log(`正在并发查询用户(1)、游戏(100000001)的信息...`);
            const user_promise = axios.get('/user/'+1);
            const game_promise = axios.get('/game/'+100000001);
            const order_promise = axios.get('/order/'+1+'/'+100000001);

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
    // computed: {
    // ...mapState(['isLogin'])
    // },
    }
}
</script>

<style>

</style>
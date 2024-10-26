<template>
  <div>test</div>
  <button @click="doLogin">登录</button>
  <button @click="doFetch">获取游戏信息</button>

</template>

<script>
import axios from 'axios';
import { mapState, mapMutations } from 'vuex';

export default {
    data(){
        return{
        }
    },
    methods:{
        doLogin(){
            const utel='root';
            const upsw='root';
            axios.post('http://localhost:8080/login', {
                'utel': utel,
                'upsw': upsw,
            }, {
                headers: {
                    // 'Content-Type': 'application/json'
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
        // ,
        // ...mapMutations(['setLogin']),
        // toggleLogin() {
        //     // this.setLogin(!this.isLogin);
        //     this.$store.commit('setLogin', true);
        // }
        ,
        doFetch(){
            const gid=100000001;
            axios.get('http://localhost:8080/game/'+gid,{
            // headers: {
            //     'Authorization': 'Bearer eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJzdWIiOiJyb290IiwiaWF0IjoxNzI3NzY1MTE3LCJleHAiOjE3MjgzNjk5MTd9.9TZ2fb4QplqTvPeiyBf6KiOckfX1wcvrTYRXu8uShJg',
            // }
            })
            .then(res=>{
                console.log(res);
                if(res.status==200){
                    console.log('获取成功');
                }else{
                    console.log('获取失败');
                }
            })
        }
    },
    // computed: {
    // ...mapState(['isLogin'])
    // },
}
</script>

<style>

</style>
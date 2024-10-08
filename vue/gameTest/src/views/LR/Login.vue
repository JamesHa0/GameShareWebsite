<template>
  <!-- 登录 -->
		<div class="form-container sign-in">
			<form @submit.prevent="login"  class="sign" method="post">
				<h1>登录</h1>
				<input v-model="formData.utel" type="text"  autocomplete="username" name="utel" placeholder="手机号" required>
				<input v-model="formData.upsw" type="password"  autocomplete="password" name="upsw" placeholder="密码" required>
				<!-- <input name="checkinput" placeholder="点击下方图片刷新" value="" class="checkinput"  required>
				<img id="checkinput" src="CheckCodeServlet" /> -->
				<!-- <a href="jsp_admin/admin_login.jsp">管理员登录</a> -->
                <input type="submit" value="登录">
			</form>
		</div>
</template>

<script>
import {parseJwt} from '@/public.js'
import axios from 'axios';

export default {
    data(){
        return{
            uid: null,
            uname: null,
            urole: null,
            token: null,
            formData:{
                utel:null,
                upsw:null,
            }
        }
    },
    created(){
    },
    methods:{
        login(){
            const utel='root';
            const upsw='root';
            axios.post('http://localhost:8080/login', 
            this.formData,
            {
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
                    this.$router.push('/');
                }else{
                    console.log('登录失败');
                }
            })
        }
        
    }
}
</script>

<style>

</style>
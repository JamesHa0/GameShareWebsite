<template>
  <!-- 登录 -->
		<div class="form-container sign-in">
			<form @submit.prevent="preLogin"  class="sign" method="post">
				<h1>登录</h1>

				<input v-model="formData.utel" type="text"  autocomplete="username" name="utel" placeholder="手机号（*必填）"/>

				<input v-model="formData.upsw" type="password"  autocomplete="password" name="upsw" placeholder="密码（*必填）" />

				<!-- <input name="checkinput" placeholder="点击下方图片刷新" value="" class="checkinput"  required>
				<img id="checkinput" src="CheckCodeServlet" /> -->
				<!-- <a href="jsp_admin/admin_login.jsp">管理员登录</a> -->
                <input type="submit" value="登录">  
			</form>
		</div>
</template>

<script>
import {parseJwt, isNull} from '@/public.js'
import axios from 'axios';

export default {
    data(){
        return{
            formData:{
                utel:null,
                upsw:null,
            },

            rules:{
                utel:{
                    required: true,
                    rangelength:[11,11],
                    pattern:/[0-9]{11}/
                },
                upsw:{
                    required: true,
                    rangelength:[8,20],
                    pattern:/[a-zA-Z0-9]{8,20}/
                },
                checkinput:{
                    required: true,
                }
            },
            messages:{
                utel:{
                    required:'手机号不能为空',
                    rangelength:"手机号长度必须为11位",
                    pattern:"格式错误：手机号格式必须为数字"
                },
                upsw:{
                    required:'密码不能为空',
                    rangelength:"密码长度在8~20位",
                    pattern:"格式错误：密码必须包含数字或大小写字母"
                },
                checkinput:{
                    required: "验证码不能为空",
                }
            },
        }
    },
    created(){
    },
    methods:{
        preLogin(){
            if(localStorage.getItem('isValidate') == 'false'){
                 this.login();
                 console.log('跳过验证');
                 return
            }

            const utel = this.formData.utel;
            const upsw = this.formData.upsw;
            const _utel = this.rules.utel;
            const _upsw = this.rules.upsw;
            let errorMsgs = [];
            if(_utel.required && isNull(utel)) errorMsgs.push(this.messages.utel.required);    // 手机号不能为空
            if(_upsw.required && isNull(upsw)) errorMsgs.push(this.messages.upsw.required);    // 密码不能为空
            
            if(!isNull(utel))if(utel.length< _utel.rangelength[0] || utel.length> _utel.rangelength[1])    // 手机号长度不满足
                errorMsgs.push(this.messages.utel.rangelength);
            if(!isNull(upsw))if(upsw.length< _upsw.rangelength[0] || upsw.length> _upsw.rangelength[1])    // 密码长度不满足
                errorMsgs.push(this.messages.upsw.rangelength);

            if(!isNull(utel))if(!_utel.pattern.test(utel)) errorMsgs.push(this.messages.utel.pattern);   // 手机号格式不正确
            if(!isNull(upsw))if(!_upsw.pattern.test(upsw)) errorMsgs.push(this.messages.upsw.pattern);   // 密码格式不正确


            // 验证失败：报出错误信息 or 验证通过：提交表单
            if(errorMsgs.length>0){
                alert(errorMsgs.join('\n'));
            }else{
                this.login();
            }

        },
        login(){
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
                    alert('登录失败');
                }
            })
        }
        
    }
}
</script>

<style>

</style>
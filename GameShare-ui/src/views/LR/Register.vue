<template>
  <!-- 注册 -->
		<div class="form-container sign-up">
			<form  @submit.prevent="preRegister" class="register">
				<h1>注册</h1>
				
				<input v-model="formData.uname" type="text" name="uname" placeholder="用户名" title="请输入用户名"/>
				
				<input v-model="formData.utel" type="text" name="utel" placeholder="手机号*（必填）" title="请输入11位手机号码"/>
				
				<input v-model="formData.upsw" type="password"  name="upsw" placeholder="请输入密码*（必填）" title="密码长度在8~20位，只能包含字母和数字"/>

				<input v-model="formData.second_pwd" type="password"  name="second_pwd" placeholder="请再次输入密码*（必填）" title="密码长度在8~20位，只能包含字母和数字"/>

				<input v-model="formData.checkinput" name="checkinput" placeholder="点击下方图片刷新（验证码*：必填）" value="" class="checkinput" >
				<img id="checkinput" src="#" />
				
				<input v-model="formData.uemail" id="uemail" name="uemail" placeholder="电子邮箱"/>

				保密<input v-model="formData.ugender" type="radio"  checked="checked" name="ugender" value="保密"/>男<input type="radio"  name="ugender" value="M"/>女<input type="radio"  name="ugender" value="F"/>
                
				<input v-model="formData.uaddress" type="text"  name="uaddress" placeholder="家庭住址" />

				<button>注册</button>
			</form>
		</div>
</template>

<script>
import { isNull } from '@/assets/js/myPublic.js'
import axios from 'axios'

export default {
	data() {
		return {
			formData:{
				uname:null,
				utel:null,
				upsw:null,
				second_pwd:null,
				checkinput:null,
				uemail:null,
				ugender:null,
				uaddress:null,
			},
			rules:{
				uname:{
					required: false,
					rangelength:[1,10],
					pattern:/[a-zA-Z0-9]{2,10}/
				},
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
				second_pwd:{
					required: true,
					rangelength:[8,20],
					pattern:/[a-zA-Z0-9]{8,20}/,
				},
				checkinput:{
					required: true,
				},
				uemail:{
					required: false,
					pattern:/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
				},
				ugender:{
					required: false,
				},
				uaddress:{
					required: false,
				}
			},
			messages:{
				uname:{
					required:"用户名不能为空",
					rangelength:"用户名长度在2~10位",
					pattern:"格式错误：用户名必须包含字母或数字"
				},
				utel:{
					required:"手机号码不能为空",
					rangelength:"手机号长度必须为11位",
					pattern:"格式错误：手机号格式必须为数字"
				},
				upsw:{
					required:'密码不能为空',
					rangelength:"密码长度在8~20位",
					pattern:"格式错误：密码必须包含数字或大小写字母"
				},
				second_pwd:{
					required:'确认密码不能为空',
					rangelength:"确认密码长度在8~20位",
					pattern:"格式错误：确认密码必须包含数字或大小写字母"
				},
				checkinput:{
					required: "验证码不能为空",
				},
				uemail:{
					required: "电子邮箱不能为空",
					pattern:"格式错误：电子邮箱格式不正确，具体格式请自行百度"
				},
				ugender:{
					required: "性别不能为空",
				},
				uaddress:{
					required: "地址不能为空",
				}
			}
		}
	},
	methods: {
		preRegister(){
			if(localStorage.getItem('isValidate') == 'false'){
                 this.register();
                 console.log('跳过验证');
                 return
            }

			const uname = this.formData.uname;
            const utel = this.formData.utel;
            const upsw = this.formData.upsw;
			const second_pwd = this.formData.second_pwd;
			const checkinput = this.formData.checkinput;
			const uemail = this.formData.uemail;
			const ugender = this.formData.ugender;
			const uaddress = this.formData.uaddress;
			const _uname = this.rules.uname;
            const _utel = this.rules.utel;
            const _upsw = this.rules.upsw;
			const _second_pwd = this.rules.second_pwd;
			const _checkinput = this.rules.checkinput;
			const _uemail = this.rules.uemail;
			const _ugender = this.rules.ugender;
			const _uaddress = this.rules.uaddress;

            let errorMsgs = [];
			if(_uname.required && isNull(uname)) errorMsgs.push(this.messages.uname.required);	// 用户名不能为空
            if(_utel.required && isNull(utel)) errorMsgs.push(this.messages.utel.required);    // 手机号不能为空
            if(_upsw.required && isNull(upsw)) errorMsgs.push(this.messages.upsw.required);    // 密码不能为空
			if(_second_pwd.required && isNull(second_pwd)) errorMsgs.push(this.messages.second_pwd.required);	// 确认密码不能为空
			if(_checkinput.required && isNull(checkinput)) errorMsgs.push(this.messages.checkinput.required);	// 验证码不能为空
			if(_uemail.required && isNull(uemail) ) errorMsgs.push(this.messages.uemail.required);	// 电子邮箱不能为空
			if(_ugender.required && isNull(ugender)) errorMsgs.push(this.messages.ugender.required);	// 性别不能为空
			if(_uaddress.required && isNull(uaddress)) errorMsgs.push(this.messages.uaddress.required);	// 地址不能为空

			if(!isNull(uname))if(uname.length< _uname.rangelength[0] || uname.length> _uname.rangelength[1])	// 用户名长度不满足
                errorMsgs.push(this.messages.uname.rangelength);
            if(!isNull(utel))if(utel.length< _utel.rangelength[0] || utel.length> _utel.rangelength[1])    // 手机号长度不满足
                errorMsgs.push(this.messages.utel.rangelength);
			if(!isNull(upsw))if(upsw.length< _upsw.rangelength[0] || upsw.length> _upsw.rangelength[1])	// 密码长度不满足
                errorMsgs.push(this.messages.upsw.rangelength);
			if(!isNull(second_pwd))if(second_pwd.length< _second_pwd.rangelength[0] || second_pwd.length> _second_pwd.rangelength[1])	// 确认密码长度不满足
                errorMsgs.push(this.messages.second_pwd.rangelength);	// 确认密码长度不满足
				
			if(!isNull(uname))if(!_uname.pattern.test(uname)) errorMsgs.push(this.messages.uname.pattern);   // 用户名格式不正确
            if(!isNull(utel))if(!_utel.pattern.test(utel)) errorMsgs.push(this.messages.utel.pattern);   // 手机号格式不正确
			if(!isNull(upsw))if(!_upsw.pattern.test(upsw)) errorMsgs.push(this.messages.upsw.pattern);   // 密码格式不正确
			if(!isNull(second_pwd))if(!_second_pwd.pattern.test(second_pwd)) errorMsgs.push(this.messages.second_pwd.pattern);	// 确认密码格式不正确
			if(!isNull(uemail))if(!_uemail.pattern.test(uemail)) errorMsgs.push(this.messages.uemail.pattern);	// 电子邮箱格式不正确

			if(!isNull(utel)&&!isNull(second_pwd))if(upsw != second_pwd) errorMsgs.push('两次密码不一致');

            // 验证失败：报出错误信息 or 验证通过：提交表单
            if(errorMsgs.length>0){
				console.log(errorMsgs.join('!'));
                alert(errorMsgs.join('\n'));
            }else{
                this.register();
            }
		},
		register(){
			alert('校验成功')
			axios.post('http://localhost:8080/register', 
			this.formData,
			{
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				}
			})
			.then(res=>{
				console.log(res);
				if(res.data.code==200){
					console.log('注册成功');
					alert('注册成功')
				}
			})
		}

	}
}
</script>

<style>

</style>
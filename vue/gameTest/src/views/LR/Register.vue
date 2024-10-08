<template>
  <!-- 注册 -->
		<div class="form-container sign-up">
			<form action="<%=request.getContextPath() %>/RegisterServlet.do"
				method="post" class="register">
				<h1>注册</h1>
				<input type="text" id="uname" name="uname" placeholder="用户名" />
				<input type="text" id="utel" name="utel" placeholder="手机号*（必填）" maxlength="18"  required/>
				<input type="password" id="upsw" name="upsw" placeholder="请输入密码*（必填）"  required/>
				<input type="password" id="second_pwd" name="second_pwd" placeholder="请再次输入密码" />
				<input name="checkinput" placeholder="点击下方图片刷新（验证码*：必填）" value="" class="checkinput">
				<img id="checkinput" src="#" />
				<input  id="uemail" name="uemail" placeholder="邮箱地址"/>

				保密<input type="radio" id="secrecy" checked="checked" name="ugender" value="保密"/>
				男<input type="radio" id="man" name="ugender" value="M"/>
				女<input type="radio" id="woman" name="ugender" value="F"/>
                <input type="text" id="uaddress" name="uaddress" placeholder="地址" /> 

				<button>注册</button>
			</form>
		</div>
</template>

<script>
export default {

}
</script>

<style>

</style>
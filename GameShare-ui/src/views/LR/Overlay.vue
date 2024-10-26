<template>
        <div class="overlay-container">
			<div class="overlay">
				<!-- 登录蒙版 -->
				<div class="overlay-panel mask-left">
					<h1>已有帐号？</h1>
					<p>请使用您的手机号进行登录</p>
					<button  @click="click_Overlay_Btn" class="signIn" id="signIn">登录</button>
				</div>
				<!-- 注册蒙版 -->
				<div class="overlay-panel mask-right">
					<h1>没有帐号？</h1>
					<p>立即注册加入我们，和我们一起开始旅程吧</p>
					<button  @click="click_Overlay_Btn"  class="signUp" id="signUp">注册</button>
				</div>
			</div>
		</div>
</template>

<script>


export default {

  methods:{
    click_Overlay_Btn() {
        this.$emit('click_Overlay_Btn');   // 触发父组件的自定义事件
    }
  } 
}
</script>

<style>
.overlay-container {
    position:absolute;
    top:0;
    left:50%;
    width:50%;
    height:100%;
    overflow:hidden;
    transition:transform .6s ease-in-out;
    z-index:100;
}
.overlay {
    background:#20b2aa;
    background:linear-gradient(to right,lightseagreen,lightseagreen) no-repeat 0 0 / cover;
    color:#fff;
    position:relative;
    left:-100%;
    height:100%;
    width:200%;
    transform:translateY(0);
    transition:transform .6s ease-in-out;
}
.overlay-panel {
    position:absolute;
    top:0;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    height:100%;
    width:50%;
    text-align:center;
    transform:translateY(0);
    transition:transform .6s ease-in-out;
}
.mask-right {
    right:0;
    transform:translateY(0);
}
.mask-left {
    transform:translateY(-50%);
}
button.signIn,.singnUp {
    background:#20b2aa;
    border-color:#fff;
}
</style>
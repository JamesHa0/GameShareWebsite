<template>
	<div class="container">
        <!-- 注册 -->
        <Register/>
        <!-- 登录 -->
        <!-- <Login/> -->
        <!-- 两边的蒙版 -->
		<!-- <overlay/> -->
	</div>
</template>

<script>
import Register from './Register.vue'
import Login from './Login.vue'
import Overlay from './Overlay.vue'

export default {
  components: {
	 Register, 
	 Login,
	 Overlay, 
  },

}
</script>

<style>
h1 {
    font-weight:bold;
}
p {
    font-size:14px;
    line-height:10px;
    margin:20px 0 20px;
}
span {
    font-size:12px;
}
a {
    color:#333;
    font-size:14px;
    text-decoration:none;
    margin:15px 0;
}
.container {
    margin: 20px auto 0px;
    background:#fff;
    border-radius:20px;
    box-shadow:0 14px 28px rgba(0,0,0,.25),0 10px 10px rgba(0,0,0,.22);
    position:relative;
    overflow:hidden;
    width:1000px;
    max-width:100%;
    height:750px;
}
.form-container form {
    background:#fff;
    display:flex;
    flex-direction:column;
    /* padding:0 50px; */
    height:100%;
    justify-content:center;
    align-items:center;
    /* text-align:center; */
}

.form-container input {
    background:#eee;
    border:none;
    padding:12px 15px;
    margin:8px 0;
    width:300px;
    outline:none;
}
button {
    border-radius:15px;
    border:1px solid #20b2aa;
    background:#20b2aa;
    width: 100px;
    height: 40px;
    line-height: 30px;
    color:#fff;
    font-size:17px;
    font-weight:bold;
    letter-spacing:4px;
    transition:transform 80ms ease-in;
    cursor:pointer;
}
button:active {
    transform:scale(.95);
}
button:focus {
    outline:none;
}
button.ghost {
    background:#20b2aa;
    border-color:#fff;
}
.form-container {
    position:absolute;
    top:0;
    height:100%;
    transition:all .6s ease-in-out;
}
.sign-in {
    left:0;
    width:50%;
    z-index:2;
}
.sign-up {
    left:0;
    width:50%;
    z-index:1;
    opacity:0;
}


/* Move signin to right */
.container.right-panel-active .sign-in {
    transform:translateY(100%);
}
/* Move overlay to left */
.container.right-panel-active .overlay-container {
    transform:translateX(-100%);
}
/* Bring signup over signin */
.container.right-panel-active .sign-up {
    transform:translateX(100%);
    opacity:1;
    z-index:5;
}
/* Move overlay back to right */
.container.right-panel-active .overlay {
    transform:translateX(50%);
}
/* Bring back the text to center */
.container.right-panel-active .mask-left {
    transform:translateY(0);
}
/* Same effect for right */
.container.right-panel-active .mask-right {
    transform:translateY(50%);
}
.error{
    color: #ff0000;
}
</style>
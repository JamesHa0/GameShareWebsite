<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    background-color="#4d4343"
    text-color="#fff"
    active-text-color="#ffd04b"
    @select="handleSelect"
  >
    <el-col :span="4">
      <el-menu-item index="1" class="left-text">
          <p v-if=" $route.fullPath =='/' ">GameShareWebsite</p><!-- 判断uri，若为index页面则发生修改；当前路径为：{{ $route.fullPath }} -->
          <router-link v-else to="/">返回首页</router-link>
      </el-menu-item>
    </el-col>

    <el-col :span="3" :push="1">
      <el-sub-menu index="2">
        <template #title>这是多级菜单</template>
        <el-menu-item index="2-1">item one</el-menu-item>
        <el-menu-item index="2-2">item two</el-menu-item>
        <el-menu-item index="2-3">item three</el-menu-item>
        <el-sub-menu index="2-4">
          <template #title>item four</template>
          <el-menu-item index="2-4-1">item one</el-menu-item>
          <el-menu-item index="2-4-2">item two</el-menu-item>
          <el-menu-item index="2-4-3">item three</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
    </el-col>

    <el-col :span="5" :push="9">
      <el-menu-item index="4">
				<router-link v-if="1" to="/LR" >登录﹠注册</router-link>
        <p v-if="0" class="hello" title="xxx">欢迎您，{{uname}}<a href="">登出</a></p>
      </el-menu-item>
    </el-col>
    
    <el-col :span="2" :push="9">
      <el-menu-item index="5">
        <el-avatar :src="circleUrl" class="info"/>
      </el-menu-item>
    </el-col>
  </el-menu>
</template>

<script lang="ts" setup>
 import { ref } from 'vue'
import { reactive, toRefs } from 'vue'

const uname = 'dd';
const state = reactive({
  circleUrl:
    'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
  squareUrl:
    'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png',
})
const { circleUrl, squareUrl } = toRefs(state)
 const activeIndex = ref('1')
 const handleSelect = (key: string, keyPath: string[]) => {
   console.log(key, keyPath)
 }
</script>

<style>
  *{
    margin: 0;
    padding: 0;
  }
  .el-menu-demo{
    height: 55px;
  }
  .left-text{ 
    margin-left: 20px;
    float: left;
    font-size: 18px;
    font-weight: 600;
    color:#ffffff;
    line-height: 45px;
  }
  .info{
    text-align: center;
  }
  a {
    color: #ffffff;
    text-decoration: inherit;
  }
  .left-text :hover{
    color: #FFD04b
  }
  
</style>
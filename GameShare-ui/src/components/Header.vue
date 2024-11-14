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
      <el-menu-item index="1" class="left-text" v-if="$route.fullPath =='/'"> 
          <p >GameShareWebsite</p><!-- 判断uri，若为index页面则发生修改；当前路径为：{{ $route.fullPath }} -->
      </el-menu-item>
      <router-link to="/" v-else><el-menu-item  class="left-text" index="1">
          <p>返回首页</p>
      </el-menu-item></router-link>

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

    <el-col :span="4" :push="9">
      <el-menu-item index="4">
				<router-link v-if="0" to="/LR" >登录﹠注册</router-link>
        <div v-if="1"  :title="uname" class="hello">
          欢迎您，{{uname}}
        </div>
      </el-menu-item>
    </el-col>
    
    <el-col :span="3" :push="10">
      
      <el-menu-item index="5">
        <router-link to="/info" title="个人信息">
          <el-avatar :src="circleUrl" class="info" style="display:block"/>
        </router-link>
        <el-sub-menu index="5-1">
          <router-link to="/info" ><el-menu-item index="5-1-1">个人信息</el-menu-item></router-link>
          <router-link to="/info" ><el-menu-item index="5-1-2">登出</el-menu-item></router-link>
        </el-sub-menu>
      </el-menu-item>
      
    </el-col>
  </el-menu>
</template>

<script lang="ts" setup>
 import { ref } from 'vue'
import { reactive, toRefs } from 'vue'

const uname = 'dssssssssssssssss333333333333';
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
  .hello{
      overflow: hidden; /* 隐藏溢出内容 */
      text-overflow: ellipsis; /* 溢出时显示省略号 */
  }
</style>
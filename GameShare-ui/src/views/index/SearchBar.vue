<template>
  <!-- 搜索框 -->
  <div class="search-bar">
    <input
      type="text"
      class="input"
      ref="input"
      @mouseenter="handleMouseEnter"
      @mouseleave="handleMouseLeave"
      aria-label="Search"
      placeholder="搜索你喜欢的游戏……"
    />
    <button @click="handleSearch" aria-label="Search button">
      <img src="../../assets/images/search.png" width="40px" alt="Search icon" />
    </button>
  </div>
  <br />
</template>

<script setup>
import { ref } from "vue";

const input = ref(null);

const handleMouseEnter = () => {
  input.value.focus();
  input.value.placeholder="";
};
const handleMouseLeave = () => {
  input.value.blur();
  input.value.placeholder="搜索你喜欢的游戏……";
};

const handleSearch = () => {
  // 可以添加搜索功能的逻辑
  console.log('Search initiated with input:', input.value?.value);
};
</script>

<style>
/****************<!--搜索框-->***************/
.search-bar {
    position: relative;
    height: 60px;
    margin: 20px auto 0;
    width: 500px;
    height: 45px;
    border-radius: 2px;
    border: 2px solid #f53c66;
}
.search-bar .input{
    width: 400px;
    height: 41px;
    border: none;
    padding: 4px 10px 0;
    outline: none;
    background-color:  #f7f8f9;
;
}
.search-bar:hover{
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.5); /* 阴影效果 */
    transition:all .2s ease-in-out;
}
.search-bar .input:hover{
    background-color: rgb(255, 255, 255);
    transition:all .2s ease-in-out;
}
.search-bar button{
    float: right;
    border: none;
    width: 80px;
    height: 100%;
    background-color: #f53c3c;
    cursor: pointer;
}


</style>
<template>
  <el-carousel :interval="4000" type="card" height="350px">
    <el-carousel-item v-for="(image, item) in images" :key="item">
      <img :src="image.src" @click="handleClick(item)">
    </el-carousel-item>
  </el-carousel>
</template>

<script setup>
const images= [
        { src: '/src/assets/game/1091500/1.jpg' },
        { src: '/src/assets/game/1086940/1.jpg' },
        { src: '/src/assets/game/1245620/1.jpg' },
        { src: '/src/assets/game/1174180/1.jpg' },
        { src: '/src/assets/game/2358720/1.jpg' }
      ];
</script>


<style scoped>
img{
    height:350px;
}


.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
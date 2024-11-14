<!-- App.vue -->
<template>
  <div id="app">
    <button v-loading="loading">显示加载动画</button>
  </div>

  <el-container v-loading="true">
    <el-header>Header</el-header>
    <el-main>Main</el-main>
    <el-footer>Footer</el-footer>
  </el-container>

  <pig-loading style="" v-if="isShow" />
  <button @click="isShow = true">显示自定义加载动画</button>
  <button @click="isShow = false">关了</button>
  
</template>

<script>
import { ElLoading } from 'element-plus';
import { defineComponent, h } from 'vue';
import CustomLoading from './CustomLoading.vue';
import PigLoadingVue from './PigLoading.vue';

export default defineComponent({
  data() {
    return {
      isShow: false
    };
  },
  components: {
    CustomLoading,
    PigLoading: PigLoadingVue
  },
  methods: {
    showLoading() {
      const loadingInstance = ElLoading.service({
        target: document.body,
        lock: true,
        spinner: h(CustomLoading),
        background: 'rgba(0, 0, 0, 0.8)'
      });

      // 模拟异步操作，例如：fetch 数据
      setTimeout(() => {
        loadingInstance.close();
      }, 5000); // 5秒钟后关闭
    }
  }
});
</script>

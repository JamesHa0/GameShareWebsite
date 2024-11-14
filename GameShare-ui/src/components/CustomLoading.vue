<!-- CustomLoading.vue -->
<template>
  <div class="custom-loading-container">
    <div class="spinner">🔄</div>
    <p>{{ message }}</p>
    <p>llllla</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: '正在加载，请耐心等候...'
    };
  },
  mounted() {
    // 模拟异步操作的进展变化
    setInterval(() => {
      this.message = `载入中，剩余时间：${Math.random().toFixed(2)} 秒`;
    }, 1000);
  }
};
</script>

<style scoped>
.custom-loading-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-family: Arial, sans-serif;
}

.spinner {
  font-size: 48px;
  animation: spin 2s infinite linear;
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>

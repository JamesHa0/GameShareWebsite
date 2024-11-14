<template>
  <div class="error-page">
    <div class="error-content">
      <h1>哎呀！</h1>
      <p>后台出现了一些问题。</p>
      <p>我们的技术团队已经在处理这个问题，请您稍后再试。</p>
      <button @click="goHome">返回首页</button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goHome() {
      this.$router.push('/'); // 假设你的首页路由名称是 'home'
    }
  }
}
</script>

<style scoped>
.error-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f5f5;
}

.error-content {
  text-align: center;
}

.error-content h1 {
  font-size: 48px;
  color: red;
  margin-bottom: 20px;
}

.error-content p {
  font-size: 20px;
  margin-bottom: 20px;
}

.error-content button {
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  background-color: #409eff;
  color: white;
  border: none;
  border-radius: 4px;
  outline: none;
  transition: background-color 0.3s;
}

.error-content button:hover {
  background-color: #337ecc;
}
</style>
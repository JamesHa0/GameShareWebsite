<template><!-- 同上 -->
    <div class="sign-in"  @click="doSignIn()">点此签到</div>

</template>

<script>
  import Header from '@comp/Header.vue'
  import { ElMessage } from 'element-plus'

  export default {
    components: {
      Header
    },
    // created() {
    //   console.debug('test_el.vue created()');
    //   try {
    //     this.jwt = getDecodedToken();
    //   } catch (error) {
    //     console.error('获取token失败：!!!!!!!!!!!!!!!!!!!', error);
    //     ElMessage({
    //       message: 'Oops！ 获取token失败。请重新登录。',
    //       type: 'error'
    //     })
    //     this.$router.push('/LR');
    //     return
    //   }
    //   console.debug('程序继续执行……')
    //   console.debug('jwt uname : ', this.jwt.uname);
    // }
  }
</script>

<style scoped>

</style>

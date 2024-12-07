<template>
    <!-- <Header/> -->
      <router-view ref="routerView"></router-view>
    <!-- <Footer/> -->
</template>

<script>
import Header from '@comp/Header.vue'
import Footer from '@comp/Footer.vue'

export default {
  components: { Header, Footer },
  name: 'App',
}
</script>

<style scoped>

</style>

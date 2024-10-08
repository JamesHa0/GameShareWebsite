<script>
export default {
  name: 'App',
}
</script>

<template>
   <router-view :key="$route.fullPath"/>
</template>

<style scoped>

</style>

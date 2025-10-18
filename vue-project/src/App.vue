<template>
  <button @click="pop('Hello')">Hello</button>
</template>

<script setup>
const pop = (message)=>{
  window.alert(message);
}
</script>

<style lang="scss" scoped>

</style>
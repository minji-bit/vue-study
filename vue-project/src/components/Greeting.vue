<template>
  <div id="greeting">
    Aloha!
  </div>
</template>

<script setup>
import {onMounted, onUnmounted} from "vue";

onMounted(()=>{
  console.log("onMounted",document.getElementById("greeting") )
})

onUnmounted(()=>{
  console.log("unMounted",document.getElementById("greeting") )
})

</script>

<style lang="scss" scoped>

</style>
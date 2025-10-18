<template>
  <div :style="{color:props.color}">
    {{props.color||'BLACK'}} TIRE
  </div>
</template>

<script setup>
const props = defineProps({
  color:String
})
</script>

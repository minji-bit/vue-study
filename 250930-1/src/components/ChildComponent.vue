<template>
    <button @click="sendEvent">자식컴포넌트에서 만든 버튼</button>
</template>

<script setup lang="ts">
import {ref} from 'vue'

const data = ref<string>("자식 컴포넌트에서 선언된 데이터입니다.")

const emit = defineEmits(["send-event"])
const sendEvent=()=>{
    emit("send-event",data.value)
}
</script>

<style lang="scss" scoped>

</style>
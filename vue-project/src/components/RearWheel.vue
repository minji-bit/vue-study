<template>
  <div class="rear-wheel">
    <span>REAR WHEEL</span>
    <Tire/>
    <div>TIMES : {{counterStore.count}}</div>
    <button @click="counterStore.increment()">회전</button>
  </div>
</template>

<script setup>
import Tire from "@/components/Tire.vue";
import {useCounterStore} from "@/stores/counter.js";
const counterStore = useCounterStore();
</script>

<style  scoped>
.rear-wheel{
  border: 1px solid black;
  border-radius: 50%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 150px;
  height: 150px;
}
</style>
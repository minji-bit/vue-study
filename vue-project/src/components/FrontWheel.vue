<template>
  <div class="front-wheel">
    <span>FRONT WHEEL</span>
    <Tire color="BLUE"/>
    <div>TIMES : {{counterStore.count}}</div>
  </div>
</template>

<script setup>
import Tire from "@/components/Tire.vue";
import {useCounterStore} from "@/stores/counter.js";

const counterStore = useCounterStore();
</script>

<style scoped>
.front-wheel {
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
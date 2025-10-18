<template>
  <div>
    <ChildComponent v-bind:sendProps1="title" v-bind:sendProps2="createAt" :sendProps3="obj"/>
  </div>
</template>

<script>
import ChildComponent from './components/ChildComponent.vue';
export default {
  components:{
    ChildComponent,
  },
  data () {
    return {
      title : "부모컴포넌트에서 선언된 데이터입니다.",
      createAt : 2024,
      obj:{
        id:2024,
        name:'John'
      }
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
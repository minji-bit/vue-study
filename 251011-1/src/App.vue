<template>
  <div>
    부모컴포넌트 레이아웃
    <ChildComponent @send-event="parentEvent"/>
  </div>
</template>

<script>
import ChildComponent from './components/ChildComponent.vue';

export default{
  components:{
    ChildComponent,
  },
  methods:{
    parentEvent(event){
      console.log(event)
    },
  }
}



</script>

<style lang="scss" scoped>

</style>
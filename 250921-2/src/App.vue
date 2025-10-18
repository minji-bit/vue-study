<template>
  <div>
    <li v-for="(item , index) in sampleArray" :key="item">
      {{item   }} /{{  index }}
    </li>
    <li v-for="(user , index) in otherArray" :key="user.id">
      {{ user.id }} /
      {{ user.name }} / {{ index }}
    </li>
  </div>
</template>

<script>
export default {
  data () {
    return {
      sampleArray : ['a','b','c','d'],
      otherArray : [
        {id:0,
          name:'John',
        },
        {id:1,
          name:'Kim',
        },
        {id:2,
          name:'Lee',
        },
        {id:3,
          name:'Park',
        },
      ]
      }    
  }
}
</script>

<style lang="scss" scoped>

</style>
import { computed } from '../../250922-1/node_modules/@vue/reactivity/dist/reactivity.cjs';
<template>
  <div>
    <h1>{{ text }}</h1>
    <h1>changeText 함수 호출 값 : {{ changeText() }}</h1>
    <h1>changeText 함수 호출 값 : {{ changeText() }}</h1>
    <h1>changeText 함수 호출 값 : {{ changeText() }}</h1>

    <h3>{{ computedText }}</h3>
     <h3>{{ computedText }}</h3>
      <h3>{{ computedText }}</h3>
  </div>
</template>

<script>
export default {
  data () {
    

    return {
      text : "Computed 테스트 데이터 문구입니다.",

    }
  },
  //methods 부분에 선언된 함수와 동일한 로직일 때,
  //캐싱 기능이 없는 methos는 호출될 때마다 console 값이 출력이 된다.
  //반면, computed 는 캐싱기능이 있기 때문에 methods 와 다른 차이점이 있다!!
  computed:{
    computedText(){
      console.log('computed 기능을 생성하였습니다.')
      return this.text.split('').reverse().join('');
    }
  },
  methods:{
    changeText(){
      console.log('함수호출');
      console.log(this.text);

      return this.text.split('').reverse().join('');
    },
  },
}
</script>

<style lang="scss" scoped>

</style>
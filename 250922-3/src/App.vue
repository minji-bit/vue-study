<template>
  <button @click="changeMessage">
    {{ message }}
  </button>
  {{ watchMessage }}
</template>

<script>
export default {
  data () {
    

    return {
      message : '안녕하세요, Vue.js Watch 기능 테스트 오리지널 문구',
      watchMessage : '',
    }
  },
  watch:{
    //message : function(){}
    //데이터 뿐만 아니라 computed로 계산된 형태의 데이터도 watch로 감지할 수 있다.
    // 보통 게시판에서 한 컬럼을 선택하였을 때, 고유한 id 값이 바뀜을 감지하고
    // 이 때, 그 id 값에 따른 상세 데이터를 호출할 때, 주로 사용한다.
    message(){
      // window.alert('message 변수에 담긴 데이터가 변경되었습니다.')
      this.watchMessage = 'Watch 동작'
    },
    id(){
      //해당 상세데이터를 조회하는 api 호출
    }

  },
  methods:{
    changeMessage(){
      console.log('함수호출')
      this.message = '변경된 message 데이터입니다.'
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
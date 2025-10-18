import defineProperty
    from '../../../250928-1/node_modules/@oxc-project/runtime/src/helpers/defineProperty';
<template>
    <div>
        {{ sendProps1 }}
    </div>
    <div>
        {{ sendProps2 }}
    </div>
    <div>
        {{ sendProps3 }}
    </div>
</template>

<script setup lang="ts">
import {toRefs} from 'vue'
interface Obj{
  id : number,
  name : string
}
//1. 컴포지션 API에서 타입스크립트를 활용하는 방법
//1-1. Prop 받은 데이터 형식에 맞게 타입을 지정해준다.

// Prop 받은 데이터 이름 자체에 미리 선언해둔 타입을 설정해준다.(Obj)
interface Props{
        sendProps1:String,
        sendProps2:Number,
        sendProps3:Obj,
}

//defineProps toRefs 내장함술르 통해 Prop 받은 데이터를 템플릿 부분에 호출하여 사용한다.
const props = defineProps<Props>()
const {sendProps1, sendProps2,sendProps3} = toRefs(props)
</script>

<style lang="scss" scoped>

</style>
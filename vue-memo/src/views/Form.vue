<template>
  <form class="detail" @submit.prevent="submit">
    <div class="mb-3">
      <label for="title" class="form-label">제목</label>
      <input type="text" id="title" class="form-control p-3"
        v-model="state.memo.title"/>
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용</label>
      <textarea id="content" class="form-control p-3"
        v-model="state.memo.content"></textarea>
    </div>
    <button type="submit" class="btn btn-primary w-100 py-3">저장</button>
  </form>
</template>

<script setup>
import {StorageService} from "@/services/StorageService.js";
import {useRoute, useRouter} from "vue-router";
import {onMounted, reactive} from "vue";

const storageService = new StorageService("myMemo")
//라우터 객체
const router = useRouter();
const route = useRoute();
const state = reactive({
  memo : {
    id : undefined,
    title : "",
    content : ""
  }

});

const submit = ()=>{
  if(route.params.id){
    storageService.setItem(state.memo);
  }else{
    storageService.addItem(state.memo);
  }

  window.alert("저장했습니다.");
  // 메인 화면으로 이동
  router.push({path:"/"});
}

onMounted(()=>{
  console.log(route.params.id)
  if(route.params.id){
    const id = Number.parseInt(route.params.id.toString());
    state.memo= storageService.getItem(id);
  }
})
</script>

<style lang="scss" scoped>

</style>
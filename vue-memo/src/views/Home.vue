<template>
  <div class="memo-list">
    <router-link :to="`/memos/${m.id}`" class="item" v-for="m in state.memos">
      <div class="d-flex pt-3">
        <div class="pb-3 mb-0 w-100">
          <div class="d-flex justify-content-between">
            <b>{{m.title}}</b>
            <div>
              <span role="button" @click.prevent="remove(m.id)">삭제</span>
            </div>
          </div>
          <div class="mt-2">{{m.content}}</div>
        </div>

      </div>
    </router-link>
    <router-link to="/memos/add" class="add btn btn-light">+ 추가하기</router-link>
  </div>
</template>

<script setup>

import {StorageService} from "@/services/StorageService.js";
import {onMounted, reactive} from "vue";

const storageService = new StorageService("myMemo");

const state = reactive({
  memos:[],
})

/*(async function onCreated(){
  state.memos = storageService.getItems();
  })();*/
onMounted(() => {
  state.memos = storageService.getItems();
});

const remove = (id)=>{
  if(!window.confirm('삭제하시겠습니까?')){
    return;
  }

  storageService.delItem(id);

  state.memos = storageService.getItems();
}
</script>

<style lang="scss" scoped>
.memo-list{
  .item{
    background: #f8f9fa;
    border: 1px solid #eee;
    display: block;
    color: #000;
    text-decoration: none;
    padding: 20px 30px;
    margin: 15px 0;

    &:hover{
      border-color: #aaa;
    }
  }
}

.add{
  display: block;
  padding: 25px;
  border : 1px solid #eee;
}
</style>
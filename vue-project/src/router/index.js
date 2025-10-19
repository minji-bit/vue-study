import { createRouter, createWebHistory } from 'vue-router'
import Join from "@/views/Join.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path : '/join',
      component : Join
    },
    {
      path : '/login',
      component : ()=> import('../views/Login.vue')
    }
  ],
})

export default router

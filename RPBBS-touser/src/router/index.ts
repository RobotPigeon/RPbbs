import { createRouter, createWebHistory } from 'vue-router'
import Layout from '@/layout/index.vue'
import Home from '@/layout/home/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      component: Layout,
      path: '/',
      children: [
        { path: '/home', component: Home ,name:'default',
        //children:[{}]   也可以继续添加children嵌套
      },
      ]
    }
  ]
})

export default router

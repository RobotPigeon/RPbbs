import { createRouter, createWebHistory } from 'vue-router'
import Layout from '@/layout/index.vue'
import Home from '@/view/home/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      //redirect 是重新定向
      redirect: '/home'
    },
    {
      component: Layout,
      path: '/',
      children: [
        {
          path: '/home', component: Home, name: 'default',
          //children:[{}]   也可以继续添加children嵌套
        },
      ]
    }
  ]
})

export default router

import { createRouter, createWebHistory } from 'vue-router'
import Layout from '@/layout/index.vue'
import Home from '@/view/home/index.vue'
import Login from '@/view/login/index.vue'
import content from '@/view/home/content/index.vue'
import Partition from '@/view/home/Partition/index.vue'
import Error from '@/view/error/error.vue'
import posteditor from '@/view/home/posteditor/index.vue'
import postDetail from '@/view/home/postDetail/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      //redirect 是重新定向
      redirect: '/home/content'
    },
    {
      path: '/home',
      redirect: '/home/content'
    },
    {
      component: Layout,
      path: '/',
      children: [
        {
          path: '/home', component: Home, name: 'home',
          children: [{
            path: '/home/content', component: content, name: 'content',
          }, {
            path: '/home/Partition', component: Partition, name: 'Partition',
          }, {
            path: '/home/posteditor', component: posteditor, name: 'posteditor',
          },{
            path: '/home/postDetail', component: postDetail, name: 'postDetail',
          }
          ]
        },
        {
          path: '/login', component: Login, name: 'login',
          //children:[{}]   也可以继续添加children嵌套
        },
        {
          path: '/error', component: Error, name: 'error',
          //children:[{}]   也可以继续添加children嵌套
        },
      ]
    }
  ]
})

export default router

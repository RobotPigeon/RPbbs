import { createRouter, createWebHistory } from 'vue-router'
import Layout from '@/layout/index.vue'
import Home from '@/view/home/index.vue'
import Login from '@/view/login/index.vue'
import content from '@/view/home/content/index.vue'
import Partition from '@/view/home/Partition/index.vue'
import Error from '@/view/error/error.vue'
import posteditor from '@/view/home/posteditor/index.vue'
import postDetail from '@/view/home/postDetail/index.vue'
import competition from '@/view/football/competition/index.vue'
import match from '@/view/football/match/index.vue'
import team from '@/view/football/team/index.vue'
import player from '@/view/football/player/index.vue'
import teamPerformance from '@/view/football/teamPerformance/index.vue'
import playerPerformance from '@/view/football/playerPerformance/index.vue'

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
          children: [
            {
              path: '/home/football/playerPerformance', component: playerPerformance, name: 'playerPerformance',
            },
            {
              path: '/home/football/teamPerformance', component: teamPerformance, name: 'teamPerformance',
            },
            {
              path: '/home/football/player', component: player, name: 'player',
            },
            {
              path: '/home/football/team', component: team, name: 'team',
            },
            {
              path: '/home/football/match', component: match, name: 'match',
            },
            {
              path: '/home/football/competition', component: competition, name: 'competition',
            },
            {
              path: '/home/content', component: content, name: 'content',
            }, {
              path: '/home/Partition', component: Partition, name: 'Partition',
            }, {
              path: '/home/posteditor', component: posteditor, name: 'posteditor',
              //没有登录的时候，点击发帖，跳转到登录页面
              beforeEnter: (to, from, next) => {
                if (localStorage.getItem('token')) {
                  next()
                } else {
                  next('/login')
                }
              }
            }, {
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

import { createRouter, createWebHistory } from 'vue-router'
import Home from '../index.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: { 
      layout: 'DefaultLayout' // 使用默认布局（包含导航等）
    }
  },
  {
    path: '/member-info',
    name: 'MemberInfo',
    component: () => import('../views/MemberInfo.vue'),
    meta: { 
      layout: 'CleanLayout' // 使用干净布局
    }
  },
  {
    path: '/duty-schedule',
    name: 'DutySchedule',
    component: () => import('../views/DutySchedule.vue'),
    meta: { 
      layout: 'CleanLayout' // 使用干净布局
    }
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: '/'
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
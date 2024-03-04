import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

// 1. index.js 是用于配置路由
// 2. path：'/'，路径  当访问 http://localhost:8080/ 就路由到 HomeView 组件
// 3. 就会把HomeView 组件的内容，返回给 <router-view/>
// 4. HomeView 组件 对应的文件就是'../views/HomeView.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

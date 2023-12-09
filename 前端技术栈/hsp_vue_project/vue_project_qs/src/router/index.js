import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

//解读 @ 表示的是src目录
import Hello from "@/components/Hello.vue"
import Hsp from "@/components/Hsp.vue";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    { // 配置的一组路由
      path: '/hello',
      name: 'Hello',
      component: Hello
    },
    { // 配置的一组路由
      path: '/hsp',
      name: 'Hsp',
      component: Hsp
    }
  ]
})

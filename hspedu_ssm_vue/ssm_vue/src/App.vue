<template>
  <!--
  1. App.vue 页面可以用于布局页面
  2. <router-view/> 就是路由指令
  3. 会把路由到的页面内容，展示/替换到 <router-view/> 位置
  4. 比如 url 地址 http://localhost:8080/ 那么路由的 path 就是 /
  5. 比如 url 地址 http://localhost:8080/about 那么路由的 path 就是 /about
  <nav>
    <router-link to="/">Home-100</router-link> |
    <router-link to="/about">About-100</router-link>
  </nav>
  <router-view/>
  -->
  <div>
    <!--引入Header组件/界面 头部-->
    <Header/>
<!--    主体-->
    <div style="display: flex">
<!--      侧边栏-->
    <Aside/>
    <!--      内容区域 这个部分通过路由展示，默认路由到HomeView.vue
    http://localhost:10000/ => HomeView.vue
    http://localhost:10000/about => AboutView.vue
    -->
      <router-view style="flex: 1"/>

    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";
import Aside from "@/components/Aside.vue";
export default {
  name: "Layout",
  components: {
    Header,
    Aside
  }
}
</script>
<style>
</style>
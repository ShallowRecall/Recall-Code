<template>
  <div>
<!--    头部-->
    <Header/>
<!--    主体-->
    <div style="display: flex;">
      <Aside/>
<!--      内容区域，这个部分从HomeView.vue组件来的(通过路由机制)-->
      <router-view style="flex: 1"/>

    </div>
  </div>
</template>
<style></style>
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
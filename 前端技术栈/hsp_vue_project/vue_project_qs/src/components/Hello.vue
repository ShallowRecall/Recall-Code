<template>
  <div>
    <img src="@/assets/logo.png">
    <h1>{{ mes }}</h1>
  </div>
</template>
<script>
export default {
  name: "hello",
  data() { //数据池
    return {
      mes: "Hello,Mary~"
    }
  }
}
</script>

<style scoped>

</style>

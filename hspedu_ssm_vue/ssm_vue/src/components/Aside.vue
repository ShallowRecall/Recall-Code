<template>
  <div>
    <!--    引入导航菜单-->
    <el-menu
        style="width: 200px"
        default-active="2"
        class="el-menu-vertical-demo"
    >
      <el-sub-menu index="1">
        <template #title>
          <el-icon>
            <location/>
          </el-icon>
          <span>导航一</span>
        </template>
        <el-menu-item-group title="组一">
          <el-menu-item index="1-1">选项一</el-menu-item>
          <el-menu-item index="1-2">选项二</el-menu-item>
        </el-menu-item-group>

        <el-sub-menu index="1-4">
          <template #title>选项4</template>
          <el-menu-item index="1-4-1">选项4-1</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      <el-menu-item index="2">
        <el-icon>
          <icon-menu/>
        </el-icon>
        <span>导航二</span>
      </el-menu-item>
      <el-menu-item index="3" disabled>
        <el-icon>
          <document/>
        </el-icon>
        <span>导航三</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon>
          <setting/>
        </el-icon>
        <span>导航四</span>
      </el-menu-item>
    </el-menu>
  </div>

</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>
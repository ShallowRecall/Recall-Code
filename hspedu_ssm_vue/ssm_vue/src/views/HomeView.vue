<template>
  <div>

    <!--
    1. 在 HomeView.vue 文件中，引入/使用 HelloWorld组件
    2. 因此这里就会显示 HelloWorld组件内容
    3. HelloWorld 组件在 '@/components/HelloWorld.vue'
    4. @ 就是/src
    5. msg="Welcome to Your Vue.js App" 表示给 HelloWorld 组件设置一个值
    <HelloWorld msg="Welcome to Your Vue.js App，Recall"/>
    -->

    <!--增加按钮和搜索框-->
    <div style="margin: 10px 5px">
      <el-button type="primary">新增</el-button>
      <el-button>其它</el-button>
    </div>

    <div style="margin: 10px 5px">
      <el-input v-model="search" style="width: 30%" placeholder="请输入关键字"/>
      <el-button style="margin-left: 10px" type="primary">查找</el-button>
    </div>

    <el-table :data="tableData" stripe style="width: 90%">
      <el-table-column sortable prop="date" label="日期"/>
      <el-table-column prop="name" label="名字"/>
      <el-table-column prop="address" label="地址"/>
      <el-table-column fixed="right" label="操作" width="100">
        <template #default>
          <el-button type="text">编辑</el-button>
          <el-button type="text">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
// @ is an alias to /src
// 导入组件，导入后，就可以使用
// 导出组件
export default {
  name: 'HomeView',
  components: {},
  data() {
    return {
      search: '',
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  }
}
</script>

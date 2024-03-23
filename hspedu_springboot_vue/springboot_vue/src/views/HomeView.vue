<template>
  <div>
    <!--    新增按钮-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button>其它</el-button>
    </div>
    <!--搜索-->
    <div style="margin: 10px 0">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 30%"></el-input>
      <el-button style="margin-left: 10px" type="primary">查询</el-button>
    </div>
    <!-- 去掉字段的 width, 让其自适应 -->
    <el-table :data="tableData" stripe style="width: 90%">
      <el-table-column prop="id" label="ID" sortable></el-table-column>
      <el-table-column prop="name" label="家居名"></el-table-column>
      <el-table-column prop="maker" label="厂家"></el-table-column>
      <el-table-column prop="price" label="价格"></el-table-column>
      <el-table-column prop="sales" label="销量"></el-table-column>
      <el-table-column prop="stock" label="库存"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template #default="scope">
          <el-button @click="handleEdit(scope.row)" type="text">编辑</el-button>
          <el-button type="text">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 添加家居的弹窗
      说明:
      1. el-dialog ：v-model="dialogVisible" 表示对话框, 和 dialogVisible 变量双向 绑定 控制是否显示对话框
      2. el-form :model="form" 表示表单数据和 form 数据变量双向绑定
      3. el-input v-model="form.name" 表示表单的 input 控件，名字为 name 需要和 后台 Javabean 属性一致
         这样到后台才会进行数据的封装
    -->
    <el-dialog title="提示" v-model="dialogVisible" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="家居名">
          <el-input v-model="form.name" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="厂商">
          <el-input v-model="form.maker" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model="form.price" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="销量">
          <el-input v-model="form.sales" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="库存">
          <el-input v-model="form.stock" style="width: 80%"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="save">确 定</el-button> </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
// @ is an alias to /src
// 引入request组件/对象
import request from '@/utils/request'

export default {
  name: 'HomeView',
  components: {},
  data() { // 数据部分
    return {
      form: {}, //表单数据
      dialogVisible: false,// 控制对话框是否显示，默认false
      search: '',
      tableData: []
    }
  },
  created() { //在次方法中，调用list()，完成表格数据的显示
    this.list()
  },
  methods: { //方法
    list() { //显示家居信息
      request.get("/api/furns").then(res => {
        // 将返回的数据和tableData进行绑定
        this.tableData = res.data
      })
    },
    save() { //添加
      request.post("/api/save", this.form).then(
          res => { // 是箭头函数
            // res 就是后端程序返回给前端的结果
            console.log("res=", res)
            this.dialogVisible = false
            this.list() //刷新家居列表
          }
      )
    },
    handleEdit(row) {
      /*console.log("row1=", row)
      // JSON.stringify(row) 转成json字符串
      console.log("row2=", JSON.stringify(row))
      // 把json字符串 转成json对象
      console.log("row3=", JSON.parse(JSON.stringify(row)))*/

      // 把得到的数据和form绑定，显示到对话框
      // 说明：
      // 1. JSON.parse(JSON.stringify(row)) 就是对行数据进行深拷贝
      // 2. 这样点击的表格当前行的数据和弹出框的数据是独立的

      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    add() {
      //add方法，显示添加的对话框
      this.dialogVisible = true
      //每次显示添加对话框的时候，清空表单数据
      this.form = {}
    }
  }
}
</script>

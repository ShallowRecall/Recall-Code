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
      <el-button style="margin-left: 10px" type="primary" @click="list">查询</el-button>
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
          <el-button @click="handleEdit2(scope.row)" type="text">编辑</el-button>
          <!--引入一个确认框PopConfirm-->
          <!--          <el-button type="text">删除</el-button>-->
          <el-popconfirm title="确定删除吗？" @confirm="handleDel(scope.row.id)">
            <template #reference>
              <el-button size="mini" type="text">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!--引入分页组件-可以根据自己的需要进行定制-->
    <div style="margin: 10px 0">
      <el-pagination
          @size-change="handlePageSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5,10]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>

    <!-- 添加家居的弹窗
      说明:
      1. el-dialog ：v-model="dialogVisible" 表示对话框, 和 dialogVisible 变量双向 绑定 控制是否显示对话框
      2. el-form :model="form" 表示表单数据和 form 数据变量双向绑定
      3. el-input v-model="form.name" 表示表单的 input 控件，名字为 name 需要和 后台 Javabean 属性一致
         这样到后台才会进行数据的封装
    -->
    <el-dialog title="提示" v-model="dialogVisible" width="30%">
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <!--说明：prop="name"表示和rules的哪个规则关联-->
        <el-form-item label="家居名" prop="name">
          <el-input v-model="form.name" style="width: 50%"></el-input>
        <!--显示返回的后端校验信息-vue的插入表达式-->
          {{validMsg.name}}
        </el-form-item>
        <el-form-item label="厂商" prop="maker">
          <el-input v-model="form.maker" style="width: 50%"></el-input>
          {{validMsg.maker}}
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" style="width: 50%"></el-input>
          {{validMsg.price}}
        </el-form-item>
        <el-form-item label="销量" prop="sales">
          <el-input v-model="form.sales" style="width: 50%"></el-input>
          {{validMsg.sales}}
        </el-form-item>
        <el-form-item label="库存" prop="stock">
          <el-input v-model="form.stock" style="width: 50%"></el-input>
          {{validMsg.stock}}
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
      validMsg: {}, //关联后端校验数据信息
      currentPage: 1,//当前页
      pageSize: 5, //每页显示几条记录
      total: 10, //一共有多少条记录，会通过请求获取到表中对应的记录数
      form: {}, //表单数据
      dialogVisible: false,// 控制对话框是否显示，默认false
      search: '',
      tableData: [],
      //定义添加表单的校验规则
      rules: {
        name: [
          //这里我们可以写多个针对name 属性的校验规则
          {required: true, message: "请输入家具名", trigger: 'blur'}
        ],
        maker: [
          {required: true, message: "请输入厂商", trigger: 'blur'}
        ],
        price: [
          {required: true, message: "请输入价格", trigger: 'blur'},
          // 使用正则表达式对输入的数据进行校验
          {
            pattern: /^([1-9]\d*|0)(\.\d+)?$/,
            message: "请输入数字",
            trigger: 'blur'
          }
        ],
        sales: [
          {required: true, message: "请输入销量", trigger: 'blur'},
          {pattern: /^([1-9]\d*|0)$/, message: '请输入数字', trigger: 'blur'}
        ],
        stock: [
          {required: true, message: "请输入库存", trigger: 'blur'},
          {pattern: /^([1-9]\d*|0)$/, message: '请输入数字', trigger: 'blur'}
        ]
      }
    }
  },
  created() { //在次方法中，调用list()，完成表格数据的显示
    this.list()
  },
  methods: { //方法
    //add方法，显示添加的对话框
    add() {
      this.dialogVisible = true
      this.form = {}
      this.$nextTick(() => {
        if (this.$refs.form) {
          this.$refs.form.resetFields()
        }
      })
      this.validMsg = {}
    }
    ,
    //处理pageSize的变化
    handlePageSizeChange(pageSize) {
      this.pageSize = pageSize
      this.list() // 刷新家居列表
    },
    //处理currentPage的变化
    handleCurrentChange(pageNum) {
      this.currentPage = pageNum
      this.list() // 刷新家居列表
    },
    //处理删除
    handleDel(id) {
      // 使用request发出请求，删除当前的家居
      // 如何显示和关闭vue方法参数提示->settings->inlay hints
      request.delete("/api/del/" + id).then(res => {
        // 判断
        if (res.code === "200") { //删除成功
          this.$message({
            type: "success",
            message: "删除成功"
          })
        } else { //删除失败
          this.$message({
                type: "error",
                message: res.msg
              }
          )
        }
      })
      // 刷新家居列表
      this.list()
    },

    list() { //显示家居信息
      /* request.get("/api/furns").then(res => {
         // 将返回的数据和tableData进行绑定
         this.tableData = res.data
       })*/

      //分页查询 + 带条件
      request.get("/api/furnsBySearchPage2", {
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => {
        // 将返回的数据和tableData进行绑定
        this.tableData = res.data.records
        // 修改total
        this.total = res.data.total
      })
    },
    save() { //添加，修改

      if (this.form.id) { //执行修改
        // 因为request.put / get / post ...都是ajax异步请求
        request.put("/api/update", this.form).then(
            res => {
              if (res.code === "200") {// 修改成功
                // 需要提示-成功的消息框
                this.$message({
                  message: "更新成功",
                  type: "success"
                })
              } else {
                // 需要提示-失败的消息框
                this.$message({
                  message: "更新失败",
                  type: "error"
                })
              }
              // 刷新 家居列表
              // 不显示对话框
              this.list()
              this.dialogVisible = false
            })
      } else {
        /*request.post("/api/save", this.form).then(
            res => { // 是箭头函数
              // res 就是后端程序返回给前端的结果
              console.log("res=", res)
              this.dialogVisible = false
              this.list() //刷新家居列表
            }
        )*/

        // 添加时，和表单验证关联，如果没有验证通过，就不提交
        this.$refs['form'].validate((valid) => {
          //为了配合后端校验，暂时放行
          //valid = true
          //valid就是表单校验后返回的结果
          if (valid) {//前端检验通过
            request.post("/api/save", this.form).then(
                res => { // 是箭头函数

                  if (res.code === "200") { //添加成功
                    // res 就是后端程序返回给前端的结果
                    console.log("res=", res)
                    this.dialogVisible = false
                    this.list() //刷新家居列表
                  } else if (res.code === "400") { //后端校验失败

                    // 取出返回的校验错误信息
                    this.validMsg.name = res.data.name
                    this.validMsg.maker = res.data.maker
                    this.validMsg.price = res.data.price
                    this.validMsg.sales = res.data.sales
                    this.validMsg.stock = res.data.stock


                  }


                }
            )
          } else {//校验没有通过
            //提示一个错误的消息框
            this.$message(
                {
                  type: "error",
                  message: "验证没有通过，不提交"
                }
            )
          }
          return false //放弃提交
        })
      }
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
    //新写一个方法handleEdit2(row)
    //1. 通过row.id 发送请求Get
    //2. 返回对应的家居信息
    //3. 返回的家居信息取出，绑定到 this.form

    handleEdit2(row) {
      request.get("/api/find/" + row.id).then(res => {
        if (res.code === "200") { //查询成功
          //取出数据绑定this.form
          this.form = res.data
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
      this.dialogVisible = true // 显示对话框
    }
  }
}
</script>

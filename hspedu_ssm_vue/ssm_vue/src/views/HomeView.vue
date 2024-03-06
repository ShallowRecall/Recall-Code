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
      <!--
          1. @click="add" 表单点击 新增，就会触发 add方法
      -->
      <el-button type="primary" @click="add">新增</el-button>
      <el-button>其它</el-button>
    </div>

    <div style="margin: 10px 5px">
      <el-input v-model="search" style="width: 30%" placeholder="请输入关键字"/>
      <el-button style="margin-left: 10px" type="primary" @click="list">检索</el-button>
    </div>

    <el-table :data="tableData" stripe style="width: 90%">
      <el-table-column prop="id" label="ID" sortable></el-table-column>
      <el-table-column prop="name" label="家具名" sortable></el-table-column>
      <el-table-column prop="maker" label="厂家" sortable></el-table-column>
      <el-table-column prop="price" label="价格" sortable></el-table-column>
      <el-table-column prop="sales" label="销量" sortable></el-table-column>
      <el-table-column prop="stock" label="库存" sortable></el-table-column>
      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <!-- 说明：
          1、这里通过 handleEdit(scope.row)
          2、可以将当前行数据传递给handleEdit
          -->
          <el-button type="text" @click="handleEdit(scope.row)">编辑</el-button>
          <!--说明：
             1. 如果点击的确定，就会触发handleDel
             2. 如果点击的是取消，就不会触发handleDel
          -->
          <el-popconfirm title="确认删除吗?" @confirm="handleDel(scope.row.id)">
            <template #reference>
              <el-button size="small" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>


    <!-- 添加家居的弹窗
      说明：
      1. el-dialog ： v-model="dialogVisible" 表示对话框，和dialogVisible 变量双向绑定，控制是否显示对话框
      2. el-form : model="form" 表示表单，数据和 form数据变量双向绑定
      3. el-input v-model="form.name" 表示表单的input空间，名字为name 需要和后台Javabean[Furn] 属性一致
      4. 在前端中，对象的属性时可以动态生成的 form.age
      -->
    <el-dialog title="提示" v-model="dialogVisible" width="30%">
      <el-form :model="form" :rules="rules" ref="form" label-width="120px">
        <el-form-item label="家居名" prop="name">
          <el-input v-model="form.name" style="width: 80%"/>
        </el-form-item>
        <el-form-item label="厂商" prop="maker">
          <el-input v-model="form.maker" style="width: 80%"/>
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" style="width: 80%"/>
        </el-form-item>
        <el-form-item label="销量" prop="sales">
          <el-input v-model="form.sales" style="width: 80%"/>
        </el-form-item>
        <el-form-item label="库存" prop="stock">
          <el-input v-model="form.stock" style="width: 80%"/>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </span>
      </template>
    </el-dialog>

    <!--添加分页导航-->
    <div style="margin: 10px 0">
      <el-pagination
          @size-change="handlePageSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[2,5,10,15]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
  </div>


</template>

<script>
// @ is an alias to /src
// 导入组件，导入后，就可以使用
// 导入 request 对象
import request from "@/utils/request"
// 导出组件
export default {
  name: 'HomeView',
  components: {},
  data() {
    return {
      // 增加分页相应的数据绑定
      currentPage: 1,//当前页
      pageSize: 5,//每页显示记录数
      total: 10,//共有多少记录
      search: '',//检索条件，可以再进行分页是，保留上次的检索条件
      dialogVisible: false,
      form: {},//定义一个空表单
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
  created() {
    this.list();//调用list方法
  },
  methods: {
    add() { //显示添加对话框-表单
      //显示对话框
      this.dialogVisible = true;
      //清空添加表单数据
      this.form = {}
      //清空上次校验的信息
      this.$refs['form'].resetFields()
    },
    save() { //将填写的表单数据，发送给后端

      // 修改和添加走的同一个方法
      if (this.form.id) { //表示update
        //本质发出ajax请求-异步处理
        request.put("/api/update", this.form).then(res => {

          if (res.code === 200) {// 修改成功
            //提示一个成功的消息框
            this.$message(
                {
                  type: "success",
                  message: "更新成功"
                }
            )
          } else {
            //提示一个错误的消息框
            this.$message(
                {
                  type: "error",
                  message: "更新失败"
                }
            )
          }
          // 关闭对话框，更新数据
          this.dialogVisible = false
          // 调用list方法，刷新数据
          this.list()
        })


      } else {

        //表单验证是否通过
        this.$refs['form'].validate((valid) => {
          //valid就是表单校验后返回的结果
          if (valid) {//如果检验通过
            //1. url: http://localhost:8080/ssm/save
            //2. this.form: 携带的数据
            request.post("/api/save", this.form).then(res => {
              console.log("res-", res);
              this.dialogVisible = false
              // 调用list方法，刷新数据
              this.list()
            })
          }else {//校验没有通过

            //提示一个错误的消息框
            this.$message(
                {
                  type: "error",
                  message: "验证失败，不提交"
                }
            )
          }
          return false //放弃提交

        })
      }
    },
    //编写list方法，请求返回家具信息
    //list方法应该是自动调用.
    list() {
      // request.get("/api/furns").then(res => {
      //   console.log("res-", res)
      //   //对返回response结果进行了统一拦截处理 let res = response.data
      //   //，所以直接使用 res.extend.furnList
      //   this.tableData = res.extend.furnList
      // })
      // 请求分页的接口-带检索条件
      request.get("/api/furnsByConditionPage", {
        params: {// 指定请求携带的参数,
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => { //处理返回的分页信息
        this.tableData = res.extend.pageInfo.list
        this.total = res.extend.pageInfo.total
      })
    },
    handleEdit(row) {
      //console.log("row--", row)

      //将当前的家居信息绑定到弹出对话框的form
      //1. 方式1：可以通过row.id 到后端-DB去获取对应的家居信息，返回后将其绑定 this.form
      //2. 方式2：把获取的row的数据通过处理，绑定到this.form 进行显示
      //3. JSON.stringify(row)：将row 转成json字符串
      //4. JSON.parse(JSON.stringify(row)) 将json字符串转成json对象
      this.form = JSON.parse(JSON.stringify(row))

      //可以通过row.id 到后端-DB去获取对应的家居信息
      // request.get("/api/find/"+row.id).then(res => {
      //   //console.log("家具信息-",res.extend.furn) // response.data.extend.furn
      //   this.form = res.extend.furn
      // })

      this.dialogVisible = true
    },
    handleDel(id) {
      // console.log("id-",id)
      request.delete("/api/del/" + id).then(res => {
        if (res.code === 200) {//删除成功
          //提示一个成功的消息框
          this.$message(
              {
                type: "success",
                message: res.msg
              }
          )
        } else { //删除失败
          //提示一个错误的消息框
          this.$message(
              {
                type: "error",
                message: res.msg
              }
          )
        }
        //刷新页面数据
        this.list()
      })
    },
    handleCurrentChange(pageNum) { //处理分页请求
      //当用于点击分页超链接时，会携带pageNum
      this.currentPage = pageNum
      //发出请求
      this.list()
    },
    handlePageSizeChange(pageSize) {
      this.pageSize = pageSize
      this.list()
    }
  }
}
</script>

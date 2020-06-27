<template>
<div id="teacher_main">
  <!--    面包屑导航-->
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>配置课程</el-breadcrumb-item>
  </el-breadcrumb>
  <el-card>
    <el-table :data="tableData" height="510px" max-height="510px" :header-cell-style="{'text-align':'center',color:'#67C23A'}" :cell-style="{'text-align':'center'}">
      <el-table-column prop="cyear" label="学年学期" >
      </el-table-column>
      <el-table-column prop="cname" label="课程名称" >
      </el-table-column>
      <el-table-column prop="ctype" label="课程类别" >
      </el-table-column>
      <el-table-column prop="address" label="上课地点">
      </el-table-column>
      <el-table-column prop="ctime" label="上课时间">
      </el-table-column>
      <el-table-column prop="operation" label="操作">
        <template slot-scope="scope">
          <el-tooltip class="item" effect="dark" content="编辑" placement="top" :enterable="false">
          <el-button
            size="mini"
            type="primary"
            icon="el-icon-edit"
            @click="handleEdit(scope.$index, scope.row)"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
  </el-card>

<!--  添加对话框-->
  <el-dialog
    title="配置课程"
    :visible.sync="editDialogVisible"
    width="50%" @close="editDialogClosed">
    <el-form ref="editformref" :rules="editformrules" :model="editform" label-width="80px">
      <el-form-item label="学期学年">
        <el-input
          v-model="editform.cyear"
          :disabled="true"
          clearable>
        </el-input>
      </el-form-item>
      <el-form-item label="课程名称">
        <el-input
          v-model="editform.cname"
          :disabled="true"
          clearable>
        </el-input>
      </el-form-item>
      <el-form-item label="课程类别">
        <el-input
          v-model="editform.ctype"
          :disabled="true"
          clearable>
        </el-input>
      </el-form-item>
      <el-form-item label="上课地点" prop="toaddress">
        <el-input
          placeholder="上课地点"
          v-model="editform.toaddress"
          clearable>
        </el-input>
      </el-form-item>
      <el-form-item label="上课时间" prop="toctime">
        <el-input
          placeholder="上课时间"
          v-model="editform.toctime"
          clearable>
        </el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
    <el-button @click="editDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="edittosave">确 定</el-button>
  </span>
  </el-dialog>
</div>
</template>

<script>
    export default {
        name: "Teacher_main",
        data() {
          const item = {
            cyear: '2019-02020-2',
            cname: '软件工程',
            ctype: '专业课',
            address:'暂定',
            ctime:'暂定'
          };
          return {
            tableData: [
              {cyear: '2019-2020-2', cname: '软件工程', ctype: '专业课', address:'暂定', ctime:'暂定'},
              {cyear: '2019-2020-1', cname: 'javaweb', ctype: '专业课', address:'暂定', ctime:'暂定'},
              {cyear: '2018-2019-2', cname: '图形学', ctype: '专业课', address:'暂定', ctime:'暂定'},
              {cyear: '2018-2019-1', cname: 'matlab', ctype: '专业课', address:'暂定', ctime:'暂定'},
              {cyear: '2019-2020-2', cname: '网络信息安全', ctype: '专业课', address:'暂定', ctime:'暂定'},
            ],
            indexid:'',
            rows:'',
            editDialogVisible:false,
            //对话框表单
            editform: {
              cyear: '',
              cname: '',
              ctype: '',
              toaddress:'',
              toctime:''
            },
            //表单验证规则
            editformrules:{
              toaddress:[
                {required: true, message: '请输入上课地点', trigger: 'blur'}
              ],
              toctime:[
                {required: true, message: '请输入上课时间', trigger: 'blur'}
              ]
            }

          }
        },
      methods:{
        // 展示编辑对话框
        handleEdit(index,row){
          this.editDialogVisible=true;

          const tocyear = row.cyear;
          const tocname = row.cname;
          const toctype = row.ctype;
          this.editform.cyear = tocyear;
          this.editform.cname = tocname;
          this.editform.ctype = toctype;
          this.indexid = index;
          console.log(index);
          console.log(row);
        },
        //监听修改配置课程的对话框关闭事件
        editDialogClosed(){
          this.$refs.editformref.resetFields()
        },
        //确定键点击事件，保存修改
        edittosave(){
          // this.$set(this.tableData[0].address,this.editform.toaddress+'');
          // this.$set(this.tableData[0].ctime,this.editform.toctime+'');
          this.tableData[this.indexid].address = this.editform.toaddress;
          this.tableData[this.indexid].ctime = this.editform.toctime;
          console.log(this.indexid);
          console.log(this.tableData[this.indexid].address);
          this.editDialogVisible = false;
        }
      }
    }
</script>

<style scoped>
  .el-breadcrumb {
    margin-bottom: 15px;
  }
  .el-card {
    box-shadow: 0 1px 1px rgba(0,0,0,0.15) !important;
  }
</style>

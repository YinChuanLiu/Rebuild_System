<template>
    <div id="director_main">
      <!--    面包屑导航-->
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>分配教师</el-breadcrumb-item>
      </el-breadcrumb>
      <el-card>
        <el-table :data="tableData" height="510px" max-height="510px" :header-cell-style="{'text-align':'center',color:'#67C23A'}" :cell-style="{'text-align':'center'}">
          <el-table-column prop="cyear" label="学年学期" >
          </el-table-column>
          <el-table-column prop="cname" label="课程名称" >
          </el-table-column>
          <el-table-column prop="ctype" label="课程类别" >
          </el-table-column>
          <el-table-column prop="distribute" label="分配教师">
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
<!--        &lt;!&ndash;   分页区域     &ndash;&gt;-->
<!--        <el-pagination-->
<!--          @size-change="handleSizeChange"-->
<!--          @current-change="handleCurrentChange"-->
<!--          :current-page="queryInfo.pagenum"-->
<!--          :page-sizes="[5, 10, 15, 20]"-->
<!--          :page-size="queryInfo.pagesize"-->
<!--          layout="total, sizes, prev, pager, next, jumper"-->
<!--          :total="total">-->
<!--        </el-pagination>-->
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
          <el-form-item label="分配教师" prop="distribute">
            <el-input
              placeholder="输入教师工号"
              v-model="editform.todistribute"
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
        name: "Director_main",
      data() {

        return {
          tableData: [
            {cyear: '2019-2020-2', cname: '软件工程', ctype: '专业课', distribute: ''},
            {cyear: '2019-2020-1', cname: 'javaweb', ctype: '专业课', distribute: ''},
            {cyear: '2018-2019-2', cname: '图形学', ctype: '专业课', distribute: ''},
            {cyear: '2018-2019-1', cname: 'matlab', ctype: '专业课', distribute: ''},
            {cyear: '2019-2020-2', cname: '网络信息安全', ctype: '专业课', distribute: ''},
          ],
          //表单数据
          editform: {
            cyear: '',
            cname: '',
            ctype: '',
            todistribute:''
          },
          //表单验证规则
          editformrules:{
            todistribute:[
              {required: true, message: '请输入教师工号', trigger: 'blur'}
            ]
          },
          index:'',
          editDialogVisible:false, //对话框隐藏
          // //获取用户列表参数值
          // queryInfo:{
          //
          //   query:'',
          //   pagenum:1,
          //   pagesize:2
          //
          // },
          // total:0
        }

      },

      methods:{

          handleEdit(index,row){
            this.editDialogVisible=true; //显示对话框
            //表单数据
            const tocyear = row.cyear;
            const tocname = row.cname;
            const toctype = row.ctype;
            this.editform.cyear = tocyear;
            this.editform.cname = tocname;
            this.editform.ctype = toctype;

            this.editform.todistribute = '';

            this.indexid = index;
          },
            edittosave(){
            this.tableData[this.indexid].distribute = this.editform.todistribute;
            this.editDialogVisible = false;
            },
        //监听修改配置课程的对话框关闭事件
        editDialogClosed(){
          this.$refs.editformref.resetFields()
        },
        // //监听pagesize改变的事件
        // handleSizeChange(newSize){
        //     console.log(newSize)
        // },
        // handleCurrentChange(newPage){
        //     console.log(newPage)
        // }

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

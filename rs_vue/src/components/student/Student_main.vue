<template>
  <div id="student_main">
<!--    面包屑导航-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>重修课程</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <el-table :data="tableData" height="510px" max-height="510px" :header-cell-style="{'text-align':'center',color:'#67C23A'}" :cell-style="{'text-align':'center'}">
        <el-table-column prop="cname" label="课程名称">
        </el-table-column>
        <el-table-column prop="ctype" label="课程类别">
        </el-table-column>
        <el-table-column prop="cyear" label="学年学期">
        </el-table-column>
        <el-table-column prop="credit" label="学分">
        </el-table-column>
        <el-table-column prop="teacher" label="授课老师">
        </el-table-column>
        <el-table-column prop="tell" label="电话">
        </el-table-column>
        <el-table-column prop="address" label="授课地点">
        </el-table-column>
        <el-table-column prop="ctime" label="授课时间">
        </el-table-column>
        <el-table-column prop="status" label="缴费状态">
        </el-table-column>
      </el-table>
    </el-card>

  </div>

</template>

<script>
    export default {
        name: "Student_main",
      data() {
        const item = {
          cname: '软件工程',
          ctype: '专业课',
          cyear: '2019-02020-2',
          credit:'5',
          teacher:'彭琛',
          tell:'12345678901',
          address:'4401',
          ctime:'周一第一大节',
          status:'已缴费'
        };
        return {
          tableData: Array(20).fill(item),

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

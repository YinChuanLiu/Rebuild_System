<template>
  <div id="student">
    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <h1 class="header_title">重修信息系统</h1>
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px; color: white"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>
      <el-container>
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
          <el-menu>
            <el-submenu index="1">
              <template slot="title"><i class="el-icon-message"></i>重修课程</template>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title"><i class="el-icon-menu"></i>个人信息</template>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title"><i class="el-icon-setting"></i>修改密码</template>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <el-table :data="tableData">
            <el-table-column prop="cname" label="课程名称">
            </el-table-column>
            <el-table-column prop="ctype" label="课程类别">
            </el-table-column>
            <el-table-column prop="cyear" label="课程年限">
            </el-table-column>
            <el-table-column prop="credit" label="学分">
            </el-table-column>
            <el-table-column prop="teacher" label="授课老师">
            </el-table-column>
            <el-table-column prop="address" label="授课地点">
            </el-table-column>
            <el-table-column prop="status" label="缴费状态">
            </el-table-column>
          </el-table>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
    export default {
        name: "Student",
      data() {
        const item = {
          cname: '软件工程',
          ctype: '专业课',
          cyear: '2019-02020-2',
          credit:'5',
          teacher:'彭琛',
          address:'4401',
          status:'已缴费'
        };
        return {
          tableData: Array(20).fill(item)
        }
      }
    }
</script>

<style scoped>
  #student{
    top: 0px;
    left: 0px;
  }
  .header_title{
    float: left;
    margin-top: -5px;

  }
  .el-header {
    background-color: #303133;
    color: white;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>

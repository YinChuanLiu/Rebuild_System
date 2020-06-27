<template>
  <div id="student">
    <el-container>
      <el-header height="80px" style="text-align: right; font-size: 12px">
        <h1 class="header_title">重修信息系统</h1>
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px; color: white"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="tologin" style="color: red">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>
      <el-container>
        <el-aside width="200px" style="background-color: #DCDFE6">
          <el-menu class="el-menu-vertical-demo" default-active="Student_main" router>
            <el-menu-item index="Student_main">
              <template slot="title"><i class="el-icon-message"></i>重修课程</template>
            </el-menu-item>
            <el-menu-item index="Student_personal">
              <template slot="title"><i class="el-icon-menu"></i>个人信息</template>
            </el-menu-item>
            <el-menu-item index="Revise_password1">
              <template slot="title"><i class="el-icon-setting"></i>修改密码</template>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

    export default {
        name: "Student",
        methods:{
          tologin(){
            window.sessionStorage.removeItem('token');//可clear
            this.$router.push('/');
          }
        }
    }
</script>

<style scoped>

  .header_title{
    float: left;
    margin-top: -5px;

  }
  .el-header {
    background-color: #409EFF;
    color: white;
    line-height: 90px;
  }

  .el-aside {
    color: #333;
    height: 100%;
  }
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    /*line-height: 160px;*/
  }
</style>

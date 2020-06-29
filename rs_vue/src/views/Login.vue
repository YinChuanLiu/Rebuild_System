<template>
<div id="login">
  <div id="form1">
    <el-card class="box-card" body-style="{padding: '0px'}">
      <el-form ref="loginformref" :rules="loginformrules" :model="form" label-width="80px">
        <el-form-item>
          <div class="h1"><h1>重修信息系统</h1></div>
          <div class="p1"><p>rebuild information system</p></div>
          <hr>
        </el-form-item>
        <el-form-item label="账号"style="width: 300px" class="username" prop="username">
          <el-input
            placeholder="请输入内容"
            v-model="form.username"
            clearable>
          </el-input>
        </el-form-item>
        <el-form-item label="密码" style="width: 300px" class="password" prop="password">
          <el-input
            placeholder="请输入内容"
            v-model="form.password"
            type="password"
            clearable>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit" class="primary">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>


</div>
</template>

<script>
    export default {
        name: "Login",
      data() {
        return {
          form: {
            username: '',
            password: ''
          },
          //表单验证规则
          loginformrules:{
            username:[
              {required: true, message: '请输入账号', trigger: 'blur'}
            ],
            password:[
              {required: true, message: '请输入密码', trigger: 'blur'}
            ]
          }
        }
      },
      methods: {
        onSubmit() {
          this.$refs.loginformref.validate(valid =>{
              if (!valid) return;
            if(this.form.username==='123' && this.form.password==='123'){
              window.sessionStorage.setItem("token",this.form.username);
              this.$router.push('/Student');
              this.$message.success('登录成功！');
            }else if (this.form.username==='456' && this.form.password==='456'){
              window.sessionStorage.setItem("token",this.form.username);
              this.$router.push('/Teacher');
              this.$message.success('登录成功！');
            }else if (this.form.username==='789' && this.form.password==='789'){
              window.sessionStorage.setItem("token",this.form.username);
              this.$router.push('/Director');
              this.$message.success('登录成功！');
            }
            else {
              this.$message.error('登录失败！');
            }
          });
          console.log('submit!');
        }
      }
    }
</script>

<style scoped>
#login{
  background: url("../image/background6.jpg");
  width: 100%;
  height: 100%;
  position: fixed;
  background-size: 100% 100%;
  /*border: 1px red solid;*/
  top: 0px;
  left: 0px;
}
#form1{
  margin: auto;
  margin-top: 140px;
  width: 520px;
  height: 365px;
  border: 1px transparent solid;
  background: rgba(255,255,255,0.35);
  padding-top: 10px;
}
.box-card{
  margin: auto;
  width: 500px;
  height: 350px;
  /*border: solid 10px rgba(64,158,255,0.5);*/
  /*background: rgba(255,255,255,0.9);*/
  }
  .username{
       margin-left: 15%;
       /*border: red solid 2px;*/
     }
.password{
  margin-left: 15%;
  /*border: red solid 2px;*/
}
  .primary{
    margin-left: 23%;
    margin-top: 15px;
    width: 40%;
  }
.h1{
  margin-left: -20%;
  margin-top: -6%;
  color: #67C23A;
}
  .p1{
    margin-left: -20%;
    margin-top: -8%;
    color: #606266;
  }
  hr{
    margin-top: -3%;
    margin-left: -20%;
    color: #67C23A;


  }
</style>

<template>
  <div id="login" style="text-align: center">
    <h1 style="text-align: center">登录</h1>
    <el-form ref="loginForm" :model="manager" :rules="rules" label-width="100px">
      <el-form-item prop="username" label="账号">
        <el-input v-model="manager.username" placeholder="请输入账号"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="manager.password" placeholder="请输入密码" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login()">登录</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import managerApi from "@/api/managerApi";


export default {
  data() {
    return {
      manager: {username: "", password: ""},
      rules: {
        username: [
          {required: true, message: "用户名不能为空", trigger: 'blur'},
          {min: 3, message: "用户名不能小于3个字符长度", trigger: 'blur'}
        ],
        password: [
          {required: true, message: "密码不能为空", trigger: 'blur'},
          {min: 4, message: "密码不能小于4个字符长度", trigger: 'blur'}
        ]
      },

    }
  },
  methods: {
    login() {
      this.$refs.loginForm.validate().then(resp => {
        managerApi.login(this.manager.username, this.manager.password)
            .then(resp => {
              if (resp.data.data){
                let manager1=resp.data.data;
                this.$message({
                  message:"登陆成功"
                })
              }

            })
      })
    }
  }
}
</script>

<style>
#login {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  /*display: flow;*/
  justify-content: center;
  align-items: center;
  background-size: cover;
  /*background-image: url('https://tva3.sinaimg.cn/large/0072Vf1pgy1foxkifyvznj31hc0u0e1h.jpg');*/
}

.el-form {
  border-radius: 20px;
  padding: 50px;
  width: 300px;
  background-color: rgba(100, 100, 100, 0.5);
}


</style>

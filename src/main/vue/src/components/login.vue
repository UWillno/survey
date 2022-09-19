<template>
  <div id="login">

    <el-form ref="loginForm" :model="manager" :rules="rules" style="text-align: center">
      <h1 style="text-align: center">登录</h1>
        <el-form-item prop="username" label="用户名" >
          <el-input v-model="manager.username" placeholder="请输入用户名"></el-input>
        </el-form-item>


        <el-form-item label="密码" prop="password">
          <el-input v-model="manager.password" placeholder="请输入密码" show-password></el-input>
        </el-form-item>

      <el-form-item style="display: inline-block">
        <el-button type="primary" @click="login()">登录</el-button>
        <el-button type="primary" @click="reset()">重置</el-button>
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
              if (resp.data.data) {
                let manager1 = resp.data.data;
                console.log(manager1)

                this.$message({
                  message: "登陆成功" + manager1.username,
                  type: 'success',
                  center: true,
                  duration: 3000
                })
                this.$cookie.set("token", manager1.token);
                this.$cookie.set("username", manager1.username);
                this.$router.push({
                  path: "/manager/home"
                })

              } else {
                this.$message({
                  message: "登陆失败",
                  type: 'error',
                  center: true,
                  duration: 3000
                })
              }

            })
      })
    },

    reset() {
      this.$refs.loginForm.resetFields();
    }
  }
}
</script>

<style scoped>
#login {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  /*display: flow;*/
  justify-content: center;
  align-items: center;
  background-size: cover;
  background: #a8ff78;  /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #78ffd6, #a8ff78);  /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #78ffd6, #a8ff78); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

}

.el-form {
  border-radius: 20px;
  padding: 50px;
  width: 300px;
  background-color: white;
}


</style>

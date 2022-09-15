<template>
  <div id="login" style="text-align: center">
    <h1 style="text-align: center">登录</h1>
    <el-form ref="form" :model="manager" :rules="rules" label-width="100px" style="align-content: center">
      <el-form-item prop="username" label="账号">
        <el-input v-model="manager.username" placeholder="请输入账号"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="manager.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item style="text-align: center">
        <el-button type="primary" @click="">登录</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      manager: {},
      rules:{
        username: [
          {required: true, message: "用户名不能为空", trigger: 'blur'},
          {min: 3, message: "用户名不能小于3个字符长度", trigger: 'blur'}
        ],
        password: [
          {required: true, message: "密码不能为空", trigger: 'blur'},
          {min: 4, message: "密码不能小于4个字符长度", trigger: 'blur'}
        ]
      }
    }
  }
}
</script>

<style>
#login {
  width: 100%;
  height: 100%;
  display: flex;
  /*display: flow;*/
  justify-content: center;
  align-items: center;
  background-size: cover;
  background-image: url('https://www.sf-express.com/uploads/speedy_express_edc602d35a.jpg');
}

.el-form {
  border-radius: 20px;
  padding: 50px;
  width: 300px;
  background-color: rgba(100, 100, 100, 0.5);
}

</style>

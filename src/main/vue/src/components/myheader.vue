<template>
  <div class="myheader clearfix">
    <div class="logo"><img
        src="https://cdn.worldvectorlogo.com/logos/pippu.svg"/>
    </div>
    <div class="welcome">
      <el-dropdown @command="handleCommand">
      <span class="el-dropdown-link">
        欢迎你:{{ this.$cookie.get("username") }}<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">修改密码</el-dropdown-item>
          <el-dropdown-item command="b">注销</el-dropdown-item>
        </el-dropdown-menu>

      </el-dropdown>

    </div>
    <div class="title">
      武昌首义欢迎你
    </div>
  </div>
</template>

<script>


export default {
  name: "myheader",

  methods: {
    handleCommand(value) {
      if (value == "a") {
        //修改密码
      } else if (value == "b") {
        // 注销
      }
    },

  }

}
</script>

<style scoped>
.myheader {
  z-index: 100;
  position: fixed;
  top: 0;
  width: 100%;
  background-color: whitesmoke;
  height: 80px;
  line-height: 80px;
  overflow: hidden;
  box-shadow: 0 1px 6px 2px #cfcbcb;
}

.title {
  font-size: 30px;
  color: #23d1ae;
  text-align: center;
  margin: 0 200px;
  font-weight: bold;
}

.logo {
  float: left;
  padding: 10px 0 0 10px;
  width: 200px;
  height: 80px;
}
img{
  width: 100%;
  height: 80%;
}
.welcome {
  text-align: center;
  width: 200px;
  float: right;
}

.el-dropdown-link {
  cursor: pointer;
  color: #ff557f;
  font-size: 12px;
}

.el-icon-arrow-down {
  font-size: 12px;
}

</style>
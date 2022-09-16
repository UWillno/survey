<template>
  <div class="myheader">
    <div class="logo"><img
        src="https://www.kaspersky.com/siterenderer/_next/static/media/kaspersky-logo.e79ac6c57fcaf0a58fbb62a8a5d56786.svg"/>
    </div>
    <div class="title">
      武昌首义欢迎你
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
  height: 80px;
  position: relative;
  background-color: whitesmoke;
  line-height: 80px;
  width: 100%;
  text-align: center;
}

.title {
  font-size: 30px;
  color: #23d1ae;
  /*line-height: 85px;*/
  font-weight: bold;
}

.logo {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0 0 10px;
  width: 200px;
}

.welcome {
  position: absolute;
  top: 0;
  right: 100px;
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
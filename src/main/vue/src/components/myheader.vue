<template>
  <div class="myheader">
    <div class="logo"><img
        src="https://www.kaspersky.com/siterenderer/_next/static/media/kaspersky-logo.e79ac6c57fcaf0a58fbb62a8a5d56786.svg"/>
    </div>
    <div class="title">
<!--      武昌首义欢迎你-->
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
  background-color: whitesmoke;
  /*display: flex;*/
  line-height: 80px;
  /*justify-content:   center;*/
  /*align-items: center;*/
}

.title {
  font-size: 30px;
  width: 800px;
  color: #23d1ae;
  height: 85px;
  /*line-height: 85px;*/
  float: left;
  text-align: center;
  font-weight: bold;
}

.logo {
  width: 300px;
  height: 85px;
  padding: 10px 0 0 10px;
  float: left;
  box-sizing: border-box;
}

.welcome {
  position: absolute;
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
<template>
  <div class="mynav ">
    <el-menu :router="true" :default-active="$route.path" class="el-menu-vertical-demo" background-color="#f8f8f8"
      active-text-color="#00a88e">

      <el-menu-item index="/grade/home">
        <span slot="title">年级管理</span>
      </el-menu-item>

      <el-menu-item index="/clazz/home">
        <span slot="title">班级管理</span>
      </el-menu-item>

      <el-menu-item index="/teacher/home">
        <span slot="title">老师管理</span>
      </el-menu-item>

      <el-menu-item index="/student/home">
        <span slot="title">学生管理</span>
      </el-menu-item>

      <el-menu-item index="/survey/home">
        <span slot="title">调查管理</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  data() {
  },
  name: "mynav"
}
</script>

<style scoped>
.mynav {
  width: 250px;
  float: left;
  text-align: center;
  height: 100%;
  background-color: #f8f8f8;
}
</style>
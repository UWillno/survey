<template>
  <div>
    <el-form :inline="true" :model="selectForm" class="demo-form-inline">
      <el-form-item label="编号">
        <el-input v-model="selectForm.id" placeholder="请输入老师编号"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="selectForm.teacherName" placeholder="请输入老师姓名"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select clearable v-model="selectForm.status" placeholder="请选择老师状态">
<!--        <el-option v-for="item in "-->
        </el-select>
        <el-form-item>
          <el-button type="primary" @click="">查询</el-button>
        </el-form-item>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectForm: {}
    }
  },
  name: "teacher"
}

</script>

<style scoped>

</style>
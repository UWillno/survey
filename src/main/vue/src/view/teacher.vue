<template>
  <div >
    <el-form ref="table" :inline="true" :model="selectForm" class="demo-form-inline">
      <el-form-item label="编号">
        <el-input clearable v-model="selectForm.id" placeholder="请输入老师编号"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input clearable v-model="selectForm.teacherName" placeholder="请输入老师姓名"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select clearable v-model="selectForm.status" placeholder="请选择老师状态">
          <el-option v-for="item in statusList" :key="item.id" :label="item.text" :value="item.id" />
        </el-select>
      </el-form-item>
      <el-form-item style="margin-left: 10px">
        <el-button type="primary" @click="selectTeacher">查询</el-button>
        <el-button type="success">新增</el-button>
      </el-form-item>
    </el-form>

    <el-table :data="teacherList" stripe style="width: auto" :height="700">
      <el-table-column label="序号" type="index" width="80" />
      <el-table-column prop="teacherName" type="姓名" width="180" />
      <el-table-column prop="gender" type="性别" width="180" />
      <el-table-column prop="bornday" type="出生日期" />
      <el-table-column prop="createTime" type="创建时间" />
      <el-table-column prop="status" type="状态" />
      <el-table-column prop="level" type="权限级别" />
      <el-table-column label="操作" width="200px">
        <el-button type="warning" @click="2">修改</el-button>
        <el-button type="danger" @click="1">删除</el-button>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
import teacherApi from "@/api/teacherApi";

export default {
  name: "teacher",
  data() {
    return {
      height: new Number,
      teacherList: [],
      statusList: [
        { id: 1, text: "正常" },
        { id: 2, text: "休假" },
        { id: 3, text: "离职" },
        { id: 4, text: "退休" },
      ],
      selectForm: {
        page: 1,
        size: 5
      }
    }
  },
  created() {
    this.selectTeacher();
  },
  mounted() {
    console.log(this.$refs.table.clientHeight);
    this.height = document.documentElement.scrollHeight
    console.log();
  },
  computed: {
    AutoHigh() {
      return
    }
  },
  methods: {
    selectTeacher() {
      // console.log(this.selectForm)
      teacherApi.list(this.selectForm)
        .then(({ data }) => {
          console.log(data)
          this.teacherList = data.data;
        })
    }
  },
  watch: {
    'document.documentElement.scrollHeight'(val) {
      console.log(val);
    }
  }
}

</script>

<style scoped>

</style>
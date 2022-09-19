<template>
  <div>
    <el-form
      ref="table"
      :inline="true"
      :model="selectForm"
      class="demo-form-inline"
    >
      <el-form-item label="编号">
        <el-input
          clearable
          v-model="selectForm.id"
          placeholder="请输入老师编号"
        ></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input
          clearable
          v-model="selectForm.teacherName"
          placeholder="请输入老师姓名"
        ></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select
          clearable
          v-model="selectForm.status"
          placeholder="请选择老师状态"
        >
          <el-option
            v-for="item in status"
            :key="item.id"
            :label="item.text"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item style="margin-left: 10px">
        <el-button type="primary" @click="selectTeacher">查询</el-button>
        <el-button type="success">新增</el-button>
      </el-form-item>
    </el-form>

    <el-table :data="teacherList" stripe style="width: auto" :height="600">
      <el-table-column label="序号" prop="id" width="80" />
      <el-table-column
        label="姓名"
        prop="teacherName"
        type="姓名"
        width="100"
      />
      <el-table-column label="性别" prop="gender" type="性别">
        <template slot-scope="scope">
          {{ sex.get(scope.row.gender)[0] }}
        </template>
      </el-table-column>
      <el-table-column
        label="出生日期"
        prop="bornday"
        type="出生日期"
        width="100"
      />
      <el-table-column
        label="创建时间"
        prop="createTime"
        type="创建时间"
        width="100"
      />
      <el-table-column label="状态" prop="status" type="状态">
        <template slot-scope="scope">
          <el-tag :type="statusList.get(scope.row.status)[0]">
            {{ statusList.get(scope.row.status)[1] }}</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column label="权限级别" prop="level" type="权限级别">
        <template slot-scope="scope">
          <el-tag :color="levellist.get(scope.row.level)[0]">
            {{ levellist.get(scope.row.level)[1] }}</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200px">
        <el-button type="warning" @click="2">修改</el-button>
        <el-button type="danger" @click="1">删除</el-button>
      </el-table-column>
    </el-table>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="selectForm.page"
        :page-size="selectForm.size"
        layout="total, prev, pager, next"
        :total="total"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import teacherApi from "@/api/teacherApi";

export default {
  name: "teacher",
  data() {
    return {
      total:"",
      teacherList: [],
      status: [
        { text: "正常", id: 1 },
        { text: "休假", id: 2 },
        { text: "离职", id: 3 },
        { text: "退休", id: 4 },
      ],
      sex: new Map([
        [1, ["男"]],
        [0, ["女"]],
      ]),
      statusList: new Map([
        [1, ["success", "正常"]],
        [2, ["", "休假"]],
        [3, ["warning", "离职"]],
        [4, ["danger", "退休"]],
      ]),
      levellist: new Map([
        [0, ["black", "初级"]],
        [1, ["pink", "中级"]],
        [2, ["bule", "高级"]],
      ]),
      selectForm: {
        page: 1,
        size: 8,
      },
    };
  },
  mounted() {
    this.selectTeacher();
  },
  computed: {
    AutoHigh() {
      return;
    },
  },
  methods: {
    selectTeacher() {
      teacherApi.select(this.selectForm).then(({ data }) => {
        console.log(data);
        this.teacherList = data.data.list;
        this.total=data.data.total
      });
      this.selectForm = {
        page: 1,
        size: 5,
      };
    },
    handleSizeChange(value) {
      this.selectForm.size = value;
      this.selectTeacher();
    },
    handleCurrentChange(value) {
      this.selectForm.page = value;
      this.selectTeacher();
    },
  },
};
</script>

<style scoped>
</style>

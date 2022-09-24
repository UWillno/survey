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
        <el-button type="success" @click="(show = true), (teacher = {})"
          >新增</el-button
        >
      </el-form-item>
    </el-form>

    <el-table :data="teacherList" stripe style="width: auto" :height="600">
      <el-table-column type="index" :index="getIndex" label="序号" width="80" />
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
          <el-tag    effect="dark" :type="levellist.get(scope.row.level)[0]">
            {{ levellist.get(scope.row.level)[1] }}</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200px">
        <template slot-scope="scope">
          <el-button
            type="warning"
            @click="(show = true), (teacher = { ...scope.row })"
            >修改</el-button
          >
          <el-popconfirm
            @confirm="deleteTeacher(scope.row.id)"
            confirm-button-text="好的"
            cancel-button-text="取消"
            icon="el-icon-info"
            icon-color="red"
            :title="`是否删除${scope.row.teacherName}信息？`"
          >
            <el-button slot="reference">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      :selectForm="selectForm"
      :total="this.selectForm.total"
      @changesize="selectchile"
    />
    <teacherFrom
      :show.sync="show"
      :data-list="teacher"
      @selectchile="selectchile"
      :status="status"
    />
  </div>
</template>

<script>
import teacherApi from "@/api/teacherApi";
import teacherFrom from "./teacherFrom.vue";
import Pagination from "../../components/pagination.vue";
import { selectForm } from "@/minxins";
export default {
  mixins: [selectForm],
  components: { teacherFrom, Pagination },
  name: "teacher",
  data() {
    return {
      teacher: {},
      show: false,
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
        [0, ["danger", "管理员"]],
        [1, ["success", "老师"]],
      ]),
    };
  },
  mounted() {
    this.selectTeacher();
  },
  methods: {
    selectTeacher() {
      teacherApi.select(this.newFrom).then(({ data }) => {
        this.teacherList = data.data.list;
        this.selectForm.total = parseInt(data.data.total);
      });
    },
    selectchile(val = this.selectForm.page) {
      this.selectForm.page = val;
      this.selectTeacher();
    },
    async deleteTeacher(id) {
      try {
        let { data } = await teacherApi.delete(id);
        if (data.code === 200) {
          this.$messge["Messages"].success("删除成功");
          this.selectTeacher();
        }
      } catch (error) {
        this.$messge["Notifys"].error(error);
      }
    },
  },
};
</script>

<style scoped>
.block {
  height: 10px;
}
</style>

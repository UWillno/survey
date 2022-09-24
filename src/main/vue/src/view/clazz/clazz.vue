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
          placeholder="请输入班级编号"
        ></el-input>
      </el-form-item>
      <el-form-item label="名称">
        <el-input
          clearable
          v-model="selectForm.className"
          placeholder="请输入班级名称"
        ></el-input>
      </el-form-item>
      <el-form-item label="年级">
        <el-select
          clearable
          v-model="selectForm.gradeId"
          placeholder="请选择年级"
        >
          <el-option
            v-for="item in gradeList"
            :key="item.id"
            :label="item.gradeName"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item style="margin-left: 10px">
        <el-button type="primary" @click="selectClazz">查询</el-button>
        <el-button type="success" @click="(show = true), (clazz = {})"
          >新增
        </el-button>
      </el-form-item>
    </el-form>

    <el-table :data="clazzList" stripe style="width: auto">
      <el-table-column type="index" :index="getIndex" label="序号">
      </el-table-column>
      <el-table-column prop="className" label="班级名称"> </el-table-column>
      <el-table-column prop="createTime" label="创建时间"> </el-table-column>
      <el-table-column prop="teacherList" label="代班老师">
        <template v-slot="scope">
          <el-tag
            v-for="tag in scope.row.teacherList"
            :key="tag.id"
            closable
            @close="removeTeacher(scope.row.id, tag.id)"
          >
            {{ tag.teacherName }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="count" label="班级人数"> </el-table-column>
      <el-table-column prop="status" label="状态">
        <template v-slot="scope">
          <el-tag v-if="scope.row.status === 1">正常</el-tag>
          <el-tag v-if="scope.row.status === 2" type="success">实习</el-tag>
          <el-tag v-if="scope.row.status === 3" type="warning">毕业</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template v-slot="scope">
          <el-button
            size="mini"
            type="warning"
            @click="
              show = true;
              clazz = { ...scope.row };
            "
            >修改</el-button
          >
          <el-popconfirm
            @confirm="deleteClazz(scope.row.id)"
            confirm-button-text="确定"
            cancel-button-text="取消"
            confirm-button-type="danger"
            cancel-button-type="success"
            icon="el-icon-info"
            icon-color="red"
            :title="'确定要删除[' + scope.row.className + ']班级吗？'"
          >
            <el-button slot="reference" size="mini" type="danger"
              >删除</el-button
            >
          </el-popconfirm>
          <el-button
            size="mini"
            type="primary"
            @click="(showTeacher = true), (cid = scope.row.id)"
            >设置代班老师</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      style="height: 20px"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="selectForm.page"
      :page-size="selectForm.size"
      layout="total, prev, pager, next"
      :total="selectForm.total"
    >
    </el-pagination>
    <clazzFrom :show.sync="show" :dataList="clazz" @selectchile="selectchile" />
    <select-teacher
      :show.sync="showTeacher"
      :cid="cid"
      @selectchile="selectchile"
    />
  </div>
</template>

<script>
import { mapState } from "vuex";
import clazzTeacherApi from "@/api/clazzTeacherApi";
import clazzApi from "@/api/clazzApi";
import clazzFrom from "./clazzFrom.vue";
import SelectTeacher from "./selectTeacher.vue";
export default {
  components: { clazzFrom, SelectTeacher },
  name: "clazz",
  data() {
    return {
      clazz: [],
      clazzList: [],
      showTeacher: false,
      show: false,
      cid: "",
      selectForm: {
        page: 1,
        size: 8,
        total: 0,
      },
    };
  },
  mounted() {
    this.selectClazz();
    this.$store.dispatch("selectGrade");
  },
  computed: {
    ...mapState(["gradeList"]),
    newFrom() {
      for (const iterator in this.selectForm) {
        if (this.selectForm[iterator] === "") {
          delete this.selectForm[iterator];
        }
      }
      return this.selectForm;
    },
  },
  methods: {
    async removeTeacher(cid, tid) {
      console.log(cid, tid);
      try {
        let { data } = await clazzTeacherApi.removeTeacher(cid, tid);
        if (data.code === 200) {
          this.$messge["Messages"].success("添加成功");
          this.selectClazz();
        }
      } catch (error) {
        this.$messge["Notifys"].error(error);
      }
    },
    getIndex(value) {
      return (this.selectForm.page - 1) * this.selectForm.size + value + 1;
    },
    selectClazz() {
      console.log(this.newFrom);
      clazzApi.select(this.newFrom).then(({ data }) => {
        this.clazzList = data.data.list;
        this.selectForm.total = parseInt(data.data.total);
      });
    },
    deleteClazz(id) {
      clazzApi
        .delete(id)
        .then(({ data }) => {
          this.$messge["Messages"].success("删除成功");
          this.selectClazz();
        })
        .catch((error) => {
          this.$messge["Notifys"].error(error);
        });
    },
    handleSizeChange(value) {
      this.selectForm.size = value;
      this.selectClazz();
    },
    handleCurrentChange(value) {
      console.log(value);
      this.selectForm.page = value;
      this.selectClazz();
    },
    selectchile() {
      this.selectClazz();
    },
  },
};
</script>

<style scoped></style>

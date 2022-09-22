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
        </el-button
        >
      </el-form-item>
    </el-form>

    <el-table :data="clazzList" stripe style="width: auto">
      <el-table-column type="index" :index="getIndex" label="序号" width="80">
      </el-table-column>
      <el-table-column prop="className" label="班级名称" width="180">
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间">
      </el-table-column>
       <el-table-column prop="teacherList" label="代班老师" >
     <template slot-scope="scope">
       <el-tag v-for="item in scope.row.teacherList"
       :key="item.teacherName" closable type="danger"
       >{{item.teacherName}}</el-tag>
     </template>
       </el-table-column>
      <el-table-column prop="count" label="班级人数">
      </el-table-column>
      <el-table-column prop="status" label="状态">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status === 1">正常</el-tag>
          <el-tag v-if="scope.row.status === 2" type="success">实习</el-tag>
          <el-tag v-if="scope.row.status === 3" type="warning">毕业</el-tag>

        </template>
      </el-table-column>

      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <el-button style="mini" type="warning" @click="dialogFormVisible=true;clazz=scope.row">修改</el-button>
          <el-popconfirm
              @confirm="deleteClazz(scope.row.id)"
              confirm-button-text="确定"
              cancel-button-text="取消"
              confirm-button-type="danger"
              cancel-button-type="success"
              icon="el-icon-info"
              icon-color="red"
              :title="'确定要删除['+scope.row.className+']班级吗？'">
            <el-button slot="reference" style="mini;margin-left: 10px" type="danger">删除</el-button>
          </el-popconfirm>
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
        :total="total"
    >
    </el-pagination>
    <insert-clazz
        :show.sync="show"
        :clazz="clazz"
        @selectchile="selectchile"
    />
  </div>
</template>

<script>
import clazzApi from "@/api/clazzApi";
import insertClazz from "./insertClazz.vue";
import gradeApi from "@/api/gradeApi.js";

export default {
  components: {insertClazz},
  name: "clazz",
  data() {
    return {
      gradeList: [],
      clazz: {},
      show: false,
      total: "",
      clazzList: [],
      selectForm: {
        page: 1,
        size: 4,
      },
    };
  },
  mounted() {
    this.selectClazz();
  },
  computed: {
    AutoHigh() {
      return;
    },
  },
  created() {
    this.selectGrade();
  },
  methods: {
    selectGrade() {
      gradeApi.gradeList()
          .then(({data}) => {
            if (data.data) {
              this.gradeList = data.data;
            }
          })
    },
    getIndex(value) {
      return (this.selectForm.page - 1) * this.selectForm.size + value + 1;
    },
    selectClazz() {
      clazzApi.select(this.selectForm).then(({data}) => {
        this.clazzList = data.data.list;
        this.total = data.data.total;
      });
      this.selectForm = {
        page: 1,
        size: 4,
      };
    },
    deleteClazz(id) {
      clazzApi.delete(id)
          .then(({data}) => {
            this.$message({
              message: '删除成功',
              type: 'success',
              duration: 1000
            });
            this.selectClazz();
          })
    },
    handleSizeChange(value) {
      this.selectForm.size = value;
      this.selectClazz();
    },
    handleCurrentChange(value) {
      this.selectForm.page = value;
      this.selectClazz();
    },
    selectchile() {
      this.selectClazz();
    },
  },
};
</script>

<style scoped>
.block {
  height: 10px;
}
</style>

<template>
  <div>
    <el-form :inline="true" :model="selectForm" class="demo-form-inline">
      <el-form-item label="编号">
        <el-input clearable v-model="selectForm.id" placeholder="请输入老师编号"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input clearable v-model="selectForm.teacherName" placeholder="请输入老师姓名"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select clearable v-model="selectForm.status" placeholder="请选择老师状态">
          <el-option v-for="item in statusList" :key="item.id" :label="item.text" :value="item.id"/>
        </el-select>

        <el-form-item style="margin-left: 10px">
          <el-button type="primary" @click="selectTeacher()">查询</el-button>
          <el-button type="success" @click="teacher={},dialogFormVisible = true">新增</el-button>
        </el-form-item>
      </el-form-item>
    </el-form>

    <el-table :data="teacherList" stripe style="width: auto">
      <el-table-column label="序号" type="index" :index="getIndex" width="80"/>
      <el-table-column label="姓名" prop="teacherName" type="姓名" width="140"/>
      <el-table-column label="性别" prop="gender" type="性别" width="80">
        <template slot-scope="scope">
          <p v-if="scope.row.gender===1">男</p>
          <p v-if="scope.row.gender===0">女</p>
        </template>
      </el-table-column>
      <el-table-column prop="bornday" label="出生日期" type="出生日期"/>
      <el-table-column prop="createTime" type="创建时间" label="创建时间"/>
      <el-table-column prop="status" type="状态" label="状态">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status===1" type="success">正常</el-tag>
          <el-tag v-if="scope.row.status===2" type="success">休假</el-tag>
          <el-tag v-if="scope.row.status===3" type="success">离职</el-tag>
          <el-tag v-if="scope.row.status===4" type="success">退休</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="level" label="权限级别" type="权限级别">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status===0" type="success">管理员</el-tag>
          <el-tag v-else-if="scope.row.status===1" type="success">老师</el-tag>
          <el-tag v-else type="warning">其他</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200px">
        <template slot-scope="scope">
          <el-button type="warning" @click="dialogFormVisible = true,teacher=scope.row">修改</el-button>
          <el-popconfirm
              @confirm="deleteTeacher(scope.row.id)"
              confirm-button-text="确定"
              cancel-button-text="取消"
              confirm-button-type="danger"
              cancel-button-type="success"
              icon="el-icon-info"
              icon-color="red"
              :title="'确定要删除[ '+scope.row.teacherName+' ]老师吗？'">
            <el-button slot="reference" type="danger" style="margin-left: 10px"
                       @click="deleteTeacher(scope.row.id)">删除
            </el-button>
          </el-popconfirm>

        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        small
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-sizes="[5,10,20,30,40,50,100]"
        :page-size="selectForm.size"
        layout="prev, pager, next"
        :current-page="selectForm.page"
        :total="total">
    </el-pagination>

    <el-dialog :title="teacher.id?'修改':'新增'" :visible.sync="dialogFormVisible" width="30%">
      <el-form :model="teacher">
        <!--        <el-form-item label="编号" :label-width="formLabelWidth">-->
        <!--          <el-input v-model="teacher.id" autocomplete="off"></el-input>-->
        <!--        </el-form-item>-->
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="teacher.teacherName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth">
          <el-input v-model="teacher.gender" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" :label-width="formLabelWidth">
          <el-input v-model="teacher.phonenumber" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="生日" :label-width="formLabelWidth">
          <el-input v-model="teacher.bornday" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="teacher.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="状态" :label-width="formLabelWidth">
          <el-input v-model="teacher.status" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible=false,teacher={}">取 消</el-button>
        <el-button typeof="primary" @click="editTeacher()">确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>
import teacherApi from "@/api/teacherApi";

export default {
  data() {
    return {
      formLabelWidth: "100px",
      dialogFormVisible: false,
      teacher: {},
      total: 0,
      teacherList: [],
      statusList: [
        {id: 1, text: "正常"},
        {id: 2, text: "休假"},
        {id: 3, text: "离职"},
        {id: 4, text: "退休"},
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
  methods: {
    selectForm_reset() {
      this.selectForm = {page: this.selectForm.page, size: this.selectForm.size};
    },
    selectTeacher() {
      teacherApi.select(this.selectForm)
          .then(({data}) => {
            console.log(data)
            this.total = data.data.total;
            this.teacherList = data.data.list;
            this.selectForm_reset();
          })
    },
    handleSizeChange(value) {
      this.selectForm.size = value;
      this.selectTeacher();
    },
    handleCurrentChange(value) {
      this.selectForm.page = value;
      this.selectTeacher();
    },
    getIndex(value) {
      return (this.selectForm.page - 1) * this.selectForm.size + value + 1
    },
    editTeacher() {
      if (this.teacher.id) {
        teacherApi.update(this.teacher).then(data => {
          this.$message({
            message: "修改成功！",
            type: 'success',
            duration: 1000
          });
          this.selectTeacher();
          this.teacher = {};
        })
      } else {
        teacherApi.insert(this.teacher).then(data => {
          this.$message({
            message: "新增成功！",
            type: 'success',
            duration: 1000
          });
          this.selectTeacher();
          this.teacher = {};

        });
      }
      this.dialogFormVisible = false;
    },
    deleteTeacher(tid) {
      teacherApi.delete(tid);
      this.selectTeacher();
    },
    name: "teacher"
  }
}

</script>

<style scoped>
::v-deep .el-pagination.is-background .el-pager li:not(.disabled).active {
  background-color: #23d1ae;
}
</style>
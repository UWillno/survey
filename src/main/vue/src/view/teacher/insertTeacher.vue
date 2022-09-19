<template>
  <div class="InsertT">
    <el-dialog
      :title="teacher.id ? '修改' : '新增'"
      :visible.sync="dialogVisible"
      width="35%"
      @close="$emit('update:show', false)"
      :before-close="handleClose"
    >
      <el-form label-width="80px" :model="teacher">
        <el-form-item label="姓名">
          <el-input v-model="teacher.teacherName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="teacher.gender" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="teacher.phonenumber" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="生日">
          <el-input v-model="teacher.bornday" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="teacher.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-input v-model="teacher.status" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button v-if="teacher.id" type="primary" @click="inserTeacher"
          >修改</el-button
        >
        <el-button v-else type="primary" @click="inserTeacher">添加</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import teacherApi from "@/api/teacherApi";
export default {
  name: "inserT",
  props: ["show", "teacher"],
  data() {
    return {
      dialogVisible: false,
    };
  },
  methods: {
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },
    async inserTeacher() {
      console.log(this.teacher);
      try {
        let { data } = await teacherApi.update(this.teacher);
        if (data.code == 200) {
          this.$emit("selectchile");
          this.$message({
            message: "修改成功",
            type: "success",
          });
          this.dialogVisible = false;
        }
        console.log(data);
      } catch (error) {
        alert(error);
      }
    },
  },
  watch: {
    show(val) {
      this.dialogVisible = val;
    },
  },
};
</script>
<style scoped>
</style>
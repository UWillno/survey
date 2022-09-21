<template>
  <div class="InsertT">
    <el-dialog
      :title="clazz.id ? '修改' : '新增'"
      :visible.sync="dialogVisible"
      width="35%"
      @close="$emit('update:show', false)"
      :before-close="handleClose"
    >
      <el-form label-width="80px" :model="clazz">
        <el-form-item label="班级名称">
          <el-input v-model="clazz.className" autocomplete="off"></el-input>
        </el-form-item>
		<el-form-item label="班级id">
		  <el-input v-model="clazz.gradeId" autocomplete="off"></el-input>
		</el-form-item>
        <el-form-item label="状态">
          <el-input v-model="clazz.status" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button v-if="clazz.id" type="primary" @click="updataClazz"
          >修改</el-button
        >
        <el-button v-else type="primary" @click="inserClazz">添加</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import clazzApi from "@/api/clazzApi";
export default {
  name: "inserT",
  props: ["show", "clazz"],
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
    async updataClazz() {
      try {
        let { data } = await clazzApi.update(this.clazz);
        if (data.code == 200) {
          this.$emit("selectchile");
          this.$message({
            message: "修改成功",
            type: "success",
          });
          this.dialogVisible = false;
        }
      } catch (error) {
        alert(error);
      }
    },
    async inserClazz() {
      try {
        let { data } = await clazzApi.insert(this.clazz);
        if (data.code == 200) {
          this.$emit("selectchile");
          this.$message({
            message: "修改成功",
            type: "success",
          });
          this.dialogVisible = false;
        }
      } catch (error) {
        console.log(error);
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
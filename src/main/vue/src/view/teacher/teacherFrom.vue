<template>
  <div class="InsertT">
    <el-dialog
      :title="dataList.id ? '修改' : '新增'"
      :visible.sync="dialogVisible"
      width="35%"
      @close="$emit('update:show', false)"
      :before-close="handleClose"
    >
      <el-form label-width="80px" :model="dataList">
        <el-form-item label="姓名">
          <el-input
            v-model="dataList.teacherName"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio v-model="dataList.gender" :label="1">男</el-radio>
          <el-radio v-model="dataList.gender" :label="0">女</el-radio>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input
            v-model="dataList.phonenumber"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="生日">
          <el-input
            v-model="dataList.bornday"
            autocomplete="off"
            type="date"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="dataList.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-select
            clearable
            v-model="dataList.status"
            placeholder="请选择状态"
          >
            <el-option
              v-for="item in status"
              :key="item.id"
              :label="item.text"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button v-if="dataList.id" type="primary" @click="operate('update')"
          >修改</el-button
        >
        <el-button v-else type="primary" @click="operate('insert')"
          >添加</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import teacherApi from "@/api/teacherApi";
import { DialogShow } from "@/minxins";

export default {
  mixins: [DialogShow],
  name: "teacherFrom",
  props: ["dataList", "status"],
  data() {
    return {
      dialogVisible: false,
    };
  },
  methods: {
    async operate(type) {
      try {
        let { data } =
          type === "insert"
            ? await teacherApi.insert(this.dataList)
            : await teacherApi.update(this.dataList);
        if (data.code === 200) {
          this.$emit("selectchile");
          this.$messge["Messages"].success("修改成功");
          this.dialogVisible = false;
        }
      } catch (error) {
        this.$messge["Notifys"].error(error);
      }
    },
  },
};
</script>
<style scoped></style>

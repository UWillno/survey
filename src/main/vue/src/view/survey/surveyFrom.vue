<template>
  <div class="surveyFrom">
    <el-dialog
      :title="dataList.id ? '修改' : '新增'"
      :visible.sync="dialogVisible"
      width="35%"
      @close="$emit('update:show', false)"
      :before-close="handleClose"
    >
      <el-form label-width="80px" :model="dataList">
        <el-form-item label="调查内容">
          <el-input v-model="dataList.surveyText" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分值">
          <el-input
            v-model="dataList.score"
            type="number"
            min="1"
            max="10"
            autocomplete="off"
          ></el-input>
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
import { DialogShow } from "@/minxins";
import surevyApi from "@/api/surevyApi"
export default {
  mixins: [DialogShow],
  name: "surveyFrom",
  props: ["dataList"],
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
            ? await surevyApi.insert(this.dataList)
            : await surevyApi.update(this.dataList);
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

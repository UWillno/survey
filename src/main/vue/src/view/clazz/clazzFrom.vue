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
        <el-form-item label="班级名称">
          <el-input v-model="dataList.className" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="年级">
          <el-input v-model="dataList.gradeId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-select
            clearable
            v-model="dataList.status"
            placeholder="请选择状态"
          >
            <el-option
              v-for="item in statusList"
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
import clazzApi from "@/api/clazzApi";
import { DialogShow } from "@/minxins";

export default {
  mixins: [DialogShow],
  name: "classFrom",
  props: ["dataList"],
  data() {
    return {
      dialogVisible: false,
      statusList: [
        { text: "正常", id: 1 },
        { text: "实习", id: 2 },
        { text: "毕业", id: 3 },
      ],
    };
  },
  methods: {
    async operate(type) {
      try {
        let { data } =
          type === "insert"
            ? await clazzApi.insert(this.dataList)
            : await clazzApi.update(this.dataList);
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
<style scoped>
</style>
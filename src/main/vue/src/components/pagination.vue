<template>
  <div id="pagination">
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
  </div>
</template>

<script>
export default {
  name: "pagination",
  props: ["selectForm", "total"],
  data() {
    return {
      page: this.selectForm.page,
    };
  },
  methods: {
    handleSizeChange(value) {
      this.selectForm.size = value;
    },
    handleCurrentChange(value) {
      this.page = value;
    },
  },
  watch: {
    page(val) {
      console.log(val);
      this.$emit("changesize", val);
    },
  },
};
</script>

<style scoped>
</style>
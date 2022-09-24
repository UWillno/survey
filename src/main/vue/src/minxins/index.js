const DialogShow = {
  props: ["show"],
  data() {},
  methods: {
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },
  },
  watch: {
    show(val) {
      console.log(val);
      this.dialogVisible = val;
    },
  },
};
const selectForm = {
  data() {
    return {
      selectForm: {
        page: 1,
        size: 8,
        total: 0,
      },
    };
  },
  computed: {
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
    getIndex(value) {
      return (this.selectForm.page - 1) * this.selectForm.size + value + 1;
    },
  },
};
export { selectForm, DialogShow };

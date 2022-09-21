export default {
    props: ["show"],
    data() {
        return {
            dialogVisible: false,
        }
    },
    methods: {
        handleClose(done) {
            this.$confirm("确认关闭？")
                .then((_) => {
                    done();
                })
                .catch((_) => {
                });
        },
    },
    watch: {
        show(val) {
            this.dialogVisible = val;
        },
    }
}
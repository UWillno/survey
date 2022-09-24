<template>
  <div id="survey">
    <el-form
      ref="table"
      :inline="true"
      :model="selectForm"
      class="demo-form-inline"
    >
      <el-form-item>
        <el-input
          clearable
          v-model="selectForm.surveyText"
          placeholder="请输入要查询的内容"
        ></el-input>
      </el-form-item>
      <el-form-item style="margin-left: 10px">
        <el-button type="primary" @click="selectSurvey">查询</el-button>
        <el-button type="success" @click="(show = true), (survey = {})"
          >新增
        </el-button>
      </el-form-item>
    </el-form>
    <!-- 表格 -->
    <el-table :data="surveyList" stripe>
      <el-table-column type="index" :index="getIndex" label="序号">
      </el-table-column>
      <el-table-column prop="surveyText" label="调查内容"> </el-table-column>
      <el-table-column prop="score" label="分值"> </el-table-column>
      <el-table-column prop="createTime" label="创建时间"> </el-table-column>
      <el-table-column label="是否启动">
        <template v-slot="scope">
          <el-switch
            v-model="scope.row.checked"
            :active-value="1"
            :inactive-value="0"
            active-color="#13ce66"
            inactive-color="#eaecf0"
            @change="changeSwitch(scope.row)"
          >
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template v-slot="scope">
          <el-button
            size="mini"
            type="warning"
            @click="
              show = true;
              survey = { ...scope.row };
            "
            >修改</el-button
          >
          <el-Popconfirm 
            @confirm="deleteSurvey(scope.row.id)"
            confirm-button-text="确定"
            cancel-button-text="取消"
            confirm-button-type="danger"
            icon="el-icon-info"
            icon-color="red"
            :title="`确定要删除“${scope.row.surveyText}”这个问题`"
          >
            <el-button slot="reference" size="mini" type="danger"
              >删除</el-button
            >
          </el-Popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <survey-from
      :dataList="survey"
      :show.sync="show"
      @selectchile="selectchile"
    />
    <pagination
      :selectForm="selectForm"
      :total="selectForm.total"
      @changesize="selectchile"
    />
  </div>
</template>

<script>
import surevyApi from "@/api/surevyApi";
import { selectForm } from "@/minxins";
import pagination from "../../components/pagination.vue";
import SurveyFrom from "./surveyFrom.vue";
export default {
  components: { pagination, SurveyFrom },
  mixins: [selectForm],
  name: "survey",
  data() {
    return {
      survey: {},
      show: false,
      surveyList: [],
    };
  },
  mounted() {
    this.selectSurvey();
  },
  methods: {
    async changeSwitch(val) {
      console.log(val);
      try {
        let { data } = await surevyApi.update(val);
        if (data.code === 200) {
          this.$emit("selectchile");
          this.$messge["Messages"].success("修改成功");
          this.dialogVisible = false;
        }
      } catch (error) {
        this.$messge["Notifys"].error(error);
      }
    },
    selectSurvey() {
      surevyApi.select(this.newFrom).then(({ data }) => {
        console.log(data);
        this.surveyList = data.data.list;
        this.selectForm.total = parseInt(data.data.total);
      });
    },
    selectchile(val = this.selectForm.page) {
      this.selectForm.page = val;
      this.selectSurvey();
    },
    async deleteSurvey(id) {
      try {
        let { data } = await surevyApi.delete(id);
        if (data.code === 200) {
          this.$messge["Messages"].success("删除成功");
          this.selectSurvey();
        }
      } catch (error) {
        this.$messge["Notifys"].error(error);
      }
    },
  },
};
</script>

<style></style>

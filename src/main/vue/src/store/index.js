import Vue from "vue";
import vuex from "vuex";
import gradeApi from "@/api/gradeApi.js";
Vue.use(vuex);
export default new vuex.Store({
  state: {
    gradeList: [],
  },
  mutations: {
    GradeList(state, payload) {
      state.gradeList = payload;
    },
  },
  actions: {
    selectGrade({ commit }) {
      gradeApi.gradeList().then(({ data }) => {
        console.log(data);
        if (data.data) {
          commit("GradeList", data.data);
        }
      });
    },
  },
});

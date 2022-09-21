import Vue from "vue";
import VueRouter from "vue-router";
import layout from "@/components/layout";
import login from "@/components/login";

const teacher = () => import("@/view/teacher/teacher");
const student = () => import("@/view/student");
const clazz = () => import("@/view/clazz/clazz");
const grade = () => import("@/view/grade");
const survey = () => import("@/view/survey");

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: "/",
      redirect: "/manager/login",
    },
    {
      path: "/manager/login",
      component: login,
    },
    {
      path: "/manager/home",
      component: layout,
      children: [
        {
          path: "/",
          redirect: "/grade/home",
        },
        {
          path: "/grade/home",
          component: grade,
          name: "grade",
        },
        {
          path: "/clazz/home",
          component: clazz,
          name: "clazz",
        },
        {
          path: "/teacher/home",
          component: teacher,
          name: "teacher",
        },
        {
          path: "/student/home",
          component: student,
          name: "student",
        },
        {
          path: "/survey/home",
          component: survey,
          name: "survey",
        },
      ],
    },
  ],
});

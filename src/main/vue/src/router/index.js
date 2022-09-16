import Vue from 'vue'
import VueRouter from 'vue-router'
import layout from "@/components/layout";
import login from "@/components/login";
import teacher from "@/components/teacher";
import student from "@/components/student";
import clazz from "@/components/clazz";
import grade from "@/components/grade";
import survey from "@/components/survey";

Vue.use(VueRouter)

export default new VueRouter({

    routes: [
        {
            path: "/",
            redirect: "/manager/login"
        },
        {
            path: "/manager/login",
            component: login
        },
        {
            path:"/manager/home",
            component:layout,
            children:[
                {
                    path:"/",
                    redirect:"/grade/home"
                },
                {
                    path:"/grade/home",
                    component:grade
                },
                {
                    path:"/clazz/home",
                    component:clazz
                },
                {
                    path:"/teacher/home",
                    component:teacher
                },
                {
                    path:"/student/home",
                    component:student
                },
                {
                    path:"/survey/home",
                    component:survey
                }
            ]
        }
    ]

})
import Vue from 'vue'
import VueRouter from 'vue-router'
import layout from "@/components/layout";
import login from "@/components/login";

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
            component:layout
        }
    ]

})
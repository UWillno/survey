import Vue from "vue";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import VueCookie from "vue-cookie";
import App from "./App.vue";
import router from "@/router";
import store from "./store";
import * as Message from "@/utils/message";
Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.use(VueCookie);

new Vue({
  router,
  store,
  render: (h) => h(App),
  beforeCreate() {
    Vue.prototype.$messge = Message;
  },
  // el: '#app',
  // render: h => h(App)
}).$mount("#app");

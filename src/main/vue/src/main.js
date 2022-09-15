import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueCookie from 'vue-cookie'
import App from './App.vue';
import router from "@/router";

Vue.config.productionTip=false
Vue.use(ElementUI);
Vue.use(VueCookie)

new Vue({
  router,
  render:h=>h(App),
  // el: '#app',
  // render: h => h(App)
}).$mount('#app')
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import App from "./App";
import router from "./router";
import store from "./store";
import i18n from "./il8n/il8n";
import "font-awesome/css/font-awesome.min.css";
import "../static/assets/icon/iconfont.css";

// 配置axios
import axios from "axios";

// 引入Element UI
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import models from "./model/models";
// require('./mock/index');
// import * as mock from "./mock/index.js";
import { Message } from "element-ui";

// Vue.use(mock);
Vue.config.productionTip = false;

Vue.use(ElementUI);

Vue.prototype.models = models;
Vue.prototype.$message = Message;
/* eslint-disable no-new */
new Vue({
  el: "#app",
  i18n,
  router,
  store,
  components: {
    App,
  },
  template: "<App/>",
});

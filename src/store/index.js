import Vue from "vue";
import Vuex from "vuex";
import moveBox from "./modules/moveBox";
import Login from "./modules/login";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    moveBox,
    Login,
  },
});

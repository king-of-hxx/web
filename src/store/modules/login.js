import { getToken } from "@/utils/auth.js";
export default {
  namespaced: true,
  state: {
    token: getToken(),
  },
  getters: {},
  actions: {},
  mutations: {},
};

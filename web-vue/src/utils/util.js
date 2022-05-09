import cookie from "js-cookie";
import router from '../router'
import Vue from "vue";
//向上取整
export function takeUpWhole(value, upValue) {
  if (!upValue)
    upValue = 1
  return Math.ceil(value / upValue) * upValue;
}

export function logout() {
  cookie.remove("token");
  cookie.remove("refreshToken");
  Vue.prototype.$message({
    message: "用户注销成功",
    type: 'success'
  });
  toLogin();
}

export function toLogin() {
  router.push({
    name: "Login",
  });
}

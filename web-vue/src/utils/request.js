import axios from "axios";
import Vue from "vue";
import { openLoading, closeLoading } from "./loading";

const service = axios.create({
  // baseURL: process.env.baseUrl,
  baseURL: "/api",
  timeout: 5000,
});

// request拦截器
service.interceptors.request.use(
  (config) => {
    openLoading();
    if (config.baseURL) {
      config.headers["Content-Type"] = "application/json;";
      config.headers["Access-Control-Allow-Origin"] = "*";
      // config.headers["Authorization"] = "Bearer " + cookie.get("token");
      // config.headers["RefreshToken"] = "Bearer " + cookie.get("refreshToken");
    }
    if (config.ContentType) config.headers["Content-Type"] = config.ContentType;
    return config;
  },
  (error) => {
    closeLoading();
    Promise.reject(error).then(() => console.error(error));
  }
);

// 响应拦截器
service.interceptors.response.use(
  (res) => {
    closeLoading();
    const { success, message, data } = res.data;
    if (success) {
      return data;
    } else {
      Vue.prototype.$message.error(message);
      return Promise.reject(new Error(message));
    }
    // let msgType = undefined;
    // if (res.config.baseURL) {
    //   if (res.data.status != 200) msgType = "error";
    //   else msgType = "success";
    // }
    // if (msgType && res.data.message)
    //   Vue.prototype.$message({
    //     dangerouslyUseHTMLString: true,
    //     message: res.data.message,
    //     type: msgType,
    //   });
  },
  (error) => {
    closeLoading();
    Vue.prototype.$message.error(error.message);
    // Vue.prototype.$message({
    //   message: error.message,
    //   type: "error",
    // });
    return Promise.reject(error);
  }
);

export default service;

// export function argsToParams(func, argument) {
//   let param = {};
//   let args = getFuncArgs(func);
//   for (var i = 0; i < argument.length; i++) {
//     console.info(args[i] + ":" + argument[i]);
//     param[args[i]] = argument[i];
//   }
//   return param;
// }

// export function getFuncArgs(func, argument) {
//   var args = func.toString().match(/function\s.*?\(([^)]*)\)/)[1];
//   return args
//     .split(",")
//     .map(function(arg) {
//       return arg.replace(/\/\*.*\*\//, "").trim();
//     })
//     .filter(function(arg) {
//       return arg;
//     });
// }

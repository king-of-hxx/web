import axios from "axios";
import { openLoading, closeLoading } from "./loading";

const instance = axios.create({
  // baseURL: process.env.baseUrl,
  baseURL: "/api",
  timeout: 5000,
});

// request拦截器
instance.interceptors.request.use(
  (config) => {
    openLoading();
    // if (getCookie() !== undefined) {
    //   config.headers["cookie"] = encodeURIComponent(getCookie());
    // }
    return config;
  },
  (err) => {
    closeLoading();
    return Promise.reject(err);
  }
);

//http response拦截器
instance.interceptors.response.use(
  (response) => {
    closeLoading();
    // const { code, message } = response.data;
    // if (code === 200) {
    return response;
    // } else {
    //   Message.error(message);
    //   // return Promise.reject(new Error(message));
    // }
  },
  (err) => {
    closeLoading();
    return Promise.reject(err);
  }
);

export default instance;

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

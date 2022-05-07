import request from "@/utils/request";

export function Login(userNumber, password) {
  return request({
    url: "/login",
    method: "post",
    params: {
      userNumber: userNumber,
      password: password,
    },
  });
}

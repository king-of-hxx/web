import request from "@/utils/request";

export function getAllUserList(data) {
  return request({
    url: "/allUserList",
    method: "post",
    data: data,
  });
}

import request from "@/utils/request";

export function upload(data) {
  return request({
    url: "/discover/upload",
    method: "post",
    headers: { "Content-Type": "multipart/form-data" },
    data,
  });
}

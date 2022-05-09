import request from "@/utils/request";

export function getAllUserList(data) {
  return request({
    url: "/allUserList",
    method: "post",
    data: data,
  });
}

export function addUser(data) {
  return request({
    url: "/addUser",
    method: "post",
    data: data,
  });
}

export function deleteUser(data) {
  return request({
    url: "/deleteUser",
    method: "post",
    data: data,
  });
}

export function updateUser(data) {
  return request({
    url: "/updateUser",
    method: "post",
    data: data,
  });
}

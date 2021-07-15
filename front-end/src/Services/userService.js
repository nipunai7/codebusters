import http from "./httpService";

const apiUrl = "https://wso2-devops-training.et.r.appspot.com/api";

export function registerUser(user) {
  return http.post(
    `https://wso2-devops-training.et.r.appspot.com/auth/register`,
    user
  );
}

export function getUser(userId) {
  return http.get(`${apiUrl}/user/listusers/${userId}`);
}

export function updateUser(userId, user) {
  return http.patch(`${apiUrl}/user/updateUser/${userId}`, user);
}

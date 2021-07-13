import http from "./httpService";

const apiUrl = "http://localhost:8080/api";

export function registerUser(user) {
  return http.post(`http://localhost:8080/auth/register`, user);
}

export function getUser(userId) {
  return http.get(`${apiUrl}/user/listusers/${userId}`);
}

export function updateUser(userId, user) {
  return http.patch(`${apiUrl}/user/updateUser/${userId}`, user);
}

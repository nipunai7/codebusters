import jwtDecode from "jwt-decode";
import http, { setJwt } from "./httpService";

const apiUrl = "http://localhost:8080/auth";

setJwt(getJwt());

export async function login(user) {
  const { data: jwt } = await http.post(`${apiUrl}/login`, user);
  localStorage.setItem("token", jwt);
}

export function logout() {
  localStorage.removeItem("token");
}

export function getCurrentUser() {
  try {
    const jwt = localStorage.getItem("token");
    return jwtDecode(jwt);
  } catch (error) {
    return null;
  }
}

export function loginWithJwt(jwt) {
  localStorage.setItem("token", jwt);
}

export function getJwt() {
  return localStorage.getItem("token");
}

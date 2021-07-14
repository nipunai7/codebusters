import jwtDecode from "jwt-decode";
import http, { setJwt } from "./httpService";

const apiUrl = "http://localhost:8080/auth";

setJwt(getJwt());

export async function login(user) {
  const { data } = await http.post(`${apiUrl}/login`, user);
  if (data.response.startsWith("Error:")) {
    throw new Error("Invalid Credentials");
  }
  localStorage.setItem("token", "Bearer " + data.response);
}

export function logout() {
  localStorage.removeItem("token");
}

export function getCurrentUser() {
  try {
    const jwt = localStorage.getItem("token");
    return jwtDecode(jwt.substring(7));
  } catch (error) {
    return null;
  }
}

export function loginWithJwt(data) {
  localStorage.setItem("token", "Bearer " + data.response);
}

export function getJwt() {
  return localStorage.getItem("token");
}

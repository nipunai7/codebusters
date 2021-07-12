import http from "./httpService";

const apiUrl = "http://localhost:8080/api";

const userId = "60e8ff1cf1434d597dfbd6cb";

export function getSensors() {
  return http.get(`${apiUrl}/${userId}/listsensors`);
}

export function getSensor(sensorId) {
  return http.get(`${apiUrl}/${userId}/listsensors/${sensorId}`);
}

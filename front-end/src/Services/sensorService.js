import http from "./httpService";

const apiUrl = "http://localhost:8080/api";

export function getSensors(userId) {
  return http.get(`${apiUrl}/${userId}/listsensors`);
}

export function getSensor(userId, sensorId) {
  return http.get(`${apiUrl}/${userId}/listsensors/${sensorId}`);
}

export async function getSensorName(userId, sensorId) {
  try {
    const { data: sensor } = await getSensor(userId, sensorId);
    return sensor.name;
  } catch (ex) {
    return null;
  }
}

export function addLightSensor(userId, sensor) {
  return http.post(`${apiUrl}/addSensor/${userId}/Light`, sensor);
}

export function addTempSensor(userId, sensor) {
  return http.post(`${apiUrl}/addSensor/${userId}/Temp`, sensor);
}

export function deleteSensor(userId, sensorId) {
  return http.delete(`${apiUrl}/${userId}/del/${sensorId}`);
}

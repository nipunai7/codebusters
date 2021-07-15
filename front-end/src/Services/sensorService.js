import http from "./httpService";

const apiUrl = "https://wso2-devops-training.et.r.appspot.com/api";

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

export function updateSensor(userId, sensorId, sensor) {
  return http.patch(`${apiUrl}/${userId}/update/all/${sensorId}`, sensor);
}

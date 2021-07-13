import http from "./httpService";

const apiUrl = "http://localhost:8080/api";

export function getMails() {
  return http.get(`${apiUrl}/user/emailtable`);
}

export async function getMailsOfSensor(sensorId) {
  const { data: mails } = await getMails();
  const mailsOfSensor = mails.filter(m => m.sensorId === sensorId);
  return mailsOfSensor;
}

import axios from "axios";

export function setJwt(jwt) {
  axios.defaults.headers.common["Authorization"] = jwt;
}

// eslint-disable-next-line import/no-anonymous-default-export
export default {
  get: axios.get,
  post: axios.post,
  put: axios.put,
  delete: axios.delete,
  patch: axios.patch
};

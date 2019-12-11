import axios from "axios";

const setJWTToken = token => {
  if (token) {
    axios.defaults.headers.common["Autorization"] = token;
  } else {
    delete axios.defaults.headers.common["Autorization"];
  }
};
export default setJWTToken;

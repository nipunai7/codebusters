import React from "react";
import { Switch, Route, Redirect } from "react-router-dom";
import Header from "./components/header";
import Login from "./components/login.component";
import SignUp from "./components/signup.component";
import SensorDetails from "./components/sensorDetails";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

function App() {
  return (
    <React.Fragment>
      <Header />
      <div style={{ marginTop: "56px" }}>
        <Switch>
          <Route path="/sign-in" component={Login} />
          <Route path="/sign-up" component={SignUp} />
          <Route path="/sensor-details" component={SensorDetails} />
          <Redirect from="/" to="/sign-in" />
        </Switch>
      </div>
    </React.Fragment>
  );
}

export default App;

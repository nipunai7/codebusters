import React, { Component } from "react";
import { Switch, Route, Redirect } from "react-router-dom";
import Header from "./components/header";
import Login from "./components/login.component";
import SignUp from "./components/signup.component";
import SensorDetails from "./components/sensorDetails";
import YourSensorsList from "./components/yourSensorsList";
import AddSensorForm from "./components/addSensor";
import { getCurrentUser } from "./Services/authService";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

class App extends Component {
  state = {};

  componentDidMount() {
    const user = getCurrentUser();
    this.setState({ user });
  }

  render() {
    return (
      <React.Fragment>
        <Header user={this.state.user} />
        <div>
          <Switch>
            <Route path="/sign-in" component={Login} />
            <Route path="/sign-up" component={SignUp} />
            <Route path="/sensor-details" component={SensorDetails} />
            <Route path="/sensor-list" component={YourSensorsList} />
            <Route path="/add-sensor" component={AddSensorForm} />

            <Redirect from="/" to="/sign-in" />
          </Switch>
        </div>
      </React.Fragment>
    );
  }
}

export default App;

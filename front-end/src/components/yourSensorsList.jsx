import React, { Component } from "react";
import { getSensors } from "../Services/sensorService";
import SensorTable from "./sensorTable";

class YourSensorsList extends Component {
  state = { sensors: [] };

  async componentDidMount() {
    const userId = "60e8ff1cf1434d597dfbd6cb";
    const { data: sensors } = await getSensors(userId);
    this.setState({ sensors });
  }

  render() {
    return (
      <div className="container  mt-5">
        <SensorTable sensors={this.state.sensors} />
      </div>
    );
  }
}

export default YourSensorsList;

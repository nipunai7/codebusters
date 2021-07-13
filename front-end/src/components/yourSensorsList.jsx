import React, { Component } from "react";
import { getSensors, deleteSensor } from "../Services/sensorService";
import SensorTable from "./sensorTable";

class YourSensorsList extends Component {
  state = { sensors: [] };

  async componentDidMount() {
    const userId = "60e8ff1cf1434d597dfbd6cb";
    const { data: sensors } = await getSensors(userId);
    this.setState({ sensors });
  }

  handleDelete = async sensor => {
    const userId = "60e8ff1cf1434d597dfbd6cb";
    const prevSensors = [...this.state.sensors];
    const sensors = prevSensors.filter(s => s.id !== sensor.id);
    this.setState({ sensors });
    await deleteSensor(userId, sensor.id);
  };

  render() {
    return (
      <div className="container  mt-5">
        <SensorTable
          sensors={this.state.sensors}
          onDelete={this.handleDelete}
        />
      </div>
    );
  }
}

export default YourSensorsList;

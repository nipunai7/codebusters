import React, { Component } from "react";
import Chart from "./chart";
import { getSensors, getSensor } from "../Services/sensorService";

class SensorDetails extends Component {
  state = {
    data: { type: "Light", sensor: "" },
    sensors: [],
    temps: [],
    stamps: []
  };

  async componentDidMount() {
    const { data: allSensors } = await getSensors();
    const sensors = allSensors.filter(
      sensor => sensor.type === this.state.data.type
    );

    this.setState({ sensors });
  }

  async componentDidUpdate(prevProps, prevState) {
    const { data } = this.state;
    if (prevState.data.type !== data.type) {
      const { data: allSensors } = await getSensors();
      const sensors = allSensors.filter(sensor => sensor.type === data.type);
      const dataNow = data;
      data.sensor = "";
      this.setState({ sensors, data: dataNow });
    }

    if (prevState.data.sensor !== data.sensor) {
      try {
        const { data: sensor } = await getSensor(data.sensor);
        const readings = sensor.temps;
        const temps = readings.map(reading => {
          const temp = reading[0];
          return temp;
        });
        const stamps = readings.map(reading => {
          const stamp = reading[1];
          return stamp;
        });
        this.setState({ temps, stamps });
      } catch (ex) {
        this.setState({ temps: [], stamps: [] });
      }
    }
  }

  handleChange = ({ currentTarget: input }) => {
    const data = { ...this.state.data };
    data[input.name] = input.value;
    this.setState({ data });
  };

  render() {
    const { data, sensors, temps, stamps } = this.state;
    return (
      <React.Fragment>
        <div className="form-group row mb-3 mt-5">
          <label className="form-label col-sm-4 pt-2 text-end" htmlFor="role">
            <span className="text-danger">*</span>Sensor Type :
          </label>
          <div className="d-flex col-sm-7 pt-2 mb-3">
            <div className="form-check me-3">
              <input
                className="form-check-input"
                type="radio"
                name="type"
                id="light"
                value="Light"
                onChange={this.handleChange}
                defaultChecked
              />
              <label className="form-check-label me-2" htmlFor="light">
                Light Sensors
              </label>
            </div>
            <div className="form-check me-3">
              <input
                className="form-check-input"
                type="radio"
                name="type"
                id="temp"
                value="Temperature"
                onChange={this.handleChange}
              />
              <label className="form-check-label" htmlFor="temp">
                Temperature Sensors
              </label>
            </div>
          </div>
        </div>
        <div className="form-group row mb-3">
          <label className="form-label col-sm-4 pt-2 text-end" htmlFor="role">
            <span className="text-danger">*</span>Select Sensor :
          </label>
          <div className="col-sm-3">
            <select
              className="form-select"
              name="sensor"
              onChange={this.handleChange}
              id="sensor"
              value={data.sensor}
            >
              <option></option>
              {sensors.map(sensor => (
                <option value={sensor.id} key={sensor.id}>
                  {sensor.name}
                </option>
              ))}
            </select>
          </div>
        </div>
        <div className="row m-3">
          <div className="offset-3 col-sm-7">
            <Chart type={data.type} temps={temps} stamps={stamps} />
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default SensorDetails;

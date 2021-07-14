import React from "react";
import Joi from "joi-browser";
import Form from "./Common/form";
import { addLightSensor, addTempSensor } from "../Services/sensorService";
import { getCurrentUser } from "../Services/authService";

class AddSensorForm extends Form {
  state = {
    data: {
      type: "",
      name: "",
      threshold1: "",
      threshold2: ""
    },
    errors: {}
  };

  schema = {
    type: Joi.string().required(),

    name: Joi.string().label("Sensor Name").min(3).max(30).required(),
    threshold1: Joi.label("Lower Threshold").required(),
    threshold2: Joi.label("Higher Threshold").required()
  };

  doSubmit = async () => {
    //call the server
    const { data } = this.state;
    const userId = getCurrentUser().jti;

    try {
      if (data.type === "Light") {
        await addLightSensor(userId, data);
      }

      if (data.type === "Temp") {
        await addTempSensor(userId, data);
      }

      window.location = "sensor-list";
    } catch (ex) {
      alert(ex);
    }
  };

  handleClear = () => {
    const data = {
      type: "",
      name: "",
      threshold1: "",
      threshold2: ""
    };
    const errors = {};
    this.setState({ data, errors });
  };

  render() {
    const { data, errors } = this.state;
    return (
      <form
        className="form m-3 w-100 d-flex justify-content-center align-items-center"
        style={{ height: "100vh" }}
        onSubmit={this.handleSubmit}
      >
        <div className="w-50">
          <div className="row mb-3">
            <h2 className="text-dark offset-3 ps-5">Add A Sensor</h2>
          </div>

          <div className="form-group row mb-3">
            <label className="form-label col-sm-4 pt-2 text-end">
              <span className="text-danger">*</span>Sensor Type:
            </label>
            <div className="d-flex col-sm-7 pt-2 mb-3">
              <div className="form-check me-3">
                <input
                  className="form-check-input"
                  type="radio"
                  name="type"
                  id="Light"
                  value="Light"
                  onChange={this.handleChange}
                />
                <label className="form-check-label" htmlFor="Light">
                  Light
                </label>
              </div>
              <div className="form-check me-3">
                <input
                  className="form-check-input"
                  type="radio"
                  name="type"
                  id="Temp"
                  value="Temp"
                  onChange={this.handleChange}
                />
                <label className="form-check-label" htmlFor="Temp">
                  Temperature
                </label>
              </div>
            </div>
          </div>

          <div className="form-group row mb-3">
            <label className="form-label col-sm-4 pt-2 text-end">
              <span className="text-danger">*</span>Sensor Name:
            </label>
            <div className="col-sm-4">
              <input
                value={data.name}
                name="name"
                onChange={this.handleChange}
                type="text"
                className="form-control"
                id="name"
                placeholder="enter name"
              />
              {errors.name && (
                <div className="alert alert-danger">{errors.name}</div>
              )}
            </div>
          </div>

          <div className="form-group row mb-3">
            <label className="form-label col-sm-4 pt-2 text-end">
              <span className="text-danger">*</span>Lower Threshold:
            </label>
            <div className="col-sm-4">
              <input
                value={data.threshold1}
                name="threshold1"
                onChange={this.handleChange}
                type="number"
                className="form-control"
                id="threshold1"
                placeholder="lower threshold"
              />
            </div>
          </div>

          <div className="form-group row mb-3">
            <label className="form-label col-sm-4 pt-2 text-end">
              <span className="text-danger">*</span>Higher Threshold:
            </label>
            <div className="col-sm-4">
              <input
                value={data.threshold2}
                name="threshold2"
                onChange={this.handleChange}
                type="number"
                className="form-control"
                id="threshold2"
                placeholder="higher threshold"
              />
            </div>
          </div>

          {/*Submit Buttons ------------------------------------------------------------------------   */}

          <div className="form-group row mb-3">
            <button
              type="submit"
              className="btn btn-primary btn-m  mt-5 offset-3 col-sm-2"
              disabled={this.validate()}
            >
              ADD
            </button>
            <button
              type="reset"
              className="btn btn-secondary btn-m mt-5 offset-1 col-sm-2"
              onClick={this.handleClear}
            >
              CLEAR
            </button>
          </div>
        </div>
      </form>
    );
  }
}

export default AddSensorForm;

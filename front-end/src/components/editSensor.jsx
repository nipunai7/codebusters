import React from "react";
import Joi from "joi-browser";
import Form from "./Common/form";
import { updateSensor, getSensor } from "../Services/sensorService";
import { getCurrentUser } from "../Services/authService";

class EditSensorForm extends Form {
  state = {
    data: {
      name: "",
      threshold1: "",
      threshold2: ""
    },
    errors: {}
  };

  schema = {
    name: Joi.string().label("Sensor Name").min(3).max(30).required(),
    threshold1: Joi.label("Lower Threshold").required(),
    threshold2: Joi.label("Higher Threshold").required()
  };

  async componentDidMount() {
    const sensorId = this.props.match.params.id;
    const userId = getCurrentUser().jti;
    const { data: sensor } = await getSensor(userId, sensorId);
    const data = {
      name: sensor.name,
      threshold1: sensor.threshold1,
      threshold2: sensor.threshold2
    };
    this.setState({ data });
  }

  doSubmit = async () => {
    //call the server
    const data = { ...this.state.data };
    const sensorId = this.props.match.params.id;
    const userId = getCurrentUser().jti;

    try {
      await updateSensor(userId, sensorId, data);

      window.location = "/sensor-list";
    } catch (ex) {
      alert(ex);
    }
  };

  handleClear = () => {
    const data = {
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
        <div className="w-50 p-5" style={{ border: "2px solid green" }}>
          <div className="row mb-3">
            <h2 className="text-dark offset-3 ps-5">Edit Sensor</h2>
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
              className="btn btn-success btn-m  mt-5 offset-3 col-sm-2"
              disabled={this.validate()}
            >
              UPDATE
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

export default EditSensorForm;

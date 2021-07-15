import React, { Component } from "react";
import Table from "./Common/table";
import { Link } from "react-router-dom";

class SensorTable extends Component {
  columns = [
    {
      label: "Sensor Name",
      path: "name"
    },
    {
      label: "Type",
      path: "type"
    },
    {
      label: "Added Time",
      path: "addDate"
    },
    {
      label: "Lower Threshold",
      path: "threshold1"
    },
    {
      label: "Higher Threshold",
      path: "threshold2"
    },
    {
      label: "Last Updated",
      path: "lastUpdate"
    },
    {
      key: "delete",
      content: sensor => (
        <button
          className="btn btn-danger"
          onClick={() => this.props.onDelete(sensor)}
        >
          Delete
        </button>
      )
    },
    {
      key: "edit",
      content: sensor => (
        <Link className="btn btn-primary" to={`/edit-sensor/${sensor.id}`}>
          Edit
        </Link>
      )
    }
  ];

  render() {
    const { sensors } = this.props;

    if (sensors.length === 0)
      return <h3>Your Sensor list is currently empty</h3>;

    return (
      <React.Fragment>
        <h3 className="mb-3">Currently Added Sensors</h3>
        <Table columns={this.columns} data={sensors} />
      </React.Fragment>
    );
  }
}

export default SensorTable;

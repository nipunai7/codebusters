import React, { Component } from "react";
import Table from "./Common/table";

class EmailTable extends Component {
  columns = [
    {
      label: "Date & Time",
      key: "date",
      content: email => {
        const parts = email.time.split(" ");
        return `${parts[0]}  @ ${parts[1]}`;
      }
    },
    {
      label: "Measurement",
      path: "value"
    },
    {
      label: "User ID",
      path: "userId"
    },
    {
      label: "To",
      path: "to"
    },
    {
      label: "From",
      path: "from"
    }
  ];

  render() {
    const { emails } = this.props;

    if (emails.length === 0)
      return <h3>No abnormal readings were found so far</h3>;

    return (
      <React.Fragment>
        <h3 className="my-3">
          Following instances generated abnormal readings
        </h3>
        <Table columns={this.columns} data={emails} />
      </React.Fragment>
    );
  }
}

export default EmailTable;

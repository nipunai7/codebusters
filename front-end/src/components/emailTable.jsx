import React, { Component } from "react";
import Table from "./Common/table";
import { getUser } from "../Services/userService";

class EmailTable extends Component {
  columns = [
    {
      label: "Date & Time",
      key: "date",
      content: email => {
        const parts = email.time.split(" ");
        return `${parts[0]} @${parts[1]}`;
      }
    },
    {
      label: "Measurement",
      path: "value"
    },
    {
      label: "Username",
      key: "user",
      content: async email => {
        const { data: user } = await getUser(email.userId);
        return user.uName;
      }
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
    if (emails.length === 0 || !emails)
      return <h3>No abnormal readings were found so far</h3>;

    return (
      <React.Fragment>
        <h3>Following instances generated abnormal readings</h3>
        <Table columns={this.columns} data={emails} />
      </React.Fragment>
    );
  }
}

export default EmailTable;

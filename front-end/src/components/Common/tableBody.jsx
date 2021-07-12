import React, { Component } from "react";

class TableBody extends Component {
  renderCell = (item, column) => {
    if (column.content) return column.content(item);

    return item[column.path];
  };

  render() {
    const { data, columns } = this.props;

    return (
      <tbody>
        {data.map(item => (
          <tr key={item._id}>
            {columns.map(column => (
              <td
                key={item._id + (column.path || column.key)}
                className="text-center"
              >
                {this.renderCell(item, column)}
              </td>
            ))}
          </tr>
        ))}
      </tbody>
    );
  }
}

export default TableBody;

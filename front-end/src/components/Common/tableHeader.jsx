import React from "react";

const TableHeader = props => {
  return (
    <thead className="table-dark">
      <tr>
        {props.columns.map(column => (
          <th key={column.path || column.key} className="text-center">
            {column.label}
          </th>
        ))}
      </tr>
    </thead>
  );
};

export default TableHeader;

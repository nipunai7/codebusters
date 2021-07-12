import React from "react";
import TableBody from "./tableBody";
import TableHeader from "./tableHeader";

const Table = ({ columns, data }) => {
  return (
    <table className="table table-hover table-striped">
      <TableHeader columns={columns} />
      <TableBody data={data} columns={columns} />
    </table>
  );
};

export default Table;

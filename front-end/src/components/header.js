import React, { Component } from "react";
import "./../index.css";
import { Link } from "react-router-dom";

export default class Header extends Component {
  render() {
    const { user } = this.props;
    return (
      <nav className="navbar navbar-expand-lg navbar-light sticky-top">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/sign-in">
            Code Busters
          </Link>
          <div
            className="collapse navbar-collapse d-flex justify-content-end"
            id="navbarTogglerDemo02"
          >
            <ul className="navbar-nav ml-auto">
              {!user && (
                <React.Fragment>
                  <li className="nav-item">
                    <Link className="nav-link" to="/sign-in">
                      Log In
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link" to="/sign-up">
                      Sign Up
                    </Link>
                  </li>
                </React.Fragment>
              )}
              {user && (
                <React.Fragment>
                  <li className="nav-item me-2">
                    <Link className="btn btn-secondary" to="/me">
                      {user.sub}
                    </Link>
                  </li>
                  <li className="nav-item me-2">
                    <Link className="nav-link" to="/sensor-details">
                      Sensor Details
                    </Link>
                  </li>
                  <li className="nav-item me-2">
                    <Link className="nav-link" to="/sensor-list">
                      Sensor List
                    </Link>
                  </li>
                  <li className="nav-item me-2">
                    <Link className="nav-link" to="/add-sensor">
                      Add Sensor
                    </Link>
                  </li>
                  <li className="nav-item me-2 pt-1">
                    <Link className="btn btn-primary btn-sm" to="/logout">
                      Logout
                    </Link>
                  </li>
                </React.Fragment>
              )}
            </ul>
          </div>
        </div>
      </nav>
    );
  }
}

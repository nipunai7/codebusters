import React, { Component } from 'react';
import './../index.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default class Header extends Component {
<<<<<<< Updated upstream
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-light fixed-top">
                    <div className="container">
                        <Link className="navbar-brand" to={"/sign-in"}>Code Busters</Link>
                        <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-item">
                                    <Link className="nav-link" to={"/sign-in"}>Log In</Link>
                                </li>
                                <li className="nav-item">
                                    <Link className="nav-link" to={"/sign-up"}>Sign Up</Link>
                                </li>
                            </ul>
                        </div>
                    </div>
                 </nav>
            </div>
        )
    }
=======
  render() {
    return (
      <nav className="navbar navbar-expand-lg navbar-light sticky-top">
        <div className="container">
          <Link className="navbar-brand" to={"/sign-in"}>
            Code Busters
          </Link>
          <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link className="nav-link" to={"/sign-in"}>
                  Log In
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/sign-up"}>
                  Sign Up
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/sensor-details"}>
                  Sensor Details
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/sensor-list"}>
                  Sensor List
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/add-sensor"}>
                  Add Sensor
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    );
  }
>>>>>>> Stashed changes
}

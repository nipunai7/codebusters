import React, { Component } from "react";
import { login } from "../Services/authService";
import "./login.signin.css";

export default class Login extends Component {
  constructor() {
    super();

    this.state = {
      email: "",
      password: ""
    };

    this.onChange = this.onChange.bind(this);
    this.onAuth = this.onAuth.bind(this);
  }

  onChange = e => {
    this.setState({ [e.target.name]: e.target.value });
  };

  onAuth = async e => {
    e.preventDefault();
    //write api code
    try {
      const user = {
        email: this.state.email,
        pass: this.state.password
      };
      await login(user);
      window.location = "/sensor-details";
    } catch (ex) {
      console.log(ex.message);
    }
  };

  render() {
    return (
      <div
        className="w-100  d-flex justify-content-center align-items-center"
        style={{ height: "100vh" }}
      >
        <form onSubmit={this.onAuth} style={{ height: "45vh", width: "40%" }}>
          <div className="form-group mb-2">
            <label>Email</label>
            <input
              type="email"
              className="form-control"
              placeholder="Enter email"
              name="email"
              required
              value={this.state.email}
              onChange={this.onChange}
            />
          </div>

          <div className="form-group mb-2">
            <label>Password</label>
            <input
              type="password"
              className="form-control"
              placeholder="Enter password"
              name="password"
              required
              value={this.state.password}
              onChange={this.onChange}
            />
          </div>

          <div className="form-group mb-2">
            <div className="custom-control custom-checkbox">
              <input
                type="checkbox"
                className="custom-control-input"
                id="customCheck1"
              />
              <label className="custom-control-label" htmlFor="customCheck1">
                Remember me
              </label>
            </div>

            <button
              type="submit"
              className="btn btn-dark btn-lg btn-block w-100"
            >
              Log In
            </button>
            <p className="forgot-password text-right">
              No Account to Manage your Sensors? <a href="/sign-up">Sign Up</a>
            </p>
          </div>
        </form>
      </div>
    );
  }
}

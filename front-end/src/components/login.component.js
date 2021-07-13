import React, { Component } from "react";

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

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onAuth(e) {
    e.preventDefault();
  }

  render() {
    return (
      <div className="outer">
        <div className="inner">
          <div>
            <form>
              <h3>LOG IN</h3>

              <div className="form-group">
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

              <div className="form-group">
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

              <div className="form-group">
                <div className="custom-control custom-checkbox">
                  <input
                    type="checkbox"
                    className="custom-control-input"
                    id="customCheck1"
                  />
                  <label
                    className="custom-control-label"
                    htmlFor="customCheck1"
                  >
                    Remember me
                  </label>
                </div>
              </div>

              <button type="submit" className="btn btn-dark btn-lg btn-block">
                Log In
              </button>
              <p className="forgot-password text-right">
                Already have an account?<a href="/sign-up">Sign In?</a>
              </p>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

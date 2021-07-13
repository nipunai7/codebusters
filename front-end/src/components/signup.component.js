import React, { Component } from "react";
import { Input, FormFeedback } from "reactstrap";
import { isEmail, isLength } from "validator";

export default class SignUp extends Component {
  constructor() {
    super();

    this.state = {
      firstname: "",
      lastname: "",
      email: "",
      password: "",
      confpass: "",
      errors: {}
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  validate = () => {
    const { firstname, lastname, email, password, confpass } = this.state;

    let errors = {};

    if (firstname === "") errors.firstname = "First Name cannot be empty.";
    if (lastname === "") errors.lastname = "Last Name cannot be empty.";
    if (email === "") errors.email = "Email cannot be empty.";
    if (!isEmail(email)) errors.email = "Email must be a valid email.";
    if (password === "") errors.password = "Password cannot be a blank.";
    if (!isLength(password, 4, 12))
      errors.password = "Password must have 4-12 charachters.";
    if (confpass !== password) errors.confpass = "Password must be same.";

    return errors;
  };

  onChange(e) {
    this.setState({
      [e.target.name]: e.target.value,

      errors: {
        [e.target.name]: ""
      }
    });
  }

  onSubmit(e) {
    e.preventDefault();

    const { firstname, lastname, email, password, confpass } = this.state;
    const errors = this.validate();

    if (Object.keys(errors).length === 0) {
      //write api to database
      console.log(firstname, lastname, email, password, confpass);
    } else {
      this.setState({ errors });
    }
  }

  render() {
    const { errors } = this.state;
    return (
      <div className="outer">
        <div className="inner">
          <div>
            <form onSubmit={this.onSubmit}>
              <h3>SIGN UP</h3>

              <div className="form-group">
                <label>First name</label>
                <Input
                  type="text"
                  className="form-control"
                  placeholder="First name"
                  name="firstname"
                  required
                  value={this.state.firstname}
                  onChange={this.onChange}
                  invalid={errors.firstname ? true : false}
                />
                <FormFeedback>{errors.firstname}</FormFeedback>
              </div>

              <div className="form-group">
                <label>Last name</label>
                <Input
                  type="text"
                  className="form-control"
                  placeholder="Last name"
                  name="lastname"
                  required
                  value={this.state.lastname}
                  onChange={this.onChange}
                  invalid={errors.lastname ? true : false}
                />
                <FormFeedback>{errors.lastname}</FormFeedback>
              </div>

              <div className="form-group">
                <label>Email</label>
                <Input
                  type="email"
                  className="form-control"
                  placeholder="Enter email"
                  name="email"
                  required
                  value={this.state.email}
                  onChange={this.onChange}
                  invalid={errors.email ? true : false}
                />
                <FormFeedback>{errors.email}</FormFeedback>
              </div>

              <div className="form-group">
                <label>Password</label>
                <Input
                  type="password"
                  className="form-control"
                  placeholder="Enter password"
                  name="password"
                  required
                  value={this.state.password}
                  onChange={this.onChange}
                  invalid={errors.password ? true : false}
                />
                <FormFeedback>{errors.password}</FormFeedback>
              </div>

              <div className="form-group">
                <label>Confirm Password</label>
                <Input
                  type="password"
                  className="form-control"
                  placeholder="Re-Enter password"
                  name="confpass"
                  required
                  value={this.state.confpass}
                  onChange={this.onChange}
                  invalid={errors.confpass ? true : false}
                />
                <FormFeedback>{errors.confpass}</FormFeedback>
              </div>

              <button type="submit" className="btn btn-dark btn-lg btn-block">
                Sign Up
              </button>
              {/* &nbsp; <input type='reset' className="btn btn-danger "  value='Reset'/> */}

              <p className="forgot-password text-right">
                Already registered <a href="/sign-in">log in?</a>
              </p>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

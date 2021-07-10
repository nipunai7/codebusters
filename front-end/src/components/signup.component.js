import React, { Component, useState } from "react";
import Header from "./header";
import { Input, FormFeedback } from "reactstrap";
import { isEmail, isLength } from 'validator';

export default class SignUp extends Component {

    constructor() {
        super();

        this.state = {

            data: {
                firstname : '',
                lastname : '',
                email : '',
                password : '',
                confpass: ''
            },
            
            errors: ' '
        }

        this.onChange=this.onChange.bind(this)
        this.onSubmit=this.onSubmit.bind(this)
    }

    validate = () => {
        const { data } = this.state;
        
        let errors = {};

        if (data.firstname === '' ) errors.firstname = "First Name cannot be empty.";
        if (data.lastname === '' ) errors.lastname = "Last Name cannot be empty.";
        if (data.email === '' ) errors.email = "Email cannot be empty.";
/*         if (!isEmail(data.email) ) errors.email = "Email must be a valid email."; */
        if (data.password === '' ) errors.password = "Password cannot be a blank.";
/*         if (!isLength(data.password,4,12)) errors.password = "Password must have 4-12 charachters."; */
        if (data.confpass !== data.password ) errors.confpass = "Password must be same.";

        return errors;

    }

    onChange(e){
        this.setState({
            data: {
                [e.target.name]:e.target.value
            },
            errors: {
                [e.target.name]: ''
            }
            })
    }

    onSubmit(e) {
        e.preventDefault()
        
        const data   = this.state;
        const errors = this.validate();

        if(Object.keys(errors).length === 0){
            //write api to database
            console.log(data);
        }
        else{
            this.setState({errors});
        }
        
    }

    render() {
        const { errors } = this.state;
        return (
            <div>
                <Header/>
                <form onSubmit = {this.onSubmit}>
                <h3>SIGN UP</h3>

                <div className="form-group">
                    <label>First name</label>
                    <Input 
                    type="text" 
                    className="form-control" 
                    placeholder="First name" 
                    name="firstname" 
                    required 
                    value={this.state.data.firstname}
                    onChange={this.onChange}
                    invalid= {errors.firstname ? true : false} />
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
                    value={this.state.data.lastname}
                    onChange={this.onChange}
                    invalid= {errors.lastname ? true : false} />
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
                    value={this.state.data.email}
                    onChange={this.onChange}
                    invalid= {errors.email ? true : false} />
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
                    value={this.state.data.password}
                    onChange={this.onChange} 
                    invalid= {errors.password ? true : false} />
                    <FormFeedback>{errors.password}</FormFeedback>
                </div>

                <div className="form-group">
                    <label>Confirm Password</label>
                    <Input type="password" 
                    className="form-control" 
                    placeholder="Re-Enter password" 
                    name="confpass" 
                    required
                    value={this.state.data.confpass}
                    onChange={this.onChange} 
                    invalid= {errors.confpass ? true : false} />
                    <FormFeedback>{errors.confpass}</FormFeedback>
                </div>

                <button type="submit" className="btn btn-dark btn-lg btn-block">Sign Up</button>
                {/* &nbsp; <input type='reset' className="btn btn-danger "  value='Reset'/> */}

                <p className="forgot-password text-right">
                    Already registered <a href="/sign-in">log in?</a>
                </p>
            </form>
            </div>
        );
    }
}
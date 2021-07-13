import React, { Component } from 'react';
import './../index.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default class TokenHeader extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-light fixed-top">
                    <div className="container">
                        <Link className="navbar-brand" to={"/home"}>Code Busters</Link>
                        <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                            <ul className="navbar-nav ml-auto">
                            <li className="nav-item">
                                    <Link className="nav-link" to={"/"}>Toekn</Link> {/* methanat token eka pass krapn */}
                                </li>
                                <li className="nav-item">
                                    <Link className="nav-link" to={"/sign-in"}>Log out</Link>
                                </li>
                                
                            </ul>
                        </div>
                    </div>
                 </nav>
            </div>
        )
    }
}

import React, { useState } from 'react';
import {Link} from 'react-router-dom';
import './Header.css';

const Header = () => {

    const loggedin = window.localStorage.getItem("isLoggedIn")

    let log;
    const role = window.localStorage.getItem("usertype");
    if (loggedin == "true") {
        log =
            <li class="login">
                <Link class="nav-link" to={`/${role}/profile`}>Profile</Link>
            </li>
    }
    else {
        log =
            <li class="login">
                <a class="nav-link" href="/login" >Login</a>
            </li>
    }

    return (
        <div class="nac">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/">Hotelify</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">

                        <li class="nav-item active">
                            <a class="nav-link" href="/rooms">Book Room</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/services">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/hoteldetails">Hotel Details</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/contact" >Contact</a>
                        </li>
                        {
                            log
                        }
                    </ul>
                </div>
            </nav>
        </div>
    )
}

export default Header;
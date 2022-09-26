import React, { Component } from 'react';
import { useState, useEffect } from 'react';
import { Link, useHistory } from 'react-router-dom';
import "./Login.css";

const Login =()=> {
    let history = useHistory();
    const [login,setLogin] = useState({
        email : "",
        password : ""
    });
    
    const {
        email,password
    } = login;

    const onInputChange = e => {
        setLogin({ ...login, [e.target.email]: e.target.value });
      };
    
      const onSubmit = async e => {
        e.preventDefault();
        
        history.push("/");
      };

   
        return (
            <div>
                <div class="emp">
                    <Link to={"/stafflogin"}>
                <button type="button" class="btn btn-outline-dark">Employee Login</button>
                </Link>
                </div>
                <h3>Customer Login :</h3>
                <form onSubmit={e => onSubmit(e)}>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" 
                        name="email"
                        value={email}
                        onChange={e => onInputChange(e)}
                        />
                        
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" 
                        name="password"
                        value={password}/>
                    </div>
                    <div class="but">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <Link to={"/customerregister"} class="reg">
                <button type="button" class="btn btn-outline-dark">Create new account</button>
                </Link>
                    </div>
                    
                </form>

                

            </div>
        )
}

export default Login;
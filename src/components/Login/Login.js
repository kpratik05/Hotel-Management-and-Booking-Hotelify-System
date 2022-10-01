import React from 'react';
import { useState,useRef} from 'react';
import { Link, useHistory } from 'react-router-dom';
import CustomerService from '../Service/CustomerService';
import "./Login.css";

const Login =()=> {
    let history = useHistory();
    const errRef = useRef();
    const [login,setLogin] = useState({
        email : "",
        password : ""
    });

    const [customer,setCustomer] = useState({
        name:"",
        email:"",
        address:"",
        mobileNo:0,
        password:"",
        birthDate:'',
        customerId:0,
    });

    const [errMsg, setErrMsg] = useState('');

    const {
        email,password
    } = login;

    const onInputChange = e => {
        setLogin({ ...login, [e.target.name]: e.target.value });
      };
    
      const onSubmit = async e => {
        e.preventDefault();
        console.log("Manager login "+login.email+" "+login.password)

        
            await CustomerService.postLogin(login).then(response => {
                console.log("Info "+response.data.customerId);
                 setCustomer(response.data);
                 
             }
            
               )
               .catch(function (ex) {
                  
            if (!ex?.response) {
                setErrMsg('No Server Response');
            } else if (ex.response?.status === 400) {
                setErrMsg('Missing Username or Password');
            } else if (ex.response?.status === 401) {
                setErrMsg('Unauthorized');
            } else {
                setErrMsg('Login Failed');
            }
            errRef.current.focus();
        }
               );

            console.log("employee id "+customer.customerId+" "+customer.email);
                
               window.localStorage.setItem("isLoggedIn",true);
               window.localStorage.setItem("id",customer.customerId);
               window.localStorage.setItem("usertype","customer");
               window.alert("Customer logged in successfully successfully !");
               setTimeout(()=>{
                   history.push("/");

               },5000)
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
                        value={password}
                        onChange={e => onInputChange(e)}/>
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
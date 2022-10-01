import React, { useState,useEffect } from 'react';
import StaffService from "../Service/StaffService";
import { useHistory } from 'react-router-dom';
import "./Login.css";

const Stafflogin =()=>{

        
        let history = useHistory();

        const [staff,setStaff] = useState({
            name:"",
            email:"",
            address:"",
            mobileNo:0,
            password:"",
            birthDate:null,
            employeeId:0,
            department:null,
            roleId: null,
            shiftId:null
        });

        const [login, setLogin] = useState({
            id:0,
            password:""
        });
        const [errMsg, setErrMsg] = useState('');
        // const [err,setError] = useState(false);
        const {id,password} = login;
    
        const onInputChange = (e) =>{
            setLogin({...login,[e.target.name]:e.target.value})
        };
    
        useEffect(() => {
            setErrMsg('');
        }, [id, password])



        const handleSubmit = async(e) =>  {
            e.preventDefault();
            console.log("call submit")
            
            
    
                await StaffService.getFromLogin(login).then(response => {
                    console.log("Info "+response.data.employeeId);
                     setStaff(response.data);
                     
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
            }
                   );
                    
                   window.localStorage.setItem("isLoggedIn",true);
                   window.localStorage.setItem("id",staff.employeeId);
                   window.localStorage.setItem("usertype","staff");
                   window.localStorage.setItem("deptId",staff.department.deptId);
                   window.alert("Customer logged in successfully !");
                   setTimeout(()=>{
                       history.push("/");
                   },5000)
            }




    
        return (
            <div>
                <div class="card text-center">
                    <div class="card-header">
                        <ul class="nav nav-tabs card-header-tabs">
                            <li class="nav-item">
                                <a class="nav-link active" href="/stafflogin">Staff login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/managerlogin">Manager login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/adminlogin">Admin login</a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <form onSubmit={handleSubmit}>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Employee Id</label>
                                <input type="number" class="form-control" id="exampleInputEmail1" placeholder="Enter id" 
                                name="id"
                                value={id}
                                onChange={e => onInputChange(e)}
                                />

                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value={password} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="but">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>



            </div>
        )
}

export default Stafflogin;
import React,{useState,useEffect} from 'react';
import ManagerService from '../Service/ManagerService';
import {Link} from 'react-router-dom';
const ManagerProfile =()=>{

    const [manager,setManager] = useState({
        employeeId:0,
        department:'',
        name:"",
        email:"",
        address:"",
        mobileNo:0,
        password:"",
        birthDate:''       
    });

    const id = window.localStorage.getItem("id");

    useEffect(()=>{
        getInfo();},[]
        );

    const getInfo =()=>{
        console.log("ID "+id);
        ManagerService.getManagerInfo(id).then(response => {
            console.log("manager profile response "+response.data.email);
            setManager(response.data);
            console.log("manager name "+manager.name+" "+manager.employeeId)
        }
        )
        .catch((err) => {
            if (err.response.statuscode == 400) {
                console.log(err);
            } else {
              console.log("something else");
            }
        });;

        
    }
    
    return(
        <div>
        <h3>
            Manager Profile :
        </h3>
        <h5>Id : {manager.employeeId}</h5>
        <h5>Name  : {manager.name}</h5>
        <h5>Mobile No  : {manager.mobileNo}</h5>
        <h5>Address  : {manager.address}</h5>
        <h5>Email : {manager.email}</h5>
        <h5>Birth Date  : {manager.birthDate}</h5>
        <h5>Department  : {manager.department.deptName}</h5>
        <Link to="/logout"><button name="button" onClick={()=>{window.localStorage.setItem("isLoggedIn",false)}}>Logout</button></Link>
        
        <h5><a href="/manager/login">Login List</a></h5>
        <Link to="/manager/update"><button name="button" >Update</button></Link>
        
        <h5><a href="/manager/stafflist">Employee List</a></h5>
        <h5><a href="/manager/customerpayment">Custoemer payment List</a></h5>
        <h5><a href="/manager/bookinglist">Custoemer booking List</a></h5>
        <h5><a href="/manager/feedbacklist">Employee Feedback List</a></h5>
        </div>
        
        
    )
}

export default ManagerProfile;
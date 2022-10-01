import React,{useState,useEffect} from 'react';
import StaffService from '../Service/StaffService';
import {Link} from 'react-router-dom';
import "./Profile.css";
const StaffProfile =()=>{

    const [staff,setStaff] = useState({
        employeeId:0,
        department:'',
        name:"",
        email:"",
        address:"",
        mobileNo:0,
        password:"",
        birthDate:'',
        shift:0,
        role:0   
    });

    const id = window.localStorage.getItem("id");

    useEffect(()=>{
        getInfo();},[]
        );

    const getInfo =()=>{
        console.log("ID "+id);
        StaffService.getStaffInfo(id).then(response => {
            console.log("Staff profile response "+response.data.email);
            setStaff(response.data);
            console.log("Staff name "+staff.name+" "+staff.employeeId)
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
        <div class="profile">
        <h3 class="staff">
            Staff Profile :
        </h3>
        <h5>Id         : {staff.employeeId}</h5>
        <h5>Name       : {staff.name}</h5>
        <h5>Mobile No  : {staff.mobileNo}</h5>
        <h5>Address    : {staff.address}</h5>
        <h5>Email      : {staff.email}</h5>
        <h5>Birth Date : {staff.birthDate}</h5>
        <h5>Department : {staff.department.deptName}</h5>
        <Link to="/logout"><button name="button" onClick={()=>{window.localStorage.setItem("isLoggedIn",false)}} class="button">Logout</button></Link>
        <Link to="/staff/update"><button name="button" class="button">Update</button></Link>
        <Link to="/staff/payment"><button name="button" class="button">Payment</button></Link>
        
        <h5><a href={`/shift/${staff.shift.shiftId}`}>Shift Details</a></h5>
        
        <h5><a href="/manager/bookinglist">Customer booking List</a></h5>
        
        
        </div>
        
        
    )
}

export default StaffProfile;
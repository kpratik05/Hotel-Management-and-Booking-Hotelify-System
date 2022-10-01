import React,{useState,useEffect} from 'react';
import AdminService from '../Service/AdminService';
import {Link} from 'react-router-dom';
import "./Profile.css";

const AdminProfile =()=>{

    const [admin,setAdmin] = useState({
        adminId:0,
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
        console.log("Admin profile ID "+id);
        AdminService.getAdminInfo(id).then(response => {
            console.log("manager profile response "+response.data.email);
            setAdmin(response.data);
            console.log("manager name "+admin.name+" "+admin.adminId)
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
        <h3 class="manager">
            Admin Profile :
        </h3>
        <h5>Id         : {admin.adminId}</h5>
        <h5>Name       : {admin.name}</h5>
        <h5>Mobile No  : {admin.mobileNo}</h5>
        <h5>Address    : {admin.address}</h5>
        <h5>Email      : {admin.email}</h5>
        <h5>Birth Date : {admin.birthDate}</h5>
        <Link to="/logout"><button name="button" onClick={()=>{window.localStorage.setItem("isLoggedIn",false);
                                                                window.localStorage.setItem("usertype",null);
                                                                window.localStorage.setItem("id",0);

                                                                
                                                                }} class="button">Logout</button></Link>
        
        <h5><a href="/admin/stafflist">Employee List</a></h5>
        <h5><a href="/admin/managerlist">Manager List</a></h5>
        <h5><a href="/admin/customerpayment">Customer payment List</a></h5>
        <h5><a href="/admin/bookinglist">Customer booking List</a></h5>
        <h5><a href="/admin/registerstaff">Register Staff</a></h5>
        <h5><a href="/admin/registermanager">Register Manager</a></h5>
        <h5><a href="/admin/roomlist">Room List</a></h5>
        <h5><a href="/admin/shiftlist">Shift List</a></h5>
        </div>
        
        
    )
}

export default AdminProfile;
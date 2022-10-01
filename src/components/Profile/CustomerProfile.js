import React,{useState,useEffect} from 'react';
import { Link } from 'react-router-dom';
import CustomerService from '../Service/CustomerService';

const CustomerProfile=()=>{
    const [customer,setCustomer] = useState({
        customerId:0,
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
        console.log("Cusotmer profile ID "+id);
        CustomerService.getProfile(id).then(response => {
            console.log("manager profile response "+response.data.email);
            setCustomer(response.data);
            console.log("manager name "+customer.name+" "+customer.customerId)
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
            Customer Profile :
        </h3>
        <h5>Id         : {customer.customerId}</h5>
        <h5>Name       : {customer.name}</h5>
        <h5>Mobile No  : {customer.mobileNo}</h5>
        <h5>Address    : {customer.address}</h5>
        <h5>Email      : {customer.email}</h5>
        <h5>Birth Date : {customer.birthDate}</h5>
        <Link to="/logout"><button name="button" onClick={()=>{window.localStorage.setItem("isLoggedIn",false);
                                                                window.localStorage.setItem("usertype",null);
                                                                window.localStorage.setItem("id",0);

                                                                
                                                                }} class="button">Logout</button></Link>
        <Link to={`/customer/update/${customer.customerId}`}><button name="button" class="button">Update</button></Link>
        <Link to={`/customer/payment`}><button name="button" class="button">Payment</button></Link>
        
        <h5><a href={`/customer/history/${customer.customerId}`}>Booking History</a></h5>
        <h5><a href={`/customer/payment/${customer.customerId}`}>Payment History</a></h5>
        </div>)
}

export default CustomerProfile;
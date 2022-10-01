import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import CustomerService from "../Service/CustomerService";
const RegisterCustomer = () => {

    const history = useHistory();
    const [customer, setCustomer] = useState({
        customerId:0,
        name: "",
        email: "",
        address: "",
        mobileNo: 0,
        password: "",
        birthDate: ''
    });

    

    const onInputChange = (e) => {
        setCustomer({ ...customer, [e.target.name]: e.target.value })
    };

    const { name, email, address, mobileNo, password, birthDate} = customer;
    
    

    const onSubmit = async e => {
        e.preventDefault();
        CustomerService.registerCustomer(customer).then(response => {
            console.log("manager profile response " + response.data.email);
            setCustomer(response.data);
            console.log("manager name " + customer.name + " " + customer.customerId)

            window.localStorage.setItem("isLoggedIn",true);
            window.localStorage.setItem("usertype","customer");
            window.localStorage.setItem("id",customer.customerId);
        }
        )
            .catch((err) => {
                if (err.response.statuscode == 400) {
                    console.log(err);
                } else {
                    console.log("something else");
                }
            });;
            // window.alert("Registered successfully !");
            setTimeout(()=>{
                history.push("/customer/profile");
            },5000);
        
    };

    return (
        <div>
            <form onSubmit={onSubmit}>
                <div class="form-group">
                    <label for="exampleInputPassword1">Name</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Name" name="name" value={name} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Email</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Email" name="email" value={email} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Address</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Address" name="address" value={address} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Mobile No</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Mobile No" name="mobileNo" value={mobileNo} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Birth Date</label>
                    <input type="Date" class="form-control" id="exampleInputPassword1" placeholder="Birthdate" name="birthDate" value={birthDate} onChange={e => onInputChange(e)} />
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value={password} onChange={e => onInputChange(e)} />
                </div>
                <div class="but">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    )
}

export default RegisterCustomer;
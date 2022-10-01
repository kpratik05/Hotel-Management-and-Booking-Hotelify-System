import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import AdminService from "../Service/AdminService";
const RegisterManager = () => {

    const history = useHistory();
    const [manager, setManager] = useState({
        name: "",
        email: "",
        address: "",
        mobileNo: 0,
        password: "",
        birthDate: '',
        department: 0,
    });

    

    const onInputChange = (e) => {
        setManager({ ...manager, [e.target.name]: e.target.value })
    };

    const { name, email, address, mobileNo, password, birthDate, department} = manager;
    
    

    const onSubmit = async e => {
        e.preventDefault();
        console.log(manager.department+" whole");
        AdminService.registerManager(manager).then(response => {
            console.log("manager profile response " + response.data.email);
            setManager();
            console.log("manager name " + manager.name + " " + manager.id)
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
        history.push("/admin/managerlist");
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
                    <label for="cars">Choose a Department:</label>

                    <select name="department" id="cars" onChange={e => onInputChange(e)}>
                        <option value="1">Kitchen</option>
                        <option value="2">Commute</option>
                        <option value="3">Management</option>
                        <option value="4">Front Staff</option>
                        <option value="5">Cleaning</option>
                    </select>
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

export default RegisterManager;
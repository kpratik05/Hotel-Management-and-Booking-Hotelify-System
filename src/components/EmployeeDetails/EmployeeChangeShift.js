import React, { useState,useEffect } from 'react';
import { useParams,useHistory } from 'react-router-dom';
import ManagerService from '../Service/ManagerService';

const EmployeeChangeShift =()=>
{
    const history = useHistory();
    const [staff,setStaff] = useState({
        employeeId:0,
        department:'',
        shift:'',
        name:"",
        email:"",
        address:"",
        mobileNo:0,
        password:"",
        birthDate:'' ,
        role:''     
    }); 

    const {id} = useParams(); 

    const onInputChange =(e)=>{
        setStaff({...staff,[e.target.name] : e.target.value})
    }

    useEffect(()=>{
        loadData();
    },[]);

    const loadData =()=> {
        console.log("empid "+id);
        ManagerService.getEmployeeDetails(id).then(response => {
            console.log("emp "+response.data);
            setStaff(response.data);
        }).catch(function (ex) {
            console.log('Response parsing failed. Error: ', ex);
        });;
    }

    const handleSubmit =()=>{
        staff.department = staff.department.deptId;
        staff.role = staff.role.id;

        ManagerService.changeShift(staff).then(response => {
        }).catch(function (ex) {
            console.log('Response parsing failed. Error: ', ex);
        });;

        history.push(`/manager/staffdetails/${staff.employeeId}`)
    }

    return(
        <div>
            <form onSubmit={handleSubmit}>
        <h5>Id : {staff.employeeId}</h5>
        <h5>Name  : {staff.name}</h5>
        <h5>Mobile No  : {staff.mobileNo}</h5>
        <h5>Address  : {staff.address}</h5>
        <h5>Email : {staff.email}</h5>
        <h5>Role : {staff.role.role}</h5>
        <h5>Birth Date  : {staff.birthDate}</h5>
        <h5>Department  : {staff.department.deptName}</h5>
        <div class="form-group">
                    <label for="cars">Choose a Shift:</label>

                    <select name="shift" id="shift" onChange={e => onInputChange(e)}>
                        <option value="1">16:00:00 - 23:59:59</option>
                        <option value="2">08:00:00 - 16:00:00</option>
                        <option value="3">00:00:00 - 08:00:00</option>
                        <option value="3">05:00:00 - 13:00:00</option>
                    </select>
                </div>
        <div>
            <button type="submit" >Change Shift</button>
        </div>
        </form>
        </div>
    )
    
}

export default EmployeeChangeShift;
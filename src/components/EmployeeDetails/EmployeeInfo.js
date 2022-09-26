import React, { useState,useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import ManagerService from '../Service/ManagerService';

const EmployeeInfo =()=>
{

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

    
    return(
        <div>
        <h5>Id : {staff.employeeId}</h5>
        <h5>Name  : {staff.name}</h5>
        <h5>Mobile No  : {staff.mobileNo}</h5>
        <h5>Address  : {staff.address}</h5>
        <h5>Email : {staff.email}</h5>
        <h5>Role : {staff.role.role}</h5>
        <h5>Birth Date  : {staff.birthDate}</h5>
        <h5>Department  : {staff.department.deptName}</h5>
        <h5>Shift  : {staff.shift.startTime} - {staff.shift.endTime}</h5>
        <div>
            <Link to={`/manager/addfeedback/${staff.employeeId}`}><button name="button">Give Feedback</button></Link>
            <Link to={`/manager/feedback/${staff.employeeId}`}><button name="button">Previous Feedback</button></Link>
        </div>
        </div>
    )
    
}

export default EmployeeInfo;
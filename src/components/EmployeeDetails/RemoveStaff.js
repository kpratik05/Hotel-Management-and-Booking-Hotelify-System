import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import AdminService from '../Service/AdminService';
const RemoveStaff =()=>
{
    const {id} = useParams();

    useEffect(()=>{
        removeEmployee();
    },[])

    const [message,setMessage] = useState();

    setTimeout(function(){
        window.location.href = '/admin/stafflist';
     }, 5000);

    const removeEmployee =()=>{
        AdminService.removeEmployee(id).then(response => {
            console.log("emp "+response.data);
            setMessage(response.data);
        }).catch(function (ex) {
            console.log('Response parsing failed. Error: ', ex);
        });;
    }

        return(
            <div>
                <h3>Removing Status :</h3>
                <h4>{message}</h4>
            </div>
        )
}

export default RemoveStaff;
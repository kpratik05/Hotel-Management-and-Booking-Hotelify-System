import StaffService from "../Service/StaffService";
import React,{useEffect,useState} from 'react';
import { useParams } from "react-router-dom";

const ShiftDetails=()=>{

    const [shift,setShift] = useState({
        shiftId : 0,
        startTime : '',
        endTime : '',
        instructions : ''
    })

    const {shiftId,startTime,endTime,instructions} = shift; 

    useEffect(()=>{
        loadData();
    })  

    const {id} = useParams();

    const loadData=()=>{
        StaffService.getShiftDetails(id).then(response => {
            console.log("Staff profile response "+response.data.email);
            setShift(response.data);
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
            <h3>Shift ID : {shift.shiftId}</h3>
            <h3>Shift Start Time : {shift.startTime}</h3>
            <h3>Shift End Time : {shift.endTime}</h3>
            <h3>Shift Instructions : {shift.instructions}</h3>
        </div>
    )
}

export default ShiftDetails;
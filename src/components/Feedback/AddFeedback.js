import React, { useEffect, useState } from 'react';
import { useHistory, useParams } from 'react-router-dom';
import ManagerService from '../Service/ManagerService';

const AddFeedback=()=>{
    const history = useHistory()
    const [fdback,setFeedback] = useState({
        staff:'',
        feedback:"",
        date:''
    })

    const {staff,feedback,date} = fdback;

    const {id }= useParams();

    useEffect(()=>{
        fdback.staff = id;
    },[])

    const onInputChange = (e) =>{
        setFeedback({...fdback,[e.target.name]:e.target.value})
    };

    const handleSubmit = async(e) =>  {
        e.preventDefault();
             
            console.log("feedback "+fdback.staff+" "+fdback.date);
            await ManagerService.addFeedback(fdback).then(response => {
                console.log("Info "+response.data.feedback);
                 
                 
             }
            
               )
               .catch( (ex)=> {
                console.log('Response parsing failed. Error: ', ex);
        }   
               );
            history.push(`/manager/feedback/${staff}`);
        }

    return (
        <div>
            <form onSubmit= {handleSubmit}>
                            <div class="form-group">
                                <h5>{staff}</h5>

                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Feedback</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="feedback" name="feedback" value={feedback} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Date</label>
                                <input type="Date" class="form-control" id="exampleInputPassword1" name="date" value={date} onChange={e => onInputChange(e)}/>
                            </div>
                            <div class="but">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
        </div>
    )
}


export default AddFeedback;
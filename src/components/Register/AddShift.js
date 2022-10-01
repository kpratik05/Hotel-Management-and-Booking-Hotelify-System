import React, { useState } from "react";
import { useHistory} from "react-router-dom";
import AdminService from "../Service/AdminService";

const AddShift = () => {

    const history = useHistory();
    const [shift, setShift] = useState({
        endTime: '',
        startTime: "",
        date: '',
        instructions: ""
    });

    const onInputChange = (e) => {
        setShift({ ...shift, [e.target.name]: e.target.value })
    };

    const {  startTime, endTime, date, instructions } = shift;

    const onSubmit = async e => {
        e.preventDefault();
        AdminService.addShift(shift).then(response => {
        }
        )
            .catch((err) => {
                if (err.response.statuscode == 400) {
                    console.log(err);
                } else {
                    console.log("something else");
                }
            });;
            window.alert("New Shift added successfully !");
        history.push("/admin/shiftlist");
    };

    return (
        <div>
            <form onSubmit={onSubmit}>
                <div class="form-group">
                    <label for="exampleInputPassword1">Start time</label>
                    <input type="time" step={2} class="form-control" id="exampleInputPassword1" name="startTime" value={startTime} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">End time</label>
                    <input type="time" step={2} class="form-control" id="exampleInputPassword1" name="endTime" value={endTime} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Date</label>
                    <input type="Date" class="form-control" id="exampleInputPassword1" name="date" value={date} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Instructions</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Add some instructions" name="instructions" value={instructions} onChange={e => onInputChange(e)} />
                </div>
                
                <div class="but">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    )
}

export default AddShift;
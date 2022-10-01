import React, { useEffect, useState } from "react";
import { useHistory, useParams } from "react-router-dom";
import AdminService from "../Service/AdminService";

const UpdateShift = () => {
    const {id} = useParams();

    const history = useHistory();
    const [shift, setShift] = useState({
        shiftId:0,
        endTime: '',
        startTime: "",
        date: '',
        instructions: ""
    });

    const onInputChange = (e) => {
        setShift({ ...shift, [e.target.name]: e.target.value })
    };

    const {  shiftId,startTime, endTime, date, instructions } = shift;

    useEffect(() => {
        loadShift();
    }, []);

    const loadShift = async () => {
        console.log("ID " + id);
        await AdminService.getShiftInfo(id).then(response => {
            console.log("romm response " + response.data);
            setShift(response.data);
            console.log("room name " +shift.shiftId + " " + shift.instructions)
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

    const onSubmit = async e => {
        e.preventDefault();
        console.log("start "+shift.startTime);
        AdminService.updateShift(id,shift).then(response => {
        }
        )
            .catch((err) => {
                if (err.response.statuscode == 400) {
                    console.log(err);
                } else {
                    console.log("something else");
                }
            });;
            window.alert("Updated successfully !");
        history.push("/admin/shiftlist");
    };

    return (
        <div>
            <h3>Shift Id : {shift.shiftId}</h3>
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

export default UpdateShift;
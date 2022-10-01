import React, { useEffect, useState } from "react";
import { useHistory, useParams } from "react-router-dom";
import AdminService from "../Service/AdminService";

const UpdateRoom = () => {

    const {rId} = useParams();

    const history = useHistory();
    const [room, setRoom] = useState({
        roomId: 0,
        floorNum: 0,
        roomNum: "",
        unitPrice: 0,
        roomCategory: ""
    });

    const onInputChange = (e) => {
        setRoom({ ...room, [e.target.name]: e.target.value })
    };

    const { roomId, floorNum, roomNum, unitPrice, roomCategory } = room;

    useEffect(() => {
        loadRoom();
    }, []);

    const loadRoom = async () => {
        console.log("ID " + rId);
        await AdminService.getRoomInfo(rId).then(response => {
            console.log("romm response " + response.data);
            setRoom(response.data);
            console.log("room name " + room.roomCategory.catName + " " + room.roomId)
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
        AdminService.updateRoomDetails(rId,room).then(response => {
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
        history.push("/admin/roomlist");
    };

    return (
        <div>
            <form onSubmit={onSubmit}>
                <div class="form-group">
                    <h3>Room Id : {roomId}</h3>
                    
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Floor Number</label>
                    <input type="Number" class="form-control" id="exampleInputPassword1" placeholder="Floor Number" name="floorNum" value={floorNum} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Room Number</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Room Number" name="roomNum" value={roomNum} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Price</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Unit Price" name="unitPrice" value={unitPrice} onChange={e => onInputChange(e)} />
                </div>
                <div class="form-group">
                    <label for="cars">Choose a Room Category:</label>

                    <select name="roomCategory" id="cars" onChange={e => onInputChange(e)}>
                        <option value="1">Standard Room</option>
                        <option value="2">Standard Twin Room</option>
                        <option value="3">Executive Room</option>
                        <option value="4">Club Room</option>
                    </select>
                </div>
                <div class="but">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    )
}

export default UpdateRoom;
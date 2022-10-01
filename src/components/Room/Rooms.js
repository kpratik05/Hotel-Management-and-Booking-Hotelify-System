import React, { useState} from 'react';
import ServicesService from '../Service/ServicesService';
import {Card,Button} from 'react-bootstrap';
import {Link} from "react-router-dom";
import './Rooms.css';

const Rooms =(props)=> {

    

    const [render,setRender] = useState(false);

    const [details,setDetails] = useState({
        checkInDate:'',
        checkOutDate:'',
        sort:1,
        roomType:1
    })

    const [rooms,setRooms] = useState({
        roomId:0,
        roomNum:'',
        floorNum:'',
        unitPrice:0,
        roomCategory:''
    })

    const [msgErr,setMessage] = useState();
    const [err,setError] = useState(false);

    props.addDateHandler(details);

    const bookRoom=(room)=>{
        const usertype = window.localStorage.getItem("usertype");
        if(usertype==="manager" || usertype==="staff")
        {
            return <Link to={`/emp/roomdetails/${room.roomId}`}><Button variant="primary" >Book Room</Button></Link>
        }
        return <Link to={`/rooms/${room.roomId}`}><Button variant="primary" >Book Room</Button></Link>
    }


    const items = [];
    const getRoomList=()=>{
        if(render){
    for(let i=0;i<rooms.length ; i++)
    {
        items.push(
            
                <div class="roomc">
                    <Card >
                    {
                        imageAttatch(rooms[i])
                    }
                        <Card.Body>
                            <Card.Title>{rooms[i].roomNum}</Card.Title>
                            <Card.Text>
                                Floor Number : {rooms[i].floorNum} ,<span>       </span>
                                Price : {rooms[i].unitPrice},<span>       </span>
                                Room Type : {rooms[i].roomCategory.catName},<span>       </span>
                                Some quick example text to build on the card title and make up the
                                bulk of the card's content.
                            </Card.Text>
                            <div  class="butto">
                            {bookRoom(rooms[i])}
                            </div>
                        </Card.Body>
                    </Card>
                </div>
            )
    }
    return items;
}
return <h3>Add dates</h3>;
}
    const {checkInDate,checkOutDate,sort,roomType} = details;

    const onInputChange =(e) =>{
        setDetails({ ...details, [e.target.name] : e.target.value });
    }



    const imageAttatch =(room)=> {
        if (room.roomCategory.catId == 4) {
            return <Card.Img src="https://cdn1.goibibo.com/voy_ing/t_g/3d9ffe32e88411eca2f20a58a9feac02.jpg" alt="loading" />
        }
        if (room.roomCategory.catId == 3)
        {
            return <Card.Img src="https://www.discoveryprimea.com/files/2017/02/Executive_Suite_11.jpg" alt="loading" />
        }
        if (room.roomCategory.catId == 2)
        {
            return <Card.Img src="https://www.riversidehotel.com.au/wp-content/uploads/2016/01/RH-13.jpg" alt="loading" />
        }
        else
        {
            return <Card.Img src="https://www.hotel-de-tourny.com/wp-content/uploads/2018/11/Hotel-tourny-bordeaux-centre-single.jpg" alt="loading" />
        }
    }

    const haveError=()=>{
            if(err==true)
            {
                return <h3>Check the dates</h3>
            }
        
    }

    const handleSubmit =()=>
    {
        // let today = new Date();
        // let checkIn = new Date(checkInDate); 
        // let checkOut = new Date(checkOutDate);
        // if(today > checkIn && checkOut < today && checkIn>checkOut )
        // {
        //     setMessage("check the dates entered !");
        //     setError(true);
        // }else{
        ServicesService.getAvailableRooms(details).then(response => {
            setRooms(response.data);
            setRender(true);
        }
        )
            .catch(function (ex) {
                console.log('Response parsing failed. Error: ', ex);
            });;
    }
// }

        return (

            <div>
                <div>
                    <nav class="navbar navbar-light bg-light">
                        <div class="form-inline">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon1">Check In Date</span>
                                </div>
                                <input type="Date" class="form-control" placeholder="Check In" aria-describedby="basic-addon1" name="checkInDate" value={checkInDate} onChange={e => onInputChange(e)}  />
                            </div>
                        </div>
                        <div class="form-inline">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon1">Check Out Date</span>
                                </div>
                                <input type="Date" class="form-control" placeholder="Check Out" aria-describedby="basic-addon1" name="checkOutDate" value={checkOutDate} onChange={e => onInputChange(e)}/>
                            </div>
                        </div>
                        <div class="form-inline">
                            <label>
                                Sort by :
                                <select name="sort" onChange={e => onInputChange(e)}>
                                    <option value="1">Lowest Price First</option>
                                    <option value="2">Highest Price First</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-inline">
                            <label>
                                Room Type :
                                <select name="roomType" onChange={e => onInputChange(e)}>
                                    <option value="5">All</option>
                                    <option value="1">Standard Room</option>
                                    <option value="2">Standard Twin Room</option>
                                    <option value="3">Executive Room</option>
                                    <option value="4">Club Room</option>
                                </select>
                            </label>
                        </div>
                    <div class="getrooms">
                            <button onClick={handleSubmit} class="button">Get Rooms</button>
                            
                    </div>
                    </nav>
                    {haveError()}
                </div>
                
                <h3>available rooms </h3>
                <div>
                    {getRoomList()}   
                </div>
            </div>
        )
    }

export default Rooms;
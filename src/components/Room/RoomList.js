import React, { Component } from 'react';
import ServicesService from '../Service/ServicesService';
import { Card, Button } from 'react-bootstrap';
import { Link } from "react-router-dom";
import './RoomList.css';
class RoomList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            rooms: []
        }
    }

    imageAttatch =(room)=> {
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

    componentDidMount() {
        ServicesService.getRooms().then(response => {
            this.setState({ rooms: response.data })
        }
        )
            .catch(function (ex) {
                console.log('Response parsing failed. Error: ', ex);
            });;
    }

    render() {
        return (

            <div>
                <div class="addroom"><Link to={"/admin/addroom"}><button name="addroom">Add Room</button></Link></div>
                <div>{
                    this.state.rooms.map(room =>
                        <div>
                        <div class="roomc">
                            <Card >{
                                this.imageAttatch(room)
                            }
                                <Card.Body>
                                    <Card.Title>{room.roomNum}</Card.Title>
                                    <Card.Text>
                                        Floor Number : {room.floorNum} ,<span>       </span>
                                        Price : {room.unitPrice},<span>       </span>
                                        Room Type : {room.roomCategory.catName},<span>       </span>
                                        Some quick example text to build on the card title and make up the
                                        bulk of the card's content.
                                    </Card.Text>
                                    <div class="butto">
                                        <Link to={`/admin/updateroom/${room.roomId}`}><Button variant="primary" >Update</Button></Link>
                                    </div>
                                </Card.Body>
                            </Card>
                        </div>
                        </div>
                    )
                }
                </div>
            </div>
        )
    }
}

export default RoomList;
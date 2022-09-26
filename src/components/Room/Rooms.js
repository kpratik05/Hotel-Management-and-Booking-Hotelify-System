import React, { Component } from 'react';
import ServicesService from '../Service/ServicesService';
import {Card,Button} from 'react-bootstrap';
import {Link} from "react-router-dom";
import './Header.css';

class Room extends Component {

    constructor(props) {
        super(props);
        this.state = {
            rooms: []
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
                <div>

                    <nav class="navbar navbar-light bg-light">
                        <form class="form-inline">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon1">Check In Date</span>
                                </div>
                                <input type="Date" class="form-control" placeholder="Check In" aria-describedby="basic-addon1" />
                            </div>
                        </form>
                        <form class="form-inline">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon1">Check Out Date</span>
                                </div>
                                <input type="Date" class="form-control" placeholder="Check Out" aria-describedby="basic-addon1" />
                            </div>
                        </form>
                        <div class="form-inline">
                            <label>
                                Sort by
                                <select >
                                    <option value="lowest">Lowest Price First</option>
                                    <option value="highest">Highest Price First</option>
                                    <option value="rating">Highest Rating First</option>
                                </select>
                            </label>
                        </div>
                    </nav>

                </div>
                <div>{
                    this.state.rooms.map(room =>
                        <div class="roomcard">
                            <Card >
                                <Card.Img src="" alt="loading"/>
                                <Card.Body>
                                    <Card.Title>{room.roomNum}</Card.Title>
                                    <Card.Text>
                                        Floor Number : {room.floorNum} ,<span>       </span>
                                        Price : {room.unitPrice},<span>       </span>
                                        Room Type : {room.roomCategory.catName},<span>       </span>
                                        Some quick example text to build on the card title and make up the
                                        bulk of the card's content.
                                    </Card.Text>
                                    <div  class="butto">
                                    <Link to={"/roomdetails"}><Button variant="primary" >Book Room</Button></Link>
                                    </div>
                                </Card.Body>
                            </Card>
                        </div>
                    )
                }
                </div>
            </div>
        )
    }
}

export default Room;
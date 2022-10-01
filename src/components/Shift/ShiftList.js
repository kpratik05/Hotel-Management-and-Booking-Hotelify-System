import React, { Component } from 'react';
import AdminService from '../Service/AdminService';
import { Card, Button } from 'react-bootstrap';
import { Link } from "react-router-dom";
import './Header.css';

class ShiftList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            shifts: []
        }
    }

    
    componentDidMount() {
        AdminService.shiftList().then(response => {
            this.setState({ shifts: response.data })
        }
        )
            .catch(function (ex) {
                console.log('Response parsing failed. Error: ', ex);
            });;
    }

    render() {
        return (

            <div>
                <div class="addroom"><Link to={"/admin/addshift"}><button name="addroom">Add Shift</button></Link></div>
                <div>{
                    this.state.shifts.map(shift =>
                        <div class="roomcard">
                            <Card>
                                <Card.Header>{shift.shiftId}</Card.Header>
                                <Card.Body>
                                    <Card.Title>{shift.startTime} - {shift.endTime}</Card.Title>
                                    <Card.Text>
                                        {shift.instructions}With supporting text below as a natural lead-in to additional content.
                                    </Card.Text>
                                    <Link to={`/admin/updateshift/${shift.shiftId}`}><Button variant="primary">Update</Button></Link>
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

export default ShiftList;
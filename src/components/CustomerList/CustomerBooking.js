import React,{Component} from 'react';
import BookingService from '../Service/BookingService';
import {Table } from 'react-bootstrap';


class CustomerBooking extends Component
{
    constructor(props)
    {
        super(props);
        this.state={
            bookings:[]
        }
    }

    componentDidMount() {
        BookingService.getBookingList().then(response => {
            console.log("login list "+response.data);
            this.setState({bookings:response.data});
            // console.log("after "+this.state.logins[2].staff.name);
        }).catch(function (ex) {
            console.log('Response parsing failed. Error: ', ex);
        });;
    }

    render()
    {
        return(
            <div>
            <div>
                <h3>Customer Bookings</h3>
            </div>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Bookings ID</th>
                        <th>Booking Date</th>
                        <th>Check in date</th>
                        <th>Check out date</th>
                        <th>Booking Mode</th>
                        <th>Booking Amount</th>
                        <th>Total Days</th>
                        <th>Total Amount</th>
                        <th>Status</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.bookings.map(b => 
                            <tr>
                                <td>{b.bookingId}</td>
                                <td>{b.bookingDate}</td>
                                <td>{b.checkInDate}</td>
                                <td>{b.checkOutDate}</td>
                                <td>{b.bookingMode.mode}</td>
                                <td>{b.bookingAmount}</td>
                                <td>{b.totalDays}</td>
                                <td>{b.totalAmount}</td>
                                <td>{b.status.status}</td>
                                <td>{b.customer.name}</td>
                            </tr>
                        )
                    }
                </tbody>
            </Table>
        </div>
        )
    }
}

export default CustomerBooking;
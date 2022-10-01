import React, { useState, useEffect } from 'react';
import { useParams,useHistory } from 'react-router-dom';
import BookingService from '../Service/BookingService';
import ServicesService from '../Service/ServicesService';

const RoomDetails = (props) => {

    const history = useHistory();

    const { id } = useParams();

    const [room, setRoom] = useState({
        roomId: 0,
        roomCategory: '',
        roomNum: '',
        floorNum: 0,
        unitPrice: 0
    })

    const [booking, setBooking] = useState({
        bookingId: 0,
        bookingDate: '',
        checkInDate: '',
        checkOutDate: "",
        modeOfBooking: '',
        bookingAmount: 0,
        totalDays: 0,
        totalAmount:0,
        status: 0,
        customer: 0
    })



    const bookingMode = () => {
        const user = window.localStorage.getItem("usertype");

        if (user === "customer") {
            booking.modeOfBooking = 1;
            
            return;
        }
        
        booking.modeOfBooking = 2;
        return;
    }

    const { bookingId,
        bookingDate,
        checkInDate,
        checkOutDate,
        modeOfBooking,
        bookingAmount,
        totalDays,
        status,
        customer } = booking;
    
    useEffect(() => {
        loadRoom();
        bookingMode();
        booking.checkInDate = props.details.checkInDate;
        booking.checkOutDate = props.details.checkOutDate;
        booking.bookingDate = new Date().toISOString();
        booking.customer = window.localStorage.getItem("id");
        const date1 = new Date(booking.checkInDate);
        const date2 = new Date(booking.checkOutDate);
        const diffTime = Math.abs(date2 - date1);
        booking.totalDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        booking.status = 1;
        console.log("book "+room.unitPrice+" "+booking.totalDays)
        booking.bookingAmount = 1000;

    }, []);

    const loadRoom = async () => {
        await ServicesService.getRoomDetails(id).then(response => {
            setRoom(response.data)
        }
        )
            .catch(function (ex) {
                console.log('Response parsing failed. Error: ', ex);
            });;
    }

    const imageAttatch = (room) => {
        if (room.roomCategory.catId == 4) {
            return <img src="https://cdn1.goibibo.com/voy_ing/t_g/3d9ffe32e88411eca2f20a58a9feac02.jpg" alt="loading" />
        }
        if (room.roomCategory.catId == 3) {
            return <img src="https://www.discoveryprimea.com/files/2017/02/Executive_Suite_11.jpg" alt="loading" />
        }
        if (room.roomCategory.catId == 2) {
            return <img src="https://www.riversidehotel.com.au/wp-content/uploads/2016/01/RH-13.jpg" alt="loading" />
        }
        else {
            return <img src="https://www.hotel-de-tourny.com/wp-content/uploads/2018/11/Hotel-tourny-bordeaux-centre-single.jpg" alt="loading" />
        }
    }

    const handleSubmit = () => {
        booking.totalAmount = room.unitPrice * booking.totalDays;
        BookingService.bookRoom(id,booking).then(response => {
        }
        )
            .catch(function (ex) {
                console.log('Response parsing failed. Error: ', ex);
            });;
            window.alert("Room has been booked successfully !");
            history.push("/");
    }

    return (
        <div>
            <h3>Room Num : {room.roomNum}</h3>
            <div>{imageAttatch(room)}</div>
            <h3>Price : {room.unitPrice}</h3>
            <p>{room.roomCategory.catDesc}
                Did you know that we've got 2.5 Crore bookings since March 2020? And this is all thanks to the sanitisation and safety measures followed at our properties, from disinfecting surfaces with high-quality cleaning products and maintaining social distance to using protective gear and more.


                The property is equipped with spacious and functionally appointed rooms with basic amenities. There is an in-house restaurant present on the premises where the guests can try a variety of dishes during their stay.

                Location
                The property is located near Nanded City PMS Office in Nanded, Pune and offers a budget-friendly and restful accommodation choice.

                Amenities
                The rooms have comfortable beds with televisions, air-conditioning, private entrances, and attached bathrooms with hygienic facilities. The property is also equipped with parking facility for the guestsâ€™ vehicles, ample garden/backyard space for the residents to unwind in, and CCTV security for their safety. Card payments are accepted here, and daily housekeeping services are provided for the comfort and convenience of the residents.</p>

            <div>
                <form onSubmit={handleSubmit}>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Booking Date</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" readOnly placeholder="Name" name="bookingDate" value={bookingDate} />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Check In Date</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" readOnly name="checkInDate" value={checkInDate} />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Check Out Date</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" readOnly name="checkOutDate" value={checkOutDate} />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Mode of Booking</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" readOnly name="modeOfBooking" value={modeOfBooking} />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Booking Amount</label>
                        <input type="number" class="form-control" id="exampleInputPassword1" readOnly name="bookingAmount" value={bookingAmount} />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Total Days</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" readOnly name="totalDays" value={totalDays} />
                    </div>
                    <div class="but">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default RoomDetails;
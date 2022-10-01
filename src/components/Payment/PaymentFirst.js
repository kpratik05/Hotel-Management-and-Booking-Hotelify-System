import React,{useEffect,useState} from 'react';
import { useHistory } from 'react-router-dom';
import BookingService from '../Service/BookingService';
import "./style.css";

const PaymentFirst=()=>{

    const history = useHistory();

    const [bookingDTO, setBooking] = useState({
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

    const { bookingId,
        bookingDate,
        checkInDate,
        checkOutDate,
        modeOfBooking,
        bookingAmount,
        totalDays,
        status,
        customer } = bookingDTO;

    const [payment,setPayment] = useState({
        paymentId : 0,
        paymentDate :'',
        paymentMode:0,
        totalAmount:0,
        employeeId:0,
        booking:0
    })

    const {paymentId,paymentDate,paymentMode,totalAmount,employeeId,booking} = payment;
    
    useEffect(()=>{
        payment.paymentDate = new Date().toISOString();
        payment.paymentMode = 1;
        const user  = window.localStorage.getItem("usertype");
        if(user==="manager" || user==="staff")
        {
            payment.employeeId = window.localStorage.getItem("id");
        }
    })


    const onInputChange=(e)=>{
        setBooking({...bookingDTO,[e.target.name] : e.target.value })
    }

    const loadBooking =()=>{
        console.log("Hello")
        BookingService.getBookingDetails(bookingDTO.bookingId).then(response => {
            setBooking(response.data);
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

    const handleSubmit =()=>{
        payment.totalAmount = bookingDTO.totalAmount;
        payment.booking = bookingDTO.bookingId
        BookingService.postPayment(payment).then(response => {
        }
        )
        .catch((err) => {
            if (err.response.statuscode == 400) {
                console.log(err);
            } else {
              console.log("something else");
            }
        });;
        const user  = window.localStorage.getItem("usertype");
        history.push("/thankyou")
    }


    return(
        <div>
           < div class="container">
	<div class="main-content">
		<p class="text">Hotelify</p>
	</div>

	<div class="last-content">
		<button type="button" class="pay-now-btn">
		Booking Information
		</button>

	</div>

	<div class = "card-details">
		<label> Booking Id </label>
		<input
			type="text"
			class="booking-id-field"
			placeholder="Enter booking id"
            name="bookingId"
            value={bookingId}

            onChange  = {(e)=>onInputChange(e)}
            />
		<br/>
        <div class="last-content">
            
		<button type="button" class="pay-now-btn" onClick={loadBooking}>
		Get Details
		</button>
	</div>
		<label> Total purchase : </label>
		<h4>{bookingDTO.totalAmount}</h4>
	</div>

        <form onSubmit={handleSubmit}>
	<div class="card-details">
		<p>Pay using Credit or Debit card</p>

		<div class="card-number">
		<label> Card Number </label>
		<input
			type="text"
			class="card-number-field" 
			pattern="(?=.*[0-9]).{12}"
			placeholder="###-###-###"/>
		</div>
		<br />
		<div class="date-number">
		<label> Expiry Date </label>
		<input type="date" class="date-number-field"
				placeholder="DD-MM-YY" />
		</div>

		<div class="cvv-number">
		<label> CVV number </label>
		<input type="text" class="cvv-number-field" pattern="(?=.*[0-9]).{3}"
				placeholder="xxx" />
		</div>
		<div class="nameholder-number">
		<label> Card Holder name </label>
		<input
			type="text"
			class="card-name-field"
			placeholder="Enter your Name"/>
		</div>
		<button type="submit"
				class="submit-now-btn">
		submit
		</button>
	</div>
    </form>
	</div>
        </div>
    )

}

export default PaymentFirst;
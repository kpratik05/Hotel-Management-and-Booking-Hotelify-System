import axios from 'axios';

const baseUrl = "http://localhost:8080/hotel/";

class BookingService {
    getBookingList()
    {
        return axios.get(baseUrl+"allbooking")
    }

    bookRoom(id,booking)
    {
        return axios.post(baseUrl+"bookroom/"+id,booking)
    }

    getBookingDetails(id)
    {
        return axios.get(baseUrl+"bookingdetails/"+id);
    }

    postPayment(payment)
    {
        return axios.post(baseUrl+"payment",payment);
    }
    
}

export default new BookingService();
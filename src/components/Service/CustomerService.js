import axios from 'axios';

const baseUrl = "http://localhost:8080/customer/";

class CustomerService {
    postLogin(login)
    {
        return axios.post(baseUrl+"login",login)
    }

    getProfile(id)
    {
        return axios.get(baseUrl+"profile/"+id)
    }

    registerCustomer(customer)
    {
        return axios.post(baseUrl+"register",customer)
    }
    getBookingHistory(id)
    {
        return axios.get(baseUrl+"history/"+id)
    }

    updateCustomer(id,customer)
    {
        return axios.post(baseUrl+"update/"+id,customer)
    }

    getPaymentList(id)
    {
        return axios.get(baseUrl+"payment/"+id);
    }

}

export default new CustomerService();
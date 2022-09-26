import axios from 'axios';

const baseUrl = "http://localhost:8080/"

class ServicesService {
    
    getHome(){
        return axios.get(baseUrl);
    }

    getServices()
    {
        return axios.get(baseUrl+"services");
    }

    getRooms()
    {
        return axios.get(baseUrl+"rooms")
    }

    getServiceDetails (serviceName)
    {
        console.log("get "+serviceName);
        return  axios.get(baseUrl+"services/"+serviceName)
    }
}       

export default new ServicesService();
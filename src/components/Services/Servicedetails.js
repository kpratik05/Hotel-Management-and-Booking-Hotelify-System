import React,{useState,useEffect} from 'react';
import ServicesService  from '../Service/ServicesService';
import "./Services.css";
import { useParams } from 'react-router-dom';
import serviceImg from "./hservice.jpg"
const Servicedetails =()=>{

    const [serviceD,setService] = useState({
        serivecId:0,
        serviceName :"",
        serviceDesc : "",
        serviceUnitPrice :0
        
});

const {service} = useParams();
    
useEffect(()=>{
    loadService();},[]
    );
    
    const loadService = async () => {
        console.log("bleed "+service);
        ServicesService.getServiceDetails(service).then(response => {
                    console.log("Info "+response.data.serviceName);
                     setService(response.data);
                    
                 }
                
                   )
                   .catch(function (ex) {
                      console.log('Response parsing failed. Error: ', ex);
                   });;
    }
    
        return(
            <div>
                <div>
            <img src={serviceImg} alt="loading"></img>
                <h3 class="name"> {serviceD.serviceName}</h3>
                <h4 class="price">Service Cost : {serviceD.serviceUnitPrice}</h4>
                <p class="desc">
                    {serviceD.serviceDesc}. A service is an " act or use for which a consumer, firm, or government is willing to pay." Examples include work done by barbers, doctors, lawyers, mechanics, banks, insurance companies, and so on. Public services are those that society as a whole pays for.
                </p>
                </div>
            </div>
        )
    
}

export default Servicedetails;
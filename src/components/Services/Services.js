import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import ServicesService  from '../Service/ServicesService';
import "./Services.css";
class Services extends Component {

    constructor(props){
        super(props);
        this.state={
            services : []
        }
    }

    componentDidMount(){
        ServicesService.getServices().then(response => {
            console.log("Welcome "+response.data.serviceName)
            this.setState({ services: response.data })
        }
          )
          .catch(function (ex) {
              console.log('Response parsing failed. Error: ', ex);
          });;
    }

    render() {
        return (
            <div>
                <h3>Services provided by the hotel : </h3>
                {
                    this.state.services.map(service=>
                        <div>
                        
                <div class="media">
                    <div class="media-body">
                        <Link to={`/services/${service.serviceName}`}><h5 class="mt-0">{service.serviceName}</h5></Link>
                        {service.serviceDesc}
                    </div>
                </div>
                </div>
                        )
                }
            </div>
        )
    }
}

export default Services;
import React,{Component} from 'react';
import ManagerService from '../Service/ManagerService';

class CustomerPaymnetList extends Component
{

    constructor(props)
    {
        super(props);
        this.state={
            payments:[]
        }
    }

    componentDidMount() {
        ManagerService.getCustomerPaymnetList().then(response => {
            console.log("login list "+response.data);
            this.setState({payments:response.data});
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
                <h3>Customer payment list </h3>
            </div>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Payment ID</th>
                        <th>Date</th>
                        <th>Mode</th>
                        <th>Amount</th>
                        <th>Employee Id</th>
                        <th>Booking</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.payments.map(p => 
                            <tr>
                                <td>{p.paymenId}</td>
                                <td>{p.paymentDate}</td>
                                <td>{p.paymentMode}</td>
                                <td>{p.totalAmount}</td>
                                <td>{p.employeeId}</td>
                                <td>{p.booking.bookingId}</td>
                            </tr>
                        )
                    }
                </tbody>
            </Table>
        </div>
        )
    }
}

export default CustomerPaymnetList;
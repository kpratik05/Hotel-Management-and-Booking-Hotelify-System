import React, {  Component } from 'react';
import ManagerService from '../Service/ManagerService';
import { Table } from 'react-bootstrap';

class StaffLoginList extends Component {

    constructor(props)
    {
        super(props);
        this.state={
            logins:[]
        }
    }

    componentDidMount() {
        ManagerService.getManagerLoginList(window.localStorage.getItem("id")).then(response => {
            console.log("login list "+response.data);
            this.setState({logins:response.data});
            // console.log("after "+this.state.logins[2].staff.name);
        }).catch(function (ex) {
            console.log('Response parsing failed. Error: ', ex);
        });;
    }
    render(){
    return (
        <div>
            <div>
                <h3>Your Login info </h3>
            </div>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Login ID</th>
                        <th>Login Time</th>
                        <th>Logout Time</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.logins.map(login => 
                            <tr>
                                <td>{login.loginId}</td>
                                <td>{login.loginTime}</td>
                                <td>{login.logoutTime}</td>
                                <td>{login.date}</td>
                            </tr>
                        )
                    }
                </tbody>
            </Table>
        </div>
    )
                }
                
}

export default StaffLoginList;
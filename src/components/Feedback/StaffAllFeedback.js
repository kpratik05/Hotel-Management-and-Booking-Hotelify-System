import React,{Component} from 'react';
import ManagerService from '../Service/ManagerService';
import {Table} from 'react-bootstrap';

class StaffAllFeedback extends Component
{

    constructor(props)
    {
        super(props);
        this.state={
            fdback:[]
        }
    }

    componentDidMount() {
        let id = window.localStorage.getItem("deptId");
        ManagerService.getAllFeedback(id).then(response => {
            console.log("login list "+response.data);
            this.setState({fdback:response.data});
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
                <h3>Employee Feedback list </h3>
            </div>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Feedback ID</th>
                        <th>Feedback</th>
                        <th>Date</th>
                        <th>Employee Id</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.fdback.map(f => 
                            <tr>
                                <td>{f.employeeFeedbackId}</td>
                                <td>{f.feedback}</td>
                                <td>{f.date}</td>
                                <td>{f.staff.employeeId}</td>
                            </tr>
                        )
                    }
                </tbody>
            </Table>
        </div>
        )
    }
}

export default StaffAllFeedback;
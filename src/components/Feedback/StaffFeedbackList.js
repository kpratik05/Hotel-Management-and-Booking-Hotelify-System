import React,{Component} from 'react';
import { Table } from 'react-bootstrap';
import {Link, useParams} from 'react-router-dom';
import ManagerService from '../Service/ManagerService';

function withParams(Component) {
    return props => <Component {...props} params={useParams()} />;
  }

class StaffFeedbackList extends Component
{
    
    constructor(props)
    {
        super(props);
        this.state={
            feedbacks:[]
        }
    }

    componentDidMount() {
        console.log("water");
        let { id } = this.props.params;
        ManagerService.getFeedbackOfStaff(id).then(response => {
            console.log("emps "+response.data);
            this.setState({feedbacks:response.data});
        }).catch(function (ex) {
            console.log('Response parsing failed. Error: ', ex);
        });;
    }

    render(){
    return(
        <div>
            <div>
                <h3>All feedback</h3>
            </div>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Feedback ID</th>
                        <th>Feedback</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.feedbacks.map(f => 
                            <tr>
                                <td>{f.employeeFeedbackId}</td>
                                <td>{f.feedback}</td>
                                <td>{f.date}</td>
                            </tr>
                        )
                    }
                </tbody>
            </Table>
            {/* <h3>Hello {this.state.emps[2].department.deptName}</h3> */}
        </div>
    )
                }
}   

export default withParams(StaffFeedbackList);
import React,{Component} from 'react';
import { Table } from 'react-bootstrap';
import AdminService from '../Service/AdminService';
class ManagerAllList extends Component
{

    constructor(props)
    {
        super(props);
        this.state={
            emps:[]
        }
    }

    componentDidMount() {
        console.log("water");
        AdminService.getAllManagerList().then(response => {
            console.log("emps "+response.data);
            this.setState({emps:response.data});
            // console.log("after "+this.state.emps[2].name);
        }).catch(function (ex) {
            console.log('Response parsing failed. Error: ', ex);
        });;
    }

    render(){
    return(
        <div>
            <div>
                <h3>Employees List of Department </h3>
            </div>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Mobile No</th>
                        <th>Address</th>
                        <th>BirthDate</th>
                        <th>Department</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.emps.map(emp => 
                            <tr>
                                <td>{emp.employeeId}</td>
                                <td>{emp.name}</td>
                                <td>{emp.email}</td>
                                <td>{emp.mobileNo}</td>
                                <td>{emp.address}</td>
                                <td>{emp.birthDate}</td>
                                <td>{emp.department.deptName}</td>
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

export default ManagerAllList;
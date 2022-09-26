import React, { Component } from 'react';
import { useHistory } from 'react-router-dom';
import "./Login.css";

class Stafflogin extends Component {

    routeChange = () => {
        let path = `/stafflogin`;
        let history = useHistory();
        history.push(path);
    }


    render() {
        return (
            <div>
                <div class="card text-center">
                    <div class="card-header">
                        <ul class="nav nav-tabs card-header-tabs">
                            <li class="nav-item">
                                <a class="nav-link active" href="/stafflogin">Staff login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/managerlogin">Manager login</a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Employee Id</label>
                                <input type="number" class="form-control" id="exampleInputEmail1" placeholder="Enter id" />

                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
                            </div>
                            <div class="but">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>



            </div>
        )
    }
}

export default Stafflogin;
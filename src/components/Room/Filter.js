import React, { Component } from 'react';
import './Header.css';

class Filter extends Component {

    render() {
        return (
            <nav class="navbar navbar-light bg-light">
                <form class="form-inline">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Check In Date</span>
                        </div>
                        <input type="Date" class="form-control" placeholder="Check In" aria-describedby="basic-addon1" />
                    </div>
                </form>
                <form class="form-inline">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Check Out Date</span>
                        </div>
                        <input type="Date" class="form-control" placeholder="Check Out" aria-describedby="basic-addon1" />
                    </div>
                </form>
                <div>
                    <label>
                        Sort by
                        <select >
                            <option value="lowest">Lowest Price First</option>
                            <option value="highest">Highest Price First</option>
                            <option value="rating">Highest Rating First</option>
                        </select>
                    </label>
                </div>
            </nav>
        )
    }
}

export default Filter;
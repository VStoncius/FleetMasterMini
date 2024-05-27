import React, { Component } from "react";
import {BsFillPencilFill, BsFillTrashFill} from "react-icons/bs"
import axios from "axios";

import "./Table.css";

class Table extends Component {
    constructor(props){
        super(props);
        this.state = {
            trucks: []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/trucks/all")
          .then(res => {
            const newData = res.data;
            this.setState({trucks: newData})
          })
      }

    render()
    {
        return <div className="table-wrapper">
            <table className="table">
                <thead>
                    <tr>
                        <th>Number</th>
                        <th>Truck ID</th>
                        <th >Trailer ID</th>
                        <th className="expand">Drivers</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.trucks.map(truck => {
                        return (
                        <tr>
                            <td></td>
                            <td>{truck.truckIdentificationNumber}</td>
                            <td>{truck.assignedTrailerNumber}</td>
                            <td>{truck.drivers}</td>
                            <td>
                                <span className="actions">
                                    <BsFillPencilFill className="edit-btn"/>
                                    <BsFillTrashFill className="delete-btn"/>
                                </span>
                            </td>
                    </tr>)
                    })}
                </tbody>
            </table>
        </div> 
    }
}

export default Table;
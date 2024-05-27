import React, { Component } from "react";
import {BsFillPencilFill, BsFillTrashFill} from "react-icons/bs"
import axios from "axios";

import "./Table.css";
import EditModal from "./EditModal";

class Table extends Component {
    constructor(props){
        super(props);
        this.state = {
            trucks: [],
            editModalOpen: false,
            currentTruck: null,
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/trucks/all")
          .then(res => {
            const newData = res.data;
            this.setState({trucks: newData})
          })
      }

    handleEditClick = (truck) => {
        this.setState({ currentTruck: truck, editModalOpen: true });
    };

    closeEditModal = () => {
        this.setState({editModalOpen: false, currentTruck: null });
    };

    handleSaveChanges = (updatedTruck) => {
        const updatedTrucks = this.state.trucks.map((truck) =>
            truck.truckIdentificationNumber === updatedTruck.truckIdentificationNumber ? updatedTruck : truck
        );
        this.setState({trucks: updatedTrucks, editModalOpen: false, currentTruck: null});
    };

    render()
    {
        return <div>
            <div className="table-wrapper">
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
                        <tr key={truck.truckIdentificationNumber}>
                            <td></td>
                            <td>{truck.truckIdentificationNumber}</td>
                            <td>{truck.assignedTrailerNumber}</td>
                            <td>{truck.drivers}</td>
                            <td>
                                <span className="actions">
                                    <BsFillPencilFill className="edit-btn"
                                                onClick={() => this.handleEditClick(truck)}/>
                                    <BsFillTrashFill className="delete-btn"/>
                                </span>
                            </td>
                    </tr>)
                    })}
                </tbody>
            </table>
        </div> 
        {this.state.editModalOpen && (
                    <EditModal
                        truck={this.state.currentTruck}
                        closeEditModal={this.closeEditModal}
                        saveChanges={this.handleSaveChanges}
                    />
                )}
        </div>
        
    }
}

export default Table;
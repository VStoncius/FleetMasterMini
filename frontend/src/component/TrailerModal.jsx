import React, { Component } from "react";
import axios from "axios";

import "./Modal.css"

class TrailerModal extends Component {
    constructor(props){
        super(props);
        this.state = {
            fleetIdentificationNumber: 0,
            model: "",
            volume: 0,
            assignedTruck: 0
        }
    }

      handleSubmit = (e) => {
        e.preventDefault();
      
        try {
            const formData = {
                "fleetIdentificationNumber": this.state.fleetIdentificationNumber,
                "model": this.state.model,
                "volume": this.state.volume,
                "assignedTruck": this.state.assignedTruck
            }
            console.log(formData);
            const response = axios.post('http://localhost:8080/trailers/create', formData);
            console.log('Form data submitted successfully:', response.data);
        } catch (error) {
            console.error('Error submitting form data:', error);
        }
      };

    render()
    {
        return <div className="trailer-modal-container" onClick={(e) => {
            if(e.target.className === "trailer-modal-container")this.props.closeTrailerModal()}}>
            <div className="modal">
                <form onSubmit={this.handleSubmit}>
                    <h1>Add Driver</h1>
                        <div className="form-group">
                            <label htmlFor="fleet-id">Fleet identification number</label>
                            <input name="fleet-id" type="number" value={this.state.fleetIdentificationNumber} onChange={(e) => this.setState({fleetIdentificationNumber: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="model">Model</label>
                            <input name="model" type="text" value={this.state.model} onChange={(e) => this.setState({model: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="volume">Volume</label>
                            <input name="volume" type="number" value={this.state.volume} onChange={(e) => this.setState({volume: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="assigned-truck">Assigned truck</label>
                            <input name="assigned-truck" type="number" value={this.state.assignedTruck} onChange={(e) => this.setState({assignedTruck: e.target.value})}/>
                        </div>
                    <button type="submit" className="btn">Submit</button>
                </form>
            </div>
        </div>
    }

}

export default TrailerModal
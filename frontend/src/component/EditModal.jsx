import React, { Component } from "react";
import axios from "axios";

import "./Modal.css"

class EditModal extends Component {
    constructor(props){
        super(props);
        this.state = {
            trailers: [],
            id: props.truck.truckIdentificationNumber,
            model: props.truck.model,
            drivers: props.truck.drivers,
            trailer: props.truck.trailer
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/trailers/all")
          .then(res => {
            const newData = res.data;
            this.setState({trailers: newData})
          })
      }

      handleSubmit = (e) => {
        e.preventDefault();
      
        try {
            const formData = {
                "truckIdentificationNumber": this.state.id,
                "model": this.state.model,
                "assignedTrailerNumber": this.state.trailer,
                "drivers": this.state.drivers
            }
            const response = axios.post('http://localhost:8080/trucks/update', formData);
            console.log('Form data submitted successfully:', response.data);
            this.props.saveChanges(formData);
            this.props.closeEditModal();
        } catch (error) {
            console.error('Error submitting form data:', error);
        }
      };

    render()
    {
        return <div className="modal-container" onClick={(e) => {
            if(e.target.className === "modal-container")this.props.closeEditModal()}}>
            <div className="modal">
                <form onSubmit={this.handleSubmit}>
                    <h1>Edit Truck</h1>
                        <div className="form-group">
                            <label htmlFor="truck-id">Fleet identification number: {this.state.id} </label>
                        </div>
                        <div className="form-group">
                            <label htmlFor="truck-model">Model</label>
                            <input name="truck-model" type="text" value={this.state.model} onChange={(e) => this.setState({model: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="assigned-trailer">Assigned trailer</label>
                            <select name="assigned-trailer" value={this.state.trailer} onChange={(e) => this.setState({trailer: e.target.value})}>
                            {this.state.trailers.map(trailer => {
                        return (
                            <option type="number" key={trailer.fleetIdentificationNumber} value={trailer.fleetIdentificationNumber}>{trailer.fleetIdentificationNumber}</option>
                        )
                    })}
                            </select>
                        </div>
                    <button type="submit" className="btn">Submit</button>
                </form>
            </div>
        </div>
    }

}

export default EditModal
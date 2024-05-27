import React, { Component } from "react";
import axios from "axios";

import "./Modal.css"

class Modal extends Component {
    constructor(props){
        super(props);
        this.state = {
            trailers: [],
            id: 0,
            model: "",
            trailer: 0
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
            const formData = {"truckIdentificationNumber": this.state.id,
                "model": this.state.model,
                "assignedTrailerNumber": this.state.trailer,
                "drivers": []}
            const response = axios.post('http://localhost:8080/trucks/create', formData);
            console.log('Form data submitted successfully:', response.data);
        } catch (error) {
            console.error('Error submitting form data:', error);
        }
      };

    render()
    {
        return <div className="modal-container" onClick={(e) => {
            if(e.target.className === "modal-container")this.props.closeModal()}}>
            <div className="modal">
                <form onSubmit={this.handleSubmit}>
                    <h1>Add Truck</h1>
                        <div className="form-group">
                            <label htmlFor="truck-id">Truck ID goes here</label>
                            <input name="truck-id" type="number" value={this.state.id} onChange={(e) => this.setState({id: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="truck-model">Model</label>
                            <input name="truck-model" type="text" value={this.state.model} onChange={(e) => this.setState({model: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="assigned-trailer">Assigned trailer</label>
                            <select name="assigned-trailer" onChange={(e) => this.setState({trailer: e.target.value})}>
                            {this.state.trailers.map(trailer => {
                        return (
                            <option type="number" value={trailer.fleetIdentificationNumber}>{trailer.fleetIdentificationNumber}</option>
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

export default Modal
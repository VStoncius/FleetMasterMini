import React, { Component } from "react";
import axios from "axios";

import "./Modal.css"

class DriverModal extends Component {
    constructor(props){
        super(props);
        this.state = {
            identification: "",
            firstName: "",
            lastName: "",
            middleName: ""
        }
    }

      handleSubmit = (e) => {
        e.preventDefault();
      
        try {
            const formData = {
                "personalIdentification": this.state.identification,
                "firstName": this.state.firstName,
                "lastName": this.state.lastName,
                "middleName": this.state.middleName,
                "truckIdentificationNumber": 0
            }
            const response = axios.post('http://localhost:8080/drivers/create', formData);
            console.log('Form data submitted successfully:', response.data);
        } catch (error) {
            console.error('Error submitting form data:', error);
        }
      };

    render()
    {
        return <div className="driver-modal-container" onClick={(e) => {
            if(e.target.className === "driver-modal-container")this.props.closeDriverModal()}}>
            <div className="modal">
                <form onSubmit={this.handleSubmit}>
                    <h1>Add Driver</h1>
                        <div className="form-group">
                            <label htmlFor="driver-id">Driver identification</label>
                            <input name="driver-id" type="text" value={this.state.identification} onChange={(e) => this.setState({identification: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="first-name">First name</label>
                            <input name="first-name" type="text" value={this.state.firstName} onChange={(e) => this.setState({firstName: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="last-name">Last name</label>
                            <input name="last-name" type="text" value={this.state.lastName} onChange={(e) => this.setState({lastName: e.target.value})}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="middle-name">Middle name</label>
                            <input name="middle-name" type="text" value={this.state.middleName} onChange={(e) => this.setState({middleName: e.target.value})}/>
                        </div>
                    <button type="submit" className="btn">Submit</button>
                </form>
            </div>
        </div>
    }

}

export default DriverModal
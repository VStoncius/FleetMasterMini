import React, { Component } from "react";

import "./Modal.css"

class Modal extends Component {
    constructor(props){
        super(props);
        this.state = {
            text: "testing text"
        }
    }

    render()
    {
        return <div className="modal-container" onClick={(e) => {
            if(e.target.className === "modal-container")this.props.closeModal()}}>
            <div className="modal">
                <form>
                    <h1>Edit Truck</h1>
                        <div className="form-group">
                            <label htmlFor="truck-id">Truck ID goes here</label>
                        </div>
                        <div className="form-group">
                            <label htmlFor="truck-model">Model</label>
                            <input name="truck-model"/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="assigned-trailer">Assigned trailer</label>
                            <select name="assigned-trailer">
                                <option>1</option>
                                <option>2</option>
                            </select>
                        </div>
                    <button type="submit" className="btn">Submit</button>
                </form>
            </div>
        </div>
    }
}

export default Modal
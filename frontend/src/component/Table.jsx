import React, { Component } from "react";
import {BsFillPencilFill, BsFillTrashFill} from "react-icons/bs"

import "./Table.css";

class Table extends Component {
    constructor(props){
        super(props);
        this.state = {
            text: "testing text"
        }
    }

    render()
    {
        return <div className="table-wrapper">
            <table className="table">
                <thead>
                    <tr>
                        <th>Number</th>
                        <th>Truck</th>
                        <th >Trailer</th>
                        <th className="expand">Drivers</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Test Truck</td>
                        <td className="empty-row">Best trailer</td>
                        <td className="empty-row">drivers list</td>
                        <td>
                            <span className="actions">
                                <BsFillPencilFill className="edit-btn"/>
                                <BsFillTrashFill className="delete-btn"/>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Test Truck 2 </td>
                        <td>Best trailer again</td>
                        <td>drivers list another driver</td>
                        <td>
                            <span>
                                <BsFillTrashFill />
                                <BsFillPencilFill />
                            </span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div> 
    }
}

export default Table;
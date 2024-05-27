import './App.css';
import { useState } from 'react';
import Table from './component/Table';
import Modal from './component/Modal';
import DriverModal from './component/DriverModal';
import TrailerModal from './component/TrailerModal';

function App() {
  const[modalOpen, setModalOpen] = useState(false);
  const[driverModalOpen, setDriverModalOpen] = useState(false);
  const[trailerModalOpen, setTrailerModalOpen] = useState(false);

  return (
      <div className="App">
        <Table setEditModalOpen/>
          <div>
            <button className='btn' onClick={() => setModalOpen(true)}>Add truck</button>
            <button className='btn' onClick={() => setDriverModalOpen(true)}>Add driver</button>
            <button className='btn' onClick={() => setTrailerModalOpen(true)}>Add trailer</button>
          </div>
        {modalOpen && (<Modal closeModal={() => setModalOpen(false)}/>)}
        {driverModalOpen && (<DriverModal closeDriverModal={() => setDriverModalOpen(false)}/>)}
        {trailerModalOpen && (<TrailerModal closeTrailerModal={() => setTrailerModalOpen(false)}/>)}
      </div>
    );
  }


export default App;

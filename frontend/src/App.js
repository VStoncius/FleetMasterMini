import './App.css';
import { useState } from 'react';
import Table from './component/Table';
import Modal from './component/Modal';
import DriverModal from './component/DriverModal';

function App() {
  const[modalOpen, setModalOpen] = useState(false);
  const[driverModalOpen, setDriverModalOpen] = useState(false);

  return (
      <div className="App">
        <Table/>
        <button className='btn' onClick={() => setModalOpen(true)}>Add truck</button>
        {modalOpen && (<Modal closeModal={() => setModalOpen(false)}/>)}
        <button className='btn' onClick={() => setDriverModalOpen(true)}>Add driver</button>
        {driverModalOpen && (<DriverModal closeDriverModal={() => setDriverModalOpen(false)}/>)}
      </div>
    );
  }


export default App;

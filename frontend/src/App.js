import './App.css';
import { useState } from 'react';
import Table from './component/Table';
import Modal from './component/Modal';

function App() {
  const[modalOpen, setModalOpen] = useState(false);

  return (
      <div className="App">
        <Table/>
        <button className='btn' onClick={() => setModalOpen(true)}>Add truck</button>
        {modalOpen && (<Modal closeModal={() => setModalOpen(false)}/>)}
      </div>
    );
  }


export default App;

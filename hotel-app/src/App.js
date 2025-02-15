import './App.css';
import { useEffect } from 'react';
import Header from './components/Header';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Screen from './pages/Screen';

function App() {

  useEffect(() => {
  }, [])

  return (
      <Router>
        <Header />
        <Routes>
          <Route path="/" element={<Screen selected={"hotel"} />} />
          <Route path="/rooms" element={<Screen selected={"room"} />} />
          <Route path="/guests" element={<Screen selected={"guest"} />} />
          <Route path="/reservations" element={<Screen selected={"reservation"} />} />
        </Routes>
      </Router>
  );
}

export default App;

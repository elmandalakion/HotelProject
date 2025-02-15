import './Header.css';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

export default function Header() {

  const [open, setOpen] = useState(false)

  useEffect(() => {
  }, [])

  return (
    <header>
      {open && 
        <form className='stuff'>
          <button className='close-x' onClick={() => {setOpen(false)}}>x</button>
          <p>Staff:</p>
          <p><span>Co-founder: </span>Elena Mandaltsi (2021082)</p>
          <p><span>Co-founder: </span>Chrysa Moulianitaki (2021095)</p>
        </form>}
      <p className='hotel-title' onClick={() => {setOpen(true)}}>Hotelification</p>
      <nav>
        <Link to="/">Hotels</Link>
        <Link to="/rooms">Rooms</Link>
        <Link to="/guests">Guests</Link>
        <Link to="/reservations">Reservations</Link>
      </nav>
    </header>
  );
}

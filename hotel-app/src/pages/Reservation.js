import './Reservation.css';
import { useEffect } from 'react';

export default function Reservation({reservation}) {

  useEffect(() => {
    
  }, [])

  return (
    <div>
      <p className='title'>{reservation.full_name}</p>
      <p >{reservation.hotel_address}</p>
      <p >{reservation.accomodations}</p>
      <p >{reservation.number_of_rooms}</p>
    </div>
  );
}
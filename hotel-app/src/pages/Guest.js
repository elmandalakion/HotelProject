import './Guest.css';
import { useEffect } from 'react';

export default function Guest({guest}) {

  useEffect(() => {
  }, [])

  return (
    <div>
      <p className='title'>{guest.full_name}</p>
      <p >{guest.hotel_address}</p>
      <p >{guest.accomodations}</p>
      <p >{guest.number_of_rooms}</p>
    </div>
  );
}
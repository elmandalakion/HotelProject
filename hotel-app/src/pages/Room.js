import './Room.css';
import { useEffect } from 'react';

export default function Room({room}) {

  useEffect(() => {
  }, [])

  return (
    <div>
      <p className='title'>{room.full_name}</p>
      <p >{room.hotel_address}</p>
      <p >{room.accomodations}</p>
      <p >{room.number_of_rooms}</p>
    </div>
  );
}
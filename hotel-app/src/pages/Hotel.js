import { getHotels } from '../services/hotel-service';
import './Hotel.css';
import { useEffect, useState } from 'react';

export default function Hotel({hotel}) {

  useEffect(() => {
  }, [])

  // const getTheHotels = async () => {
  //   try {
  //     const hotels = await getHotels()
  //     if (hotels.length)
  //       setHotels(hotels)
  //   }
  //   catch {
  //     //displayError
  //   }
  // }

  return (
    <div>
      <img src="%PUBLIC_URL%/hotel_image.jpg" />
      <p className='title'>{hotel.hotel_name}</p>
      <p >{hotel.hotel_address}</p>
      <p >{hotel.accomodations}</p>
      <p >{hotel.number_of_rooms}</p>
    </div>
  );
}
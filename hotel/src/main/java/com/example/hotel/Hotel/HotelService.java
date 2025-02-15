package com.example.hotel.Hotel;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class HotelService {
    
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    
    public List<Hotel> getHotels() {
       return hotelRepository.findAll();
     }

    public void addNewHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long hotel_id) {

      boolean exists =  hotelRepository.existsById(hotel_id);
      if (!exists) {

          throw new IllegalStateException(
                  ("Hotel with id " + hotel_id+ "does not exist"));
      }
      hotelRepository.deleteById(hotel_id);
    }

    @Transactional 
    public void updateHotel(Long hotel_id, String new_name, String hotel_address, int number_of_rooms, String accomodations){
       Hotel hotel =  hotelRepository.findById(hotel_id)
                .orElseThrow(() -> new IllegalStateException(
                    "hotel with id" +hotel_id+ "does not exist"
                ));
       if ( new_name != null && !Objects.equals(hotel.getHotel_name(), new_name)) { //to onoma poy dothike den einai to onoma poy yparxei hdh
        hotel.setHotel_name(new_name);
       }
    
    
    }
    
}

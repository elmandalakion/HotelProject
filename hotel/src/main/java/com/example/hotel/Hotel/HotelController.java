package com.example.hotel.Hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path="hotel")
public class HotelController {
    
    private final HotelService hotelService;
    
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping
    public List<Hotel> getHotels() {
        return hotelService.getHotels();

    }
    @PostMapping
    public void addNewHotel(@RequestBody Hotel hotel) {
        hotelService.addNewHotel(hotel);
    }

    @DeleteMapping(path = "{hotel_id}")
    public void deleteHotel(@PathVariable("hotel_id") Long hotel_id) {
        hotelService.deleteHotel(hotel_id);

    }

    
    // @PutMapping(path = "{hotel_id}")
    // public void updateHotel(
    //   @PathVariable("hotel_id") Long hotel_id,
    //   @RequestParam(required = false) String hotel_name,
    //   @RequestParam(required = false) String hotel_address)
    //    {

    //       hotelService.updateHotel(hotel_id, hotel_name, hotel_address, number_of_rooms, hotel_address);        
    //   }

}

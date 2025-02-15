package com.example.hotel.Hotel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
    
    @Id
    @SequenceGenerator(
            name = "hotel_sequence",
            sequenceName = "hotel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hotel_sequence"

    )
    private Long hotel_id;
    private String hotel_name;
    private String hotel_address;
    private int number_of_rooms;
    private String accomodations;
    public Hotel() {
    }
    public Hotel(Long hotel_id, String hotel_name, String hotel_address, int number_of_rooms, String accomodations) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.number_of_rooms = number_of_rooms;
        this.accomodations = accomodations;
    }
    public Long getHotel_id() {
        return hotel_id;
    }
    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }
    public String getHotel_name() {
        return hotel_name;
    }
    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }
    public String getHotel_address() {
        return hotel_address;
    }
    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }
    public int getNumber_of_rooms() {
        return number_of_rooms;
    }
    public void setNumber_of_rooms(int number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }
    public String getAccomodations() {
        return accomodations;
    }
    public void setAccomodations(String accomodations) {
        this.accomodations = accomodations;
    }
    @Override
    public String toString() {
        return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_address=" + hotel_address
                + ", number_of_rooms=" + number_of_rooms + ", accomodations=" + accomodations + "]";
    }
    
    
    
}

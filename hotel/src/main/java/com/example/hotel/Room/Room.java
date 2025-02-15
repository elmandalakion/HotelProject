package com.example.hotel.Room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @SequenceGenerator(
            name = "room_sequence",
            sequenceName = "room_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_sequence"

    )
    private String room_id;
    private String room_type;
    private boolean room_availability;
    private Long room_price;
    
    public Room() {
    }

    

    public Room(String room_id, String room_type, boolean room_availability, Long room_price) {
        this.room_id = room_id;
        this.room_type = room_type;
        this.room_availability = room_availability;
        this.room_price = room_price;
    }



    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public boolean isRoom_availability() {
        return room_availability;
    }

    public void setRoom_availability(boolean room_availability) {
        this.room_availability = room_availability;
    }

    public Long getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Long room_price) {
        this.room_price = room_price;
    }

    @Override
    public String toString() {
        return "Room [room_id=" + room_id + ", room_type=" + room_type + ", room_availability=" + room_availability
                + ", room_price=" + room_price + "]";
    }

    

}

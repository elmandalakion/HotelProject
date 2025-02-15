package com.example.hotel.Room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class RoomService {
    
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRoom() {
       return roomRepository.findAll();
     }

    public void addNewRoom(Room room) {
        roomRepository.save(room);
    }

    public void deleteRoom(Long room_id) {

      boolean exists =  roomRepository.existsById(room_id);
      if (!exists) {

          throw new IllegalStateException(
                  ("room with id " + room_id+ "does not exist"));
      }
      roomRepository.deleteById(room_id);
    }

    @Transactional 
    public void updateRoomState(Long room_id, String new_email, String new_phone ){
       Room room =  roomRepository.findById(room_id)
                .orElseThrow(() -> new IllegalStateException(
                    "there is no room with id number: " +room_id));
        
         room.setRoom_availability(true);       

    }

}

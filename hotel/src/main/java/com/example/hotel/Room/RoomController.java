package com.example.hotel.Room;

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
@RequestMapping(path="room")
public class RoomController {
    
    private final RoomService roomService;
    
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping
    public List<Room> getRoom() {
        return roomService.getRoom();

    }
    @PostMapping
    public void addNewRoom(@RequestBody Room room) {
        roomService.addNewRoom(room);

    }

    @DeleteMapping(path = "{room_id}")
    public void deleteRoom(@PathVariable("room_id") Long room_id) {
        roomService.deleteRoom(room_id);

    }

}

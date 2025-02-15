package com.example.hotel.Guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path="guest")
public class GuestController {
    
    private final GuestService guestService;
    
    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }
    
    @GetMapping
    public List<Guest> getGuest() {
        return guestService.getGuest();

    }
    @PostMapping
    public void addNewGuest(@RequestBody Guest guest) {
        guestService.addNewStudent(guest);

    }

    @DeleteMapping(path = "{guest_id}")
    public void deleteGuest(@PathVariable("guest_id") Long guest_id) {
        guestService.deleteGuest(guest_id);

    }

    
    @PutMapping(path = "{guest_id}")
    public void updateStudent(
      @PathVariable("guest_id") Long guest_id,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {

        guestService.updateGuest(guest_id, email, name);
      }
}

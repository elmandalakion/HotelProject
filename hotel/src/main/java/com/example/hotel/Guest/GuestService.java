package com.example.hotel.Guest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class GuestService {
    
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
    public List<Guest> getGuest() {
       return guestRepository.findAll();
     }

    public void addNewStudent(Guest guest) {
        Optional<Guest> guestOptional = guestRepository.findById(guest.getGuest_id());
        if (guestOptional.isPresent()){
            throw new IllegalStateException("guest name already in the data base");

        }
        guestRepository.save(guest);
    }

    public void deleteGuest(Long guest_id) {

      boolean exists =  guestRepository.existsById(guest_id);
      if (!exists) {

          throw new IllegalStateException(
                  ("guest with id " + guest_id+ "does not exist"));
      }
      guestRepository.deleteById(guest_id);
    }

    @Transactional 
    public void updateGuest(Long guest_id, String new_email, String new_phone ){
       Guest guest =  guestRepository.findById(guest_id)
                .orElseThrow(() -> new IllegalStateException(
                    "guest with id" +guest_id+ "does not exist"
                ));
       if (new_email != null && !Objects.equals(guest.getGuest_email(), new_email)) { //to onoma poy dothike den einai to onoma poy yparxei hdh
        guest.setGuest_email(new_email);
       }

       if (new_phone != null && !Objects.equals(guest.getGuest_phone(), new_phone)) {
        Optional<Guest> guestOptional = guestRepository.findById(guest.getGuest_id());
        if (guestOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        guest.setGuest_phone(new_phone);
       }
    }
}

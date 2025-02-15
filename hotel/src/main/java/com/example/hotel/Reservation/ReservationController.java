package com.example.hotel.Reservation;

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
@RequestMapping(path="reservation")
public class ReservationController {
    
    private final ReservationService reservationService;
    
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<Reservation> getReservations() {
        return reservationService.getReservations();

    }
    @PostMapping
    public void registerNewStudent(@RequestBody Reservation reservation) {
        reservationService.addNewReservation(reservation);

    }

    @DeleteMapping(path = "{reservation_id}")
    public void deleteReservation(@PathVariable("reservation_id") Long reservation_id) {
        reservationService.deleteReservation(reservation_id);

    }

    
    // @PutMapping(path = "{reservation_id}")
    // public void updateStudent(
    //   @PathVariable("reservation_id") Long reservation_id,
    //   @RequestParam(required = false) String name,
    //   @RequestParam(required = false) String email) {

    //     reservationService.updateReservation(reservation_id, name, email);
    //   }

}

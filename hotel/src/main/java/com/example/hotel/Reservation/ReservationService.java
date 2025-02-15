package com.example.hotel.Reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations() {
       return reservationRepository.findAll();
     }

    public void addNewReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long reservation_id) {

      boolean exists =  reservationRepository.existsById(reservation_id);
      if (!exists) {

          throw new IllegalStateException(
                  ("reservation with id " + reservation_id+ "does not exist"));
      }
      reservationRepository.deleteById(reservation_id);
    }

   

}

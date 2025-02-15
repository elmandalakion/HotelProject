package com.example.hotel.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //  @Query("SELECT s FROM reservation s WHERE s.reservation_id = :reservation_id")
    // Optional<Reservation> findReservationById(Long reservation_id);
}

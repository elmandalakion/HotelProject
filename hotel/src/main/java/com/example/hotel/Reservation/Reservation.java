package com.example.hotel.Reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
    
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"

    )
    private Long reservation_id;
    private String name_of_reservation;
    private String check_in_date;
    private String check_out_date;
    public Reservation() {
    }
    public Reservation(Long reservation_id, String name_of_reservation, String check_in_date, String check_out_date) {
        this.reservation_id = reservation_id;
        this.name_of_reservation = name_of_reservation;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
    }
    public Long getReservation_id() {
        return reservation_id;
    }
    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }
    public String getName_of_reservation() {
        return name_of_reservation;
    }
    public void setName_of_reservation(String name_of_reservation) {
        this.name_of_reservation = name_of_reservation;
    }
    public String getCheck_in_date() {
        return check_in_date;
    }
    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }
    public String getCheck_out_date() {
        return check_out_date;
    }
    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }
    @Override
    public String toString() {
        return "Reservation [reservation_id=" + reservation_id + ", name_of_reservation=" + name_of_reservation
                + ", check_in_date=" + check_in_date + ", check_out_date=" + check_out_date + "]";
    }
    
    
    
}

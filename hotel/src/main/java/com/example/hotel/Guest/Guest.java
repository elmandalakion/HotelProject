package com.example.hotel.Guest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @SequenceGenerator(
            name = "guest_sequence",
            sequenceName = "guest_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guest_sequence"

    )
    private Long guest_id;
    private String guest_name;
    private String guest_email;
    private String guest_phone;
    public Guest() {
    }
    public Guest(Long guest_id, String guest_name, String guest_email, String guest_phone) {
        this.guest_id = guest_id;
        this.guest_name = guest_name;
        this.guest_email = guest_email;
        this.guest_phone = guest_phone;
    }
    public Long getGuest_id() {
        return guest_id;
    }
    public void setGuest_id(Long guest_id) {
        this.guest_id = guest_id;
    }
    public String getGuest_name() {
        return guest_name;
    }
    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }
    public String getGuest_email() {
        return guest_email;
    }
    public void setGuest_email(String guest_email) {
        this.guest_email = guest_email;
    }
    public String getGuest_phone() {
        return guest_phone;
    }
    public void setGuest_phone(String guest_phone) {
        this.guest_phone = guest_phone;
    }
    @Override
    public String toString() {
        return "Guest [guest_id=" + guest_id + ", guest_name=" + guest_name + ", guest_email=" + guest_email
                + ", guest_phone=" + guest_phone + "]";
    }
   
    
    
    
    
}

package com.hrs.hotel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    private String booking_id;
    private String user_id;
    private String room_id;
    private LocalDate booking_date;
    private LocalDate check_out_date;
    private Integer amount;
    private PaymentStatus payment_status;

    @ManyToOne
    @JsonIgnore
    private Hotel hotel;
    @Transient
    @JsonIgnore
    private User user;

}

package com.hrs.hotel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long room_id;
    private String room_type;
    private String room_number;
    private Integer roomPrice;
    private Status status;
    private String room_description;
    @ManyToOne
    @JsonIgnore
    private Hotel hotel;
    
}

package com.hrs.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrs.hotel.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

}

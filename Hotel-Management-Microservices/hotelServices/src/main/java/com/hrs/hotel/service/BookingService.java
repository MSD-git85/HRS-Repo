package com.hrs.hotel.service;

import java.util.List;

import com.hrs.hotel.entities.Booking;

public interface BookingService {
    public String bookRoom(String hotelId, String userId,Booking booking);

    public Booking getBookingById(String bookingId);

    public List<Booking> getAllBooking();

    public String cancelBooking(String bookingId);

    public String completeBooking(String bookingId);

}

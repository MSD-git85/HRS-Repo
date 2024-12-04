package com.hrs.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.hotel.entities.Booking;
import com.hrs.hotel.service.BookingService;
import com.hrs.hotel.service.hotelService;

@RestController
@RequestMapping("/hotels")
public class BookingController {

    @Autowired
    private hotelService hotelService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/addBooking/{hotelId}/{userId}")
    public ResponseEntity<String> addBooking(@PathVariable String hotelId, @PathVariable String userId, @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.bookRoom(hotelId,userId, booking));
    }

    @GetMapping("/getBooking/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    @GetMapping("/getAllBooking")
    public ResponseEntity<List<Booking>> getAllBooking() {
        return ResponseEntity.ok(bookingService.getAllBooking());
    }

    @GetMapping("/cancelBooking/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.cancelBooking(bookingId));
    }

    @GetMapping("/completeBooking/{bookingId}")
    public ResponseEntity<String> completeBooking(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.completeBooking(bookingId));
    }
}

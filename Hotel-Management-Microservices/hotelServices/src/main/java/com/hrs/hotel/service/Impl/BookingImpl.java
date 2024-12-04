package com.hrs.hotel.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrs.hotel.entities.Booking;
import com.hrs.hotel.entities.Hotel;
import com.hrs.hotel.entities.Room;
import com.hrs.hotel.entities.Status;
import com.hrs.hotel.exception.NotFoundException;
import com.hrs.hotel.repository.BookingRepository;
import com.hrs.hotel.repository.HotelRepository;
import com.hrs.hotel.repository.RoomRepository;
import com.hrs.hotel.service.BookingService;

@Service
public class BookingImpl implements BookingService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public String bookRoom(String hotelId, String userId, Booking book) {

        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));

        Room room = roomRepository.findById(book.getRoom_id()).orElseThrow( () -> new NotFoundException("Room not found with id: " + book.getRoom_id() + ""));

        if(room.getStatus().equals(Status.BOOKED)) {
            return "ROOM ALREADY BOOKED";
        }

        Booking booking = new Booking();
        booking.setHotel(hotel);
        booking.setRoom_id(book.getRoom_id());
        booking.setBooking_id(book.getBooking_id());
        booking.setAmount(book.getAmount());
        booking.setPayment_status(book.getPayment_status());
        booking.setBooking_date(book.getBooking_date());
        booking.setCheck_out_date(book.getCheck_out_date());
        booking.setUser_id(userId);

        room.setStatus(Status.BOOKED);
        bookingRepository.save(booking);
        return "BOOKED";

    }

    @Override
    public Booking getBookingById(String bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow( () -> new NotFoundException("Booking not found with id: " + bookingId + ""));
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public String cancelBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow( () -> new NotFoundException("Booking not found with id: " + bookingId + ""));

        Room room = roomRepository.findById(booking.getRoom_id()).orElseThrow( () -> new NotFoundException("Room not found with id: " + booking.getBooking_id() + ""));

        if (room.getStatus().equals(Status.AVAILABLE)) {
            return "ROOM ALREADY AVAILABLE";
        }
        room.setStatus(Status.AVAILABLE);
        roomRepository.save(room);
        return "CANCELLED";
    }

    @Override
    public String completeBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow( () -> new NotFoundException("Booking not found with id: " + bookingId + ""));

        Room room = roomRepository.findById(booking.getRoom_id()).orElseThrow( () -> new NotFoundException("Room not found with id: " + booking.getRoom_id() + ""));

        room.setStatus(Status.AVAILABLE);
        roomRepository.save(room);
        return "COMPLETED";
    }


}

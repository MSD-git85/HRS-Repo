package com.hrs.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.hotel.entities.Hotel;
import com.hrs.hotel.entities.Room;
import com.hrs.hotel.service.hotelService;

@RestController
@RequestMapping("/hotels")
public class hotelController {

    @Autowired
    private hotelService hotelService;

    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.addHotel(hotel));
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getHotelById(hotelId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> deleteHotelById(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.deleteHotelById(hotelId));
    }

    @PostMapping("/{hotelId}/rooms")
    public ResponseEntity<Room> addRoom(@PathVariable String hotelId, @RequestBody Room hotel) {
        return ResponseEntity.ok(hotelService.addRoom(hotelId, hotel));
    }

    @GetMapping("/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable String roomId) {
        return ResponseEntity.ok(hotelService.getRoomById(roomId));
    }

    @GetMapping("/{hotelId}/available")
    public ResponseEntity<List<Room>> getAllAvailableRoom(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getAllAvailableRoom(hotelId));
    }

    @GetMapping("/{hotelId}/rooms/booked")
    public ResponseEntity<List<Room>> getAllBookedRoom(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getAllBookedRoom(hotelId));
    }

    @GetMapping("/{hotelId}/getAllRooms")
    public ResponseEntity<List<Room>> getAllRooms(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getAllRooms(hotelId));
    }


    @DeleteMapping("/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Room> deleteRoomById(@PathVariable String roomId) {
        return ResponseEntity.ok(hotelService.deleteRoomById(roomId));
    }


    @GetMapping("/location/{location}")
    public ResponseEntity<List<Hotel>> getHotelByLocation(@PathVariable String location) {
        return ResponseEntity.ok(hotelService.getHotelByLocation(location));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Hotel> getHotelByName(@PathVariable String name) {
        return ResponseEntity.ok(hotelService.getHotelByName(name));
    }

}

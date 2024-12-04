package com.hrs.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.hotel.entities.Room;

public interface RoomRepository extends JpaRepository<Room, String> {
}

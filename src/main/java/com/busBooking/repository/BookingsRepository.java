package com.busBooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busBooking.model.Bookings;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

	List<Bookings> findByUserId(int userId);
}

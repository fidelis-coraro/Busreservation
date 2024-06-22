package com.busBooking.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.busBooking.DTO.BookingsDTO;
import com.busBooking.DTO.UserRegisteredDTO;
import com.busBooking.model.Bookings;
import com.busBooking.model.User;

public interface DefaultUserService extends UserDetailsService{

	User save(UserRegisteredDTO userRegisteredDTO);

	Bookings updateBookings(BookingsDTO bookingDTO,UserDetails user);
	
	void sendEmail(BookingsDTO bookingDTO, User users, String nameGenrator);


	
}

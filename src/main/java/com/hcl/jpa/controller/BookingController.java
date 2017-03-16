/**
 * 
 */
package com.hcl.jpa.controller;

import com.hcl.jpa.models.Booking;
import com.hcl.jpa.models.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Srinivas
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	/**
	 * GET /create  --> Create a new booking and save it in the database.
	 */
	@RequestMapping("/create")
	public Booking create(Booking booking) {
		booking.setTravelDate(new Date());
		booking = bookingRepository.save(booking);
	    return booking;
	}
	
	/**
	 * GET /read  --> Read a booking by booking id from the database.
	 */
	@RequestMapping("/read")
	public Booking read(@RequestParam Long bookingId) {
		Booking booking = bookingRepository.findOne(bookingId);
	    return booking;
	}
	
	/**
	 * GET /update  --> Update a booking record and save it in the database.
	 */
	@RequestMapping("/update")
	public Booking update(@RequestParam Long bookingId, @RequestParam String psngrName) {
		Booking booking = bookingRepository.findOne(bookingId);
		booking.setPsngrName(psngrName);
		booking = bookingRepository.save(booking);
	    return booking;
	}
	
	/**
	 * GET /delete  --> Delete a booking from the database.
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam Long bookingId) {
		bookingRepository.delete(bookingId);
	    return "booking #"+bookingId+" deleted successfully";
	}
}

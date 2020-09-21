package com.myproject.reservation.view.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.reservation.business.service.BookingService;
import com.myproject.reservation.model.Booking;
import com.myproject.reservation.view.resources.vo.BookingVO;

@RestController
@RequestMapping("/api/booking")
public class BookingResource {

	@Autowired BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestBody BookingVO bookingVO){
		Booking booking = new Booking();
		booking.setAmount(bookingVO.getAmount());
		booking.setCheckIn(bookingVO.getCheckIn());
		booking.setCheckOut(bookingVO.getCheckOut());
		booking.setCode(bookingVO.getCode());
		booking.setDescription(bookingVO.getDescription());
		return new ResponseEntity<Booking>(this.bookingService.create(booking), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Booking>> findAll(){
		return ResponseEntity.ok(bookingService.findAll());
	}
}

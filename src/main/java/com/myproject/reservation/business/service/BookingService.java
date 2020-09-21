package com.myproject.reservation.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.reservation.business.repository.BookingRepository;
import com.myproject.reservation.model.Booking;

/**
 * Class to define the booking services
 * @author Juan
 *
 */
@Service
@Transactional(readOnly = true)
public class BookingService {
	
	@Autowired BookingRepository bookingRepository;
	
	/**
	 * Method to save a booking
	 * @param booking
	 * @return
	 */
	@Transactional
	public Booking create(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	/**
	 * Method to update a booking
	 * @param booking
	 * @return
	 */
	@Transactional
	public Booking update(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	/**
	 * Method to delete a booking
	 * @param booking
	 */
	@Transactional
	public void delete(Booking booking) {
		bookingRepository.delete(booking);
	}
	
	/**
	 * Method to get all booking
	 * @return
	 */
	public List<Booking> findAll(){
		return bookingRepository.findAll();
	}

}

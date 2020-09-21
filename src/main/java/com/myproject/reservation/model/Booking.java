package com.myproject.reservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idBooking;
	private String code;
	@Temporal(TemporalType.DATE)
	private Date checkIn;
	@Temporal(TemporalType.DATE)
	private Date checkOut;
	private String description;
	private String amount;
	@ManyToOne
	@JoinColumn(name="id")
	private Client client;
	
	
}

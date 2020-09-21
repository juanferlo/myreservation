/**
 * 
 */
package com.myproject.reservation.view.resources.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Juan
 *
 */
@Data
public class BookingVO implements Serializable{

	private static final long serialVersionUID = 2402887906230301049L;
	
	private String code;
	private Date checkIn;
	private Date checkOut;
	private String description;
	private String amount;
	private ClientVO client;
	
}

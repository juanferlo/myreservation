/**
 * 
 */
package com.myproject.reservation.view.resources.vo;

import java.io.Serializable;

import com.myproject.reservation.model.Client;

import lombok.Data;

/**
 * @author Juan
 *
 */
@Data
public class ClientVO implements Serializable{

	private static final long serialVersionUID = 2526622266652308253L;

	private String name;
	private String surname;
	private String identification;
	private String address;
	private String phone;
	private String email;
	
}

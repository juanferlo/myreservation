package com.myproject.reservation.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.reservation.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{
	
	/**
	 * Method to search for a client by its identification
	 * @param identificacionCli
	 * @return
	 */
	public Client findClientByIdentification(String identification);
	
	/**
	 * Method to find a client by email 
	 * @param email
	 * @return
	 */
	//@Query("Select c from Cliente c where c.emailCli like %:email")
	//public Client findClientByEmail(@Param("email") String email);

}

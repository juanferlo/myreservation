package com.myproject.reservation.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.reservation.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{
	
	/**
	 * Method to search for a client by its identification
	 * @param identificacionCli
	 * @return
	 */
	public Client findByIdentification(String identification);
	
	/**
	 * Method to find a client by email 
	 * @param email
	 * @return
	 */
	@Query("Select c from Client c where c.email like %:email")
	public Client findClientByEmail(@Param("email") String email);

}

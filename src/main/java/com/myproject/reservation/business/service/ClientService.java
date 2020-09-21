package com.myproject.reservation.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.reservation.business.repository.ClientRepository;
import com.myproject.reservation.model.Client;

/**
 * Class to define the client services
 * @author Juan
 *
 */
@Service
@Transactional(readOnly = true)
public class ClientService {

	@Autowired ClientRepository clientRepository;
	
	/**
	 * Method to save a client 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client create(Client client) {
		return clientRepository.save(client);
	}
	
	/**
	 * Method to update a client
	 * @param client
	 * @return
	 */
	@Transactional
	public Client update(Client client) {
		return clientRepository.save(client);
	}
	
	/**
	 * Method to delete a client
	 * @param client
	 */
	@Transactional
	public void delete(Client client) {
		clientRepository.delete(client);
	}
	
	/**
	 * Method to get all client
	 * @return
	 */
	public List<Client> findAll(){
		return this.clientRepository.findAll();
	}
	
	/**
	 * Method to get a client from an identification
	 * @param identification
	 * @return
	 */
	public Client findByIdentification(String identification) {
		return this.clientRepository.findByIdentification(identification);
	}
}

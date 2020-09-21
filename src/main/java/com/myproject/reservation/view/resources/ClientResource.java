package com.myproject.reservation.view.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.reservation.business.service.ClientService;
import com.myproject.reservation.model.Client;
import com.myproject.reservation.view.resources.vo.ClientVO;

@RestController
@RequestMapping("/api/client")
public class ClientResource {
	
	@Autowired ClientService clientService;
	
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO){
		Client client = new Client();
		client.setAddress(clientVO.getAddress());
		client.setEmail(clientVO.getEmail());
		client.setIdentification(clientVO.getIdentification());
		client.setName(clientVO.getName());
		client.setPhone(clientVO.getPhone());
		client.setSurname(clientVO.getSurname());
		return new ResponseEntity<Client>(this.clientService.create(client), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clientService.findAll());
	}
	
	@PutMapping("/{identification}")
	public ResponseEntity<Client> updateClient(@PathVariable("identification") String identification, ClientVO clientVo){
		Client client = this.clientService.findByIdentification(identification);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}else {
			client.setName(clientVo.getName());
			client.setSurname(clientVo.getSurname());
			client.setAddress(clientVo.getAddress());
			client.setPhone(clientVo.getPhone());
			client.setEmail(clientVo.getEmail());
		}
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);	
	}
	
	@DeleteMapping("/{identification}")
	public void removeClient(@PathVariable("identification") String identification){
		Client client = this.clientService.findByIdentification(identification);
		if (client != null) {
			this.clientService.delete(client);
		}
	}
	
	

}

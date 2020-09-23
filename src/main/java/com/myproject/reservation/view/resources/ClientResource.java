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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {
	
	@Autowired ClientService clientService;
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
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
	@ApiOperation(value = "Listar Clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(this.clientService.findAll());
	}
	
	@PutMapping("/{identification}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
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
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void removeClient(@PathVariable("identification") String identification){
		Client client = this.clientService.findByIdentification(identification);
		if (client != null) {
			this.clientService.delete(client);
		}
	}
	
	

}

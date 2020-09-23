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

import com.myproject.reservation.business.service.BookingService;
import com.myproject.reservation.business.service.ClientService;
import com.myproject.reservation.model.Booking;
import com.myproject.reservation.model.Client;
import com.myproject.reservation.view.resources.vo.BookingVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/booking")
@Api(tags = "booking")
public class BookingResource {

	@Autowired BookingService bookingService;
	@Autowired ClientService clientService;
	
	@PostMapping
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear un nueva reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
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
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") })
	public ResponseEntity<List<Booking>> findAll(){
		return ResponseEntity.ok(bookingService.findAll());
	}
	
	@PutMapping("/{code}")
	@ApiOperation(value = "Actualizar Reserva", notes = "Servicio para actualizar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva actualizada correctamente"),
			@ApiResponse(code = 404, message = "Reserva no encontrada") })
	public ResponseEntity<Booking> updateBooking(@PathVariable("code") String code, BookingVO bookingVo){
		Booking booking = bookingService.findByCode(code);
		if (booking == null) {
			
		}else {
			Client client = clientService.findByIdentification(bookingVo.getClient().getIdentification());
			booking.setClient(client);
			booking.setAmount(bookingVo.getAmount());
			booking.setCheckIn(bookingVo.getCheckIn());
			booking.setCheckOut(bookingVo.getCheckOut());
			booking.setDescription(bookingVo.getDescription());
		}
		return new ResponseEntity<Booking>(this.bookingService.update(booking), HttpStatus.OK);
	}
	
	@DeleteMapping("/{code}")
	@ApiOperation(value = "Eliminar Reserva", notes = "Servicio para eliminar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva eliminada correctamente"),
			@ApiResponse(code = 404, message = "Reserva no encontrada") })
	public void removeBooking(@PathVariable("code") String code){
		Booking booking = bookingService.findByCode(code);
		if (booking != null) {
			this.bookingService.delete(booking);
		}
	}
}

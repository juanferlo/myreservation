package com.myproject.reservation.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.reservation.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String>{

	/**
	 * Método para consultar las reservas por cliente
	 * 
	 * @param cliente
	 * @return
	 */
//	@Query("Select r from Reserva r where r.cliente =:cliente")
//	public List<Reserva> findByCliente(Cliente cliente);
	
	/**
	 * Definición de método para consultar las reservas por la fecha de ingreso en
	 * base a un rango de fechas
	 * 
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
//	@Query("Select r from Reserva r where r.fechaIngresoRes =:fechaInicio  and r.fechaSalidaRes =:fechaSalida")
//	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);

	/**
	 * Method to search for a reservation by its code.
	 * @param codigoReserva
	 * @return
	 */
	public Booking findByCode(String code);
	
}

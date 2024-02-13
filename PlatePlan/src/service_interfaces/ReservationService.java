package service_interfaces;

import java.util.List;

import dto.Customer;
import dto.Reservation;

public interface ReservationService {
	
	public Reservation createCustomerReservation();
	
	public List<Reservation> getCustomerReservation(String email);
	
	
	

}

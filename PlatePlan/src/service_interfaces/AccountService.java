package service_interfaces;

import dto.Customer;
import dto.Reservation;

public interface AccountService {
	
	public Customer registerAccount(String firstName, String lastName, String email, String password);
	
	public Customer login (String email, String password);
	
	public Customer getAccountDetails (String email);
	
	public void addReservationToAccount (Reservation reservation, String email);
	

}

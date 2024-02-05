package services;

import dto.Customer;
import dto.Reservation;

public interface AccountService {
	
	public Customer registerAccount(String firstName, String lastName, String email, String password);
	
	public Customer login (String email, String password);
	
	public Customer reserveSpot (Reservation reservation);
	

}

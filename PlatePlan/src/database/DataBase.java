package database;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import dto.Business;
import dto.Customer;
import dto.Reservation;

public interface DataBase {
	
	public boolean registerCustomer(Customer object);
		
	public Customer getCustomerAccount (String email) throws AccountNotFoundException;
	
	public Business getBusinessAccount ();

	public List<Reservation> getCustomerReservations (String email) throws AccountNotFoundException;
	

}

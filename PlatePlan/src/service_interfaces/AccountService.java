package service_interfaces;

import dto.Business;
import dto.Customer;
import dto.Reservation;

public interface AccountService {
	
	public Customer registerAccount(String firstName, String lastName, String email, String password);
	
	public Customer customerLogin (String email, String password);
	
	public Business businessLogin (String email, String password);
	
	public Customer getCustomerAccountDetails (String email);


}
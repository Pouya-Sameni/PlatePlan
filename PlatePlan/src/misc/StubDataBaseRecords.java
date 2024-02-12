package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dto.Business;
import dto.Customer;

public class StubDataBaseRecords {
	public static List<Customer> customers = new ArrayList<Customer>(Arrays.asList(
			new Customer("johndoe@email.com", "john", "doe", "password"),
			new Customer("janedoe@email.com", "jane", "doe", "password"),
			new Customer("max@email.com", "max", "payne", "password")));
	
	public static Business business = new Business ("alfredo@email.com", "password");
	
	

}

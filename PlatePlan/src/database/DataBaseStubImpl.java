package database;

import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import dto.Customer;
import dto.Reservation;
import misc.StubDataBaseRecords;

public class DataBaseStubImpl implements DataBase {
	
	private static DataBaseStubImpl dataBaseInstance;

	
	private DataBaseStubImpl() {

	}

	public static synchronized DataBaseStubImpl getInstance() {
		if (dataBaseInstance == null) {
			dataBaseInstance = new DataBaseStubImpl();
		}
		return dataBaseInstance;
	}

	
	
	@Override
	public boolean insertRecord(String tableName, String values) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getCustomerAccount(String email) throws AccountNotFoundException {
		List<Customer> customers = StubDataBaseRecords.customers;
		
		try {
			Customer customerFound = customers.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email))
					.collect(Collectors.toList()).get(0);
			return customerFound;
		}catch (Exception e) {
			throw new AccountNotFoundException("No customer with the given email" + email);
		}
		
	}

	@Override
	public List<Reservation> getCustomerReservations(String email) throws AccountNotFoundException {
		Customer customer = this.getCustomerAccount(email);
		
		if (customer != null)
		{
			return customer.getReservations();
		}
		throw new AccountNotFoundException("No customer with the given email" + email);
	}

}
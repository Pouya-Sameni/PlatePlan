package database;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import dto.Customer;
import dto.Reservation;

public interface DataBase {
	
	public boolean insertRecord(String tableName, String values);
	
	public Customer getCustomerAccount (String email) throws AccountNotFoundException;
	
	public List<Reservation> getCustomerReservations (String email) throws AccountNotFoundException;
	

}

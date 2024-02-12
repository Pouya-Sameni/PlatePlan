package database;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import dto.Business;
import dto.Customer;
import dto.Reservation;

public interface DataBase {
	
	public boolean registerCustomer(Customer object);
		
	public Business getBusinessAccount ();

    public boolean insertRecord(String tableName, String values);

    public Customer getCustomerAccount(String email) throws AccountNotFoundException;

    public List<Reservation> getCustomerReservations(String email) throws AccountNotFoundException;

    public void updateRecord(String tableName, String updatedValues, String conditionColumn, String conditionValue);
}

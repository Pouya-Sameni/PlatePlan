package services;

import java.util.ArrayList;
import java.util.UUID;

import javax.security.auth.login.AccountNotFoundException;

import database.DataBase;
import database.DataBaseFactory;
import database.DataBaseImpl;
import database.SQLTables;
import dto.Customer;
import dto.Reservation;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import service_interfaces.AccountService;




public class AccountsServiceImpl implements AccountService {
	DataBase db;
	
	
	public AccountsServiceImpl ()
	{
		this.db =  DataBaseFactory.getDatabase();
	}

	public Customer registerAccount(String firstName, String lastName, String email, String password) {
		
		Customer customer = new Customer (firstName, lastName, email, password, new ArrayList<>());
		

		//TODO: Add Customer to database if an error is returned then return null or throw an exception. Duplicates are checked by the 
		//SQL database
		db.insertRecord(SQLTables.ACCOUNTS_TABLE, customer.genSQLValue());
		
		return null;
	}

	@Override
	public Customer login(String email, String password) {
		
		try {
			Customer customer = db.getCustomerAccount(email);
			if (customer.getPassword().equals(password))
			{
				
				return customer;
			}
			System.out.println ("Incorrect password given: expected " + customer.getPassword() + " but was " + password);
		}catch (Exception e) {
			System.out.println ("Account with email" + email + " does not exist");
		}
		
		return null;
	}

	@Override
	public Customer getAccountDetails(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReservationToAccount(Reservation reservation, String email) {
		// TODO Auto-generated method stub
		
	}
}


